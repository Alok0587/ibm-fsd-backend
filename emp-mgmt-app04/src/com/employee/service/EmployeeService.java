package com.employee.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class EmployeeService {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "training";
	static final String PASS = "training";
	
	 static Connection conn = null;
	 static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
   //employee operations
	int record=0;
	static Scanner s=new Scanner(System.in);

	public void add(int id,String name,int age,String desg,String country)
	{
		
	     
	     try
	     {
	    	 Class.forName("com.mysql.jdbc.Driver");

				// STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				conn.setAutoCommit(false); // enable transaction

				System.out.println("Connection estabilished: " + conn);

				// STEP 4: Execute a query
				System.out.println("Creating statement...");
				stmt = conn.createStatement();
	     }catch(ClassNotFoundException ed)
	     {
	    	 System.out.println("connector not found");
	     }
	     catch(SQLException x)
	     {
	    	System.out.println(x); 
	     }
	     try
	     {      
	     String insertQuery = "INSERT INTO employee (id, name, age, desg, country) VALUES ('"+id+"', '"+name+"', '"+age+"' , '"+desg+"', '"+country+"')";
			//boolean status = stmt.execute(insertQuery);
			int insertCount = stmt.executeUpdate(insertQuery);
			conn.setAutoCommit(true); // enable transaction

			System.out.println("Employee inserted " + insertCount);
	     }
	     catch(SQLException se)
	     {
	    	 System.out.println("Connection failed");
	     }
	}
}