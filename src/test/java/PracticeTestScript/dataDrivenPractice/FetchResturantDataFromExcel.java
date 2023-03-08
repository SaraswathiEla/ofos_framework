package PracticeTestScript.dataDrivenPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchResturantDataFromExcel {

	public static void main(String[] args) throws IOException { 
		String expTestScriptName="Add resturant";
		
		
		//Excel data fetch
		Map<String,String>data=new HashMap<String,String>();
		FileInputStream f=new FileInputStream("./src/test/resources/data/crmCapign.xlsx");
		DataFormatter df=new DataFormatter();
		Workbook wb = WorkbookFactory.create(f);
		Sheet sheet = wb.getSheet("Admin");
		int rowcount=sheet.getLastRowNum();
//		System.out.println(rowcount);
		for(int i=1;i<=rowcount;i++)
		{
			
			String tescriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
//			System.out.println(tescriptName);
//			System.out.println(expTestScriptName);
			if(tescriptName.equals(expTestScriptName))
			{
			
			for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
			{
				String key=df.formatCellValue(sheet.getRow(i).getCell(j));
				String value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				data.put(key,value);
			}
			break;
			}
			
		}
	System.out.println(data);
      System.out.println(data.get("ResturantName"));
      System.out.println(data.get("BusinessEmail"));
      System.out.println(data.get("Phone"));
      System.out.println(data.get("WebsiteUrl"));
      System.out.println(data.get("Openhours"));
      System.out.println(data.get("closehours"));
      System.out.println(data.get("opendays"));
      System.out.println(data.get("imagepath"));
      System.out.println(data.get("SelectCategory"));
      System.out.println(data.get("ResturantAddress"));
     /* String resName=data.get("ResturantName");
	 	String bEmail=data.get("BusinessEmail");
	 	String ph=data.get("Phone");
	 	String webUrl=data.get("WebsiteUrl");
	 	String  openH=data.get("Openhours");
	 	String closeH=data.get("closehours");
	 	String  opendays=data.get("opendays");
	 	String img=data.get("imagepath");
	 	String selectCat=data.get("SelectCategory");
	 	String restAdd=data.get("ResturantAddress");
	 	
		*/
      
      wb.close();
      f.close();

      
	}

}
