package org.example.spring_demo2;

import java.util.UUID;

import org.example.spring_demo2.model.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext context;

	public static void main( String[] args )
    {
        try {
        	
        	context = new ClassPathXmlApplicationContext("applicationContext.xml");
        	
        	Order myOrder=context.getBean("order",Order.class);
        	myOrder.setOrderId(UUID.randomUUID().toString());
        	myOrder.setOrderName("Pen");
        	myOrder.setOrderValue(2.9);
        	System.out.println(myOrder.toString());
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
