package com.ecom.ofos.generic.Reporter;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ecom.ofos.generic.Constant.FrameWorkConstants;
import com.ecom.ofos.generic.Misc.UtilityInstanceTransfer;
 
public class ReportUtility {

	private ExtentReports report;
	private ExtentTest test;
	private String extentFileReportPath;

	public void init(String filePath, String title, String reportname, String browserName) {
		extentFileReportPath="FrameWorkConstants.EXTENT_REPORT_PATH+\"extentReport\"+filePath+\".html\"";
		ExtentSparkReporter spark = new ExtentSparkReporter(extentFileReportPath);
		spark.config().setDocumentTitle(title);
		spark.config().setReportName(reportname);
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", browserName);
		report.setSystemInfo("OS", System.getProperty("os.name"));

	}

	public void createTest(String testName) {
		test = report.createTest(testName);
		UtilityInstanceTransfer.setExtenttest(test);
		
	}

	public void pass(ExtentTest test,String message) {
		test.pass(message);
		System.out.println(message);
	}

	public void fail(ExtentTest test,String message) {
		test.fail(message);
		System.out.println(message);
	}

	public void fail(ExtentTest test,Throwable errorMessage) {
		test.fail(errorMessage);
		System.out.println(errorMessage);
	}

	public void warn(ExtentTest test,String message) {
		test.warning(message);
		System.out.println(message);
	}

	public void skip(ExtentTest test,Throwable errorMsg,String message) {
		test.skip(message);
		test.skip(errorMsg);
		System.out.println(message);
	}

	public void skip(ExtentTest test,String message,Throwable errorMessage) {
		test.skip(message);
		test.skip(errorMessage);
		System.out.println(errorMessage);
	}

	public void info(ExtentTest test,String message) {
		test.info(message);
		System.out.println(message);
	}

	public void addAuthor(ExtentTest test,String... names) {
		test.assignAuthor(names);
		UtilityInstanceTransfer.setExtenttest(test);

	}

	public void addCategory(ExtentTest test,String... names) {
		test.assignCategory(names);
		UtilityInstanceTransfer.setExtenttest(test);

	}

	public void attachScreenshot(ExtentTest test,String screenshotPath, String title, String strategy) {

		if (strategy.equalsIgnoreCase("base64"))
			test.addScreenCaptureFromBase64String(screenshotPath, title);
		else
			test.addScreenCaptureFromPath(screenshotPath, title);
	}

	public void saveReport() {
		//Destop is a Singlton class it will create only one object
		try {
			Desktop.getDesktop().browse(new File(extentFileReportPath).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report.flush();
	}
}