package PracticeTestScript.dataDrivenPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 

public class Dataprovide {
@Test(dataProvider ="data")
		
public void test(String un,String pwd)
{
	System.out.println(un+"   "+pwd);
}
@DataProvider
public String[][] data()
{
	//ExcelUtility excelutility=new 	ExcelUtility(FrameWorkConstants.TEST_EXCEL_FILE_PATH);
	return null ;//excelutility.getdata("Sheet2");
}
}
