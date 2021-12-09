package com.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

	

	
   List<Product> findByProductName(String productName);
	
	List<Product> findByCategory(String category);
	
	List<Product> findByProductType(String productType);

	Product deleteByProductName(String productName);
	
	
}
