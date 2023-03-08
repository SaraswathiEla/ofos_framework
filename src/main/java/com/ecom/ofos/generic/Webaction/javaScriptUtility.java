package com.ecom.ofos.generic.Webaction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javaScriptUtility {

	JavascriptExecutor js;
	public javaScriptUtility(WebDriver driver)
	{
		 js = (JavascriptExecutor)driver;
	}
	/**
	 * this method is used to scrollup the webpage
	 */
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	/**
	 * this method is used to scrolldown the webpage
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/**
	 * 	this method is used to clkick the webElement in webpage
	 * @param element
	 */
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()",element);
	}
	/**
	 * This method is used to send the text to webelement textbox
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	/**
	 * This method is used to scroll till Specified element
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoview()",element); 
	}
	/**
	 * this method is used to launch the application
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]",url);		
	}
	/**
	 * setAttribute  --->>>>  we are highlighting element with the help of this
	 * style   -->>>> Is a css inbuilt method  
	 * border: dashed red;  ---->>>> we will search this syntax in chrome browser as css border copy paste the code
	 * @param element
	 */
	
	public void highlight(WebElement element)
	{
		js.executeScript("arguments[0].setAttribute('style','border: dashed red;');",element);	
		             
	}
	
	/**
	 * this method is used to refresh the webpage 
	 */
	public void refreshPage()
	{
		js.executeScript("history.go(0)");
	}
	
	/**
	 * this method is used to fetch the innner text of WebElement
	 */
	public void getInnerTextOfWebpage()
	{
		System.out.println(js.executeScript("return document.documentElement.innerText;").toString());
	}
	/**
	 * this method is used to fetch the tiltile of the webpoage
	 * 
	 */
	public void getTitleOfWebPage()
	{	
		System.out.println(js.executeScript("return document.title;").toString());            
	}
	/**
	 * 
	 */
	
	public void checkbox()
	{	
		js.executeScript("document.getElementById('enter element id').checked=false;");             
	}
	/**
	 * this method is used to fetch the url of current web page
	 */
	public void getUrlOfThePage()
	{	
	  System.out.println(js.executeScript("return document.URL;").toString());    
	}
	/*public void getHeightofWebpage()
	{	
		 js.executeScript("return window.innerHeight;").toString();
		 js.executeScript("return window.innerWidth;").toString();
		    
	}*/
	

}
