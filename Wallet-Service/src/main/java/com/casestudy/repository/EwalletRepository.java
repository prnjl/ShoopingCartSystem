package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.daolayer.EwalletService;
import com.casestudy.model.Ewallet;

public interface EwalletRepository extends MongoRepository<Ewallet, String> {

	
	
	
}
