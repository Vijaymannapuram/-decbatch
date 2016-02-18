package com.test.sql;

import com.test.dao.PersonDAO;

public class DBApp {
	public static void main(String[] args) throws Exception{
		PersonDAO dao = new PersonDAO();
		dao.insert(999,"Rama","Krishna","Chandler","AZ"); 
	}

}
