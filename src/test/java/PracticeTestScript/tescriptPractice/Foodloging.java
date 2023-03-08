package PracticeTestScript.tescriptPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Foodloging {
	 

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		 
		
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		driver.findElement((By.name("username"))).sendKeys("rohan");
		driver.findElement((By.name("password"))).sendKeys("rohanrohan");
		driver.findElement((By.name("submit"))).click();
		driver.findElement(By.xpath("(//a[@class=\"nav-link active\"])[2]")).click();
		
		driver.findElement(By.xpath("(//a[text()='View Menu'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name=\"quantity\"])[1]")).sendKeys("3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Add To Cart'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		driver.findElement((By.xpath("//input[@value='Order Now']"))).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("(//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10'])[1]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.close();
		
		
	}
   @Test
   public void login()
   
   {
	   
   }

}
