package org.example.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.example.mapper.EmployeeMapper;
import org.example.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository(value = "employeeRepository")
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private final JdbcTemplate jdbcTemplate;
	private Scanner scanner;

	@Override
	public void createEmployee(Employee employee) throws SQLException {
		jdbcTemplate.update("insert into employees(first_name,last_name,email) values(?,?,?)", employee.getFirstName(),
				employee.getLastName(), employee.getEmail());

	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		/*
		 * List<Employee> list = jdbcTemplate.query("select * from employees", new
		 * RowMapper<Employee>() {
		 * 
		 * @Override public Employee mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { // TODO Auto-generated method stub Employee employee = new
		 * Employee(); employee.setEmployeeId(rs.getInt(1));
		 * employee.setFirstName(rs.getString(2));
		 * employee.setLastName(rs.getString(3)); employee.setEmail(rs.getString(4));
		 * return employee; }
		 * 
		 * });
		 */
		List<Employee> list = jdbcTemplate.query("select * from employees", new EmployeeMapper());
		return list;
	}

	@Override
	public void updateEmployeeById(int employeeId) throws SQLException {

		List<Employee> list = getAllEmployees();
		boolean flag = false;
		for (Employee e : list) {
			if (e.getEmployeeId() == employeeId) {
				flag = true;
				break;
			}
		}

		// Employee employee= jdbcTemplate.queryForObject("select * from employees where
		// id="+employeeId,new EmployeeMapper());

		// if(employee==null)

		if (flag == false) {
			System.out.println("no such id found...");
		} else {
			System.out.print("Enter New First Name: ");
			String fName = scanner.next();
			System.out.print("Enter New Last Name: ");
			String lName = scanner.next();
			System.out.print("Enter New Email: ");
			String email = scanner.next();

			int count = jdbcTemplate.update("update employees set first_name=?,last_name=?,email=? where id=?", fName,
					lName, email, employeeId);
			System.out.println("updation successfull.." + count + " record updated...!");
		}

	}

}
