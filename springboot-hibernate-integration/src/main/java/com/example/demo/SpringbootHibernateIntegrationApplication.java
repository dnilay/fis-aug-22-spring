package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootHibernateIntegrationApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(SpringbootHibernateIntegrationApplication.class, args);
	EmployeeRepository employeeRepository=context.getBean("employeeRepository",EmployeeRepository.class);
	/*
	 * Employee employee=new Employee("Atul", "Kumar", "atul@email.com");
	 * employeeRepository.createEmployee(employee);
	 */
	List<Employee> list=employeeRepository.fetchAllEmployees();
	for(Employee e:list)
	{
		System.out.println(e);
	}
	
	log.info("done.!");
	}

}
