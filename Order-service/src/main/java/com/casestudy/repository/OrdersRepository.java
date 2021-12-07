package com.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.casestudy.model.Cart;
import com.casestudy.model.Orders;


public interface OrdersRepository extends MongoRepository<Orders, Integer> {


	}
