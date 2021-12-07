package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Cart;

public interface CartRepository extends MongoRepository<Cart , Integer>{

}
