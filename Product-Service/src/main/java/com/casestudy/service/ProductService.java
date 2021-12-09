package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import com.casestudy.model.Product;

public interface ProductService {

	 
	   
	List<Product> getAllProducts();      //customer control
	Optional<Product> getProductById(int productId);    //merchant control
	Product addProduct(Product product);              //merchant control 
	String updateProduct(Product product , int productId);
	String deleteByProductId(Product product , int productId);
	
	
	
	//Merchant control 

	List<Product> getProductByName(String productName);

	List<Product> getProductByCategory(String category);

	List<Product> getProductByType(String productType);
	
	Product deleteByProductName(String productName);   //merchant control
}
