package com.ecom.ofos.ObjectRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DishesPage {

	private String quantityTextFieldPartialXpath = "//div[@class='food-item']//a[text()='%s']//ancestor::div[@class='col-xs-12 col-sm-12 col-lg-8']/following-sibling::div//input[@name='quantity']";
	private String addToCartButtonPartialXpath = "//div[@class='food-item']//a[text()='%s']//ancestor::div[@class='col-xs-12 col-sm-12 col-lg-8']/following-sibling::div//*[@value='Add To Cart']";
	private WebDriver driver = null;
	@FindBy(name = "quantity")
	private WebElement quantityTextField;
	@FindBy(xpath = "//*[@value='Add To Cart']")
	private WebElement addToCartButton;
	@FindBy(xpath = "//*[text()='Checkout']")
	private WebElement checkoutButton;
	@FindBy(xpath = "//input[@id='example-number-input']")
	private WebElement actualQtyInCheckout;
	@FindBy(xpath = "//div[@class='price-wrap text-xs-center']//strong")
	private WebElement checkOutTotal;
	
	
	
	 
	public DishesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebElement convertToElement(String partialXpath, String replaceData) {
		return driver.findElement(By.xpath(String.format(partialXpath, replaceData)));
	}

	public void addToCartAction(String qty) {
		quantityTextField.clear();
		quantityTextField.sendKeys(qty);
		addToCartButton.click();
	}

	public void addToCartAction(String dish, String qty) {
		WebElement quantity = convertToElement(quantityTextFieldPartialXpath, dish);
		quantity.clear();
		quantity.sendKeys(qty);
		convertToElement(addToCartButtonPartialXpath, dish).click();
	}
public String actualQtyInCheckout()
{
	return actualQtyInCheckout.getAttribute("Value");
}
	public void checkoutAction() {
		checkoutButton.click();
	}
	
	public String checkOutTotal()
	{
		return checkOutTotal.getText();
	}
}