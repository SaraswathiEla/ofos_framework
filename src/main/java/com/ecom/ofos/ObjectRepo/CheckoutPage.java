package com.ecom.ofos.ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	/**
	 * declaring the WebElement using findByAnnotation
	 */

	@FindBy(name = "submit")
	private WebElement orderNowButton;

	@FindBy(xpath = "(//tr/td[2])[3]")
	private WebElement CheckoutPageTotal;
/**
 * this constructor is used to intialize the driver(avoid the stale Element Exception
 */
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * this method is used to click the OrderNow Button
 */
	public void orderNowAction() {
		orderNowButton.click();
	}
	/**
	 * this method will return the CheckoutPageTotal 
	 * @return
	 */
	public String CheckoutPageTotal()
	{
		return CheckoutPageTotal.getText();
	}
}
