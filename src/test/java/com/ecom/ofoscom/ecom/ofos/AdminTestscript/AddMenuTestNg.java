package com.ecom.ofoscom.ecom.ofos.AdminTestscript;
import java.io.IOException;
import com.ecom.ofos.generic.Annotation.Record;

import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.ofos.ObjectRepo.AddMenuPage;
import com.ecom.ofos.ObjectRepo.AdminLoginPage;
import com.ecom.ofos.ObjectRepo.AdminPanelPage;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Webaction.waitUtility;
public class AddMenuTestNg extends BaseClass{
	@Record(author = "Saraswati")
	@Test(groups="Sanity")
		public   void addMenu ( ) throws IOException, InterruptedException
		{
			String expTestScriptName="Add Menu";
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
 			adminaction.menuClick(w, 500, 10);
	    w.setExplicitWait(driver, timeout);
	   
	    adminaction.addMenu(w, 500, 10);
	    String eAddmenuTitile="Add Menu";
	    w.waitforElementwithvisibilitycond(driver, eAddmenuTitile);       
         String addmenuTitile = seleniumutility.getPageTitle();
         System.out.println(addmenuTitile);
         s.assertEquals(addmenuTitile, eAddmenuTitile);
         Reporter.log("Add Menu page is displayes",true);
         AddMenuPage m=new AddMenuPage(driver);
 	    String restname="meghana";
 	    		System.out.println(restname);
 	    	System.out.println(mapdata.get("Image"));
 	    		m.addmenuAction(dropdown, restname, mapdata);
 	    		String expAlertmdg = "New Dish Added Successfully.";
 	    		String alermsg=m.getAlertMessage().split("\n")[1];
 	    	 System.out.println(alermsg); 
 	    	 s.assertEquals(alermsg,expAlertmdg);
 	         Reporter.log(" Menu Added sucessfully",true);    	 	    
	      }
}