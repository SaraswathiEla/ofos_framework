package PracticeTestScript.tescriptPractice;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.ofos.ObjectRepo.AddCatagoryPage;
import com.ecom.ofos.ObjectRepo.AddMenuPage;
import com.ecom.ofos.ObjectRepo.AddResturantPage;
import com.ecom.ofos.ObjectRepo.AdminLoginPage;
import com.ecom.ofos.ObjectRepo.AdminPanelPage;
import com.ecom.ofos.ObjectRepo.CheckoutPage;
import com.ecom.ofos.ObjectRepo.DishesPage;
import com.ecom.ofos.ObjectRepo.MyOrdersPage;
import com.ecom.ofos.ObjectRepo.OrderUpdatePage;
import com.ecom.ofos.ObjectRepo.RegistrationPage;
import com.ecom.ofos.ObjectRepo.UserCommonPage;
import com.ecom.ofos.ObjectRepo.UserLoginPage;
import com.ecom.ofos.generic.Base.BaseClass;
import com.ecom.ofos.generic.Enums.ExcelSheet;
import com.ecom.ofos.generic.Webaction.waitUtility;

public class OFOS_endtoend extends BaseClass{
	 
	//@Test(priority=1)
	public void  AdminLogin() throws IOException
	{
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
		
       	 
	 	}
	//@Test(priority=2)
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
			Thread.sleep(2000);
 			s.assertEquals(acategory,category);
			Reporter.log("category displayed in list category",true);
	}
	
	
	//@Test(priority=3)
	public void AddRestarunts() throws InterruptedException, IOException
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
	//@Test(priority=4)
	public void AddMenu() throws InterruptedException, IOException
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
	//@Test(priority=5)
	public void  userSignup() throws InterruptedException, IOException
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
		userAction.clickRegisterLink(w, 500, 10);
		 String eRegTitile="Registration";
			wait.until(ExpectedConditions.titleContains(eRegTitile));
			String aRegTitile = seleniumutility.getPageTitle();
			s.assertEquals(aRegTitile,eRegTitile);
			Reporter.log("Customer Registration page is diplyed",true);	
			 RegistrationPage registration=new RegistrationPage(driver);
			String userName=mapdata.get("User-Name")+randomNumber;
		    registration.usercreate(userName, mapdata);
			popuputility.acceptAlert(driver);
			 String eLogTitile="Login";
	 			String aLogTitile = seleniumutility.getPageTitle();
	 			wait.until(ExpectedConditions.titleContains(eLogTitile));
	 			s.assertEquals(aLogTitile, eLogTitile);
	 			Reporter.log(eLogTitile+"  displayed",true);
	 		
	}
	//@Test(priority=6)
	public void userLogin() throws InterruptedException, IOException
	{
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
		String un="saraswathi176";
		String pwd="sara123";
		UserLoginPage userLoginaction=new UserLoginPage(driver);
		userLoginaction.loginAction(un, pwd);
		s.assertEquals(aHomeTitile,eHomeTitile);
		Reporter.log("After successful login homepage displayed",true);
	
		
 
	}
	
	
	
	//@Test
	public void UserPlaceOrderUsingHomePage() throws InterruptedException, IOException
	{
		String expTestscript="FooDAddToCartUsingHomePage";
		Map<String, String> mapdata=excelUtility.getExcelData(expTestscript,ExcelSheet.USER.getSheetName());
		String dishname=mapdata.get("dishname");
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
 			String un="saraswathi176";
 			String pwd="sara123";
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
 			String qty = "3";
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
  			Reporter.log(expTestscript+" test case is pass ",true); 
  			
  						
  
	}

	
	
	@Test()
	public void UserPlaceOrder() throws InterruptedException, IOException
	{
		String expTestscript="FooDAddToCartUsingHomePage";
		Map<String, String> mapdata=excelUtility.getExcelData(expTestscript,ExcelSheet.USER.getSheetName());
		String dishname=mapdata.get("dishname");
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
 			String un="saraswathi176";
 			String pwd="sara123";
 			UserLoginPage userLoginaction=new UserLoginPage(driver);
 			userLoginaction.loginAction(un, pwd);
 			s.assertEquals(aHomeTitile,eHomeTitile);
 			Reporter.log("After successful login homepage displayed",true);
 			w.setExplicitWait(driver, timeout);
 			userAction.clickRestaurantsLink(w, 500, 10);
 			 String exRestTitile="Restaurants";
			  wait.until(ExpectedConditions.titleContains(exRestTitile));
				String acRestTitile = driver.getTitle();
			s.assertEquals(acRestTitile,exRestTitile);
			Reporter.log(exRestTitile+"  page displayed",true);
			
 			
 		/*	 String qty = "3";
 			String dishe="Pink Spaghetti Gamberoni";

 			DishesPage dishesPage=new DishesPage(driver);
 			dishesPage.addToCartAction(dishe, qty);
 			String actQty = dishesPage.actualQtyInCheckout();
 			s.assertEquals(actQty, qty);
 			Reporter.log(actQty+"  is  present",true);
 			
 			String expcheckOutTotal =dishesPage.checkOutTotal();
 			dishesPage.checkoutAction();
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
  			Reporter.log(expTestscript+" test case is pass ",true); 
  			
  						
  
 			
		 /*
		driver.findElement(By.xpath("(//a[text()='View Menu'])[1]")).click();
		  String eTitile="Dishes";
		String aTitile = driver.getTitle();
		s.assertEquals(aTitile, eTitile);
		Reporter.log("Dishes page displayed",true);
		

		 driver.findElement(By.xpath("(//input[@name=\"quantity\"])[1]")).sendKeys(qty);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Add To Cart'])[1]")).click();
		String aqty = driver.findElement(By.xpath("//input[@id=\"example-number-input\"]")).getText();
		s.assertEquals(aqty, qty);
		Reporter.log("add qty is matched in checout div ",true);
		String etotal = driver.findElement(By.xpath("//div[@class=\"price-wrap text-xs-center\"]")).getText();
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		  String exTitile="Checkout";
			String acTitile = driver.getTitle();
			s.assertEquals(acTitile, exTitile);
			Reporter.log("Checkout page displayed",true);
			
		String atotal=driver.findElement(By.xpath("//tr/td[2]")).getText();
		s.assertEquals(atotal, etotal);
		Reporter.log("added cart total is matched in checout page total  ",true);
		
		
			
			
		
		driver.findElement((By.xpath("//input[@value='Order Now']"))).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		 String expTitile="My orders";
			String accTitile = driver.getTitle();
			s.assertEquals(accTitile, expTitile);
			Reporter.log("My orders page displayed",true);
			String axpDishe = driver.findElement(By.xpath("//tr//td[1]")).getText();
			String expDishe=" Pink Spaghetti Gamberoni";
			s.assertEquals(axpDishe, expDishe);
			Reporter.log("user placed orders is diplayed in My order page table",true);
		
		driver.findElement(By.xpath("(//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10'])[1]")).click();
		
		driver.switchTo().alert().accept();
		//driver.close();
		//driver.findElement(By.xpath("//a[text()='Logout']")).click();*/
		
	}
	//@Test(priority=1)
	public void verifyplacedorderAdminpage() throws InterruptedException {
		//AdminLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		//OrderUpdatePage OrderUpdatePage=new OrderUpdatePage();
		driver.findElement(By.xpath("//span[text()=\"Orders\"]")).click();
		Thread.sleep(2000);
		String expordersDate = "2023-02-02 03:42:38";
	
	String	accordersDate=driver.findElement(By.xpath("//td[text()=\"saraswathi176\"]//..//td[7]")).getText();		
		
	SoftAssert s=new SoftAssert();
	s.assertEquals(accordersDate, expordersDate);
	Reporter.log("user placed order verified in admin page");
	//driver.close();
	}
	
	//@Test
	public void Modify_order_statusAdmin() throws InterruptedException
	{
		
		//UserPlaceOrder();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		verifyplacedorderAdminpage();	
		driver.findElement(By.xpath("//td[text()=\"saraswathi176\"]/../td[8]/a[2]")).click();
		driver.findElement(By.xpath("//button[text()=\"Update Order Status\"]")).click();
		String parentWh = driver.getWindowHandle();
		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh)
		{
						if(parentWh.equalsIgnoreCase(wh))
			{
							driver.switchTo().window(wh);

			}
		}
		String eHomeTitile="Home";
		String ahomeTitile = driver.getTitle();
		SoftAssert s=new SoftAssert();
		s.assertEquals(ahomeTitile,eHomeTitile);
		Reporter.log("homepage displayed",true);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		String un="saraswathi176";
		String pwd="sara123";
		
		driver.findElement((By.name("username"))).sendKeys(un);
		driver.findElement((By.name("password"))).sendKeys(pwd);
	//	driver.findElement((By.name("submit"))).click();
		 

		
		
	}
	
}
