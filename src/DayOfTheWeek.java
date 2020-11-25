import java.util.Calendar;

public class DayOfTheWeek {

	public static void main(String[] args) {
		System.out.println(dayOfTheWeek(31,8,2019));
	}
	public static String dayOfTheWeek(int day, int month, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        int d = c.get(Calendar.DAY_OF_WEEK);
        //System.out.print("Today is ");
        switch (d) {
            case 1:
                return("Sunday");
            case 2:
                return("Monday");
            case 3:
                return("Tuesday");
            case 4:
                return("Wednesday");
            case 5:
                return("Thursday");
            case 6:
                return("Friday");
            case 7:
                return("Saturday");
        }
		return null;
    }

}
