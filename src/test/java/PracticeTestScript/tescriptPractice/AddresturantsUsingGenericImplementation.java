package PracticeTestScript.tescriptPractice;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ecom.ofos.ObjectRepo.AddResturantPage;
import com.ecom.ofos.ObjectRepo.AdminLoginPage;
import com.ecom.ofos.ObjectRepo.AdminPanelPage;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.JavaUtility.VerificationUtility;
import com.ecom.ofos.generic.Webaction.waitUtility;
public class AddresturantsUsingGenericImplementation extends BaseClass{
	@Test(groups="sanity")
		public   void addresturant ( ) throws IOException, InterruptedException
		{
			String expTestScriptName="Add resturant";
			
		 	waitUtility w=new waitUtility();

		 	Map<String, String> mapdata=excelUtility.getExcelData(expTestScriptName,ExcelSheet.ADMIN.getSheetName());
			 seleniumutility.launchApplication(adminUrl);
			VerificationUtility verificationUtility=new VerificationUtility();
		    w.setExplicitWait(driver,timeout);
			WebDriverWait wait = w.setExplicitWait(driver, timeout);
			String eLoginTitile="Admin Login";
		 	w.waitForElementLoad(driver, timeout);
		 	wait.until(ExpectedConditions.titleContains(eLoginTitile));
		 	String aLoginTitile = seleniumutility.getPageTitle();
		    AdminLoginPage l=new AdminLoginPage(driver);
		    verificationUtility.exactVerifyUsingSwitch(aLoginTitile, eLoginTitile, "page", aLoginTitile);
		   	l.adminLoginAction(admin, pwd);
	       	 
			
	    WebDriverWait wait1= w.setExplicitWait(driver,timeout);
		w.setExplicitWait(driver, timeout);
		  
  		 
		 	String eadminpanelTitile="Admin Panel";
	 	wait1.until(ExpectedConditions.titleContains(eLoginTitile));
	 	String aadminpanelTitile = seleniumutility.getPageTitle();
	    verificationUtility.exactVerifyUsingSwitch(aadminpanelTitile, eadminpanelTitile, "page", aadminpanelTitile);
	    AdminPanelPage adminaction=new AdminPanelPage(driver);
	    w.waitforElementwithvisibilitycond(driver, eadminpanelTitile);
	    adminaction.resturantClick();
	    adminaction.addResturant(w, 500, 10);
				
	    String eTitile="Add Restaurant";
		wait1.until(ExpectedConditions.titleContains(eTitile));
		String aTitile=driver.getTitle();
	    verificationUtility.exactVerifyUsingSwitch(aTitile, eTitile, "page", aTitile);
	    
	    wait1.until(ExpectedConditions.titleContains(eTitile));
        AddResturantPage rest=new AddResturantPage(driver);
 	    rest.addResturant(mapdata);
 	    String expRestAlert="New Restaurant Added Successfully.";
 	    String aRestAlert = rest.getRestalertMessagetext().getText().split("\n")[1];
 	    System.out.println(aRestAlert);
 	     wait1.until(ExpectedConditions.visibilityOf(rest.getRestalertMessagetext()));
	    verificationUtility.exactVerifyUsingSwitch(aRestAlert, expRestAlert, "element", aRestAlert);
	    verificationUtility.exactVerifyUsingSwitch(aRestAlert, expRestAlert, "tc", expTestScriptName);
	     }
}