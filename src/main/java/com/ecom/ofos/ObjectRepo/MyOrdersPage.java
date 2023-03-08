package com.ecom.ofos.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage {
	/**
	 * declare the Myorder page webElemtt
	 */
	
	@FindBy(xpath = "(//td[@data-column='Date'])[last()]")
	private WebElement orderTime;
	
	@FindBy(xpath = "//tr//td[1]")
	private WebElement axpDishe;

/**
 * this contructor is used to intialze the driver
 * @param driver
 */
	public MyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * This method will return the orderTime
 * @return
 */
	public String getOrderTime() {
		return orderTime.getText().trim();
	}
	/**
	 * this method will return the actual dish placed in MyOrder Page
	 * @return
	 */
	public String axpDishe() {
		return axpDishe.getText();
	}
}
