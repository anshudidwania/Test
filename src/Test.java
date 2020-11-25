import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String s = "a, a, a, a, b,b,b,c, c";
		String[] banned = {"a"}; 
		mostCommonWord(s, banned);
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		paragraph =  paragraph.toLowerCase();
		paragraph = paragraph.replaceAll("!"," ");
		paragraph = paragraph.replaceAll("\\?"," ");
		paragraph = paragraph.replaceAll("'"," ");
		paragraph = paragraph.replaceAll(","," ");
		paragraph = paragraph.replaceAll(";"," ");
		paragraph = paragraph.replaceAll("\\."," ");
		Map<String, Integer> mp = new HashMap<> ();
		for(String s : paragraph.split(" ")){
			if(!s.trim().equals("")) {
				if(null != mp.get(s.trim())){
					mp.put(s.trim(), mp.get(s.trim())+1);
				}else{
					mp.put(s.trim(), 1);
				}
			}

		}
		List<Map.Entry<String, Integer>> list =
				new LinkedList<Map.Entry<String, Integer>>(mp.entrySet());
		Collections.sort(list, (o1, o2) -> {
			return o2.getValue().compareTo(o1.getValue());
		});
		boolean f = true;
		String r=null;
		for (Map.Entry<String, Integer> entry : list) {
			for(String ss : banned){
				if(ss.equals(entry.getKey())) {
					f = false;
					break;
				}
			}
			if(f){
				r = entry.getKey();
				break;
			}
			f = true;
			//System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
		return r;
	}

}

