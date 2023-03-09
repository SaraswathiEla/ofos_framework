package PracticeTestScript.tescriptPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.ofos.ObjectRepo.AddCatagoryPage;
import com.ecom.ofos.ObjectRepo.AdminLoginPage;
import com.ecom.ofos.ObjectRepo.AdminPanelPage;
import com.ecom.ofos.generic.Constant.FrameWorkConstants;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Enums.PropertyKey;
import com.ecom.ofos.generic.ExternallUtility.ExcelUtility;
import com.ecom.ofos.generic.ExternallUtility.PropertyUtility;
import com.ecom.ofos.generic.JavaUtility.JavaUtility;
import com.ecom.ofos.generic.JavaUtility.VerificationUtility;
import com.ecom.ofos.generic.Webaction.Seleniumutility;
import com.ecom.ofos.generic.Webaction.waitUtility;



public class AddCatagoryusingusingGenericMethodsImplementation {
	public static void main(String[] args) throws IOException
	{
		String expTestScriptName="AddCatategory";
		String expKey="Category";
		JavaUtility javaUtility=new JavaUtility();
		PropertyUtility p=new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH);
		String url =p.getPropertyData(PropertyKey.URL);
		
		String admin=javaUtility.decode(p.getPropertyData(PropertyKey.ADMIN));
		String pwd= javaUtility.decode(p.getPropertyData(PropertyKey.PWD));
	    long timeout =Long.parseLong(p.getPropertyData(PropertyKey.TIMEOUT));
	    
	    ExcelUtility e=new ExcelUtility(FrameWorkConstants.TEST_EXCEL_FILE_PATH);
	  	waitUtility w=new waitUtility();
		//System.out.println(ExcelSheet.ADMIN.getSheetName());
	 	String category=e.getExcelData(expTestScriptName, expKey,ExcelSheet.ADMIN.getSheetName())+javaUtility.getRandomNumber(100);
		System.out.println(category);
		e.closeWorkBook();
		//Add catagory testcases
		WebDriver driver=null;
		Seleniumutility seleniumutility=new Seleniumutility();
	//	driver=seleniumutility.launchBrowser(p.getPropertyData(PropertyKey.BROWSER), null);
		seleniumutility.maximize();
		seleniumutility.launchApplication(url);
		VerificationUtility verificationUtility=new VerificationUtility();
	    WebDriverWait wait= w.setExplicitWait(driver,timeout);
		w.setExplicitWait(driver, timeout);
		
	 	String eLoginTitile="Admin Login";
	 	wait.until(ExpectedConditions.titleContains(eLoginTitile));
	 	String aLoginTitile = seleniumutility.getPageTitle();
	    AdminLoginPage l=new AdminLoginPage(driver);
	    verificationUtility.exactVerifyUsingSwitch(aLoginTitile, eLoginTitile, "page", aLoginTitile);
	   	//jklasdjlkjadlkklsd
	   l.adminLoginAction(admin, pwd);
       
	   String eHomeTitile="Admin Panel";
	     w.setExplicitWait(driver,timeout);
       wait.until(ExpectedConditions.titleContains(eHomeTitile));
		String aHomeTitile =driver.getTitle();
		verificationUtility.exactVerifyUsingSwitch(aHomeTitile, eHomeTitile, "page", aHomeTitile);
		
		AdminPanelPage r=new AdminPanelPage(driver);
		r.resturantClick();
		r.addCatagory();
	 
		AddCatagoryPage c=new AddCatagoryPage(driver);
		 c.addCatagoryAction(category);
		//verify category
		c.getAlertMessage(category);
		String acategory = c.getAlertMessage(category);
		System.out.println(acategory);
		wait.until(ExpectedConditions.titleContains( "Add Category"));
 		 verificationUtility.exactVerifyUsingSwitch(acategory, category, "element", acategory);
// 		seleniumutility.closeBrowser(); 
	
	}
	
}

