import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {

	public static void main(String[] args) {
		int[] arr = {1,0,2,3,0,4,5,0};
		duplicateZeros(arr);
		System.out.println(arr);

	}
	
	public static void duplicateZeros(int[] arr) {
		Queue<Integer> q = new LinkedList<>();
	        for(int i=0; i<arr.length; i++){
	            if(arr[i]==0){
	            	q.add(0);
	            }else if(!q.isEmpty()){
	                q.add(arr[i]);
	                arr[i] = q.poll();
	            }
	        }
	    }

}
