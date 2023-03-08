package com.ecom.ofos.ObjectRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.ofos.generic.Webaction.waitUtility;

public class UserCommonPage {

	@FindBy(xpath = "//a[.='Register']")
	private WebElement registerLink;
	@FindBy(xpath = "//a[text()='Restaurants ']")
	private WebElement restaurantsLink;
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginlink;
	@FindBy(xpath="//a[text()='Yorkshire Lamb Patties']") //write dynamic xpath
	private WebElement popularDishlink;
	
   public UserCommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickRegisterLink(waitUtility wait,int pollingTime,int duration) throws InterruptedException {
 		wait.waitTillClick(pollingTime, duration, registerLink);
		
		registerLink.click();
	}
	
	public void clickRestaurantsLink(waitUtility wait,int pollingTime,int duration) throws InterruptedException {
		wait.waitTillClick(pollingTime, duration, restaurantsLink);

		restaurantsLink.click();
	}
	public void userloginLink(waitUtility wait,int pollingTime,int duration) throws InterruptedException
	{ 
		wait.waitTillClick(pollingTime, duration, loginlink);

		loginlink.click();
	}
	//write dynamic xpath
	public void popularDish(waitUtility wait,int pollingTime,int duration) throws InterruptedException
	{ 
		wait.waitTillClick(pollingTime, duration, popularDishlink);

		popularDishlink.click();
	}


}



