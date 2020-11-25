
public class DistanceBetweenBusStops {

	public static void main(String[] args) {
		int []a = {8,11,6,7,10,11,2};
		System.out.println(distanceBetweenBusStops(a, 0,3));


	}
	public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start == destination) return 0;
        int c = 0;
        for(int i=start; i<destination; i++){
            c = c+distance[i];
        }
        int ac=0;
        int x=-1;
        for(int i=destination; i<distance.length && x < start; ){
            ac = ac+distance[i];
            i++;
            if(i == distance.length) {
            	i=0;
            	x=0;
            }
        }
        
        return c>ac?ac:c;
    }
}
