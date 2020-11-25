
public class ReverseOnlyLetters {

	public static void main(String[] args) {
		String S = "ab-cd";
		char [] cA = S.toCharArray();
        int i=0;
        int j= S.length()-1;
        char c;
        while(i<j){
            if((cA[i] >= 'a' && cA[i]<='z' || cA[i] >= 'A' && cA[i]<='Z') && (cA[j] >= 'a' && cA[j]<='z' || cA[j] >= 'A' && cA[j]<='Z')){
                c = cA[i];
                cA[i] = cA[j];
                cA[j]=c;
                i++;
                j--;
            }else if(!(cA[i] >= 'a' && cA[i]<='z' || cA[i] >= 'A' && cA[i]<='Z') && (cA[j] >= 'a' && cA[j]<='z' || cA[j] >= 'A' && cA[j]<='Z')){
                i++;
            }else if((cA[i] >= 'a' && cA[i]<='z' || cA[i] >= 'A' && cA[i]<='Z') && !(cA[j] >= 'a' && cA[j]<='z' || cA[j] >= 'A' && cA[j]<='Z')){
                j--;
            }else{
                i++;
                j--;
            }
        }
        System.out.println(new String(cA));
	}

}
