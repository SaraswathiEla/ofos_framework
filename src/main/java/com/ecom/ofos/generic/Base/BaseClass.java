package com.ecom.ofos.generic.Base;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ecom.ofos.generic.Constant.FrameWorkConstants;
import com.ecom.ofos.generic.Enums.PropertyKey;
import com.ecom.ofos.generic.ExternallUtility.ExcelUtility;
import com.ecom.ofos.generic.ExternallUtility.PropertyUtility;
import com.ecom.ofos.generic.JavaUtility.JavaUtility;
import com.ecom.ofos.generic.ListenerImplmentation.ExtentReportsListener;
import com.ecom.ofos.generic.Webaction.DropDownUtility;
import com.ecom.ofos.generic.Webaction.Popuputility;
import com.ecom.ofos.generic.Webaction.ScreenShotUtility;
import com.ecom.ofos.generic.Webaction.Seleniumutility;
/**
 * this class contains all configaration annotation
 * @author saraswathi.B
 */
//comment from rakesh
public class BaseClass extends Basedeclaration{
 		
	/**
	 * This method is used to intialize all required class level utility
	 * @throws IOException
	 */
	
		@BeforeClass(alwaysRun=true )
		public void intializationSetup() throws IOException
		{ 
			driver=null;
			//this.browser=value;
			 seleniumutility=new Seleniumutility();
			 javaUtility= new JavaUtility();
			 popuputility=new Popuputility();
			propertyfile=new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH);
			adminUrl=propertyfile.getPropertyData(PropertyKey.URL);
			userUrl=propertyfile.getPropertyData(PropertyKey.USERURl);
			admin=javaUtility.decode(propertyfile.getPropertyData(PropertyKey.ADMIN));
			pwd= javaUtility.decode(propertyfile.getPropertyData(PropertyKey.PWD));
			dropdown=new DropDownUtility();
			excelUtility=new ExcelUtility();
			//report=ExtentReportsListener.sreport;
			excelUtility=new ExcelUtility(FrameWorkConstants.TEST_EXCEL_FILE_PATH);
			timeout =Long.parseLong(propertyfile.getPropertyData(PropertyKey.TIMEOUT));
			randomNumber=javaUtility.getRandomNumber(100);
		 }
	 	/**
	 	 * this method will used to lunch the browser and intialize the screenshotutility
	 	 * @param browser
	 	 * @throws IOException
	 	 */
      @Parameters(value="browser")
		@BeforeMethod(alwaysRun=true)
       
		public void setup(@Optional String browser) throws IOException {
    	  this.browser=browser;
		//if (browser==null||browser.isBlank()||browser.isEmpty()||browser.equals(""))
    	  if(browser==null)
			{
					this.browser=propertyfile.getPropertyData(PropertyKey.BROWSER);
					
			}	
			
			driver=seleniumutility.launchBrowser(this.browser);
			seleniumutility.maximize();
			screenShotUtility=new ScreenShotUtility(driver);
			
				    
		}
       /**
        * this method is used to close the browser after test method execution
        * @throws IOException
        */
		@AfterMethod(alwaysRun=true)
		public void teardown() throws IOException
		{
			seleniumutility.closeBrowser(); 
		}
		/**
		 * this method is used to close the workbook after the class excution
		 * @throws Exception
		 */
	  @AfterClass(alwaysRun=true)
		public void intializeteardown() throws Exception
		{
		  
			excelUtility.closeWorkBook();
			
		}
		
		
		
	

}
