import java.util.Stack;

public class BackspaceCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("aaa###a","aaaa###a"));

	}
	
	public static boolean backspaceCompare(String S, String T) {
        Stack<Character> sS = new Stack<>();
        Stack<Character> sT = new Stack<>();
        int s = S.length()>T.length()?S.length():T.length();
        for(int i=0; i<s;i++){
            if(i < S.length()){
                if(S.charAt(i)=='#' && !sS.isEmpty()){
                	if(!sS.isEmpty()) sS.pop();
                }else{
                    sS.push(S.charAt(i));
                }
            }
            if(i < T.length()){
                if(T.charAt(i)=='#' && !sT.isEmpty()){
                	if(!sT.isEmpty()) sT.pop();
                }else{
                    sT.push(T.charAt(i));
                }
            }
        }
        S = null;
        T = null;
        //s = sS.size()>sT.size()?sS.size():sT.size();
        while(!sS.isEmpty() || !sT.isEmpty()) {
        	if(!sS.isEmpty()){
                S = sS.pop() + S;
            }
            if(!sT.isEmpty()){
                T = sT.pop() + T;
            }
        }
        
        
        if((null == S && null == T) || (null != S && S.equals(T))){
            return true;
        }
        return false;
        
    }

}
