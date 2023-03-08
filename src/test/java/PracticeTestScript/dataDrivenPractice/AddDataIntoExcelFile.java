package PracticeTestScript.dataDrivenPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddDataIntoExcelFile {

	public static void main(String[] args) throws IOException {
		String path="./src/test/resources/data/crmCapign.xlsx";
		FileInputStream fis=new FileInputStream(path);
		
		//Step2:get control to workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3:get control to Sheet
		Sheet sheet = wb.getSheet("data");
		
		 Row row = sheet.getRow(1);
		 Cell cell = row.createCell(1);
		 cell.setCellValue("Tc_pass");
		 FileOutputStream fos=new FileOutputStream(path);
		 wb.write(fos);
		 wb.close();
		 
	}
}
