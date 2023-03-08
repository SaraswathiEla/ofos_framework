package com.ecom.ofos.generic.Webaction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Popuputility {
	/**
	 * this method is used to handle the Alert popup
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to Cancel the Alert popup
	 * 
	 * @param driver
	 */
	public void closeAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		;
	}

	/**
	 * this method is used to getText on the Alert popup
	 * 
	 * @param driver
	 */
	public void getTextAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
/**
 * this method is used to switch window using titile
 * @param driver
 * @param PartialWindowTitle
 */
	public void switchWindow(WebDriver driver, String PartialWindowTitle) {
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it = allwh.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			if (driver.getTitle().contains(PartialWindowTitle)) {
				break;
			}
		}

	}
	/**
	 * this method is used to switch window using URL
	 * @param driver
	 * @param PartialWindowTitle
	 */

	public void switchWindow(String PartialWindowURL, WebDriver driver) {
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it = allwh.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			if (driver.getCurrentUrl().contains(PartialWindowURL)) {
				break;
			}
		}
	}
	/**
	 * this method is used to switch window using element
	 * @param driver
	 * @param PartialWindowTitle
	 */

	public void switchWindow(WebDriver driver, WebElement Element,String text) {
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it = allwh.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			if (Element.getText().contains(text)) {
				break;
			}
		}

	}

 

}
