package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Statement;

public interface StatementsRepository extends MongoRepository<Statement, String>{

}
