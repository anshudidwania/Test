import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		lengthOfLongestSubstringN("pwwkew");

	}
	public static int lengthOfLongestSubstring(String s) {
	       Set<Character> st = null;
	        int i=0;
	         int length=0;
	        while(i<s.length()){
	        	st = new HashSet<>();
	            for(int j=i; j<s.length();j++){
	                if(st.add(s.charAt(j))){
	                    if(length < j-i+1){
	                        length = j-i+1;
	                    }
	                    if(i == s.length()-1 || i+st.size() == s.length()) {
	                    	i++;
	                    }
	                }else{
	                    i = s.substring(i, j).indexOf(s.charAt(j))+i+1;
	                    break;
	                }
	            }
	        }
	        return length;
	    }
	
	public static int lengthOfLongestSubstringN(String s) {
	       Set<Character> st = new HashSet<>();
	        int l=0;
	        int r=0;
	         int length=0;
	        while(r<s.length()){
	        	if(!st.contains(s.charAt(r))) {
	        		st.add(s.charAt(r));
	        		length = Math.max(length, st.size());
	        		r++;
	        	}else {
	        		st.remove(s.charAt(l));
	        		l++;
	        	}
	        }
	        return length;
	    }
}
