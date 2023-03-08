package PracticeTestScript.tescriptPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.ofos.ObjectRepo.DishesPage;
import com.ecom.ofos.ObjectRepo.RestaurantsPage;
import com.ecom.ofos.ObjectRepo.UserCommonPage;
import com.ecom.ofos.ObjectRepo.UserLoginPage;
import com.ecom.ofos.generic.Constant.FrameWorkConstants;
import com.ecom.ofos.generic.Enums.PropertyKey;
import com.ecom.ofos.generic.ExternallUtility.PropertyUtility;
import com.ecom.ofos.generic.JavaUtility.JavaUtility;
import com.ecom.ofos.generic.JavaUtility.VerificationUtility;
import com.ecom.ofos.generic.Webaction.Popuputility;
import com.ecom.ofos.generic.Webaction.Seleniumutility;
import com.ecom.ofos.generic.Webaction.waitUtility;

public class Food_AddToCartGenericY {
public static void main(String[] args) throws  IOException {
		WebDriver driver=null;
		Seleniumutility seleniumutility=new Seleniumutility();
		Popuputility popuputility=new Popuputility();
		PropertyUtility p=new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH);
		driver=seleniumutility.launchBrowser(p.getPropertyData(PropertyKey.BROWSER));
		seleniumutility.maximize();
		JavaUtility javaUtility=new JavaUtility();
		waitUtility w=new waitUtility();
		long timeout =Long.parseLong(p.getPropertyData(PropertyKey.TIMEOUT));
		WebDriverWait wait= w.setExplicitWait(driver,timeout);
		String url =p.getPropertyData(PropertyKey.USERURl);
		 seleniumutility.launchApplication(url);
		 String eHomeTitile="Home";
		String aHomeTitile = driver.getTitle();
		VerificationUtility verificationUtility=new VerificationUtility();
		verificationUtility.exactVerifyUsingSwitch(aHomeTitile, eHomeTitile, "page", aHomeTitile);
		//WebDriverWait wait= w.setExplicitWait(driver,timeout);
		  	w.setImplicitWait(driver, timeout);
			w.setImplicitWait(driver, timeout);
			UserCommonPage userCommonPage=new UserCommonPage(driver);
		//	userCommonPage.userloginLink();
			String user=javaUtility.decode(p.getPropertyData(PropertyKey.USERNAME));
			String pwd= javaUtility.decode(p.getPropertyData(PropertyKey.USERPWD));
			UserLoginPage userLogin=new UserLoginPage(driver);
			userLogin.loginAction(user, pwd);
			    String eLoginTitile="home";
		   String aLoginTitile = driver.getTitle();
		verificationUtility.exactVerifyUsingSwitch(aLoginTitile, eLoginTitile, "page", aLoginTitile);
		verificationUtility.exactVerifyUsingSwitch(aHomeTitile, eHomeTitile, "page", aHomeTitile);
	//	 userCommonPage.clickRestaurantsLink();
		 String eResturantTitile="Restaurants";
		String aResturantTitile = driver.getTitle();
	verificationUtility.exactVerifyUsingSwitch(aResturantTitile, eResturantTitile, "page", aResturantTitile);
	RestaurantsPage restaurantsPage=new RestaurantsPage(driver); 
	restaurantsPage.viewMenuButton();                            
 
		String eTitile="Dishes";
		String aTitile = driver.getTitle();
				 wait.until(ExpectedConditions.titleContains(eTitile));                                                                                                  
		verificationUtility.exactVerifyUsingSwitch(aTitile, eTitile, "page", aTitile);	
		 DishesPage dishes=new DishesPage(driver);
		 String qty="3";
		dishes.addToCartAction(qty);
	/*	String aqty = driver.findElement(By.xpath("//input[@id=\"example-number-input\"]")).getAttribute("value");
			verificationUtility.exactVerifyUsingSwitch(aqty, qty, "element", aqty);
	*/	// String etotal = driver.findElement(By.xpath("//div[@class='price-wrap text-xs-center']//strong")).getText();
				 dishes.checkoutAction();
	 
		  String exTitile="Checkout";
		 wait.until(ExpectedConditions.titleContains(exTitile));
			String acTitile = driver.getTitle();
			verificationUtility.exactVerifyUsingSwitch(acTitile, exTitile, "page", acTitile);
			String atotal=driver.findElement(By.xpath("//tr/td[2]")).getText();
			//verificationUtility.exactVerifyUsingSwitch(atotal, etotal, "element", atotal);
 	
 	}

}


