import java.util.Stack;

public class StackBraces {

	public static void main(String[] args) {
		System.out.println(isValid("()"));

	}

	public static boolean isValid(String s) {
        char c;
        Stack<Character> ss = new Stack<>();
        for(int i=0; i<s.length(); i++){
            c = validate(s.charAt(i));
            if(c=='P') ss.push(s.charAt(i));
            else if (ss.isEmpty() || ss.pop() != c){
                return false;
            }
        }
        if(ss.isEmpty()){
            return true;
        }
        return false;
    }
    
    public static Character validate(char c){
        if(c == '(' || c == '{' || c == '['){
            return 'P';
        }else if(c == ')'){
            return '(';
        }else if(c == '}'){
            return '{';
        }else if(c == ']'){
            return '[';
        }
        return null;
    }
}
