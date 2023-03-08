package com.ecom.ofos.generic.ExternallUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtiliy {
	/**
	 * 
	 * @param url
	 * @param un
	 * @param pwd
	 * @param sql
	 * @param columnLabel
	 * @return
	 * @throws SQLException
	 */
	public String FetchDataFromDataBase(String url,String un,String pwd,String sql,String columnLabel) throws SQLException  {
		Driver dBdriver=new Driver();
		DriverManager.registerDriver(dBdriver);
		Connection connection=null;
		
		try {
			connection=DriverManager.getConnection(url, un, pwd);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		String coumnvalue = null;
		while(result.next())
		{
			 coumnvalue=  result.getString(columnLabel);
		}
			
		
		return coumnvalue;
		}
	  finally {
		connection.close();
		System.out.println("DB connection closed");
	}
			
		}
	
	
	/**
	 * 
	 * @param url
	 * @param un
	 * @param pwd
	 * @param sql
	 * @throws SQLException
	 */
	
	public void ModifyDataFromDataBase(String url,String un,String pwd,String sql ) throws SQLException  {
		Driver dBdriver=new Driver();
		DriverManager.registerDriver(dBdriver);
		Connection connection=null;
		
		try {
			connection=DriverManager.getConnection(url, un, pwd);
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(sql);
		 if(result==1)
		 {
			System.out.println("Data added sucessfully");
			 
		 }
		}
	finally {
		connection.close();
		System.out.println("DB connection closed");
	     }
			
		}

}