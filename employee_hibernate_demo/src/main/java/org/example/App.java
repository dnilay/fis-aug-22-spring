package org.example;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import org.example.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        	Session session=sessionFactory.openSession();
			
			  Employee employee=new Employee(); 
			  employee.setFirstName("Sachin");
			  employee.setLastName("Tendulkar");
			  employee.setEmail("sachin@email.com");
			  session.getTransaction().begin(); 
			 // session.persist(employee);
			  Integer i= (Integer) session.save(employee);
			  System.out.println(i);
			  session.getTransaction().commit();
			  System.out.println("employee created..."+employee);
			 
        	session.getTransaction().begin();
			/*
			 * Query<Employee> query=session.createQuery("FROM Employee",Employee.class);
			 * List<Employee> list=query.getResultList(); for(Employee e:list) {
			 * System.out.println(e); }
			 */
        	TypedQuery<Employee> query=session.createQuery("FROM Employee",Employee.class);
        	List<Employee> list=query.getResultList();
        	for(Employee e:list)
        	{
        		System.out.println(e);
        	}
        	session.getTransaction().commit();
        	session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
