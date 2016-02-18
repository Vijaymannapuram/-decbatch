package com.test.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args)throws Exception {

           //Load.Driver Class Name
		  //Class.forName("com.mysql.jdbc.Driver");
		  
		  //Get the connection 
		 Connection connection =  DBUtil.getDBConnection();//DriverManager.getConnection("jdbc:mysql://localhost:3306/decdb","root","root");
	
		 Connection connection1 =  DBUtil.getDBConnection();
		 //Performing DB
		 Statement stmt = connection.createStatement(); 
               
		 /*stmt.execute("CREATE TABLE Persons"
			+"(PersonID int,LastName varchar(255),"
		    +"FirstName varchar(255), Address varchar(255),"
			+" City varchar(255));" );
         System.out.println("Table Created Successfully"); */
		 //Insert
		/* int result = stmt.executeUpdate("INSERT INTO persons VALUES (9876,'Tim','W','Chandler','AZ')");
		 System.out.println(" Inserted " + result + " Record Succesfully in DB");*/
		 
		 //Update 
		/* int result = stmt.executeUpdate("Update persons Set City='AZ' where PersonID =1000");
		 System.out.println(" Updated " + result + " Record Succesfully in DB");*/
		 
		 //Delete 
		 int result = stmt.executeUpdate("DELETE from persons where PersonID =9876");
		 System.out.println(" Deleted " + result + " Record Succesfully in DB");
	connection.close();

	}

}
