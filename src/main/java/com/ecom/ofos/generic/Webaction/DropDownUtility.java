package com.ecom.ofos.generic.Webaction;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * this class is used to handle the dropdown
 * 
 * @author Saraswathi B
 *
 */
public class DropDownUtility {
	/**
	 * this method is used to select the option usiong Index in  the dropdown
	 * @param ele
	 * @param i
	 */
	public void selectByIndex(WebElement ele,int i)
	{
		Select s=new Select(ele);
 		s.selectByIndex(i);
	
	}
	/**
	 * this method is used to select the option usiong Value in  the dropdown
	 * @param ele
	 * @param i
	 */
	
	public void selectByValue(WebElement ele,String value)
	{
		Select s=new Select(ele);
 		s.selectByValue(value);
	}/**selectByText
	 * this method is used to select the option usiong Text in  the dropdown
	 * @param ele
	 * @param i
	 */
	
	public void selectByVisibleText(WebElement ele,String text)
	{
		Select s=new Select(ele);
 		s.selectByVisibleText(text);
	
	}
	/**
	 * this method is used to deselect the option using Index in the dropdown
	 * @param ele
	 * @param i
	 */
	
	public void deselectByIndexText(WebElement ele,int i)
	{
		Select s=new Select(ele);
 		s.deselectByIndex(i);
	
	}/**
	 * this method is used to deselect the option using Value in the dropdown
	 * @param ele
	 * @param i
	 */
	
	public void deselectByValue(WebElement ele,String value)
	{
		Select s=new Select(ele);
 		s.deselectByValue(value);
	}
	/**
	 * this method is used to deselect the option using text  inthe dropdown
	 * @param ele
	 * @param i
	 */
	
	public void deselectByText(WebElement ele,String text)
	{
		Select s=new Select(ele);
 		s.deselectByVisibleText(text);
	
	}
	/**
	 * this method is used to deselectAll option in the dropdown
	 * @param ele
	 * @param i
	 */
	
	public void deselectAll (WebElement ele)
	{
		Select s=new Select(ele);
		s.deselectAll();
 	}
	/**
	 * this method is used to get all the options in  the dropdown
	 * @param ele
	 * @param i
	 */
	
	public List<WebElement> getOptions (WebElement ele)
	{
		Select s=new Select(ele);
		return s.getOptions();
 	}
	/**
	 * this method is used to getFirstSelectedOption in the dropdown
	 * @param ele
	 * @param i
	 */
	 
	public WebElement getFirstSelectedOption1(WebElement ele)
	{
		Select s=new Select(ele);
		return s.getFirstSelectedOption();
 	}
	/**
	 * this method is used to getAllSelectedOptionsin  the dropdown
	 * @param ele
	 * @param i
	 */
	
	public List<WebElement> getAllSelectedOptions(WebElement ele)
	{
		Select s=new Select(ele);
		return s.getAllSelectedOptions();
 	}
	/**
	 * this method is used to get  the dropdown all element
	 * @param ele
	 * @param 
	 */
	
	public WebElement getWrappedElement(WebElement ele)
	{
		Select s=new Select(ele);
		return s.getWrappedElement();
 	}
	/**
	 * this method is used to select the dropdown is mulile select or not
	 * @param ele
	 * @param i
	 */
	
	public boolean isMultiple(WebElement ele)
	{
		Select s=new Select(ele);
		return s.isMultiple();
 	}
	/**
	 * this method is used to select the dropdown
	 * @param ele
	 * @param i
	 */
	
	public int hashCode(WebElement ele)
	{
		Select s=new Select(ele);
		return s.hashCode();
 	}


}
