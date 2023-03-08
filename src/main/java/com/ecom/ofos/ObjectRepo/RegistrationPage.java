package com.ecom.ofos.ObjectRepo;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	/**
	 * 
	 * 
	 */

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTextField;
	
	@FindBy(name="email")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//textarea[@id=\"exampleTextarea\"]")
	private WebElement addressTextArea;
	
	@FindBy(xpath = "//input[@name=\"submit\"]")
	private WebElement submitButton;
	
	@FindBy(xpath="//input[@name=\"firstname\"]")
	private WebElement firstnametxtField;
	
	@FindBy(xpath="//input[@name=\"lastname\"]")
	private WebElement lastnametxtField; 
	
	@FindBy(xpath="//input[@name=\"phone\"]") 
	private WebElement phonetxtFiels;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement passwordtxtField;
	
	@FindBy(xpath="//input[@name=\"cpassword\"]")
	private WebElement cpasswordtxtField;
	
	/**
	 * this is constructor is used to intialize the webElement.
	 * @param driver
	 */
	public RegistrationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
/**
 * 
 * @param username
 * @param data
 */
	public  void usercreate(String username,Map<String, String> data)
	{ 
		System.out.println(data);
		usernameTextField.sendKeys(username+new Random().nextInt(100));
		firstnametxtField.sendKeys(data.get("First Name"));
		lastnametxtField.sendKeys(data.get("Last Name"));
		phonetxtFiels.sendKeys(data.get("Phone number"));
		passwordtxtField.sendKeys(data.get("Password"));
		cpasswordtxtField.sendKeys(data.get("Confirm password"));
		emailTextField.sendKeys("sara"+new Random().nextInt(100)+username+data.get( "Email Address"));
		addressTextArea.sendKeys(data.get("Delivery Address"));
		submitButton.click();
   }
	
} 