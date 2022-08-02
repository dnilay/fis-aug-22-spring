package org.example.spring_demo2;

import java.util.Scanner;
import java.util.UUID;

import org.example.spring_demo2.config.SpringConfig;
import org.example.spring_demo2.model.Customer;
import org.example.spring_demo2.model.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	private static ApplicationContext context = null;
	

	public static void main(String[] args) {
		try {

			
			context= new AnnotationConfigApplicationContext(SpringConfig.class);
			Scanner scanner=context.getBean("scanner",Scanner.class);
			Order order = context.getBean("order", Order.class);
			order.setOrderId(UUID.randomUUID().toString());
			order.setOrderName("Desktop");
			System.out.print("Enter Order Value: ");
			order.setOrderValue(scanner.nextDouble());
			Customer customer = context.getBean("customer", Customer.class);
			customer.setCustomerId(101);
			customer.setCustomerName("Marry Public");
			customer.setOrder(order);
			System.out.println(customer);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
