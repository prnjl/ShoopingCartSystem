package com.casestudy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Orders {
	
	@Id
	private int orderId;
	@JsonFormat(pattern="yyyy-MM-dd") 
	private LocalDate orderDate;
	private int customerId;
	private double amountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private int quantity;
	
	private List<Product>products=new ArrayList<>();
	private List<Address>address=new ArrayList<>();
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public Orders(int orderId, LocalDate orderDate, int customerId, double amountPaid, String modeOfPayment,
			String orderStatus, int quantity, List<Product> products, List<Address> address) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.amountPaid = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.products = products;
		this.address = address;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", amountPaid=" + amountPaid + ", modeOfPayment=" + modeOfPayment + ", orderStatus=" + orderStatus
				+ ", quantity=" + quantity + ", products=" + products + ", address=" + address + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, amountPaid, customerId, modeOfPayment, orderDate, orderId, orderStatus, products,
				quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(address, other.address)
				&& Double.doubleToLongBits(amountPaid) == Double.doubleToLongBits(other.amountPaid)
				&& customerId == other.customerId && Objects.equals(modeOfPayment, other.modeOfPayment)
				&& Objects.equals(orderDate, other.orderDate) && orderId == other.orderId
				&& Objects.equals(orderStatus, other.orderStatus) && Objects.equals(products, other.products)
				&& quantity == other.quantity;
	}
	
	
}
