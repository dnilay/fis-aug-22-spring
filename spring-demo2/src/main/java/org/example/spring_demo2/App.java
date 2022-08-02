package org.example.spring_demo2;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import org.example.spring_demo2.model.Customer;
import org.example.spring_demo2.model.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext context=null;

	public static void main( String[] args )
    {
        try {
        	
        	context = new ClassPathXmlApplicationContext("applicationContext.xml");
        	Scanner scanner=new Scanner(System.in);
        	Order myOrder=context.getBean("order",Order.class);
        	myOrder.setOrderId(UUID.randomUUID().toString());
        //	myOrder.setOrderName("Pen");
        	System.out.print("enter order value: ");
        	myOrder.setOrderValue(scanner.nextDouble());
        	Customer customer=context.getBean("theCustomer",Customer.class);
        	customer.setCustomerId(new Random().nextInt(100));
        	customer.setCustomerName("John Doe");
        	customer.setOrder(myOrder);
        	System.out.println(customer);
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
