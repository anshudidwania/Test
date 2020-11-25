import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SmallerNumber {

	public static void main(String[] args) {
		int [] a = {8,1,2,2,3};
		smallerNumbersThanCurrent(a	);

	}
	
	public static int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, List<Integer>> s = new TreeMap<>();
        for(int i=0; i<nums.length; i++){
            if(null != s.get(nums[i])){
                 s.get(nums[i]).add(i);
            }else{
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                 s.put(nums[i], ls);
            }
        }
        int [] r = new int[nums.length];
        Set<Integer> ss = s.keySet();
        Iterator<Integer> it = ss.iterator();
        int a=nums.length;
        int b=0;
        while(it.hasNext()){
        	b=0;
            for(int j : s.get(it.next())){
                r[j] = nums.length-a-b;
               a--;
               b++;
            }
            //a--;
        }
       return r;
    }

}
