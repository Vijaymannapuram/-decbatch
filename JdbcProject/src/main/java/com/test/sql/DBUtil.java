package com.test.sql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	private static  Properties dbProperties = new Properties();
	
	static{
		try{
			//FileInputStream fileInStream = new FileInputStream("D:\\CONSULTANCIES\\ITECH\\Java By ITECH VEERA REDDY\\Java Programs\\New Java Programs\\JdbcProject\\src\\main\\java\\database.properties");
		dbProperties.load(DBUtil.class.getResourceAsStream("database.properties"));
		System.out.println(" DB Properties   :::" + dbProperties);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		
	}
	public static Connection getDBConnection(){
		//Load Configurations
		
		try{
			
		//FileInputStream fileInStream = new FileInputStream("D:\\CONSULTANCIES\\ITECH\\Java By ITECH VEERA REDDY\\Java Programs\\New Java Programs\\JdbcProject\\src\\main\\java\\database.properties");
		//dbProperties.load(fileInStream);
	  
	  System.out.println(" DB Properties   :::" + dbProperties);
	  //Load Driver Class Name 
	Class.forName(dbProperties.getProperty("dbClassName"));
	  
	  //Get the connection 
	 Connection connection =  DriverManager.getConnection(dbProperties.getProperty("url"),dbProperties.getProperty("username"),dbProperties.getProperty("password"));

	return connection;
	
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(" Failed to Creat DB Connection ");
		}
		return null;
	}

}
