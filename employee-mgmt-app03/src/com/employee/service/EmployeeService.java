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

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter x=response.getWriter();
	x.println("hello i am connected to db");
	
	 }
	
	 
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "training";
	static final String PASS = "training";
	
	static Connection conn = null;
	 static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;   //employee operations
	int record=0;
	static Scanner s=new Scanner(System.in);

	public int add(int id,String name,int age,String desg,String country)
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

		  return insertCount;
	     }
	     catch(SQLException se)
	     {
	    	 System.out.println("Connection failed");
	     }
	     return -1;
	}
	public int update(int upid,String upname,int upage,String updesg, String upcountry)
	{
		int xy=0;
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
	    	
	    	String selectQuery = "UPDATE employee SET name='"+upname+"',age='"+upage+"',desg='"+updesg+"',country='"+upcountry+"' where id='"+upid+"';";
			xy = stmt.executeUpdate(selectQuery);
			conn.setAutoCommit(true); // enable transaction
			System.out.println(xy+" Record Updated Succesfully.");
	    }
	    catch(SQLException se)
	    {
	   	 System.out.println("Connection failed");
	    }
	    return xy;
	}
public String viewById(int x)
	{
		String res="";
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
	    catch(SQLException y)
	    {
	   	System.out.println(y); 
	    }
	    try
	    {
	    	String selectQuery = "SELECT  *FROM employee WHERE id='"+x+"';";
			rs = stmt.executeQuery(selectQuery);

			// STEP 5: Extract data from result set
			// Header
			while (rs.next()) {
				// Retrieve by column name
				int eid = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String designation = rs.getString("desg");
				String country = rs.getString("country");
			
				// Display values
				res+=eid+" "+name+" "+age+" "+designation+" "+country;
			}
	    }
	    catch(SQLException se)
	    {
	   	 System.out.println("Connection failed");
	    }
      return res;
}
	public void deleteById(int id)
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
	    	
	    	String selectQuery = "DELETE FROM employee where id='"+id+"';";
			int xy = stmt.executeUpdate(selectQuery);

			conn.setAutoCommit(true); // enable transaction
			System.out.println(xy+" Record Deleted Succesfully.");
	    }
	    catch(SQLException se)
	    {
	   	 System.out.println("Connection failed");
	    }
	}
	public String viewAll() throws Exception
	{
		String res="";
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
	    	String selectQuery = "SELECT * FROM employee";
			rs = stmt.executeQuery(selectQuery);
			
			while (rs.next()) {
				// Retrieve by column name
			
				int eid = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String designation = rs.getString("desg");
				String country = rs.getString("country");
			
				// Display values

				res+=eid+" "+ name+" "+ age+" "+ designation+" "+ country;
				res+=",";
				
			}
	    }
	    catch(SQLException se)
	    {
	   	 System.out.println("Connection failed");
	    }
		return res;   
	}
	
	}

