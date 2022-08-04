package org.example;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
					.buildSessionFactory();
			Session session = sessionFactory.getCurrentSession();

			/*
			 * Employee employee=new Employee(); employee.setFirstName("Sachin");
			 * employee.setLastName("Tendulkar"); employee.setEmail("sachin@email.com");
			 * session.getTransaction().begin(); // session.persist(employee); Integer i=
			 * (Integer) session.save(employee); System.out.println(i);
			 * session.getTransaction().commit();
			 * System.out.println("employee created..."+employee);
			 * 
			 * session.getTransaction().begin();
			 * 
			 * Query<Employee> query=session.createQuery("FROM Employee",Employee.class);
			 * List<Employee> list=query.getResultList(); for(Employee e:list) {
			 * System.out.println(e); }
			 * 
			 * TypedQuery<Employee>
			 * query=session.createQuery("FROM Employee",Employee.class); List<Employee>
			 * list=query.getResultList(); for(Employee e:list) { System.out.println(e); }
			 * session.getTransaction().commit();
			 */

			System.out.println("Enter ID: ");
			int id = scanner.nextInt();
			session.getTransaction().begin();
			/*
			 * TypedQuery<Employee> query =
			 * session.createQuery("FROM Employee E WHERE E.employeeId=:eId",
			 * Employee.class); query.setParameter("eId", id); List<Employee> list =
			 * query.getResultList(); if (list.isEmpty()) {
			 * System.out.println("No Such ID Found.."); } else { Employee employee =
			 * query.getResultList().get(0); session.getTransaction().commit();
			 * 
			 * System.out.println(employee); }
			 */
			
			
			Employee employee=session.find(Employee.class, id);
			if(employee==null)
			{
				System.out.println("not found.");
			}
			else
			{
				System.out.print("Enter New First Name: ");
				String fName=scanner.next();
				System.out.print("Enter New Last Name: ");
				String lName=scanner.next();
				System.out.print("Enter Email: ");
				String em=scanner.next();
				employee.setEmail(em);
				employee.setFirstName(fName);
				employee.setLastName(lName);
			
				session.merge(employee);
				session.getTransaction().commit();
				System.out.println("Foundand updated. \n"+employee);
			}

			session.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
