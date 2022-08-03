package org.example;

import java.util.List;
import java.util.Scanner;

import org.example.config.SpringConfig;
import org.example.dao.EmployeeRepository;
import org.example.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	private static ApplicationContext context;

	public static void main(String[] args) {
		try {

			context = new AnnotationConfigApplicationContext(SpringConfig.class);
			EmployeeRepository employeeRepository = context.getBean("employeeRepository", EmployeeRepository.class);
			Scanner scanner=context.getBean("scanner",Scanner.class);
			System.out.print("First Name: ");
			String fName=scanner.next();
			System.out.print("Last Name: ");
			String lName=scanner.next();
			System.out.print("Email: ");
			String eml=scanner.next();
			
			Employee tempEmployee= employeeRepository.createEmployee(new Employee(fName, lName, eml));
			System.out.println("employee created: "+tempEmployee+"\n================\n");
			List<Employee> employees = employeeRepository.getAllEmployees();
			for (Employee employee : employees) {
				System.out.println(employee);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
