package org.example;

import org.example.entity.Employee;
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
        	employee.setFirstName("David1");
        	employee.setLastName("Mark1");
        	employee.setEmail("david1@email.com");
        	session.getTransaction().begin();
        	session.persist(employee);
        	session.getTransaction().commit();
        	System.out.println("employee created..."+employee);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
