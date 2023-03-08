package PracticeTestScript.dataDrivenPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AdddataRmgUI_andverifyinDatabase {

	public static void main(String[] args) throws SQLException {
		
		//Step1:create instance and register to databasemanager
			Driver dbDriver=new Driver();
			DriverManager.registerDriver(dbDriver);
			Connection	connection=null;
			try {
	    //Step2:connect to jdbc
			 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");//rmg databse connection
			
		//Step3:create statement
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from project;");
			int size=result.getMetaData().getColumnCount();
			for(int i=1;i<=size;i++)
			{
				System.out.println(result.getMetaData().getColumnName(i));
			}
			
			//Step5:insert data and verify or fetch
				//fetch data from database table
			
		while(result.next())
			{
				String manager=result.getString("created_by");
				String projectName=result.getString("project_name");
				String projectId=result.getString("project_id");
				String status=result.getString("status");
				String createdOn=result.getString("created_on");
				String teamSize=result.getString("team_size");
				
			 		System.out.println(projectName+"  "+manager+"  "+projectId+"  "+teamSize+"  "+status);
			}

			}
			
			finally {
				connection.close();
			}

	}

}
