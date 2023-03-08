package PracticeTestScript.dataDrivenPractice;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException; 
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class FetchMultipleDataInExcel {

		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			  
			String expTescriptName="SelectOragnizationListTest";
			String expkey="OrgName";
	
			
			DataFormatter df=new DataFormatter();
			String path="./src/test/resources/data/crmCapign.xlsx";
			FileInputStream fis=new FileInputStream(path);
			
			//Step2:get control to workbook
			Workbook wb = WorkbookFactory.create(fis);
			
			//Step3:get control to Sheet
			Sheet sheet = wb.getSheet("Organization");
			int rowCount=sheet.getLastRowNum();//index
			String[] value=null;
			
			for (int i=1;i<=rowCount;i++)
			{
				String testScriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
				System.out.println(testScriptName);
				
				if(testScriptName.equalsIgnoreCase(expTescriptName))
				{
					for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
					{
						String key=df.formatCellValue(sheet.getRow(i).getCell(j));
						if(key.equalsIgnoreCase(expkey))
						{
								int count=0;
							for(int k=i+1;;k++) {
								
								String data = df.formatCellValue(sheet.getRow(k).getCell(j));
								System.out.println(data);
								if(data.equals(""))
									{
										break;
									}
									else
									{
										count++;
									}
							}
							value= new String[count];
							for(int k=0;k<count;k++)
							{
								value[k]=df.formatCellValue(sheet.getRow(i+1+k).getCell(j));
							}
							
							break;
						}
						
					}
					break;
					
				}
			}
			//System.out.println(value);
		
	    }

	}
