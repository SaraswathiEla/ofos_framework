package com.ecom.ofos.ObjectRepo;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.ofos.generic.Webaction.DropDownUtility;
/**
 * this pom page  is used to declare add Menu page webElement and intialize and businesslogic methods
 * @author Saraswathi B
 *
 */


public class AddMenuPage {
/**
 * declaring the webelemnet
 */
	@FindBy(name = "d_name")
	private WebElement dishNameTextField;
	@FindBy(name = "about")
	private WebElement descriptionTextField;
	@FindBy(name = "price")
	private WebElement priceTextField;
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement imageUpload;
	@FindBy(name = "res_name")
	private WebElement selectRestoDropdown;
	@FindBy(name = "submit")
	private WebElement submitButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement alertMessage;
/**
 * this constructor is used to intialize the Addmenupage webelement
 * @param driver
 */
	public AddMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * this method will return the alert messege after succefully added the Menu.
 * @return
 */
	public String getAlertMessage() {
		return alertMessage.getText();
	}
/**
 * this methos is used to add the menu details into AddmenuPageS
 * @param dropdown
 * @param restaurantName
 * @param addDishData
 */
	public void addmenuAction(DropDownUtility dropdown,String restaurantName, Map<String, String> addDishData) {

		dishNameTextField.sendKeys(addDishData.get("Dish Name"));
		descriptionTextField.sendKeys(addDishData.get("Description"));
		priceTextField.sendKeys(addDishData.get("Price"));

		imageUpload.sendKeys(addDishData.get("Image"));
		dropdown.selectByVisibleText(selectRestoDropdown,restaurantName);
		submitButton.click();
	}
}
	
	

