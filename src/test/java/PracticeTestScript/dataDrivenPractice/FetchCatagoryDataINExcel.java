package PracticeTestScript.dataDrivenPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchCatagoryDataINExcel {

	public static void main(String[] args) throws IOException {
		String expTestScriptName="AddCatategory";
		String expKey="Category";
	 	 
		
		//Excel data fetch
		DataFormatter df=new DataFormatter();

		Map<String,String>data=new HashMap<String,String>();
		FileInputStream f=new FileInputStream("./src/test/resources/data/crmCapign.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		Sheet sheet = wb.getSheet("Admin");
		int rowcount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			
			String tescriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
			//System.out.println(tescriptName);
			//System.out.println(expTestScriptName);
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
		String category=   data.get(expKey);
		System.out.println(category);
      wb.close();
      f.close();

	}

}
