package com.ecom.ofoscom.ecom.ofos.AdminTestscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.ofos.ObjectRepo.AddCatagoryPage;
import com.ecom.ofos.generic.Annotation.Record;

import com.ecom.ofos.ObjectRepo.AdminLoginPage;
import com.ecom.ofos.ObjectRepo.AdminPanelPage;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Webaction.waitUtility;

public class AddCatategory extends BaseClass{
	@Record(author = "Saraswati")
	@Test(groups="Sanity")
	public void Addcategory() throws InterruptedException, IOException
	{
	
	String expTestScriptName="AddCatategory";
	String expKey="Category";
 waitUtility w=new waitUtility();
	 String category=excelUtility.getExcelData(expTestScriptName, expKey,ExcelSheet.ADMIN.getSheetName())+javaUtility.getRandomNumber(100);
	 System.out.println(category);
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
	AdminPanelPage r=new AdminPanelPage(driver);
    wait.until(ExpectedConditions.titleContains(eHomeTitile));
    w.waitForElementLoad(driver, timeout);
	r.resturantClick();
    String arestTitile =seleniumutility.getPageTitle();
    wait.until(ExpectedConditions.titleContains(arestTitile));
   s.assertEquals(arestTitile, eHomeTitile);
	Reporter.log("Admin Panel page displayed",true);

     	w.waitForElementLoad(driver, timeout);
  w.pause(timeout);
	r.addCatagory();
	 String aAddcatTitile =seleniumutility.getPageTitle();
	   s.assertEquals(aAddcatTitile,"Add Category");
		Reporter.log(" Add Category   page displayed",true);

	
 AddCatagoryPage c=new AddCatagoryPage(driver);
	 c.addCatagoryAction(category);	
	 wait.until(ExpectedConditions.titleContains(aAddcatTitile));

	//verify category
	 
	 String acategory = driver.findElement(By.xpath("//td[text()='"+category+"']")).getText();
		
			s.assertEquals(acategory,category);
		Reporter.log("category displayed in list category",true);

	}
}

