package com.examples.java;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class EmployeeManagementApp {
	Employee ref=new Employee();
	int record=0;
	static Scanner s=new Scanner(System.in);

	public void addEmp()
	{
		Employee xnew=new Employee();
		//callable implementation
						
						System.out.println("Enter Id:");
					      int eId;
					      try {
					      eId=s.nextInt();
					      xnew.seteId(eId);

					      }
					      catch(InputMismatchException e)
					      {
					    	  System.out.println("Invalid input for Id.");
					      }
					      System.out.println("Enter Name:");
					      String ename=s.next();
					      System.out.println("Enter Desg:");
					      String desg=s.next();
					      System.out.println("Enter Age:");
					      int age;
					      try {
					      age=s.nextInt();
					      xnew.setAge(age);
					      }
					      catch(InputMismatchException e)
					      {
					    	 System.out.println("Invalid input for Age.");
					    	 
					      }
					      System.out.println("Enter Country:");
					      String country=s.next();
					     xnew.seteName(ename);
					     xnew.setDesg(desg);
					     xnew.setCountry(country);
					     xnew.setNext(ref);
					     ref=xnew;
					     record++;
	}
public void viewEmp(int id)
{
	if(record==0)
	{
		System.out.println("no records Exist");
	}
	else
	{
		Employee x=ref;
	   for(int i=0;i<record;i++)
	   {
		   
		   if(x.geteId()==id)
		   {
			   System.out.println("Employee details:\n ID:"+x.eId+" Employee Name:"+x.eName+" Employee Age:"+x.age+" Employee Desg:"+x.desg+" Country:"+x.country);
		   }
		   x=x.next;
	   }
	}
}
public void updateEmp(int id)
{

	Employee x=ref;
	   for(int i=0;i<record;i++)
	   {
		   
		   if(x.geteId()==id)
		   {
			   System.out.println("What you want to update choose the option:\n1.Name\n2.Age\n3.Desg\n4.Country");
			   int op=s.nextInt();
			   if(op==1)
			   {
				   System.out.println("Enter the new Name:");
				   String upname=s.next();
				   System.out.println("name succesfully updated from "+x.geteName()+" to "+upname);
				   x.seteName(upname);
				   break;
			   }
			   else if(op==2)
			   {
				   System.out.println("Enter the new Age:");
				   int upage=s.nextInt();
				   System.out.println("Age succesfully updated from "+x.getAge()+" to "+upage);
				   x.setAge(upage);
				   break;
			   }
			   else if(op==3)
			   {
				   System.out.println("Enter the new Desg:");
				   String updesg=s.next();
				   System.out.println("Desg succesfully updated from "+x.getDesg()+" to "+updesg);
				   x.setDesg(updesg);
				   break;
			   }
			   else if(op==4)
			   {
				   System.out.println("Enter the Updated Country:");
				   String upcountry=s.next();
				   System.out.println("Country succesfully updated from "+x.getCountry()+" to "+upcountry);
				   x.setCountry(upcountry);
				   break;
			   }
			   else {
				   System.out.println("Invalid option selected");
			   }
			   
		   }//end of outer for
		   
		   
		   x=x.next;
	   }//end of for
}
public void deleteEmp(int id)
{
	Employee x=ref;

	//deleting if its only record
	if(record==1)
	{
		if(x.geteId()==id)
		{
			x.setNext(null);
			System.out.println("Record deleted successfully");
			record--;
		}
		else
		{
			System.out.println("Employee doesnt exists");
		}
	}
	else
	{
		//if its the first element
		if(x.geteId()==id)
		{
			x.setNext(x.getNext());
			System.out.println("Record deleted succesfully");
			record--;
		}
		else
		{
	Employee del=x.next;
	int i;
	   for(i=0;i<record;i++)
	   {
		   if(del.geteId()==id)
		   {
			  break; 
		   }
		   x=x.next;
		   del=del.next;
	   }
	   x.setNext(x.getNext().getNext());
	   record--;
	   System.out.println("Employee record deleted successfully");
	}
	}
	  
}
public void viewAll()
{
	System.out.println("Employee Records:");
	Employee x=ref;
	   while(x.next!=null)
	   {
		   System.out.println("Id "+x.geteId()+" Name: "+x.geteName()+" Age: "+x.getAge()+" Desg:"+x.getDesg()+" Country:"+x.getCountry());
           x=x.next;
	   }
	   
}
public void importEmp()
{

	try
	{
	File file=new File("emp.txt");
    Scanner sc=new Scanner(file);
    int count=0;
    while(sc.hasNextLine())
    {
    	String ip=sc.nextLine();
    	String st[]=ip.split(" ");
    	int eid=Integer.parseInt(st[0]);
    	String name=st[1];
    	int Age=Integer.parseInt(st[2]);
    	String desg=st[3];
    	String country=st[4];
    	Employee xnew=new Employee();
	      xnew.seteId(eid);
	      xnew.seteName(name);
	      xnew.setAge(Age);
	      xnew.setDesg(desg);
	      xnew.setCountry(country);
	      xnew.setNext(ref);
	      ref=xnew;
	      record++;
	      count++;
    }
	System.out.println(count+" Records Succesfully Created.");
	
	}catch(FileNotFoundException fe)
	{
		System.out.println("File not found");
	}
	
}
public  void exportEmp()
{
	try
	{
	FileWriter fw=new FileWriter("EmpOutput.txt");
	Employee e=ref;
	int count=0;
	while(e!=null)
	{
		String op=e.geteId()+" "+e.geteName()+" "+e.getAge()+" "+e.getDesg()+" "+e.getCountry();
		fw.write(op);
		fw.write("\n");
		e=e.next;
		count++;
	}
	fw.close();
	System.out.println(count+" Records written to the file");
	}catch(Exception fe)
	{
		System.out.println(fe);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EmployeeManagementApp e=new EmployeeManagementApp();
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
