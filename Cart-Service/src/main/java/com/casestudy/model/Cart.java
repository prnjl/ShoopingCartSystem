package com.casestudy.model;

import java.util.ArrayList;
import java.util.List;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {
	
	@Id
    private int cartId;
    private double totalPrice;

    private List<Items> items= new ArrayList<>();

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public Cart(int cartId, double totalPrice, List<Items> items) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.items = items;
	}

	public Cart() {
		super();
	}

	
	public Cart(int i, double d, String string, double e, int j) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalPrice=" + totalPrice + ", items=" + items + "]";
	}
    
    
    
    
}