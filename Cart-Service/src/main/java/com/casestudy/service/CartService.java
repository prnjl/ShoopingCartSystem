package com.casestudy.service;


import com.casestudy.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

	public Cart addCart( Cart cart);
	public Optional<Cart> getCartById(int cartId);
	public String updateCartDetails( Cart cart,  int cartId);
	public List<Cart> getAllCarts();
	public String deleteCartDetails( int cartId);
}