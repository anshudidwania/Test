import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class Test1 {
public static void main(String[] args) {
	new Test();
	
		
		
	}

 static int getDateTypeFunction(Date input, int type){
    int output = -1;
   if(null != input){
       Calendar cal = Calendar.getInstance();
       cal.setTime(input);
       output = cal.get(type);
   }
   return output;
}
 
  static Date convertToDateFromString(String dateString){
	    if(StringUtils.isNotBlank(dateString)){	
			try{
				SimpleDateFormat dateFormat = new SimpleDateFormat();
				dateFormat.applyPattern("dd-MMM-yyyy");
				Date date = dateFormat.parse(dateString);
				return date;
			}catch(ParseException parseException) {
			    System.out.println("LoyConnectUtil: Error in toCalendarFromDateString : "+ parseException);
			}
		}
		return null;
	}
}
