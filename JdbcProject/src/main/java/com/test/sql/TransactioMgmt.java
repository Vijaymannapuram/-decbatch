package com.test.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactioMgmt {

	public static void main(String[] args)throws Exception {
		//Get Connection
		Connection connection = DBUtil.getDBConnection();
		connection.setAutoCommit(false);
		try{
		//step1
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO persons VALUES (?,?,?,?,?)");
       pstmt.setInt(1,900007);
 	   pstmt.setString(2, "Jhon");
 	   pstmt.setString(3, "W");
 	   pstmt.setString(4, "MN");
 	   pstmt.setString(5, "plymouth");
 	   pstmt.executeUpdate();
 	  
 	//step2(Fail)
 			pstmt = connection.prepareStatement("INSERT INTO Test VALUES (?,?,?,?,?)");
 	        pstmt.setInt(1,900009);
 	 	    pstmt.setString(2, "Jhon");
 	 	    pstmt.executeUpdate();
 	 	  
 	 	    connection.commit();
		}catch(SQLException se){
			se.printStackTrace();
			connection.rollback();//Undo 
		}
		connection.close();
	}

}
