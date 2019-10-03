package com.java.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.employee.Model.*;
import com.employee.config.EmployeeConfiguration;
public class JavaBasedDependencyMain {

	static List<Employee> li=new ArrayList<Employee>();
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		while(true)
		{
			System.out.println("1.Add Employee\n2.View All\n3.Edit Employee\n4.Delete Employee\n5.Exit");
			int choice=s.nextInt();
			if(choice==1)
			{
				ApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
				   Employee obj1=ctx.getBean(Employee.class);
				   li.add((Employee)obj1);

			}
			else if(choice==2)
			{
				int size=li.size();
				System.out.println("Employee Details:\nEID\t\tENAME\t\tEAGE\t\tEDEPT\t\tEDesg\t\tECountry");

				for(int i=0;i<size;i++)
				{
					Employee obj=li.get(i);
				System.out.println(obj.getEmpId()+"\t\t"+obj.getEmpName()+"\t\t"+obj.getEmpAge()+"\t\t"+obj.getEmpDept()+"\t\t"+obj.getEmpDesg()+"\t\t"+obj.getEmpCountry());
				}
			}
			else if(choice==3)
			{
				System.out.println("Enter Employee Id:");
				int id=s.nextInt();
				int size=li.size();

				for(int i=0;i<size;i++)
				{
					if(li.get(i).getEmpId()==id)
					{
						System.out.println("Enter updated name:");
						String name=s.next();
						li.get(i).setEmpName(name);
						
						System.out.println("Enter updated Age:");
						int age=s.nextInt();
						li.get(i).setEmpAge(age);
						
						System.out.println("Enter updated department:");
						String dept=s.next();
						li.get(i).setEmpDept(dept);
						
						System.out.println("Enter updated Designation:");
						String desg=s.next();
						li.get(i).setEmpDesg(desg);
						
						System.out.println("Enter updated Country:");
						String country=s.next();
						li.get(i).setEmpCountry(country);
						break;
					}
					else if(i==size)
					{
						System.out.println("No Employee found of this id");
					}
					
				}
			}
				else if(choice==4)
				{
					System.out.println("Enter the id You want to delete:");
					int size=li.size();

					int id=s.nextInt();
					for(int i=0;i<size;i++)
					{
					  if(id==li.get(i).getEmpId())
					  {
						  li.remove(i);
						  System.out.println("deleted succesfully");
					  }
					}
					
				}
			
			else
			{
		break;
			}
		}
	}
	
}
