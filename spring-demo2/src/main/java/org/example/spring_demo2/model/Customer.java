package org.example.spring_demo2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "theCustomer")
public class Customer {

	private int customerId;
	private String customerName;
	// attribute level dependency injection
	// @Autowired
	private Order order;

	// constructor injection
	// @autowired is optional

	@Autowired
	public Customer(Order order) {

		this.order = order;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Order getOrder() {
		return order;
	}

	// setter injection
	// @Autowired
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", order=" + order + "]";
	}

}
