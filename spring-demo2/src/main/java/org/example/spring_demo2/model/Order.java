package org.example.spring_demo2.model;

public class Order {

	private String orderId;
	// @Value("Pen")
	private String orderName;
	// @Value("10.0")
	private double orderValue;

	public Order() {

	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderValue=" + orderValue + "]";
	}

}
