package PracticeTestScript.dataDrivenPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.poifs.property.Property;

public class PropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filepath="./src/test/resources/data/rmg.properties";
		
		//Step1: conver the phical file into java readable formAT
		FileInputStream fis=new FileInputStream(filepath);
		
		//STEP:2 CREATE A OBJECT FOR PROPERTIES FILE
		Properties p=new Properties();
		
		//STEP:3  LOAD ALL THE KEYS
		p.load(fis);
		String url = p.getProperty("url");
		System.out.println(url);
		fis.close();
		p.clear();
		
		

	}
 
}
