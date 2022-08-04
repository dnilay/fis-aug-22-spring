package com.example.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Employee;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository(value = "employeeRepository")
@AllArgsConstructor
@Slf4j
@EnableTransactionManagement
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private final EntityManager entityManager;

	@Override
	@org.springframework.transaction.annotation.Transactional
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		entityManager.persist(employee);
	
		log.info("employee created");

	}

	@Override
	public List<Employee> fetchAllEmployees() {
		
		TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
		/*
		 * 
		 * */
		
		
		 entityManager.merge(null);
		 entityManager.remove(null);
		 entityManager.find(null, null);
		
		
		log.info("fetched all records...");
		return query.getResultList();
	}

	@Override
	public void findByEmail(String email) {
		TypedQuery<Employee> query=entityManager.createQuery("FROM Employee E WHERE E.email=:theEmail",Employee.class);
		query.setParameter("theEmail", email);
		List<Employee> list=query.getResultList();
		if(list.isEmpty())
		{
			System.out.println("no such email found");
		}
		else
		{
			System.out.println(list.get(1));
		}
		
	}

}
