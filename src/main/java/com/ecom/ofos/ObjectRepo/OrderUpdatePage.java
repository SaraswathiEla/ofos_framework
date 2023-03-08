package com.ecom.ofos.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.ofos.generic.Webaction.DropDownUtility;
import com.ecom.ofos.generic.Webaction.Seleniumutility;
 

public class OrderUpdatePage{
/**
 * This is a webElement declaration ...
 */
	@FindBy(name = "status")
	private WebElement statusDropdown;

	@FindBy(name = "remark")
	private WebElement remarkTextArea;

	@FindBy(name = "update")
	private WebElement updateButton;

	@FindBy(name = "Submit2")
	private WebElement closeWindowButton;
/**
 * this constructor is used to intialize the driver
 * @param driver
 */
	public OrderUpdatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * This method is used to update the order....
 * @param dropdown
 * @param remark
 * @param seleniumUtility
 */
	public void OrderUpdateAction(DropDownUtility dropdown, String remark, Seleniumutility seleniumUtility) {
		// Delivered
		dropdown.selectByVisibleText(statusDropdown, remark);
		remarkTextArea.sendKeys(remark);
		updateButton.click();
		seleniumUtility.acceptAlert();
		closeWindowButton.click();
	}
}
