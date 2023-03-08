package com.ecom.ofos.generic.JavaUtility;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class JavaUtility 
{
	/**
	 * This method will return the random number every time whenever it is called 
	 * @param boundryValue
	 * @return
	 */
public int getRandomNumber(int boundryValue)      //boubdryvalue=1000
{
	return new Random().nextInt(boundryValue);
}
/**
 * This method is used to print in the consol
 * object because we can pass anything even String and Integer
 * @param output
 */
public void consolPrint(Object output)
{
	System.out.println(output);
}
/**
 * This method is used to convert monthName into monthNumber and mention the pattern as below specified
 * MMMM --->> month full name
 * MMM  --->> month short name
 * @param mothName
 * @param pattren
 */
public int getMonthNumber(String mothName,String pattren)
{
	int monthNumber = DateTimeFormatter.ofPattern(pattren.toUpperCase())
	.withLocale(Locale.ENGLISH)
	.parse(mothName)
	.get(ChronoField.DAY_OF_MONTH);
	
	return monthNumber;
}

/**
 * This method used to convert string data type to integer datatype
 * @param s
 * @return
 */
public int parseNumber(String s)
{
	return Integer.parseInt(s);
	
}
/**
 * This method used to split the string based on the given strategy like space(" "),comma(",") 
 * @param s
 * @param strategy
 * @return
 */
public String[] split(String s,String strategy)
{
	return s.split(strategy);
}
/**
 * This method is used to encrypt the given string
 * @param s
 * @return
 */
public String encode(String s)
{
	return new String(Base64.getEncoder().encode(s.getBytes()));
}
/**
 * This method is used to decrypt the given string
 * @param s
 * @return
 */
public String decode(String s)
{
	return new String(Base64.getDecoder().decode(s.getBytes()));
}
/**
 *  This method used get the current date
 * @return
 */
public String getCurrentDateTime()
{
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");
	String date = sdf.format(new Date());
	return date;
}
/**
 *  This method used get the any date by passing required date
 * @param days
 * @return
 */
public String addorSubstractDate(int days)
{
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, days);
	return sdf.format(cal.getTime());
}
/**
 * This method is used get the any date from given date 
 * date is a string and in this format  ===>>>  01_01_2020
 * days is in integer format 
 * @param date
 * @param days
 * @return
 * @throws ParseException
 */
public String addorSubstractDate(String date,int days) throws ParseException
{
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
	Calendar cal = Calendar.getInstance();
	cal.setTime(sdf.parse(date));
	cal.add(Calendar.DAY_OF_MONTH, days);
	return sdf.format(cal.getTime());
}
}
 

