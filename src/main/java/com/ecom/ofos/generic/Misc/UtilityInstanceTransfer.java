package com.ecom.ofos.generic.Misc;

import com.aventstack.extentreports.ExtentTest;

public class UtilityInstanceTransfer {
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
/**
 * 
 * @return
 */
	public static ExtentTest getExtenttest() {
		return extentTest.get();
	}
/**
 * 
 * @param setExtentTest
 */
	public static void setExtenttest( ExtentTest setExtentTest) {
		
		extentTest.set(setExtentTest);
	}
	

}
