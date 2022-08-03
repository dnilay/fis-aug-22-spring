package org.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.example.mapper.EmployeeMapper;
import org.example.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository(value = "employeeRepository")
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private final JdbcTemplate jdbcTemplate;

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
		List<Employee> list=jdbcTemplate.query("select * from employees", new EmployeeMapper());
		return list;
	}

}
