
public class LongestPalindrome {

	public static void main(String[] args) {
		new LongestPalindrome().longestPalindrome("babad");
	}
	int resS;
    int resL;
    
    public String longestPalindrome(String s) {
        int l = s.length();
        if(l < 2){
            return s;
        }
        for(int i=0; i<s.length(); i++){
            palindrome(s,i,i);
            palindrome(s,i,i+1);
        }
        return s.substring(resS, resS+resL);
    }
    
    private void palindrome(String s, int f, int l){
        while(f>=0 && l<=s.length()-1 && s.charAt(f) == s.charAt(l)){
            f--;
            l++;
        }
        if(resL < l-f-1){
            resS = f+1;
            resL = l-f-1;
        }
        
    }

}
