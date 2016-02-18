package com.test.sql;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Statement;

public class BatchUpdates {

	public static void main(String[] args)throws Exception {
		//Get Connection
				Connection connection = DBUtil.getDBConnection();
				try{
					Statement stmt = connection.createStatement();
					stmt.addBatch("DELETE from persons where PersonID =9999");
					stmt.addBatch("Update persons Set City='AZ' where PersonID =1000");
					stmt.addBatch("INSERT INTO persons VALUES (9876,'Tim','W','Chandler','AZ')");
					stmt.executeBatch();
					connection.commit();
				}catch(SQLException se){
					se.printStackTrace();
					connection.rollback();
				}
              connection.close();
	}

}
