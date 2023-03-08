package PracticeTestScript.tescriptPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OFOS_endtoendtestng{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
	}
	WebDriver driver;
	Random ran=new Random();
	int rannum=ran.nextInt(99);
	int ranint=ran.nextInt(200);
	 String filepath="./src/test/resources/data/rmg.properties";
		
		//Step1: conver the phical file into java readable formAT
	//	FileInputStream fis=new FileInputStream(filepath);
		
		//STEP:2 CREATE A OBJECT FOR PROPERTIES FILE
		Properties p=new Properties();
		
		//STEP:3  LOAD ALL THE KEYS
	//	p.load(fis);
		String url = p.getProperty("url");
		String admin = p.getProperty("admin");
		String pwd = p.getProperty("pwd");
		String userUrl=p.getProperty("userUrl");
		long timeout=Long.parseLong(p.getProperty("timeout"));//it is in string convert into long
		
	
	
	@Test(priority=1)
	public void  AdminLogin() throws IOException
	{
		 driver=new ChromeDriver();
		 	driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
			
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit SECONDS);
			
			
		
		
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit SECONDS);
		
		String eLoginTitile="Admin Login";
		String aLoginTitile = driver.getTitle();
		SoftAssert s=new SoftAssert();
		s.assertEquals(aLoginTitile,eLoginTitile);
		Reporter.log("loginpage displayed",true);
		
		 driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(admin);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click(); 
		String eHomeTitile="Admin Panel";
		String aHomeTitile = driver.getTitle();
		s.assertEquals(aHomeTitile, eHomeTitile);
		Reporter.log("Homepage displayed",true);
		
	}
	//@Test(priority=2)
	public void Addcategory() throws InterruptedException, IOException
	{
		AdminLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.findElement(By.xpath("//span[text()=\"Restaurant\"]")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Add Category\"]")).click();
		String category="dubai";
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"c_name\"]")).sendKeys(category+ranint);
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.close();
	/*verify category	
		String acategory = driver.findElement(By.xpath("//td[text()=\" dubai\"]")).getText();
		Thread.sleep(2000);
		SoftAssert s=new SoftAssert();
		s.assertEquals(acategory,category);
		Reporter.log("category displayed in list category",true);
		
		driver.close();
		*/
	}
	//@Test(priority=3)
	public void AddRestarunts() throws InterruptedException, IOException
	{
		AdminLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.findElement(By.xpath("//span[text()=\"Restaurant\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Add Restaurant\"]")).click();
		String eTitile="Add Restaurant";
		String aTitile=driver.getTitle();
		SoftAssert s=new SoftAssert();
		s.assertEquals(aTitile,eTitile);
		Reporter.log("add resturant page displayed ",true);
		String resturant="indianfood";
		String businessemail=resturant+ranint;
		driver.findElement(By.xpath("//input[@name=\"res_name\"]")).sendKeys(resturant+ranint );
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(businessemail+"@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("88998899"+rannum);
		 driver.findElement(By.xpath("//input[@name=\"url\"]")).sendKeys("www."+businessemail+".com");
	
		
			
		
		WebElement openhours = driver.findElement(By.xpath("//select[@name=\"o_hr\"]"));
		openhours.click();
		Select s1=new Select(openhours );
		 s1.selectByVisibleText("6am");
		 openhours.click();
		 Thread.sleep(2000);
		 
			 WebElement closehours = driver.findElement(By.xpath("//select[@name=\"c_hr\"]"));
			 closehours.click();	
			 Select s3=new Select(closehours );
				 s3.selectByVisibleText("6pm");
				 closehours.click();
				 Thread.sleep(2000);
				 
				 
				 WebElement selectcategory = driver.findElement(By.xpath("//select[@name=\"c_name\"]"));
				 selectcategory.click();	
				 Select s2=new Select(selectcategory );
					 s2.selectByVisibleText("Italian");
					 selectcategory.click();
					 Thread.sleep(2000);
				
					 WebElement opendays = driver.findElement(By.xpath("//select[@name=\"o_days\"]"));
					 opendays.click();	
					 Select s4=new Select(opendays );
						 s4.selectByVisibleText("Mon-Wed");
						 opendays.click();
						 
		driver.findElement(By.xpath(("//input[@name=\"file\"]"))).sendKeys("C:\\restphoto\\food.png.jpg");
		driver.findElement(By.xpath(" //textarea[@name=\"address\"]")).sendKeys("bangalore");
		driver.findElement(By.xpath(" //input[@name=\"submit\"]")).click();
		
		String eCreatedResturant="New Restaurant Added Successfully.";
		String aCreatedResturant = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible fade show\"]")).getText();
		s.assertEquals(aCreatedResturant, eCreatedResturant);
		Reporter.log("new resturant created",true);
		driver.close();
		
		
 		}
	//@Test(priority=4)
	public void AddMenu() throws InterruptedException
	{
	//	AdminLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.findElement(By.xpath("//span[text()=\"Menu\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=\"Add Menu\"]")).click();
	   String eAddmenutitile="Add Menu";
	   String aAddmenutitile=driver.getTitle();
	   SoftAssert s=new SoftAssert();
	   s.assertEquals(eAddmenutitile, aAddmenutitile);
	   Reporter.log("add menu page displayed");
		
		
		
		String dish = "masaldosa";
		driver.findElement(By.xpath("//input[@name=\"d_name\"]")).sendKeys(dish);
		driver.findElement(By.xpath("//input[@name=\"about\"]")).sendKeys(dish+"is very tasy");
		driver.findElement(By.xpath("//input[@name=\"price\"]")).sendKeys("15");
		driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys("C:\\\\restphoto\\\\food.png.jpg");
		WebElement selectRest = driver.findElement(By.xpath("//select[@name=\"res_name\"]"));
		selectRest.click();	
		 Select s1=new Select(selectRest );
			 s1.selectByVisibleText("Eataly");
			 selectRest.click();
		
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		String emenu="Dish Added Successfully.";
		String amenu=driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible fade show\"]")).getText();
		s.assertEquals(amenu, emenu);
		Reporter.log("dish added suceesfully",true);
		driver.close();
	}
	//@Test(priority=5)
	public void  userSignup() throws InterruptedException
	{
		 driver=new ChromeDriver();
		 
		 
		 driver.get(userUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
			String eHomeTitile="Home";
			String aHomeTitile = driver.getTitle();
			SoftAssert s=new SoftAssert();
			s.assertEquals(aHomeTitile,eHomeTitile);
			Reporter.log("homepage displayed",true);
			
			 
			
			driver.findElement(By.xpath("//a[text()='Register']")).click();
			String eRestTitile="Registration";
			String aRestTitile = driver.getTitle();
			s.assertEquals(aRestTitile,eRestTitile);
			Reporter.log("Registration page displayed",true);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("saraswathi"+ranint);
			driver.findElement(By.xpath( "//input[@name=\"firstname\"]")).sendKeys("saraswathi");
			driver.findElement(By.xpath( "//input[@name=\"lastname\"]")).sendKeys("elavarasan");
			driver.findElement(By.xpath( "//input[@name=\"email\"]")).sendKeys("saraswathi"+ranint+".elavarasan7778@gmail.com");
			driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("9902957778");
			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("sara123");
			driver.findElement(By.xpath("//input[@name=\"cpassword\"]")).sendKeys("sara123");
			 
			driver.findElement(By.xpath("//textarea[@id=\"exampleTextarea\"]")).sendKeys("#265,7th cross,25th main,BTM layout 2nd stage bangaLORE-560076");
			driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
			Thread.sleep(3000);
			String eLoginTitile="Login";
			String aLoginTitile = driver.getTitle();
			s.assertEquals(aRestTitile,eRestTitile);
			Reporter.log("after succeful signup login page displayed",true);
			driver.close();
			
	}
	//@Test(priority=6)
	public void userLogin() throws InterruptedException
	{
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(userUrl);
		driver.manage().window().maximize();
		String eHomeTitile="Home";
		String ahomeTitile = driver.getTitle();
		SoftAssert s=new SoftAssert();
		s.assertEquals(ahomeTitile,eHomeTitile);
		Reporter.log("homepage displayed",true);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		String eLoginTitile="Login";
		String aLoginTitile = driver.getTitle();

		s.assertEquals(aLoginTitile,eLoginTitile);
		Reporter.log("loginpage displayed",true);
		
		String un="saraswathi176";
		String pwd="sara123";
		
		driver.findElement((By.name("username"))).sendKeys(un);
		driver.findElement((By.name("password"))).sendKeys(pwd);
		driver.findElement((By.name("submit"))).click();
		 
		s.assertEquals(ahomeTitile,eHomeTitile);
		Reporter.log("After successful login homepage displayed",true);
	}
	//@Test()
	public void UserPlaceOrder() throws InterruptedException
	{
		userLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
		SoftAssert s=new SoftAssert();
		driver.findElement(By.xpath("(//a[@class=\"nav-link active\"])[2]")).click();
		String eResturantTitile="Home";
		String aResturantTitile = driver.getTitle();
		s.assertEquals(aResturantTitile, eResturantTitile);
		Reporter.log("resturant page displayed",true);
		
		driver.findElement(By.xpath("(//a[text()='View Menu'])[1]")).click();
		  String eTitile="Dishes";
		String aTitile = driver.getTitle();
		s.assertEquals(aTitile, eTitile);
		Reporter.log("Dishes page displayed",true);
		
		 String qty = "3";

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
	//	AdminLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.findElement(By.xpath("//span[text()=\"Orders\"]")).click();
		Thread.sleep(2000);
		String expordersDate = "2023-02-02 03:42:38";
	
	String	accordersDate=driver.findElement(By.xpath("//td[text()=\"saraswathi176\"]//..//td[7]")).getText();		
		
	SoftAssert s=new SoftAssert();
	s.assertEquals(accordersDate, expordersDate);
	Reporter.log("user placed order verified in admin page");
	//driver.close();
	}
	
	@Test
	public void Modify_order_status() throws InterruptedException
	{
		
		UserPlaceOrder();
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
