package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import com.casestudy.model.Product;

public interface ProductService {

	 
	   
	List<Product> getAllProducts();                              //for admin and user both
	Optional<Product> getProductById(int productId);
	
	
	Product addProduct(Product product);                           //for admin
	String updateProduct(Product product , int productId);          //for admin
	String deleteByProductId(Product product , int productId);         //for admin
	
	List<Product> getProductByName(String productName);             //for admin and user both
	List<Product> getProductByCategory(String category);             //for admin and user both
	List<Product> getProductByType(String productType);             //for admin and user both

}
