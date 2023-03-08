package com.ecom.ofos.CustomerTestScript;

import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ecom.ofos.generic.Annotation.Record;


import com.ecom.ofos.ObjectRepo.RegistrationPage;
import com.ecom.ofos.ObjectRepo.UserCommonPage;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Webaction.waitUtility;

public class CustomerSignupTestNg extends BaseClass {
	@Record(author = "Saraswati")
	@Test(groups="Sanity")
	public   void CustomerSignup( ) throws InterruptedException, Exception {
		String expTestScriptName="Registraion";
 		waitUtility w=new waitUtility();
		Map<String, String> mapdata=excelUtility.getExcelData(expTestScriptName,ExcelSheet.USER.getSheetName());
 System.out.println(mapdata);
 seleniumutility.launchApplication(userUrl);
 
 	 String eHomeTitile="Home";
	String aHomeTitile = driver.getTitle();
	SoftAssert s=new SoftAssert();
	s.assertEquals(aHomeTitile,eHomeTitile);
	Reporter.log("Customer Home page is diplyed",true);	
	 WebDriverWait wait= w.setExplicitWait(driver,timeout);
	 w.setExplicitWait(driver, timeout);
		UserCommonPage userAction=new UserCommonPage(driver);
		userAction.clickRegisterLink(w, 500, 10);
		 String eRegTitile="Registration";
			wait.until(ExpectedConditions.titleContains(eRegTitile));

			String aRegTitile = seleniumutility.getPageTitle();
			s.assertEquals(aRegTitile,eRegTitile);
			Reporter.log("Customer Registration page is diplyed",true);	
			
			 
			 RegistrationPage registration=new RegistrationPage(driver);
			String userName=mapdata.get("User-Name")+randomNumber;
		    
			registration.usercreate(userName, mapdata);
			w.setExplicitWait(driver, timeout);
 			 String eLogTitile="Login";
	 			String aLogTitile = seleniumutility.getPageTitle();
	 			wait.until(ExpectedConditions.titleContains(eLogTitile));
	 			s.assertEquals(aLogTitile, eLogTitile);
	 			Reporter.log(eLogTitile+"  displayed",true);
	 			
	 			
	 			System.out.println(	Thread.currentThread().getId());

		 
}
}