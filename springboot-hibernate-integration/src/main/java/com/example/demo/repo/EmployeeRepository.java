package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeRepository {
	
	void createEmployee(Employee employee);
	List<Employee> fetchAllEmployees();
	void findByEmail(String email);
	

}
