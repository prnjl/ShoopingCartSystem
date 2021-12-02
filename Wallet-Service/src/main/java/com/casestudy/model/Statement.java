package com.casestudy.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Statement {
	
	private String statementId;
	private String transactionType;
	private double amount;
	private LocalDateTime dateTime;
	private String orderId;
	private String transactionRemarks;
	public String getStatementId() {
		return statementId;
	}
	public void setStatementId(String statementId) {
		this.statementId = statementId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTransactionRemarks() {
		return transactionRemarks;
	}
	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}
	public Statement(String statementId, String transactionType, double amount, LocalDateTime dateTime, String orderId,
			String transactionRemarks) {
		super();
		this.statementId = statementId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.orderId = orderId;
		this.transactionRemarks = transactionRemarks;
	}
	@Override
	public String toString() {
		return "Statement [statementId=" + statementId + ", transactionType=" + transactionType + ", orderId=" + orderId
				+ ", transactionRemarks=" + transactionRemarks + "]";
	}
	public Statement() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, dateTime, orderId, statementId, transactionRemarks, transactionType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statement other = (Statement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(dateTime, other.dateTime) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(statementId, other.statementId)
				&& Objects.equals(transactionRemarks, other.transactionRemarks)
				&& Objects.equals(transactionType, other.transactionType);
	}
	
	

}
