package com.ecom.ofos.CustomerTestScript;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ecom.ofos.generic.Annotation.Record;


import com.ecom.ofos.ObjectRepo.CheckoutPage;
import com.ecom.ofos.ObjectRepo.DishesPage;
import com.ecom.ofos.ObjectRepo.MyOrdersPage;
import com.ecom.ofos.ObjectRepo.UserCommonPage;
import com.ecom.ofos.ObjectRepo.UserLoginPage;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Webaction.waitUtility;

public class CustPlaceOrderUsingHomeTestNg extends BaseClass{
	@Record(author = "Saraswati")
	@Test(groups="Sanity")
	public void PlaceOrderUsingHomePage() throws IOException, InterruptedException
	{
	String expTestScriptName="PlaceOrderUsingHomePage";
	Map<String, String> mapdata=excelUtility.getExcelData(expTestScriptName,ExcelSheet.USER.getSheetName());

	 //String dishname=mapdata.get("dishname");
		waitUtility w=new waitUtility();
	    
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
			String un=mapdata.get("username");
			String pwd=mapdata.get("passward");
			
		 	UserLoginPage userLoginaction=new UserLoginPage(driver);
			userLoginaction.loginAction(un, pwd);
			s.assertEquals(aHomeTitile,eHomeTitile);
			Reporter.log("After successful login homepage displayed",true);
			userAction.popularDish(w, 500, 10);
			String eTitile="Dishes";
			String aTitile = driver.getTitle();
			s.assertEquals(aTitile, eTitile);
			Reporter.log(eTitile+" displayed",true);
			DishesPage dishes=new DishesPage(driver);
			String qty =mapdata.get("qty"); ;
			dishes.addToCartAction(qty);
			String actQty = dishes.actualQtyInCheckout();
			s.assertEquals(actQty, qty);
			Reporter.log(actQty+"  is  present",true);
			
			String expcheckOutTotal =dishes.checkOutTotal();
			dishes.checkoutAction();
			 String exTitile="Checkout";
			  wait.until(ExpectedConditions.titleContains(exTitile));
				String acTitile = driver.getTitle();
			s.assertEquals(acTitile,exTitile);
			Reporter.log(exTitile+"  page displayed",true);
			CheckoutPage checkoutPage=new CheckoutPage(driver);
			String atotal=checkoutPage.CheckoutPageTotal();
			s.assertEquals(atotal,expcheckOutTotal);
			Reporter.log(expcheckOutTotal+" total cost is matched ",true);
			checkoutPage.orderNowAction();
			w.setExplicitWait(driver, timeout);
			w.pause(timeout);
		    popuputility.acceptAlert(driver);
			popuputility.acceptAlert(driver);
			String expTitile="My Orders";
			  wait.until(ExpectedConditions.titleContains(expTitile));
			
			  String actTitile = driver.getTitle();
			 s.assertEquals(actTitile,expTitile);
			Reporter.log(expTitile+" page is displayed ",true);
			MyOrdersPage myOrdersPage=new MyOrdersPage(driver);
			String expDishes="Yorkshire Lamb Patties";
			String axpDishe=myOrdersPage.axpDishe();
			System.out.println(axpDishe);
			s.assertEquals(axpDishe, expDishes);
			Reporter.log(expDishes+"  dishes is present ",true);
			Reporter.log(expTestScriptName+" test case is pass ",true); 
			
	}

}
