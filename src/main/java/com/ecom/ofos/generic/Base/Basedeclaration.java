package com.ecom.ofos.generic.Base;

import org.openqa.selenium.WebDriver;

import com.ecom.ofos.generic.ExternallUtility.ExcelUtility;
import com.ecom.ofos.generic.ExternallUtility.PropertyUtility;
import com.ecom.ofos.generic.JavaUtility.JavaUtility;
import com.ecom.ofos.generic.Reporter.ReportUtility;
import com.ecom.ofos.generic.Webaction.DropDownUtility;
import com.ecom.ofos.generic.Webaction.Popuputility;
import com.ecom.ofos.generic.Webaction.ScreenShotUtility;
import com.ecom.ofos.generic.Webaction.Seleniumutility;

public class Basedeclaration {

	protected  WebDriver driver;
	protected PropertyUtility propertyfile;
	protected JavaUtility javaUtility;
	protected Seleniumutility  seleniumutility;
	protected ExcelUtility excelUtility;
	protected long timeout;
	protected long pollingTime;
	protected long randomNumber;
	protected	String adminUrl;
	protected String admin;
	protected	String pwd;
	protected String userUrl;
	protected DropDownUtility dropdown;
	protected Popuputility popuputility;
	protected String browser;
	public ScreenShotUtility screenShotUtility;
	//public ReportUtility report;


}
