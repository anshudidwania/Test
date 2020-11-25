import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumSpecialEquivGroups {

	public static void main(String[] args) {
		String[] A = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
		Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (String s : A) {
            int[] odd = new int[26], even = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) even[s.charAt(i) - 'a']++;
                else odd[s.charAt(i) - 'a']++;
            }
            sb.append(Arrays.toString(even));
            sb.append(Arrays.toString(odd));
            set.add(sb.toString());
            sb.setLength(0);
        }
        Map<Character,Integer> mt = new HashMap<>();
        mt.
        sb.toString().substring(beginIndex, endIndex);
        
        System.out.println(set.size());
        
        /*
         Set set=new HashSet();
for(String s: A){
String even="",odd="";
for(int i=0;i<s.length();i++){
if(i%2==0)
even+=s.charAt(i);
else
odd+=s.charAt(i);
}
char o[]=odd.toCharArray();
char e[]=even.toCharArray();
Arrays.sort(o);
Arrays.sort(e);
set.add(new String(o)+new String(e));
}
return set.size();
         * */

	}

}
