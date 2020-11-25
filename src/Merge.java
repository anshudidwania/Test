
public class Merge {

	public static void main(String[] args) {
		int[] a = {1,2,3,0,0,0};
		int[] b = {2,5,6};
		merge(a,3,b,3);
		//System.out.println(canPlaceFlowers(a,3,b,3));

	}

	public static void merge(int[] num1, int m, int[] num2, int n) {
        int [] num = new int[m+n];
        int l=0;
        int r=0;
        int i=0;
        while(l<m && r<n){
            if(num1[l]<num2[r]){
                num[i]=num1[l];
                l++;
            }else{
                num[i]=num2[r];
                r++;
            }
            i++;
        }
        
        for(int ii=l; i<m; ii++){
            num[i]=num1[ii];
            i++;
        }
        for(int ii=r; i<n; ii++){
            num[i]=num2[ii];
            i++;
        }
        
        for(int ii=0; i<m+n; i++){
            num1[i]=num[i];
        }
    }
}
