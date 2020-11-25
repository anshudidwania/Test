
public class RotateArray {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		rotate(a, 3);
		System.out.println(a);
	}
	
	public static void rotate(int[] nums, int k) {
        int [] ns = new int[nums.length];
        int i=0;
        
        for(; i<nums.length-k-1;i++){
            ns[i] = nums[k+1+i];
        }
        int j=0;
        for(; i<nums.length;i++){
             ns[i] = nums[j];
            j++;
        }
        nums=ns;
    }

}
