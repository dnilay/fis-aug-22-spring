package org.example;

import org.example.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext context = null;

	public static void main(String[] args) {
		try {

			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			// Coach myCoach = context.getBean("theCoach", Coach.class);
			// System.out.println(myCoach.getDailyWorlout());

			Employee employee = context.getBean("employee", Employee.class);
			System.out.println(employee);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
