package PracticeTestScript.dataDrivenPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadFormulaValueInSheetFetch {

	public static void main(String[] args) throws IOException {
		
		String path="./src/test/resources/data/crmCapign.xlsx";
		FileInputStream fis=new FileInputStream(path);
		DataFormatter df=new DataFormatter();
		//Step2:get control to workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3:get control to Sheet
		Sheet sheet = wb.getSheet("FormulaSheet");
	FormulaEvaluator evalutor = wb.getCreationHelper().createFormulaEvaluator();
		
		//Strep4:count all the row in sheet
		int row=sheet.getLastRowNum();//index
		
		//Step4 : count the no. of column in particular row
		int col=sheet.getRow(1).getLastCellNum();  //it returns o th row colmns count
		
		
		System.out.println("the number of row in a sheet "+row);
		System.out.println("the no of colum in particular 0th  row index "+col);

	   System.out.println("all data in sheet");
	   
	   for(int i=0;i<=row;i++)
	   {
		  Row r= sheet.getRow(i);
		  
		   for(int j=0;j<col;j++)
		   {
			   Cell cell = r.getCell(j);
			String data = df.formatCellValue(sheet.getRow(i).getCell(j), evalutor);
			
			System.out.print(data+" ");

		   }
		   System.out.println();
	   }

	
}




/*
 *   for(int i=0;i<=row;i++)
	   {
		  Row r= sheet.getRow(i);
		  
		   for(int j=0;j<sheet.getRow(1).getLastCellNum();j++)
		   {
/	Cell cell = r.getCell(j);
			String data = df.formatCellValue(sheet.getRow(i).getCell(j));
			System.out.print(data+" ");

		   }
		   System.out.println();
	   }

*/
}