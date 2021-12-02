package com.casestudy.CartService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.casestudy.CartService.model.Cart;
import com.casestudy.CartService.repository.CartRepository;

public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartrepository;

	@Override
	public Cart additemtocart(Cart cart) {
		
		Cart c= cartrepository.save(cart);
		return c;
	}

	@Override
	public List<Cart> getAll() {
		
		return cartrepository.findAll();
	}

	@Override
	public Optional<Cart> getCartItemById(String productName) {
		
		return cartrepository.findById(productName);
	}
 
	@Override
	public String deleteItembyId(String productName) {
		cartrepository.deleteById(productName);
		return "DELETED ITEM WITH productName "+ productName;
	}

	@Override
	public String updateItemDetails(Cart cart, String productName) {
		cartrepository.findByCartId(productName);
		cartrepository.save(cart);
		return "UPDATED ITEM WITH product Name"+productName;
	}
	}