import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AllCombinationString {

	public static void main(String[] args) {
		//allCombination("abcd");
		//printPermutn("abcd", "");
		String s = "leetcode" ; String t="practice";
		Map<Character, Integer> mps = new HashMap<>();
        Map<Character, Integer> mpt = new HashMap<>();
        Integer is;
        Integer it;
        int c=0;
        for(int i=0; i<t.length(); i++){
            is = mps.get(s.charAt(i));
            if(null == is){
                mps.put(s.charAt(i),1);
            }else{
                mps.put(s.charAt(i),is+1);
            }
            it = mpt.get(t.charAt(i));
            if(null == it){
                mpt.put(t.charAt(i),1);
            }else{
                mpt.put(t.charAt(i),it+1);
            }
        }
        it =0;
        
        for(Character e : mps.keySet()) {
			it = mpt.get(e);
			if(it == null) c=c+mps.get(e);
			else if(mps.get(e) - it > 0)			
            c = c + (mps.get(e) - it);
            it =0;
		}
        int[] iA = new int[mp.size()];
        Arrays.toString(a)
System.out.println(c);
	}
	
	public static void allCombination(String s) {
		
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<s.length(); j++) {
				if(i!=j)
				System.out.println(
						 s.substring(0,j)
						+ s.substring(j+1, s.length())
						+ s.charAt(j)
						);
				
			}
		}
		
	}
	
	static void printPermutn(String str, String ans) 
    { 
  
        // If string is empty 
        if (str.length() == 0) { 
            System.out.print(ans + " "); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            // Recurvise call 
            printPermutn(ros, ans + ch); 
        } 
    } 

}
