package com.employee.Model;

public class Employee {
	int empId;
	String empName;
	int empAge;
	String empDept;
	String empDesg;
	String empCountry;
	
	public Employee()
	{
		
	}
	public Employee(int empId, String empName, int empAge,String empDept, String empDesg, String empCountry) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empDept= empDept;
		this.empDesg = empDesg;
		this.empCountry = empCountry;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	public String getEmpCountry() {
		return empCountry;
	}
	public void setEmpCountry(String empCountry) {
		this.empCountry = empCountry;
	}
	
	
	

}
