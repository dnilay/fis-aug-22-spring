package org.example.model;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	
	private Department department;
	public Employee() {
		
	}
	public Employee(int employeeId, String firstName, String lastName, String email,Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department=department;
		
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee ID: "+employeeId+" First Name: "+firstName+" Last Name: "+lastName+" Email: "+email+" Department: "+department;
		
	}
	

}
