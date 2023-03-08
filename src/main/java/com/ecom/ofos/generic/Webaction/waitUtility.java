package com.ecom.ofos.generic.Webaction;

import java.io.IOException;
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 

	public class waitUtility 
	{
		/**
		 * 
		 * This method will be executed until particular period of time even though required action has been done 
		 * @param millisecond
		 */
		WebDriver driver=null;
	public void pause(long millisecond)
	{
		try
		{
			Thread.sleep(millisecond);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to check for element for every 0.5 sec until the required element found and at last thows exception
	 * @param driver
	 * @param timeout
	 */
	public void waitForElementLoad(WebDriver driver,long timeout)
	{
		new WebDriverWait(driver,Duration.ofSeconds(timeout));
	}
	/**
	 * This method is used to check condition as title contains required value
	 * @param driver
	 * @param Z
	 */
	 public void waitforElementwithvisibilitycond(WebDriver driver,String titile)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		wait.until(ExpectedConditions.titleContains(titile));
	}
	/**
	 * this method is used to wait till click.
	 * @param pollingTime
	 * @param duration
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitTillClick(int pollingTime,int duration,WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<duration)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(pollingTime);
			    count=count+((int)pollingTime/1000);
			}
		}
		}
	 public void waitTillClick1(long pollingTime,int duration,WebElement element) throws InterruptedException
		{
			int count=0;
			while(count<duration)
			{
				try
				{
					element.click();
					break;
				}
				catch(Exception e)
				{
					Thread.sleep(pollingTime);
				    count=count+((int)pollingTime/1000);
				}
			}
			}
		
	public void setImplicitWait(WebDriver driver2, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

 		
	}
public WebDriverWait setExplicitWait(WebDriver driver,long timeout) throws IOException {
		
		return new WebDriverWait(driver,Duration.ofSeconds(timeout));
	}
	
	
	}
			

	

	/*private	WebDriver driver;
	private WebDriverWait  wait;
	public  WaitUtility()
	{
		
	}
	public void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will set the implicit wait
	 * 
	 * @throws IOException
	 */
	/*public void setImplicitWait(WebDriver driver, long timeout) throws IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	/**
	 * This method will set the explicit wait
	 * 
	 * @param driver
	 * @return
	 * @throws IOException
	 */
/*	public WebDriverWait setExplicitWait(WebDriver driver,long timeout) throws IOException {
		
		return new WebDriverWait(driver,Duration.ofSeconds(timeout));
	}
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	/*public void intializeConditionalWait(WebDriver driver,long timeout)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));

	}
	/**
	 * this methodis used to wait the webpage till click action
	 * @param pollingTime
	 * @param duration
	 * @param element
	 * @throws InterruptedException
	 */
	/*	


}


*/