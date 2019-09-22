package com.examples.java;

class Employee
{
	int eId;
	String eName;
	int age;
	String desg;
	String country;
	Employee next;
	public Employee(int eId, String eName, int age, String desg, String country) {
		this.eId = eId;
		this.eName = eName;
		this.age = age;
		this.desg = desg;
		this.country = country;
	}
	public Employee()
	{
		this.eId=0;
		this.eName=null;
		this.age=0;
		this.desg=null;
		this.country=null;
		this.next=null;
		
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setNext(Employee next)
	{
		this.next=next;
	}
	public Employee getNext()
	{
		return this.next;
	}
	
}