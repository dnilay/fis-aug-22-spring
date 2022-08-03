package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Employee;

public interface EmployeeRepository {
	
	Employee createEmployee(Employee employee);
	
	List<Employee> getAllEmployees() throws SQLException;

}
