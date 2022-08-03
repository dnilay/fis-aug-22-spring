package org.example;

import java.util.List;
import java.util.Scanner;

import org.example.config.SpringConfig;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	private static ApplicationContext context;
	

	public static void main(String[] args) {

		try {
			context = new AnnotationConfigApplicationContext(SpringConfig.class);
			Scanner scanner = context.getBean("scanner", Scanner.class);
			EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
			int choice = 0;
			String firstName, lastName, email = null;
			List<Employee> employees = null;
			do {
				System.out.println("1. Create Employee. ");
				System.out.println("2. Fetch All Employees. ");
				System.out.println("0. Exit. ");
				System.out.print("Enter your choice: ");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("First Name: ");
					firstName = scanner.next();
					System.out.print("Last Name: ");
					lastName = scanner.next();
					System.out.print("Email: ");
					email = scanner.next();
					employeeService.createEmployee(new Employee(firstName, lastName, email));
					break;
				case 2:
					employees = employeeService.getAllEmployees();
					for(Employee e:employees)
					{
						System.out.println(e);
					}
					
					break;
				case 0:
					System.out.println("Bye...!");
					System.exit(0);
					break;
				default:
					System.out.println("invalid choice try again...");
					break;
				}

			} while (choice != 0);

		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
