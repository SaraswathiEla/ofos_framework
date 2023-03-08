package com.ecom.ofos.generic.ExternallUtility;

import java.io.FileInputStream;
 import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is used to access the Excel data
 * @author Saraswathi B
 *
 */
public class ExcelUtility {
	private DataFormatter df;
	private Workbook wb;
    public ExcelUtility()
    {
    	
    }
    /**
     * this method is used to intialize the Excel   using constructor
     * @param filePath
     */
    public ExcelUtility(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			df = new DataFormatter();
			wb = WorkbookFactory.create(fis);
			fis.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    /**
     *  this method is used to intialize the Excel
     * @param filePath
     */
    @Deprecated
    
	public void createWorkBook(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			df = new DataFormatter();
			wb = WorkbookFactory.create(fis);
			fis.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * this method is used to fetch datafrom excel file
 * @param expTestScriptName
 * @param sheetName
 * @return
 */
	public Map<String, String> getExcelData(String expTestScriptName, String sheetName) {

		Map<String, String> data = new HashMap<String, String>();
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j)).trim();
					String value = df.formatCellValue(sheet.getRow(i + 1).getCell(j)).trim();
					if(!key.equals(""))
						data.put(key, value);
				}
				break;
			}
		}
		// System.out.println(data+data.get(key));
		return data;
	}
	
	public String[][] getdata(String sheetName)
	{
		Sheet sheet=wb.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		String[][] arr=new String[rowcount][sheet.getRow(0).getLastCellNum()];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();i++)
			{
				arr[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
		}
	return arr;
	}
	
/**
 *  * this method is used to fetch datafrom excel file
 * @param expTestScriptName
 * @param expKey
 * @param sheetName
 * @return
 */
	public String getExcelData(String expTestScriptName, String expKey, String sheetName) {

		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
         int testScriptCounter=0;
         int KeyCounter=0;
 		
		String value = "";
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
				testScriptCounter++;
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if (key.equalsIgnoreCase(expKey)) {
						KeyCounter++;
						value = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
						break;
					}
				}
				break;
			}
		}
		if(KeyCounter==0)
		{
			if(testScriptCounter==0)
			{
				value="please give proper testScript key"+ expTestScriptName+"";
			}
			else
			{
				value="please give proper testScript key"+ expKey+"";
			}
		}
		System.out.println("Value fetched from excel===>"+value);
		return value;
	}
/**
 * this method is used to close the database
 * @throws IOException
 */
	public void closeWorkBook() throws IOException {
		wb.close();
	}
}
