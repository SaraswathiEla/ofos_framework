package PracticeTestScript.dataDrivenPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		String path="./src/test/resources/data/crmCapign.xlsx";
		FileInputStream fis=new FileInputStream(path);
		
		//Step2:get control to workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3:get control to Sheet
		Sheet sheet = wb.getSheet("Sheet1");
		
		//Step4:get control to row
		Row row = sheet.getRow(0);
		
		//Step4:get control to cell
			Cell cell = row.getCell(1);
			
		//Step6:get cell value
			String data = cell.getStringCellValue();
	
		//Step7:Utilize data
			System.out.println(data);
			
			
			
			

	}
} 
