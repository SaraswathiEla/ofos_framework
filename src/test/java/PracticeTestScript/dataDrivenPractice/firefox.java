package PracticeTestScript.dataDrivenPractice;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert; 

import io.github.bonigarcia.wdm.WebDriverManager;

public class firefox extends com.ecom.ofos.generic.Base.BaseClass{
	@Test()

public   void practicetest() throws IOException {
	 driver.get(adminUrl);
	 org.testng.Assert.fail();
}
}
