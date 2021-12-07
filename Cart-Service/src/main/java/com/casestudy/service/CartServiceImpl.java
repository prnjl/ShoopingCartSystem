package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.casestudy.exception.ItemException;
import com.casestudy.model.Cart;
import com.casestudy.repository.CartRepository;

public class CartServiceImpl implements CartService {

	
	@Autowired
	private CartRepository cartRepository;
	
	
	//save the cart
		@Override
		public Cart addCart( Cart cart) {
			if(cart.getItems().isEmpty()) {
				throw new ItemException("601","You have to provide the Item Details!");
			}
			Cart e =  cartRepository.save(cart);
			return e;
		}
		
		//find all cartDetails
			@Override
			public List<Cart> getAllCart(){
				List<Cart> cartList = cartRepository.findAll();
				if(cartList.isEmpty()) {
					throw new ItemException("700","Cart List is completely empty");
				}
				else {
					return cartRepository.findAll();
				}
				
			}
			
		
		//find the Cart by id
		@Override
		public Optional<Cart> getCartById(int cartId){
			Optional<Cart> findById= cartRepository.findById(cartId);
			if(findById.isEmpty()) {
				throw new ItemException("300","Cart not found with this ID!");
			}else {
				return cartRepository.findById(cartId);
			}
		}
		
		//update the Cart by id
		@Override
		public String updateCartDetails( Cart cart, int cartId) {
			boolean isCropExist = cartRepository.existsById(cartId);
			if(isCropExist) {
				cartRepository.save(cart);
				return "Update Cartdetails with id: "+cartId;
			}else {
				throw new ItemException("604","Can not Update as cart not found with this ID");
			}
			
			
		}
		
		//delete by id
		@Override 
		public String deleteCartDetails(int  cartId) {
			boolean isCropExist = cartRepository.existsById(cartId);
			if(isCropExist) {
				cartRepository.deleteById(cartId);
				 return "Delete Cartdetails with id: "+cartId;
			}else {
				throw new ItemException("604","Can not delete as cart not found with this ID");
			}
			
		}
		
		
}