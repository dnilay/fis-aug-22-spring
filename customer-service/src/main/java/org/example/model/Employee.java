package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	@Override
	public String toString() {
	
		return "\nEmployee ID: "+getEmployeeId()+"\nFirst Name: "+getFirstName()+"\nLast Name: "+getLastName()+
				"\nEmail: "+getEmail();
	}

}
