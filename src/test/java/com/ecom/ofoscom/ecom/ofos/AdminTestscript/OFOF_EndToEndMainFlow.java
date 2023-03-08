package com.ecom.ofoscom.ecom.ofos.AdminTestscript;



import java.time.Duration;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OFOF_EndToEndMainFlow {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
	}

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");

		Random ran = new Random();
		int ranint = ran.nextInt(1000);
		int rannum = ran.nextInt(99);

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);

		String home = driver.getTitle();

		if (home.equals("Admin Panel")) {
			System.out.println("admin panel passed");
		} else {
			System.out.println("admin panel Failed");
		}

		driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Add Category']")).click();
		String category = driver.getTitle();
		if (category.equals("Add Category")) {
			System.out.println("In category page");
		} else {
			System.out.println("not in category page");
		}
		driver.findElement(By.name("c_name")).sendKeys("Thai" + ranint);
		driver.findElement(By.name("submit")).click();

		String gt = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();

		if (gt.contains("New Category Added")) {
			System.out.println("category added passed");
		} else {
			System.out.println("category added failed");
		}

		driver.findElement(By.xpath("//a[text()='Add Restaurant']")).click();
		String restaurant = driver.getTitle();
		if (restaurant.equals("Add Restaurant")) {
			System.out.println("in Add Restaurant page");
		} else {
			System.out.println("not in Add Restaurant page");
		}
		driver.findElement(By.name("res_name")).sendKeys("Peetbhar" + ranint);
		driver.findElement(By.name("email")).sendKeys("peetbhar" + ranint + "@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("85285285" + rannum);
		driver.findElement(By.name("url")).sendKeys("peetbhar" + ranint + ".com");

		WebElement ele = driver.findElement(By.name("o_hr"));
		ele.click();
		Select s = new Select(ele);
		s.selectByValue("11am");

		ele.click();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.name("c_hr"));
		ele1.click();
		Select r = new Select(ele1);
		r.selectByVisibleText("10pm");
		ele1.click();

		WebElement ele2 = driver.findElement(By.name("o_days"));
		ele2.click();
		Select o = new Select(ele2);
		o.selectByVisibleText("Mon-Sat");
		ele2.click();
		Thread.sleep(3000);

		driver.findElement(By.name("file")).sendKeys("C:\\\\\\\\restphoto\\\\\\\\food.png.jpg");

		WebElement ele3 = driver.findElement(By.name("c_name"));
		ele3.click();
		Select e = new Select(ele3);
		e.selectByVisibleText("Thai" + ranint);
		ele3.click();

		driver.findElement(By.name("address")).sendKeys("tgbtgb yhnyhn ujmujm");
		driver.findElement(By.name("submit")).click();

		Thread.sleep(3000);

		String gt1 = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();
		if (gt1.contains("New Restaurant Added")) {
			System.out.println("Restaurant added pass");
		} else {
			System.out.println("Restaurant not added");
		}
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.xpath("//a[text()='Add Menu']")).click();

		String menu = driver.getTitle();
		if (menu.equals("Add Menu")) {
			System.out.println("In menu page pass");
		} else {
			System.out.println("Not in menu page");
		}
		driver.findElement(By.name("d_name")).sendKeys("Spaghetti" + ranint);
		driver.findElement(By.name("about")).sendKeys("noodles");
		driver.findElement(By.name("price")).sendKeys("49");

		driver.findElement(By.name("file")).sendKeys("C:\\\\\\\\restphoto\\\\\\\\food.png.jpg");
		WebElement ele4 = driver.findElement(By.name("res_name"));
		ele4.click();
		Select d = new Select(ele4);
		d.selectByVisibleText("Peetbhar" + ranint);
		ele4.click();

		driver.findElement(By.name("submit")).click();
		String gt2 = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();

		if (gt2.contains("New Dish Added")) {
			System.out.println("New Dish Added passed");
		} else {
			System.out.println("New Dish Added failed");
		}
		driver.findElement(By.xpath("//img[@alt='user']")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();

		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		String gt3 = driver.getTitle();
		if (gt3.equals("Home")) {
			System.out.println("in home page pass");
		} else {
			System.out.println("not in home page");
		}
		driver.findElement(By.xpath("//a[text()='Register']")).click();

		String gt4 = driver.getTitle();
		if (gt4.equals("Registration")) {
			System.out.println("in Registration page pass");
		} else {
			System.out.println("not in Registration page");
		}
		String name = "jagga" + ranint;
		driver.findElement(By.name("username")).sendKeys(name);
		driver.findElement(By.name("firstname")).sendKeys(name);
		driver.findElement(By.name("lastname")).sendKeys("dan");
		driver.findElement(By.name("email")).sendKeys(name + "@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("78974978" + rannum);
		driver.findElement(By.name("password")).sendKeys(name);
		driver.findElement(By.name("cpassword")).sendKeys(name);
		driver.findElement(By.name("address")).sendKeys("qwerty qwerty qwerty");
		driver.findElement(By.name("submit")).click();

		Thread.sleep(3000);
		String gt5 = driver.getTitle();

		if (gt5.equals("Login")) {
			System.out.println("in login page pass");
		} else {
			System.out.println("not in login page fail");
		}
		driver.findElement(By.name("username")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(name);
		driver.findElement(By.name("submit")).click();

		Thread.sleep(3000);
		String gt6 = driver.getTitle();

		if (gt6.equals("Home")) {
			System.out.println("in home page pass");
		} else {
			System.out.println("not in home page fail");
		}
		driver.findElement(By.xpath("//a[text()='Restaurants ']")).click();
		String gt7 = driver.getTitle();
		if (gt7.equals("Restaurants")) {
			System.out.println("in Restaurants page pass");
		} else {
			System.out.println("not in Restaurants page fail");
		}
		driver.findElement(By.xpath("(//a[text()='View Menu'])[1]")).click();
		String gt8 = driver.getTitle();
		if (gt8.equals("Dishes")) {
			System.out.println("in Dishes page pass");
		} else {
			System.out.println("not in Dishes page fail");
		}
		WebElement dish = driver.findElement(By.xpath("(//input[@value='Add To Cart'])[3]"));
		Point p = dish.getLocation();
		int x = p.getX();
		int y = p.getY();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		Thread.sleep(3000);
		dish.click();

		WebElement co = driver.findElement(By.xpath("//a[text()='Checkout']"));
		Point q = co.getLocation();
		int x1 = q.getX();
		int y1 = q.getY();
		js.executeScript("window.scrollBy(" + x1 + "," + y1 + ")");
		Thread.sleep(3000);
		co.click();

		String gt9 = driver.getTitle();
		if (gt9.equals("Checkout")) {
			System.out.println("in Checkout page pass");
		} else {
			System.out.println("not in Checkout page fail");
		}
		driver.findElement(By.name("submit")).click();

		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();

		String gt10 = driver.getTitle();
		if (gt10.equals("My Orders")) {
			System.out.println("in My Orders page pass");
		} else {
			System.out.println("not in My Orders page fail");
		}
		Thread.sleep(2000);

//		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		String gt11 = driver.getTitle();
		if (gt11.equals("Admin Login")) {
			System.out.println("in Admin Login page pass");
		} else {
			System.out.println("not in Admin Login fail");
		}

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.xpath("(//tr[last()])[2]//a[contains(@class,'btn btn-info')]")).click();

		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		String etitle = "Order Update";
		String parent = driver.getWindowHandle();

		Set<String> allw = driver.getWindowHandles();
		for (String wh : allw) {
			driver.switchTo().window(wh);
			String aTitle = driver.getTitle();
			if (aTitle.equals(etitle)) {
				driver.switchTo().window(wh);
			}
		}
		WebElement ele5 = driver.findElement(By.name("status"));
		ele5.click();
		Select t = new Select(ele5);
		t.selectByVisibleText("Delivered");
		ele5.click();
		driver.findElement(By.name("remark")).sendKeys("done");
		driver.findElement(By.name("update")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.name("Submit2")).click();
		driver.switchTo().window(parent);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='user']")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();
	}
}

