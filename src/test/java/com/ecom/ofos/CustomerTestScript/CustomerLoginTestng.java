package com.ecom.ofos.CustomerTestScript;
//sara

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.ofos.ObjectRepo.UserCommonPage;
import com.ecom.ofos.ObjectRepo.UserLoginPage;
import com.ecom.ofos.generic.Annotation.Record;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Webaction.waitUtility;

public class CustomerLoginTestng extends BaseClass {
	@Record(author = "Saraswathi.B")
	@Test(groups="Sanity")
	public void userLogin() throws InterruptedException, IOException
	{
	String expTestScriptName="userLogin";
 		waitUtility w=new waitUtility();
		Map<String, String> mapdata=excelUtility.getExcelData(expTestScriptName,ExcelSheet.USER.getSheetName());
    System.out.println(mapdata);
    seleniumutility.launchApplication(userUrl);
     String eHomeTitile="Home";
	String aHomeTitile = driver.getTitle();
	SoftAssert s=new SoftAssert();
	s.assertEquals(aHomeTitile,eHomeTitile);
	Reporter.log("Customer Home page is diplyed",true);	
	// WebDriverWait wait= w.setExplicitWait(driver,timeout);
	 w.setExplicitWait(driver, timeout);
		UserCommonPage userAction=new UserCommonPage(driver);
		userAction.userloginLink(w, 500, 10);
		String eLoginTitile="Login";
		String aLoginTitile = driver.getTitle();
		Assert.assertEquals(aLoginTitile, eLoginTitile);
		//s.assertEquals(aLoginTitile,eLoginTitile);
		Reporter.log("loginpage displayed",true);
		String un=mapdata.get("username");
		String pwd=mapdata.get("passward");
		  UserLoginPage userLoginaction=new UserLoginPage(driver);
		userLoginaction.loginAction(un, pwd);
		//Assert.assertEquals(aHomeTitile, eHomeTitile);
		//s.assertEquals(aHomeTitile,eHomeTitile);
		Reporter.log("After successful login homepage displayed",true);
	
	System.out.println(	Thread.currentThread().getId());
 
	}
//sara
	//learned git
	//hjhjfgf

}
