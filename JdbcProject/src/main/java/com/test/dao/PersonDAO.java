package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.sql.DBUtil;

public class PersonDAO {

	public void insert(int pid,String fname,String lname,String city,String state)throws Exception{
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO persons VALUES (?,?,?,?,?)");
           pstmt.setInt(1,pid);
    	   pstmt.setString(2, fname);
    	   pstmt.setString(3, lname);
    	   pstmt.setString(4, city);
    	   pstmt.setString(5, state);
    	   pstmt.executeUpdate();
    	  connection.close(); 
	}
	public PersonDTO getPersonByID(int personID)throws DataException{
		Connection connection = DBUtil.getDBConnection();
		try{
			
			PersonDTO dto = new PersonDTO();
				
			Connection connection1 = DBUtil.getDBConnection();
			PreparedStatement pstmt = connection1.prepareStatement("Select * from Persons where PersonID=?");
	        pstmt.setInt(1,personID);
        
	        ResultSet rs = pstmt.executeQuery();
	          if(rs.next()){
	        	  dto.setPid(rs.getInt("PersonID"));
	        	  dto.setCity(rs.getString("City"));
	        	  dto.setFname(rs.getString("Firstname"));
	        	  dto.setLname(rs.getString("Lastname"));
	        	  dto.setAddress(rs.getString("Address"));
	        	  connection1.close();
	        	  return dto;
	          }else{
	        	  DataException dataException = new DataException("1002","Person Record Not Found " +personID);
	  			throw dataException; 
	          } 
		}catch(SQLException ex){
			ex.printStackTrace();
			DataException dataException = new DataException("1001",ex.getMessage());
			throw dataException;
		}finally{
    	   try{
    		   connection.close();
    	   }catch(Exception ex){
    		   ex.printStackTrace();
    	   }
		}
	}
}