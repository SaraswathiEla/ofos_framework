package com.ecom.ofos.generic.Webaction;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ecom.ofos.generic.Constant.FrameWorkConstants;
import com.ecom.ofos.generic.JavaUtility.DateUtility;

public class ScreenShotUtility {
	WebDriver driver;
	public ScreenShotUtility(WebDriver driver) {
		this.driver=driver;
	}
	/**
	 * this method  is used to take screenshot of the webpage
	 * @param driver
	 * @param name
	 * @throws IOException
	 */

	public void getScreenshot(WebDriver driver, String name) throws IOException {

		String currentDate = new Date().toString().replaceAll(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.TEST_SCREENSHOT_FILE_PATH_WEBPAGE + name + currentDate + ".png");
		FileUtils.copyFile(src, dest);
	}

	/**
	 * this method  is used to take screenshot of the web element
	 * @param element
	 * @param name
	 * @throws IOException
	 */
	public void getScreenshot(WebElement element, String name) throws IOException {

		String currentDate = new Date().toString().replaceAll(":", "-");
		 File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.TEST_SCREENSHOT_FILE_PATH_WEBELEMENT+ name + currentDate + ".png");
		FileUtils.copyFile(src, dest);
	}
	/**
	 * this method  is used to take screenshot of the webpage
	 * @param driver
	 * @param name
	 * @throws IOException
	 */

	public String capture(String testcaseName,DateUtility dateUtility) throws IOException {

 		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.TEST_SCREENSHOT_FILE_PATH_WEBPAGE + testcaseName+ "  "+dateUtility.getDate() + ".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();

	}
	/**
	 * this method  is used to take screenshot of the web element
	 * @param element
	 * @param name
	 * @throws IOException
	 */

	
	public String capture(WebElement element, String elementName,DateUtility dateUtility) throws IOException {

		String currentDate = new Date().toString().replaceAll(":", "-");
		 File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.TEST_SCREENSHOT_FILE_PATH_WEBELEMENT+ elementName + currentDate + ".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();

	}
	/**
	 * this method is used to take screenshot 

	 * @return
	 */
	public String getScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}



}

