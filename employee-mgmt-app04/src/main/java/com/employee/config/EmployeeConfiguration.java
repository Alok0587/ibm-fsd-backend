package com.employee.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.employee.Model.Employee;
import java.util.Scanner;
@Configuration
public class EmployeeConfiguration {

	@Bean
	public Employee addEmployee()
	{
		Scanner s=new Scanner(System.in);
		Employee obj1=new Employee();
		System.out.println("Enter id:");
		   obj1.setEmpId(s.nextInt());
		   System.out.println("Enter Name:");
		   obj1.setEmpName(s.next());
		   System.out.println("Enter Age:");
		   obj1.setEmpAge(s.nextInt());
		   System.out.println("Enter Department:");
		   obj1.setEmpDept(s.next());
		   System.out.println("Enter Desg:");
		   obj1.setEmpDesg(s.next());
		   System.out.println("Enter country:");
		   obj1.setEmpCountry(s.next());
		System.out.println("Employee created succesfully");
		
	 return obj1;
	}
	
	
}
