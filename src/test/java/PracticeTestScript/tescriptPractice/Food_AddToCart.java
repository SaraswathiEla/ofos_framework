package PracticeTestScript.tescriptPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Food_AddToCart {
	 

	public static void main(String[] args) throws  IOException {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
	
 		 String filepath="./src/test/resources/data/rmg.properties";
			
			//Step1: conver the phical file into java readable formAT
			FileInputStream fis=new FileInputStream(filepath);
			
			//STEP:2 CREATE A OBJECT FOR PROPERTIES FILE
			Properties p=new Properties();
			
			//STEP:3  LOAD ALL THE KEYS
			 String userUrl=p.getProperty("userUrl");
			long timeout=Long.parseLong(p.getProperty("timeout"));//it is in string convert into long
		
		
		driver.get(userUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
		driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		driver.findElement((By.name("username"))).sendKeys("rohan");
		driver.findElement((By.name("password"))).sendKeys("rohanrohan");
		driver.findElement((By.name("submit"))).click();
		driver.findElement(By.xpath("//a[text()=\"Yorkshire Lamb Patties\"]")).click();
	driver.findElement(By.xpath("(//input[@name=\"quantity\"])[1]")).sendKeys("2");
	driver.findElement(By.xpath("(//input[@value=\"Add To Cart\"])[1]")).click();
	p.load(fis);
	driver.close();
	}

}
