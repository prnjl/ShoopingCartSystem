package com.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

	

   
}
