package com.casestudy.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.ERole;
import com.casestudy.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	 
	 
	Optional<Role> findByName(String name);
	}
