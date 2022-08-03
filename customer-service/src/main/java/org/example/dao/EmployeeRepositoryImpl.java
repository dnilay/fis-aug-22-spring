package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.example.model.Employee;
import org.springframework.stereotype.Component;

@Component(value = "employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private DataSource dataSource;

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;

	@Override
	public Employee createEmployee(Employee employee) throws SQLException {
		preparedStatement=connection.prepareStatement("insert into employees(first_name,last_name,email) values(?,?,?)");
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setString(3, employee.getEmail());
		preparedStatement.executeUpdate();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from employees");
		List<Employee> employees = new ArrayList<Employee>();
		while (resultSet.next()) {
			employees.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4)));
		}
		return employees;
	}

	public EmployeeRepositoryImpl(DataSource dataSource) throws SQLException {

		this.dataSource = dataSource;
		connection = dataSource.getConnection();
	}

}
