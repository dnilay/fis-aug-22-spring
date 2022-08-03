package org.example;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.example.config.SpringConfig;
import org.example.dao.EmployeeRepository;
import org.example.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    private static ApplicationContext context;

	public static void main( String[] args )
    {
        try {
        	
        	context = new AnnotationConfigApplicationContext(SpringConfig.class);
        	EmployeeRepository employeeRepository=context.getBean("employeeRepository",EmployeeRepository.class);
        	List<Employee> employees=employeeRepository.getAllEmployees();
        	for(Employee employee:employees)
        	{
        		System.out.println(employee);
        	}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
