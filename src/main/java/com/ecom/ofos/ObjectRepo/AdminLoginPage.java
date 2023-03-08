package com.ecom.ofos.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this pom page  is used to declare AdminLoginPage webElement and intialize and businesslogic methods
 * @author Saraswathi B
 *
 */

public class AdminLoginPage {
	
//declaration	
	@FindBy(name="username")
	private WebElement untbx;

	@FindBy(name="password")
	private WebElement pwdtbx;

	@FindBy(name="submit")
	private WebElement lgbtn;
	/**
	 * this constructor is used to intialze the driver
	 * @param driver
	 */
	//intialization
	public  AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//busineess logic
	/**
	 * This methpod is used to Admin 
	 * @param un
	 * @param pwd
	 */
	public void adminLoginAction(String un,String pwd)
	{
		untbx.sendKeys(un);
		pwdtbx.sendKeys(pwd);
		lgbtn.click();
	}
}
