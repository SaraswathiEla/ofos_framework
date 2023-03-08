package PracticeTestScript.dataDrivenPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
	@Test
	public void testAllLink() throws MalformedURLException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		List<WebElement> linklist = driver.findElements(By.xpath("//a"));
		List<String> listUrl=new ArrayList<String>();
		List<String> brokenUrl=new ArrayList<String>();
		for(WebElement linkEle:linklist)
		{
			 String url = linkEle.getAttribute("href");
			 listUrl.add(url);
		}
		
		for(String u:listUrl)
		{
			URL url=new URL(u);
		try {
			URLConnection urlConn=url.openConnection();
			HttpURLConnection httpUrlConnection=(HttpURLConnection)urlConn;
			int statuscode=httpUrlConnection.getResponseCode();
			String statusmessage=httpUrlConnection.getResponseMessage();
			if(statuscode!=200)
			{
				brokenUrl.add(u+statusmessage);
			}
		}
		catch (IOException e) {
			brokenUrl.add(u+"===>No message");
		}
		System.out.println(brokenUrl+"not working properly");
		}
			
		
		
	}
}


