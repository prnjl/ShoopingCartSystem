package com.casestudy.model;

import java.util.Objects;

public class Ewallet {

	private String ewalletId;
	private double currentBalance;
	
	public String getEwalletId() {
		return ewalletId;
	}
	public void setEwalletId(String ewalletId) {
		this.ewalletId = ewalletId;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Ewallet(String ewalletId, double currentBalance) {
		super();
		this.ewalletId = ewalletId;
		this.currentBalance = currentBalance;
	}
	public Ewallet() {
		super();
	}
	@Override
	public String toString() {
		return "Ewallet [ewalletId=" + ewalletId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(currentBalance, ewalletId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ewallet other = (Ewallet) obj;
		return Double.doubleToLongBits(currentBalance) == Double.doubleToLongBits(other.currentBalance)
				&& Objects.equals(ewalletId, other.ewalletId);
	}
	
	
}
