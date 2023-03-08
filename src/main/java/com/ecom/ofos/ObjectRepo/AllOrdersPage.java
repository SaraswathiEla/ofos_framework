package com.ecom.ofos.ObjectRepo;
 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrdersPage {
	//declation
	/**
	 * 
	 */
	private WebDriver driver = null;

	@FindAll({ @FindBy(xpath = "//tr[last()]//preceding-sibling::td//button"),
			@FindBy(xpath = "//tr[last()]//button") })
	private WebElement currentOrderStatusText;
	@FindBy(xpath = "//tr[last()]/td/a[contains(@class,'btn-sm')]")
	private WebElement editOrderIcon;
/**
 * this is a constructor is used to intialize the driver
 * @param driver
 */
	public AllOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
/**
 * this method will return the CurrentOrder Status
 * @return
 */
	public String getOrderStatus() {
		return currentOrderStatusText.getText();
	}
/**
 *  * this method will return the  OrderID Status
 * @param orderTime
 * @return
 */
	public String getOrderId(String orderTime) {
		return "//td[text()='" + orderTime + "']";
	}
/**
 * this method will return ther orderTime
 * @param orderTime
 * @return
 */
	public String getOrderTimeForValidation(String orderTime) {
		return driver.findElement(By.xpath(getOrderId(orderTime))).getText();
	}
	/**
	 * This method  is used to click the Edit Icon
	 * @param orderTime
	 */

	public void clickOnEditOrderIcon(String orderTime) {
		driver.findElement(By.xpath(getOrderId(orderTime) + "//following-sibling::td//a[contains(@class,'btn-sm')]"))
				.click();
	}
	/**
	 * This method  is used to clickOnEditOrderIcon ...
	 * @param orderTime
	 */


	public void clickOnEditOrderIcon() {
		editOrderIcon.click();
	}
}
