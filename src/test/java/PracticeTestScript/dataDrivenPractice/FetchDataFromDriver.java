package PracticeTestScript.dataDrivenPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDriver {

	public static void main(String[] args) throws SQLException  {
		
		//Step1: create instance for a driver and register driver into jdbc
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
	Connection connection=null;
		try {
		//step2:Connect to jdbc
		
	 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3306/sdet46","root","root");//rmg database connection
		//Step:3 Create Statement
		Statement statement = connection.createStatement();
		
		//Step:4 Execuete Query
		 
		ResultSet result = statement.executeQuery("Select * from project;");//rmg database

		//Step:5 iterate data and verify and fetch
		while(result.next())
		{
			String data = result.getString(1);
			System.out.println(data);
		}
	}
	  
	finally {
		//Step6: close the database connection mandatory
		
		connection.close();
		System.out.println("connection is closed");
			
		}
	}
}