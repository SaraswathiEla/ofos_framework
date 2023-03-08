package com.ecom.ofos.generic.ListenerImplmentation;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ecom.ofos.generic.Annotation.Record;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Constant.FrameWorkConstants;
import com.ecom.ofos.generic.Enums.PropertyKey;
import com.ecom.ofos.generic.ExternallUtility.PropertyUtility;
import com.ecom.ofos.generic.JavaUtility.JavaUtility;
import com.ecom.ofos.generic.Misc.UtilityInstanceTransfer;
import com.ecom.ofos.generic.Reporter.ReportUtility;

public class ExtentReportsListener implements ITestListener, ISuiteListener {

	private ReportUtility report;
	public static ReportUtility sreport;

	/**
	 * this method is used to intialie the Reportutility Object
	 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart--->Suite");
		PropertyUtility proprtyUtility = null;
		// FetchDataFromPropertyFile propUtil = null;
		try {
			proprtyUtility = new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		report = new ReportUtility();
		String overrideOrNot = proprtyUtility.getPropertyData(PropertyKey.OVERRIDERREPORT);
		String randomName = "";
		if (overrideOrNot.equalsIgnoreCase("no"))
			randomName = "-" + new JavaUtility().getCurrentDateTime();
		report.init(randomName, proprtyUtility.getPropertyData(PropertyKey.EXTENTREPORTTITLE),
				proprtyUtility.getPropertyData(PropertyKey.EXTENTREPORTNAME),
				proprtyUtility.getPropertyData(PropertyKey.BROWSER));
		sreport = report;
	}

	/**
	 * 
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart-->test");
	}

	/**
	 * This method will be invoked before @test method execution Extent the text
	 * Object and adds autorname and Catagoryname
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		 Record reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Record.class);
		System.out.println(reportAnnotation.author());
		report.addAuthor(UtilityInstanceTransfer.getExtenttest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfer.getExtenttest(), reportAnnotation.category());
	}

	/**
	 * this method will execute after the test case is pass
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		report.pass(UtilityInstanceTransfer.getExtenttest(), result.getMethod().getMethodName() + "PASS");
	}

	/**
	 * this method will execute after the test case is Fail
	 */

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(UtilityInstanceTransfer.getExtenttest());
		report.fail(UtilityInstanceTransfer.getExtenttest(), result.getThrowable());

		String screenshotPath = BaseClass.class.cast(result.getMethod().getInstance()).screenShotUtility
				.getScreenshot();
		report.attachScreenshot(UtilityInstanceTransfer.getExtenttest(), screenshotPath,
				result.getMethod().getMethodName(), "base64");
	}

	/**
	 * this method will execute after the test case is Skipped
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");

		report.skip(UtilityInstanceTransfer.getExtenttest(), result.getMethod().getMethodName() + "is Failed",
				result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	/**
	 * this method will execute after the test case is FailedWithTimeout
	 */

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onFinish(ITestContext context) {
	}

	/**
	 * this method is save the Report after the suit XML file execution
	 */
	@Override
	public void onFinish(ISuite suite) {

		System.out.println("Onstart---Suite");
		report.saveReport();

	}

}
