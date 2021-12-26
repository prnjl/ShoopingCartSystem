package com.casestudy.model;

public class ERole {

	private String USER_CUSTOMER;
	private String USER_MERCHANT;
	
	
	public String getUSER_CUSTOMER() {
		return USER_CUSTOMER;
	}
	public void setUSER_CUSTOMER(String uSER_CUSTOMER) {
		USER_CUSTOMER = uSER_CUSTOMER;
	}
	public String getUSER_MERCHANT() {
		return USER_MERCHANT;
	}
	public void setUSER_MERCHANT(String uSER_MERCHANT) {
		USER_MERCHANT = uSER_MERCHANT;
	}
	public ERole(String uSER_CUSTOMER, String uSER_MERCHANT) {
		super();
		USER_CUSTOMER = uSER_CUSTOMER;
		USER_MERCHANT = uSER_MERCHANT;
	}
	public ERole() {
		super();
	}
	@Override
	public String toString() {
		return "ERole [USER_CUSTOMER=" + USER_CUSTOMER + ", USER_MERCHANT=" + USER_MERCHANT + "]";
	}
	
}
