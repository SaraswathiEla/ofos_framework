package PracticeTestScript.dataDrivenPractice;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetPreviusDateByCalendarInstance {

	public static void main(String[] args) throws ParseException  {
            String givendate = "13_DEC_2022";
           SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy");
           Calendar cal = Calendar.getInstance();
           cal.setTime(sdf.parse(givendate));
           cal.add(Calendar.DAY_OF_MONTH, 2);
           String date = sdf.format(cal.getTime());
           System.out.println(date);
	}

}