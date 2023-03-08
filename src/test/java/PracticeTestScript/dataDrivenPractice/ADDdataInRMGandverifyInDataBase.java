package PracticeTestScript.dataDrivenPractice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ADDdataInRMGandverifyInDataBase {
	public static void main (String args[])
	{
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	String un="rmgyantra";
    String pwd="rmgy@9999";	
    Random ranum=new Random();
    String projectname="selenium"+ranum.nextInt(100);
    String manager="abc"+ranum.nextInt(100);
	driver.get(" http://rmgtestingserver:8084");
	String titileRmg = driver.getTitle();
	if(titileRmg.equals("React APP"))
	{
		System.out.println("rmg welcome page displayed");
	}
	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(un);
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(pwd);
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//span[.='Create Project']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectname);
	driver.findElement(By.name("createdBy")).sendKeys(projectname);
	WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	Select s=new Select(ele);
	ele.click();
	s.selectByVisibleText("Created");
	ele.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		
	String alert = driver.findElement(By.xpath("//div[@role='alert']")).getText();
	if(alert.contains("Sucessfuly")){
		System.out.println("project created");
		
	}
	else
	{
		System.out.println("project is not  created");
		
	}
	
	
	
	
	

}
}
