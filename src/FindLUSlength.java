
public class FindLUSlength {

	public static void main(String[] args) {
		findLUSlength("jjnwxqanluenhgadgjxfvppjbzavlp","mnnjzsrbyurtcbdhcohaqsgnzfjsww");

	}
	public static int findLUSlength(String a, String b) {
		System.out.println("as".indexOf('s', 2));
		if(a.length() != b.length()) return Math.max(a.length(), b.length());
        return !a.equals(b) ? a.length() : -1;
	}
}
