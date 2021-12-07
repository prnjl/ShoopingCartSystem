package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import com.casestudy.model.Cart;

public interface CartService {
	
	public Cart addCart( Cart cart);
	public Optional<Cart> getCartById(int cartId);
	public String updateCartDetails( Cart cart,  int cartId);
	public List<Cart> getAllCart();
	public String deleteCartDetails( int cartId);

	
}
