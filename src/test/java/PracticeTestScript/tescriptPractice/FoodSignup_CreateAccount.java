package PracticeTestScript.tescriptPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FoodSignup_CreateAccount {


		static
		{
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			
		}

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			
			driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit SECONDS);
			driver.findElement(By.xpath("//a[text()='Register']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("saraswathi");
			driver.findElement(By.xpath( "//input[@name=\"firstname\"]")).sendKeys("saraswathi");
			driver.findElement(By.xpath( "//input[@name=\"lastname\"]")).sendKeys("elavarasan");
			driver.findElement(By.xpath( "//input[@name=\"email\"]")).sendKeys("saraswathi.elavarasan7778@gmail.com");
			driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("9902957778");
			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("sara123");
			driver.findElement(By.xpath("//input[@name=\"cpassword\"]")).sendKeys("sara123");
			 
			driver.findElement(By.xpath("//textarea[@id=\"exampleTextarea\"]")).sendKeys("#265,7th cross,25th main,BTM layout 2nd stage bangaLORE-560076");
			driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
			Thread.sleep(3000);
			
			
			
			//driver.close();


	}

}
