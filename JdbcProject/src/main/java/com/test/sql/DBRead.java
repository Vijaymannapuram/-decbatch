package com.test.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class DBRead {

	public static void main(String[] args)throws Exception {
		
		//printStudentDetails("9999")	
		//printStudentDetails1("MS");
		System.out.println(" =========== ");
		
	 //printStudentDetails1("MBBS OR 1=1"); // SQL Injection
	
	//insertDBRecord();
	}
		public static void printStudentDetails1(String sno)throws Exception{
			Connection connection = DBUtil.getDBConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Student Where sno = " + sno);
			while(rs.next()){
				System.out.println(" Sno " + rs.getInt("Sno"));
				System.out.println(" Sname " + rs.getString("Sname"));
				System.out.println(" Course " + rs.getInt("Course"));
				System.out.println(" Fee " + rs.getInt(" Fee"));
				
			}
		}



	public static void printStudentDetails(String sno)throws Exception{
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("Select Course,Fee from Student Where sno = " + sno);
		pstmt.setString(1, sno);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			//System.out.println(" Sno " + rs.getInt("Sno"));
			//System.out.println(" Sname " + rs.getString("Sname"));
			System.out.println(" Course " + rs.getInt("Course"));
			System.out.println(" Fee " + rs.getInt(" Fee"));
		}	
		}
		
		/*public static void insertDBRecordstmt()throws Exception{
			Connection connection = DBUtil.getDBConnection();
			//Statement stmt = Connection.createStatement();
			//PreparedStatement pstmt = connection.prepareStatement("INSERT INTO persons VALUES (?,?,?,?,?)");
			for(int i=11000;i<12000;i++){
			stmt.executeUpdate(" INSERT INTO persons VALUES (" + i + ",'" + "Fname" +i+"'," 
					+ ",'" + "Lname" +i+"'," 
					+ ",'" + "City" +i+"'," 
					+ ",'" + "Address" +i+"')" ); 
		   
			}*/
			
		   
	}