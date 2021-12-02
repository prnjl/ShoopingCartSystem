package com.casestudy.CartService.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.CartService.model.Cart;
import com.casestudy.CartService.model.Items;
import com.casestudy.CartService.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartResource {
	
	
	@Autowired
	CartServiceImpl cartservice;

	
	@PostMapping("/additemtocart")
	public Cart additemtocart(@RequestBody Cart cart) {
		
		return cartservice.additemtocart(cart);
	}
	
	@GetMapping("/getallitem")
	public List<Cart> getAll(){
		return cartservice.getAll();
	}
	@GetMapping("/getitembyid/{productName}")
	public Optional<Cart> getCartItemById(@PathVariable String productName){
		return cartservice.getCartItemById(productName);
	}
	
	@DeleteMapping("/deleteitembyid/{productName}")
	public String deleteItembyId(@PathVariable String productName) {
		return cartservice.deleteItembyId(productName);
	}
	
	@PutMapping("/updateitembyid/{productName}")
	public String updateItemDetails(@RequestBody Cart cart,@PathVariable String productName) {
		
	 cartservice.getCartItemById(productName);
	 cartservice.additemtocart(cart);
		return "UPDATED ITEM WITH product Name"+productName;
	}
	
}

