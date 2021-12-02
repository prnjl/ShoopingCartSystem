package com.casestudy.CartService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.CartService.model.Cart;


public interface CartRepository extends MongoRepository<Cart , String>{
	
	
	Cart findByCartId( String productName);
	
	
}
