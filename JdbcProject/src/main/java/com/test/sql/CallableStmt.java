package com.test.sql;

import java.sql.Connection;

import java.sql.CallableStatement;

public class CallableStmt {

	public static void main(String[] args)throws Exception {
		
		//Get Connection
		Connection connection = DBUtil.getDBConnection();
		connection.setAutoCommit(false);
		
		
		CallableStatement cstmt = connection.prepareCall("{call insertStudent}");
		cstmt.executeUpdate();
		connection.commit();
		
	}

}
