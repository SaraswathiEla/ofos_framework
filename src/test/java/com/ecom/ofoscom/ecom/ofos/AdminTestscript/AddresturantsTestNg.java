package com.ecom.ofoscom.ecom.ofos.AdminTestscript;
import java.io.IOException;

import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ecom.ofos.generic.Annotation.Record;

import com.ecom.ofos.ObjectRepo.AddResturantPage;
import com.ecom.ofos.ObjectRepo.AdminLoginPage;
import com.ecom.ofos.ObjectRepo.AdminPanelPage;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Webaction.waitUtility;
public class AddresturantsTestNg extends BaseClass{
	@Record(author = "Saraswati")
	@Test(groups="major")
		public   void addresturant ( ) throws IOException, InterruptedException
		{
		String expTestScriptName="Add resturant";
		waitUtility w=new waitUtility();
		Map<String, String> mapdata=excelUtility.getExcelData(expTestScriptName,ExcelSheet.ADMIN.getSheetName());
 System.out.println(mapdata);
 seleniumutility.launchApplication(adminUrl);
 String eLoginTitile="Admin Login";
	String aLoginTitile = driver.getTitle();
	SoftAssert s=new SoftAssert();
	s.assertEquals(aLoginTitile,eLoginTitile);
	Reporter.log("loginpage displayed",true);
AdminLoginPage l=new AdminLoginPage(driver);
	l.adminLoginAction(admin, pwd);
	String eHomeTitile="Admin Panel";
String aHomeTitile = driver.getTitle();
s.assertEquals(aHomeTitile, eHomeTitile);
Reporter.log("Homepage displayed",true);

WebDriverWait wait = w.setExplicitWait(driver, timeout);
AdminPanelPage adminaction=new AdminPanelPage(driver);
wait.until(ExpectedConditions.titleContains(eHomeTitile));
w.waitForElementLoad(driver, timeout);
adminaction.resturantClick();
String arestTitile =seleniumutility.getPageTitle();
wait.until(ExpectedConditions.titleContains(arestTitile));
s.assertEquals(arestTitile, eHomeTitile);
Reporter.log("Admin Panel page displayed",true);
w.setExplicitWait(driver, timeout);

		adminaction.addResturant(w, 500, 10);
	    String eTitile="Add Restaurant";
	    w.waitforElementwithvisibilitycond(driver, eTitile);
wait.until(ExpectedConditions.titleContains(eTitile));
String aTitile=driver.getTitle();
System.out.println(aTitile);
s.assertEquals(aTitile, eTitile);
Reporter.log("Add Restaurant page displayed",true);

 wait.until(ExpectedConditions.titleContains(eTitile));
AddResturantPage rest=new AddResturantPage(driver);
    rest.addResturant(mapdata);
    String expRestAlert="New Restaurant Added Successfully.";
    String aRestAlert = rest.getRestalertMessagetext().getText().split("\n")[1];
    System.out.println(aRestAlert);
     wait.until(ExpectedConditions.visibilityOf(rest.getRestalertMessagetext()));
     
     s.assertEquals(aRestAlert, expRestAlert);
 	Reporter.log("Restaurant added sucessfully",true);
 	Reporter.log("Add Restaurant testcase is pass ",true);
 	
 
	
	  }
}