package com.casestudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Cart;
import com.casestudy.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	
	@Autowired
    CartService cartService;
    
  //save the Cart
  	@PostMapping("/addCart")
  	public Cart addCart(@RequestBody Cart cart) {
  		return  cartService.addCart(cart);
  	}
  	
  	//find all Cart
  	@GetMapping("/findAllCart")
  	public List<Cart> getAllCart(){
  		return cartService.getAllCart();
  	}
  	
  	//find the Cart by id
  	@GetMapping("/findCartBy/{cartId}")
  	public Optional<Cart> getCartDetails(@PathVariable  int cartId){
  		return cartService.getCartById(cartId);
  	}
  	
  	//delete the Cart by id
  	@DeleteMapping("/delete/{cartId}")
  	public String deleteCartDetails(@PathVariable int cartId) {
  		cartService.deleteCartDetails(cartId);
  		 return "Delete Cart with id: "+cartId;
  	}
  	
  	//update the Cart by id
  	@PutMapping("/update/{cartId}")
  	public String updateCartDetails(@RequestBody Cart cart, @PathVariable int cartId) {
  		cartService.updateCartDetails(cart, cartId);
  		return "Update Cart with id: "+cartId;
  	}
  	
}

