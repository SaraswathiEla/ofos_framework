package PracticeTestScript.tescriptPractice;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.ofos.ObjectRepo.UserCommonPage;
import com.ecom.ofos.ObjectRepo.UserLoginPage;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Webaction.waitUtility;

public class CustomerLoginTestng extends BaseClass {
	@Test(groups="sanity")
	public void userLogin() throws InterruptedException, IOException
	{
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
		userAction.userloginLink(w, 500, 10);
		String eLoginTitile="Login";
		String aLoginTitile = driver.getTitle();

		s.assertEquals(aLoginTitile,eLoginTitile);
		Reporter.log("loginpage displayed",true);
		String un="saraswathi176";
		String pwd="sara123";
		UserLoginPage userLoginaction=new UserLoginPage(driver);
		userLoginaction.loginAction(un, pwd);
		s.assertEquals(aHomeTitile,eHomeTitile);
		Reporter.log("After successful login homepage displayed",true);
	
	System.out.println(	Thread.currentThread().getId());
 
	}


}
