package com.ecom.ofos.generic.JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.protobuf.TextFormat.ParseException;

public class DateUtility {
 
	
	private Calendar c;
	private SimpleDateFormat sdf;
	


/**
 * intialize the calender object
 */
	public DateUtility() {
		c = Calendar.getInstance();
		sdf = new SimpleDateFormat("dd_mm_yyyy_HH_mm_sss");
	}

	public DateUtility(String format) {
		c = Calendar.getInstance();
		sdf = new SimpleDateFormat(format);
	}
/**
 * this method is used to fetch current date in given format
 * @return
 * @throws ParseException
 */
	public String getDate() throws ParseException {
		return sdf.format(c.getTime());
	}
	 

	public String getDate(String dateString) throws ParseException, java.text.ParseException {
		c.setTime(sdf.parse(dateString));
		return sdf.format(c.getTime());
	}

	public String getDate(int amount) throws ParseException {
		c.add(Calendar.DAY_OF_MONTH, amount);
		return sdf.format(c.getTime());
	}

	public String getDate(String dateString, int amount) throws ParseException, java.text.ParseException {
		c.setTime(sdf.parse(dateString));
		c.add(Calendar.DAY_OF_MONTH, amount);
		return sdf.format(c.getTime());
	}

	/**
	 *  this method is used for fetching date
	 * here it will take current date and addOr subtract the no.of days
	 *
	 * @param dateString
	 * @param noOfDays
	 * @return
	 */

public String addOrSubtractDayToCurrentDate(String dateString, int noOfDays)  {
	String date="";
	c = Calendar.getInstance();
	sdf = new SimpleDateFormat("dd-mm-yyyy");
	try {
		c.setTime(sdf.parse(dateString));
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	c.add(Calendar.DAY_OF_MONTH, noOfDays);
	date=sdf.format(c.getTime());
	
	return date;

	
	
}
/**
 * this method is used for fetching date
 * here it will take specified  date and addOr subtract the no.of days
 * @param noOfDays
 * @return
 */

public String addOrSubtractDayToCurrentDate(int noOfDays)  {
	String date="";
	c = Calendar.getInstance();
	sdf = new SimpleDateFormat("dd-mm-yyyy");
    c.add(Calendar.DAY_OF_MONTH, noOfDays);
	date=sdf.format(c.getTime());
	
	return date;

}
/**
 *  this method is used for fetching date
 * here it will take current date and  subtract the no.of days
 *
 * @param dateString
 * @param noOfDays
 * @return
 */

public String  subtractDayToCurrentDate(String dateString, int noOfDays) {
	String date="";
	c = Calendar.getInstance();
	sdf = new SimpleDateFormat("dd-mm-yyyy");
	try {
		c.setTime(sdf.parse(dateString));
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	c.add(Calendar.DAY_OF_MONTH, -noOfDays);
	date=sdf.format(c.getTime());
	
	return date;

}

}


