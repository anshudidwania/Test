import java.util.Stack;

public class StackProblem {

	public static void main(String[] args) {
		//checkBalance("{()}[)");
		findDuplicate("((x+y)+((z)))");

	}

	static void checkBalance (String input) {
		String [] arr = input.split("");
		Stack<String> stack = new Stack<>();
		String temp = null;
		boolean ret = true;
		for(String s : arr) {
			temp = performOperation(s);
			if(temp == null) {
				ret = false;
				break;
			}
			if("a".equals(temp)) {
				stack.push(s);
			}else {
				if(stack.isEmpty()) {
					if(!temp.equals(stack.pop())){
						ret = false;
						break;
					}
				}
			} 
		}
		if(stack.isEmpty()) {
			ret = false;
		}
		System.out.println(ret);
	}

	static String performOperation (String input) {
		if(input.equals("[")) {
			return "a";
		}else if(input.equals("]")) {
			return "[";
		}else if(input.equals("{")) {
			return "a";
		}else if(input.equals("}")) {
			return "{";
		}else if(input.equals("(")) {
			return "a";
		}else if(input.equals(")")) {
			return "(";
		}
		return null;
	}
	
	static void findDuplicate (String input) {
		String [] arr = input.split("");
		Stack<String> stack = new Stack<>();
		String temp = null;
		boolean ret = false;
		for(String s : arr) {
			if(!s.equals(")")) {
				stack.push(s);
			}else {
				if("(".equals(stack.peek())) {
					ret = true;
					break;
				}
				while(!"(".equals(stack.peek())) {
					stack.pop();
				}
				stack.pop();
			}
		}
		System.out.println(ret);
		
	}
}
