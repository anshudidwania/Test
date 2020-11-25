import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NumUniqueEmails {

	public static void main(String[] args) {
		String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
		Set<String> st = new HashSet<>();
        for(String s : emails){
            String[] sA = s.split("@");
            String t = sA[0];
            if(t.contains("+")){
                String[] tA = t.split("\\+");
                t = tA[0].replaceAll("\\.","");
            }else{
               t = t.replaceAll("\\.",""); 
            }
            st.add(t+"@"+sA[1]);
        }
        System.out.println( st.size());
        List<String> gL = new ArrayList<String>();
        Iterator<String> is= gL.iterator();
        is.next(); is.hasNext();
        is.

	}

}
