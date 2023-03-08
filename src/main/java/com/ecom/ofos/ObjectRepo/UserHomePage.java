package com.ecom.ofos.ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	//declaration	
	@FindBy(name="username")
	private WebElement  unTxtbx;
	@FindBy(name="password")
	private WebElement  pwdTxtbx;
	@FindBy(name="submit")
	private WebElement  lgbtn;
 
	
	
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//businesslogic
 
	public void UserHomeLogin(String un,String pwd)
	{
		unTxtbx.sendKeys(un);
		pwdTxtbx.sendKeys(pwd);
		lgbtn.click();
	}
	/**
	 * this method is used to click the loginlink
	 */
	}


 
