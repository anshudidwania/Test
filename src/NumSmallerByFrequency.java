
public class NumSmallerByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] queries= {"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
		String[] words= {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
		for(int i:numSmallerByFrequency(queries, words)) {
			System.out.print(i);
		}
	}
	
	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int [] ans = new int[queries.length];
        int [] querie = new int[queries.length];
        int [] word = new int[words.length];
        for(int i=0; i<queries.length; i++) {
            querie[i] = numSmaller(queries[i]);
        }
        for(int i=0; i<words.length; i++) {
            word[i] = numSmaller(words[i]);
        }
        for(int i=0; i<querie.length; i++) {
            for(int j=0; j<word.length; j++) {
                if(word[j] > querie[i]){
                    ans[i]=ans[i]+1;
                }
            }
        }
        return ans;
    }
    
    public static int numSmaller(String s) {
        char [] cA = s.toCharArray();
        char c = cA[0];
        int f = 1;
        for(int i=1; i<cA.length; i++){
            if(cA[i] < c){
                c = cA[i];
                f =1;
            }else if(cA[i] == c){
                f++;
            }
        }
        return f;
    }

}
