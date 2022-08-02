package org.example.model;

public class Department {
	
	private int departmentId;
	private String departmentName;
	private String location;
	public Department() {
		super();
	}
	public Department(int departmentId, String departmentName, String location) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", location="
				+ location + "]";
	}
	
	
	

}
