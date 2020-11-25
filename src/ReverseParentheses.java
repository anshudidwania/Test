import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class ReverseParentheses {

	public static void main(String[] args) {
		System.out.println(reverseParen("a(bcdefghijkl(mno)p)q"));
		//String s = "Ans(hu)";
		//System.out.println(s.replaceFirst("\\(hu\\)", "Done"));

	}

	public static String reverseParentheses(String s) {
		
		Stack<String> st = new Stack<>();

		int i=0;
		int j= s.length();
		String temp=null;
		while (i<j){
			if(s.charAt(i) == '('){
				temp = s.substring(++i, --j);
				temp = temp.replaceAll("\\(", "#");
				temp = temp.replaceAll("\\)", "#");
				st.push(temp);
			}else {
				i++;
				if(s.charAt(j-1) != ')') {
					j--;
				}
			}
		}
		StringBuilder sb;
		StringBuilder sr;
		String r = "";
		String rr = "";
		String [] sA = new String[2];
		while (!st.isEmpty()) {
			r = st.pop();
			rr = r;
			if(null != sA[0]) {
				rr = r.replaceFirst(sA[0], sA[1]);
				//r = r.replaceAll(sA[0], sA[1]);
			}
			sr = new StringBuilder(rr);
			sb = new StringBuilder();
			sb.append("#").append(r).append("#");
			sA[0] = sb.toString();
			sA[1] = sr.reverse().toString();

		}
		return sA[1];
	}

	public static String reverseParen(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		StringBuilder res = new StringBuilder();
		Queue<Character> queue = new ArrayDeque<>();

		//if alpha, push to stack
		//if (, push to stack
		//if ), pop from stack and add to queue till reach (, push queue to stack
		//at the end, pop from stack and reverse stringBuilder


		for(char c: s.toCharArray()) {

			if(c == '(') {
				stack.push(c);
			} else if (c == ')') {
				queue.clear();
				c = stack.pop();
				while(c != '(') {
					queue.add(c);
					c = stack.pop();
				} 

				while(!queue.isEmpty()) {
					stack.push(queue.poll());
				}

			} else {
				stack.push(c);
			}
		}

		while(!stack.isEmpty()) {
			res.append(stack.pop());
		}

		return res.reverse().toString();

	}
}

