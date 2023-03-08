package com.ecom.ofos.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.ofos.generic.Webaction.waitUtility;
/**
 * this pom page  is used to declare AdminPanelPage webElement and intialize and businesslogic methods
 * @author Saraswathi B
 *
 */
public class AdminPanelPage {
	//declaration	
		@FindBy(xpath="//span[text()=\"Restaurant\"]")
		private WebElement  resturantExpandAndColapseBtn;
		
		@FindBy(xpath="//span[text()=\"Menu\"]")
		private WebElement menuExpandAndColapseBtn;
		
		@FindBy(xpath="//a[.='Add Menu']")
		private WebElement  addMenuBtn;
	
		
		@FindBy(xpath="//a[text()=\"Add Category\"]")
		private WebElement  addCatgoryBtn;
		
		@FindBy(xpath="//a[.='Add Restaurant']")
		private WebElement  addResturantBtn;
	
		/**
		 * 
		 * @param driver
		 */
		//intialization
		
		public AdminPanelPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//businesslogic
		/**
		 * thismethod is used to click the ReturantExpandAndColapse button
		 */
		public void resturantClick()
		{
			resturantExpandAndColapseBtn.click();
		}
		/**
		 * thismethod is used to click the ReturantExpandAndColapse button
		 * @throws InterruptedException 
		 */
		public void menuClick(waitUtility wait,int pollingTime,int duration) throws InterruptedException
		{
		
			wait.waitTillClick(pollingTime, duration, menuExpandAndColapseBtn);
			menuExpandAndColapseBtn.click();
		}
		
		/** 
		 * this method is used to click  add catagory button
		 */
		public void addCatagory()
		{
			addCatgoryBtn.click();
		}
		/**
		 * this method is used click add resturant button
		 * @throws InterruptedException 
		 */
		public void addResturant(waitUtility wait,int pollingTime,int duration) throws InterruptedException {
			wait.waitTillClick(pollingTime, duration, addResturantBtn);

			addResturantBtn.click();
		}
		/**
		 * this method is used click  addMenu button
		 * @throws InterruptedException 
		 */
		
		public void addMenu(waitUtility wait,int pollingTime,int duration) throws InterruptedException {
			wait.waitTillClick(pollingTime, duration, addMenuBtn);
			addMenuBtn.click();
		}
		  
}
