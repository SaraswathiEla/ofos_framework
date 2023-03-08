package com.ecom.ofos.ObjectRepo;

/**
 * this pom page  is used to declare Add Resturant page webElement and intialize and businesslogic methods
 * @author Saraswathi B
 *
 */
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * this pom page  is used to declare AddResturantPage webElement and intialize and businesslogic methods
 * @author Saraswathi B
 *
 */


public class AddResturantPage {
	//declaration
	@FindBy(xpath="//input[@name=\"res_name\"]")
	private WebElement restaurantNametxtBx;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	private WebElement bussinessEmailtxtBx;
	
	@FindBy(xpath="//input[@name=\"phone\"]")
	private WebElement phonetxtBx;
	
	@FindBy(xpath="//input[@name=\"url\"]")
	private WebElement websiteURLtxtBx;
	
	@FindBy(xpath="//select[@name=\"o_hr\"]")
	private WebElement openHoursDpBx;
	
	@FindBy(xpath="//select[@name=\"c_hr\"]")
	private WebElement closeHoursDPBx;
	
	@FindBy(xpath="//select[@name=\"o_days\"]")
	private WebElement  OpenDaysDPBx;
	
	@FindBy(xpath="//input[@name=\"file\"]")
	private WebElement imageupload;
	
	@FindBy(xpath="//select[@name=\"c_name\"]")
	private WebElement 	selectCategoryDPBx;

	@FindBy(xpath="//textarea[@name=\"address\"]")
	private WebElement 	restaurantAddresstxtBx;
	
	@FindBy(xpath="//input[@name=\"submit\"]")
	private WebElement 	saveRestaurantBtn;
	
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible fade show\"]")
	private WebElement alertMessagetext;

	/**
	 * intialization 
	 * @param driver
	 */
	public AddResturantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	private Select s ;
	public WebElement getRestalertMessagetext()
	{
		return alertMessagetext;
	}
 	/**
 	 * thismethod is used to addrestrant in resturant module
 	 * @param data
 	 */
	 public void addResturant(Map<String, String> data)
	{
		restaurantNametxtBx.sendKeys(data.get("ResturantName")+new Random().nextInt(100));
		bussinessEmailtxtBx.sendKeys(data.get("BusinessEmail"));
		phonetxtBx.sendKeys(data.get("Phone"));
		websiteURLtxtBx.sendKeys(data.get("WebsiteUrl"));
		s=new Select(openHoursDpBx);
		s.selectByValue(data.get("Openhours"));
		s=new Select(closeHoursDPBx);
		s.selectByValue(data.get("closehours"));
		s=new Select(OpenDaysDPBx);
		s.selectByValue(data.get("opendays"));
		 imageupload.sendKeys( data.get("imagepath"));
		s=new Select(selectCategoryDPBx);
		s.selectByVisibleText(data.get("SelectCategory"));
		 restaurantAddresstxtBx.sendKeys(data.get("ResturantAddress"));
		saveRestaurantBtn.click();
	}
	
	
 }
