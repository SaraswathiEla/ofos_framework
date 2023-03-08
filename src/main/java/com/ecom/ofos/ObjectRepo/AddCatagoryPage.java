package com.ecom.ofos.ObjectRepo;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this pom page  is used to declare add catagory page webElement and intialize and businesslogic methods
 * @author Saraswathi B
 *
 */
public class AddCatagoryPage {

	//declaration	
			@FindBy(name="c_name")
			private WebElement  catgoryTxtbx;
			@FindBy(name="submit")
			private WebElement  saveCatagoryBtn;
			private String partialXpath="//td/ancestor::div//td[.='%s']";
			private WebDriver driver;

		/**
		 *This Constructor will intialize the webelemen
		 * @param driver
		 */
			public AddCatagoryPage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			/**
			 * 
			 * @param replaceText
			 * @return
			 */
			private WebElement convertToWebElement(String replaceText) {
				
				String xpath=String.format(partialXpath, replaceText);
				return driver.findElement(By.xpath(xpath));
			}

			/**
			 * this method will enter catagory name into catagory textbox
			 * @param catagoryName
			 */
			//businesslogic
			public void addCatagoryAction(String catagoryName)
			{
		       catgoryTxtbx.sendKeys(catagoryName+new Random().nextInt(100));
				saveCatagoryBtn.click();
			}
			/**
			 * this method will return the catagory added alert message
			 * @param category
			 * @return
			 */
			public String getAlertMessage(String category) {
				return convertToWebElement(category).getText();
				
			}

	
}
