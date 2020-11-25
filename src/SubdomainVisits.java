import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {

	public static void main(String[] args) {
		//String[] cpdomains = {"9001 discuss.leetcode.com"};
		String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		System.out.println(subdomainVisits(cpdomains));

	}
	
	public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> mp = new HashMap<>();
        for(String sss : cpdomains){
        	String[] s = sss.split(" ");
            if(null != mp.get(s[1]))
                mp.put(s[1], mp.get(s[1])+Integer.parseInt(s[0]));
            else
                mp.put(s[1], Integer.parseInt(s[0]));
            int i=0;
            String ss = s[1];
            while(ss.indexOf(".", 0) != -1){
                i=ss.indexOf(".", 0)+1;
                ss = ss.substring(i, ss.length());
                if(null != mp.get(ss))
                    mp.put(ss, mp.get(ss)+Integer.parseInt(s[0]));
                else
                    mp.put(ss, Integer.parseInt(s[0]));
            }
        }
        List<String> ls = new ArrayList<> ();
        
        mp.forEach((k, v) -> ls.add((v + " " + k)));
        return ls;
    }

}
