package com.ecom.ofos.ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestaurantsPage {

	@FindBy(xpath = "//a[text()='FishLand*' and @href='dishes.php?res_id=37']")
	private WebElement restaurantNameLink;
	@FindBy(xpath="(//a[text()='View Menu'])[1]")
	private WebElement viewMenuButton;


	public RestaurantsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickRestaurantNameLink() {
		restaurantNameLink.click();
	}
	public void viewMenuButton() {
		
	viewMenuButton.click();
}
}
