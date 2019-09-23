package com.employee.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.employee.service.EmployeeService;
import com.employee.employee.*;


public class EmployeeManagementApp {
	Employee ref=new Employee();
	int record=0;
	static Scanner s=new Scanner(System.in);

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EmployeeService e=new EmployeeService();
		while(true)
		{
			System.out.println("Select option:\n1. Add Employee\n2. View Employee\n3. Update Employee\n4. Delete Employee\n5. View All Employee\n6. Import from file\n7.Export File\n8. Exit");
			int n=s.nextInt();
			switch (n)
			{
			    
				case 1:
				{
				
			      e.addEmp();
			      break;
			      
				}
				case 2:
				{
					System.out.println("Enter Employee Id:");
					int id=s.nextInt();
					e.viewEmp(id);
					break;
				}//end of case 2
				case 3:
				{
					System.out.println("Enter the Id you want to Update:");
					int id=s.nextInt();
					e.updateEmp(id);
					break;   	
				}//end of case 3
				case 4:
				{
					System.out.println("Enter the id you want to delete:");
					int id=s.nextInt();
					e.deleteEmp(id);
					break;
					
				}//end of case 4;
				case 5:
				{
					e.viewAll();
					   break; 
				}
				//importing from file
				case 6:
				{
					e.importEmp();
					break;
				}
				case 7://exporting
				{
					e.exportEmp();
					break;
					
				}
				case 8:
				{
					System.exit(0);
					break;
				}
				default:
				{
					System.out.println("Invalid option selected");
					break;
				}
			}
		}

	}

	

}
