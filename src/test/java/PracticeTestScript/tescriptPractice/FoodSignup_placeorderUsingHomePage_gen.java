package PracticeTestScript.tescriptPractice;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.ofos.ObjectRepo.RegistrationPage;
import com.ecom.ofos.ObjectRepo.UserCommonPage;
import com.ecom.ofos.generic.Constant.FrameWorkConstants;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Enums.PropertyKey;
import com.ecom.ofos.generic.ExternallUtility.ExcelUtility;
import com.ecom.ofos.generic.ExternallUtility.PropertyUtility;
import com.ecom.ofos.generic.JavaUtility.JavaUtility;
import com.ecom.ofos.generic.JavaUtility.VerificationUtility;
import com.ecom.ofos.generic.Webaction.Popuputility;
import com.ecom.ofos.generic.Webaction.Seleniumutility;
 

public class FoodSignup_placeorderUsingHomePage_gen {
	public static void main(String args[]) throws Exception
	{
		
	String expTestScriptName="Registraion";
	WebDriver driver=null;
	Seleniumutility seleniumutility=new Seleniumutility();
	Popuputility popuputility=new Popuputility();
	PropertyUtility p=new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH);
	driver=seleniumutility.launchBrowser(p.getPropertyData(PropertyKey.BROWSER));
	seleniumutility.maximize();
	JavaUtility javaUtility=new JavaUtility();
	//WaitUtility w=new WaitUtility();
	long timeout =Long.parseLong(p.getPropertyData(PropertyKey.TIMEOUT));
//	WebDriverWait wait= w.setExplicitWait(driver,timeout);
	String url =p.getPropertyData(PropertyKey.USERURl);
	 seleniumutility.launchApplication(url);
	 String eHomeTitile="Home";
	String aHomeTitile = driver.getTitle();
	VerificationUtility verificationUtility=new VerificationUtility();
	verificationUtility.exactVerifyUsingSwitch(aHomeTitile, eHomeTitile, "page", aHomeTitile);
	   //WebDriverWait wait= w.setExplicitWait(driver,timeout);
		//w.setImplicitWait(driver, timeout);
 			driver.findElement(By.xpath("//a[text()='Register']")).click();
 			 String eRegTitile="Registration";
 			String aRegTitile = seleniumutility.getPageTitle();
 			//wait.until(ExpectedConditions.titleContains(eRegTitile));
 			verificationUtility.exactVerifyUsingSwitch(aRegTitile, eRegTitile, "page", eRegTitile);
 			ExcelUtility excelUtility=new ExcelUtility(FrameWorkConstants.TEST_EXCEL_FILE_PATH);
 				Map<String, String> data=excelUtility.getExcelData(expTestScriptName,ExcelSheet.USER.getSheetName());
			System.out.println(data);
			excelUtility.closeWorkBook();
			String user=data.get("User-Name")+javaUtility.getRandomNumber(100);
			System.out.println(user); 
			RegistrationPage registration=new RegistrationPage(driver);
			String userName=data.get("User-Name")+javaUtility.getRandomNumber(100);
		    
		//	registration.usercreate(data);
			popuputility.acceptAlert(driver);
			UserCommonPage userCommonPage=new UserCommonPage(driver);
			//userCommonPage.userloginLink();
	

			//driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
			String eLoginTitile="Login";
		    String aLoginTitile = driver.getTitle();
			verificationUtility.exactVerifyUsingSwitch(aLoginTitile, eLoginTitile, "page", aLoginTitile);
			driver.findElement((By.name("username"))).sendKeys(user);
			driver.findElement((By.name("password"))).sendKeys(data.get("Password"));
			driver.findElement((By.name("submit"))).click();
			driver.findElement(By.xpath("(//a[@class=\"nav-link active\"])[2]")).click();
			verificationUtility.exactVerifyUsingSwitch(aHomeTitile, eHomeTitile, "page", aHomeTitile);
			driver.findElement(By.xpath("//a[text()='Home ']")).click();
			driver.findElement(By.xpath("//a[text()=\"Yorkshire Lamb Patties\"]")).click();
			String eTitile="Dishes";
			String aTitile = driver.getTitle();
			verificationUtility.exactVerifyUsingSwitch(aTitile, eTitile, "page", aTitile);
			String qty = "3";
		 driver.findElement(By.xpath("(//input[@name=\"quantity\"])[1]")).clear(); 
			 driver.findElement(By.xpath("(//input[@name=\"quantity\"])[1]")).sendKeys(qty);
			driver.findElement(By.xpath("(//input[@value='Add To Cart'])[1]")).click();
			Thread.sleep(2000);
			String aqty = driver.findElement(By.xpath("//input[@id=\"example-number-input\"]")).getAttribute("value");
				verificationUtility.exactVerifyUsingSwitch(aqty, qty, "element", aqty);
				
				
			 String etotal = driver.findElement(By.xpath("//div[@class='price-wrap text-xs-center']//strong")).getText();
			 driver.findElement(By.xpath("//a[text()='Checkout']")).click();
			  String exTitile="Checkout";
			  // wait.until(ExpectedConditions.titleContains(exTitile));
				String acTitile = driver.getTitle();
				verificationUtility.exactVerifyUsingSwitch(acTitile, exTitile, "page", acTitile);
				String atotal=driver.findElement(By.xpath("//tr/td[2]")).getText();
				verificationUtility.exactVerifyUsingSwitch(atotal, etotal, "element", atotal);
				
				driver.findElement(By.xpath("//span[text()=\"Cash on Delivery\"]")).click();
				driver.findElement((By.xpath("//input[@value='Order Now']"))).click();  
				popuputility.acceptAlert(driver);
				popuputility.acceptAlert(driver);
				 String expTitile="My Orders";
			//	  wait.until(ExpectedConditions.titleContains(expTitile));
				
				  String actTitile = driver.getTitle();
					verificationUtility.exactVerifyUsingSwitch(actTitile, expTitile, "page", actTitile);
					
					String axpDishe = driver.findElement(By.xpath("//tr//td[1]")).getText();
					//System.out.println(axpDishe);
					String expDishe="Yorkshire Lamb Patties";
					verificationUtility.exactVerifyUsingSwitch(actTitile, expTitile, "element", expDishe);
					verificationUtility.exactVerifyUsingSwitch(actTitile, expTitile, "tc", expTestScriptName );
				                                                                    		 
			    	driver.findElement(By.xpath("(//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10'])[1]")).click();      
					popuputility.acceptAlert(driver);

			
 	}

}
