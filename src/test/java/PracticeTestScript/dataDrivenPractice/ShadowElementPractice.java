package PracticeTestScript.dataDrivenPractice;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowElementPractice {
	@Test
	public void shadowElementPractice() throws MalformedURLException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("chrome://downloads/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
	

}
}
