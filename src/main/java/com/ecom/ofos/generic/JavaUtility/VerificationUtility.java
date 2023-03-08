package com.ecom.ofos.generic.JavaUtility;

public class VerificationUtility {
	
	/**
	 * this method is used to verify testcase,page,element
	 * @param actual
	 * @param expected
	 * @param strategy
	 * @param pageOrElementOrTCname
	 */
	
	public void exactVerifyUsingSwitch(String actual,String expected,String strategy,String pageOrElementOrTCname) {
	
		String pass="";
		String fail="";
		switch(strategy.toUpperCase())
		{
			case "TC":
				pass="  Test case is pass";
				fail="   TestCase is fail";
				break;

			case "PAGE":
				pass=" PAGE is dispayed";
				fail=" PAGE is not displayed";
				break;

			case "ELEMENT":
				pass=" is present";
				fail=" is not present";
				break;
				default:
					break;
		}
		if (actual.equals(expected)) {
			System.out.println(pageOrElementOrTCname+pass);
		} else {
			System.out.println(pageOrElementOrTCname+fail);
		}
	
	}
	/**
	 * We use this method when accepted result meets actual result
	 *  
	 * (String actResult,String expResult,String strategy,String paegNameorTCNameorwebelement)
	 * strategy ---- >>> Tc,page,webElement
	 * @param actResult
	 * @param expResult
	 */
	public void exactverifiaction(String actResult,String expResult,String strategy,String paegNameorTCNameorWebelement)
	{
		if(strategy.equalsIgnoreCase("Tc"))
		{
			if(actResult.equals(expResult))
			{
				System.out.println(paegNameorTCNameorWebelement+"TC is pass");
			}
			else
			{
				System.out.println(paegNameorTCNameorWebelement+"TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page"))
		{
			if(actResult.equals(expResult))
			{
				System.out.println(paegNameorTCNameorWebelement+"Page is Displayed");
			}
			else
			{
				System.out.println(paegNameorTCNameorWebelement+"Page is not Displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("webElement"))
		{
			if(actResult.equals(expResult))
			{
				System.out.println(paegNameorTCNameorWebelement+"webElement is showing");
			}
			else 
			{
				System.out.println(paegNameorTCNameorWebelement+"webElement is not showing");
			}
		}
	}

	/**
	 *  We use this method when accepted result partially meets actual result 
	 * @param actResult
	 * @param expResult
	 */
	public void partialverification(String actResult,String expResult,String strategy,String PageNameorTCName)
	{
		if(strategy.equalsIgnoreCase("TC"))
		{
			if(actResult.contains(expResult))
			{
				System.out.println(PageNameorTCName+"TC is pass");
			}
			else
			{
				System.out.println(PageNameorTCName+"TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page"))
		{
			if(actResult.contains(expResult))
			{
				System.out.println(PageNameorTCName+"Page is Displayed");
			}
			else
			{
				System.out.println(PageNameorTCName+"Page is Not Displyed");
			}	
		}
		else if(strategy.equalsIgnoreCase("webElement"))
		{
			if(actResult.contains(expResult))
			{
				System.out.println(PageNameorTCName+"webElement is Displayed");
			}
			else
			{
				System.out.println(PageNameorTCName+"webElement is Not Displyed");
			}	
		}

	}

	/**
	 * 
	 * @param actual
	 * @param expected
	 * @param startegy
	 * @param pagenameORtc
	 */
	public void exactVerify(String actual, String expected,String startegy,String pagenameORtcName) {
		if (startegy.equalsIgnoreCase("TC"))
		if (actual.equals(expected)) {
			System.out.println("TC is pass");
		} else {
			System.out.println("TC is fail");
		}
	}
}
