import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DestinationCity {

	public static void main(String[] args) {
		List<List<String>> paths = new ArrayList<>();
		List<String> ls = new ArrayList<>();
//		ls.add("qMTSlfgZlC");
//		ls.add("ePvzZaqLXj");
//		paths.add(ls);
//		ls = new ArrayList<>();
//		ls.add("xKhZXfuBeC");
//		ls.add("TtnllZpKKg");
//		paths.add(ls);
//		ls = new ArrayList<>();
//		ls.add("ePvzZaqLXj");
//		ls.add("sxrvXFcqgG");
//		paths.add(ls);
//		ls = new ArrayList<>();
//		ls.add("sxrvXFcqgG");
//		ls.add("xKhZXfuBeC");
//		paths.add(ls);
//		ls = new ArrayList<>();
//		ls.add("TtnllZpKKg");
//		ls.add("OAxMijOZgW");
//		paths.add(ls);
		ls = new ArrayList<>();
		ls.add("B");
		ls.add("C");
		paths.add(ls);
		ls = new ArrayList<>();
		ls.add("D");
		ls.add("B");
		paths.add(ls);
		ls = new ArrayList<>();
		ls.add("C");
		ls.add("A");
		paths.add(ls);
		
		System.out.println(destCity(paths));
	}

	public static String destCity(List<List<String>> paths) {
		return remain(paths, null, paths.size());
	}

	public static String remain(List<List<String>> t, String r, int s) {
		Iterator<List<String>> it = t.iterator();
		while (it.hasNext()){
			List<String> ls = it.next();
			if(r== null || r.equals(ls.get(0))){
				r = ls.get(1);
				it.remove();
			}
		}
		if(t.size() > 0 && t.size() < s){
			return remain(t, r, t.size());
		}
		return r;
	}

}
