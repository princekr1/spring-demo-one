package com.exmple.prince.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcurl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeZone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("Connecting to Databae : "+jdbcurl);
			Connection myConn=DriverManager.getConnection(jdbcurl,user,pass);
			
			System.out.print("connection Successful :"+ myConn);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
