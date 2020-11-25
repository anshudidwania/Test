import java.util.ArrayList;
import java.util.List;

public class MaximizingProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List <Long> ls = new ArrayList<Long> ();
		ls.add(3l);
		ls.add(4l);
		ls.add(5l);
		ls.add(3l);
		ls.add(5l);
		ls.add(2l);*/
		
		List <Long> ls = new ArrayList<Long> ();
		ls.add(7l);
		ls.add(6l);
		ls.add(5l);
		ls.add(10l);
		ls.add(9l);
		
		
		/*List <Long> ls = new ArrayList<Long> ();
		ls.add(5l);
		ls.add(3l);
		ls.add(2l);
		
		
		List <Long> ls = new ArrayList<Long> ();
		ls.add(1l);
		ls.add(2l);
		ls.add(100l);
		
		
		List <Long> ls = new ArrayList<Long> ();
		ls.add(1l);
		ls.add(3l);
		ls.add(1l);
		ls.add(2l);*/
		
		//long n = 6;
		long profit = 0;
		long buyQty = 0;
		/*if(ls.size() <= 1) {
			profit = 0;
		}else if(ls.size() == 2 && ls.get(0) >= ls.get(1)) {
			profit = 0;
		}else {*/
			for(int i=0; i<ls.size();i++) {
				if (i+1<ls.size() && ls.get(i+1) > ls.get(i)) {
					profit = profit + buy(ls.get(i));
					System.out.println(i +"-b-"+profit);
					buyQty++;
				}else  {
					profit = profit + sell(buyQty, ls.get(i));
					System.out.println(i +"-s-"+profit);
					buyQty = 0;
				}
			}
		//}
		
		System.out.println(profit);
	
	}

	public static long buy (long amt) {
		return amt*(-1);
	}

	public static long sell (long qty, long amt) {
		return qty*amt;
	}

}
