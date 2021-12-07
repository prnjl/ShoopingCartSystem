package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Userdetails;

@Repository
public interface UserRepository extends MongoRepository<Userdetails, Integer> {

	Userdetails findByName(String username);
	
}
