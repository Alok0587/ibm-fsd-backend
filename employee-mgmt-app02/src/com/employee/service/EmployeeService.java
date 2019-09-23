package com.employee.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeService {
	
	//database connection
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "training";
	static final String PASS = "training";
	
	 Connection conn = null;
	 Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
//employee operations
	int record=0;
	static Scanner s=new Scanner(System.in);

	public  void addEmp()
	{
		
						
						System.out.println("Enter Id:");
					      int eId;
					      
					      eId=s.nextInt();
					     
					      System.out.println("Enter Name:");
					      String ename=s.next();
					      System.out.println("Enter Desg:");
					      String desg=s.next();
					      System.out.println("Enter Age:");
					      int age;
					      age=s.nextInt();
					      System.out.println("Enter Country:");
					      String country=s.next();
					     
					     record++;
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
					     String insertQuery = "INSERT INTO employee (id, name, age, desg, country) VALUES ('"+eId+"', '"+ename+"', '"+age+"' , '"+desg+"', '"+country+"')";
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
public void viewEmp(int x)
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
		System.out.format("\t%s \t%s \t%s \t%s \t%s\n", "Id", "Name", "Age", "Desg","Country");
		while (rs.next()) {
			// Retrieve by column name
			int eid = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String designation = rs.getString("desg");
			String country = rs.getString("country");
		
			// Display values
			System.out.format("\t%d \t%s \t%s \t%s \t%s\n", eid, name, age, designation, country);
		}
    }
    catch(SQLException se)
    {
   	 System.out.println("Connection failed");
    }
}
public void updateEmp(int upid)
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
    	System.out.println("Enter the updated name:");
    	String upname=s.next();
    	System.out.println("Enter the updated Age:");
    	int upage=s.nextInt();
    	System.out.println("Enter the updated Desg:");
    	String updesg=s.next();
    	System.out.println("Enter the updated Country name:");
    	String upcountry=s.next();
    	String selectQuery = "UPDATE employee SET name='"+upname+"',age='"+upage+"',desg='"+updesg+"',country='"+upcountry+"' where id='"+upid+"';";
		int xy = stmt.executeUpdate(selectQuery);

		conn.setAutoCommit(true); // enable transaction
		System.out.println(xy+" Record Updated Succesfully.");
    }
    catch(SQLException se)
    {
   	 System.out.println("Connection failed");
    }
}
public void deleteEmp(int id)
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
public void viewAll()
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
    	String selectQuery = "SELECT * FROM employee";
		rs = stmt.executeQuery(selectQuery);

		// STEP 5: Extract data from result set
		// Header
		System.out.format("\t%s \t%s \t%s \t%s \t%s\n", "Id", "Name", "Age", "Desg","Country");
		while (rs.next()) {
			// Retrieve by column name
			int eid = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String designation = rs.getString("desg");
			String country = rs.getString("country");
		
			// Display values
			System.out.format("\t%d \t%s \t%s \t%s \t%s\n", eid, name, age, designation, country);
		}
    }
    catch(SQLException se)
    {
   	 System.out.println("Connection failed");
    }
	   
}
}