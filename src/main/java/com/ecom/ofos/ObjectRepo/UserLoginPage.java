package com.ecom.ofos.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {

	@FindBy(name = "username")
	private WebElement usernameTextField;
	@FindBy( xpath="//input[@placeholder=\"Password\"]")
	private WebElement passwordTextField;
	@FindBy(id = "buttn")
	private WebElement loginButton;

	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginAction(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
}