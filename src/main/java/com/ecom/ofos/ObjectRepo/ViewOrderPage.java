	package com.ecom.ofos.ObjectRepo;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ViewOrderPage {

		@FindBy(xpath = "//button[text()='Update Order Status']")
		private WebElement updateOrderStatusButton;

		public ViewOrderPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public void clickUpdateOrderStatusButton() {
			updateOrderStatusButton.click();
		}
	}

