package com.casestudy.model;

import java.util.List;

public class Pay {

	private List<Orders> ord;
	private int orderId;
	public List<Orders> getOrd() {
		return ord;
	}
	public void setOrd(List<Orders> ord) {
		this.ord = ord;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Pay(List<Orders> ord, int orderId) {
		super();
		this.ord = ord;
		this.orderId = orderId;
	}
	public Pay() {
		super();
	}
	@Override
	public String toString() {
		return "Pay [ord=" + ord + ", orderId=" + orderId + "]";
	}
	
}
