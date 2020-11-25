
public class CanPlaceFlowers {

	public static void main(String[] args) {
		int[] a = {1,0,0,0,0,1};
		System.out.println(canPlaceFlowers(a,2));
	}

	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //int i=0;
        int s=0;
        int p=0;
        for(int i=0; i<flowerbed.length;){
            if(flowerbed[i] == 1){
                i=i+2;
                //s++;
            }else if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                i=i+2;
                s++;
            }else {
            	i++;
            }
            if(n == s) break;
        }
        if(n == s) return true;
        return false;
    }

}
