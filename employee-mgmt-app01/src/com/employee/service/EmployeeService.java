package com.employee.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.employee.employee.Employee;


public class EmployeeService  {
	Employee ref=new Employee();
	int record=0;
	static Scanner s=new Scanner(System.in);
	public  void addEmp()
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
			   System.out.println("Employee details:\n ID:"+x.geteId()+" Employee Name:"+x.geteName()+" Employee Age:"+x.getAge()+" Employee Desg:"+x.getDesg()+" Country:"+x.getCountry());
		   }
		   x=x.getNext();
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
		   
		   
		   x=x.getNext();
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
	Employee del=x.getNext();
	int i;
	   for(i=0;i<record;i++)
	   {
		   if(del.geteId()==id)
		   {
			  break; 
		   }
		   x=x.getNext();
		   del=del.getNext();
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
	   while(x.getNext()!=null)
	   {
		   System.out.println("Id "+x.geteId()+" Name: "+x.geteName()+" Age: "+x.getAge()+" Desg:"+x.getDesg()+" Country:"+x.getCountry());
           x=x.getNext();
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
		e=e.getNext();
		count++;
	}
	fw.close();
	System.out.println(count+" Records written to the file");
	}catch(Exception fe)
	{
		System.out.println(fe);
	}
}
}

