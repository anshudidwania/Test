import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SortString {

	public static void main(String[] args) {
		//System.out.println(sortString("leetcode"));
		//System.out.println(sortString("aaaabbbbcccc"));
		System.out.println('a'-'z');
		System.out.println('z'+1);
		char x = 96+10;
		System.out.println(x);
		Set<Integer> st = new HashSet<>();
	}

	public static String sortString(String s) {
		List<Character> cls = new ArrayList<> ();
		Map<Character, Integer> im = new HashMap<>();
		for(char c : s.toCharArray()){
			if(null != im.get(c)){
				im.put(c, im.get(c)+1);
			}else{
				cls.add(c);
				im.put(c, 1);
			}
		}
		Collections.sort(cls);
		List<Character> rcls = new ArrayList<> ();
		for(int i=cls.size()-1; i>=0; i--) {
			rcls.add(cls.get(i));
		}
		int i = 1;
		boolean b = false;
		StringBuilder sb = new StringBuilder();
		char c;
		//Iterator<Character> cit;
		ListIterator<Character> cit;
		while(i <= s.length()) {
			if(!b){
				//low
				b = !b;
				cit = cls.listIterator();
				while(cit.hasNext()) {
					c = cit.next();
					if(im.get(c) > 0){
						sb.append(c);
						im.put(c, im.get(c)-1);
						i++;
					}else {
						cit.remove();
					}
				}
			}else {
				//high
				b = !b;
				cit = cls.listIterator(cls.size());
				while(cit.hasPrevious()) {
					c = cit.previous();
					if(im.get(c) > 0){
						sb.append(c);
						im.put(c, im.get(c)-1);
						i++;
					}else {
						cit.remove();
					}
				}
			}
		}
		return sb.toString();
	}
}
