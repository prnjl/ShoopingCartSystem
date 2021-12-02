package com.casestudy.Profile.Service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Profile.Service.model.UserProfile;

public interface ProfileRepository extends MongoRepository<UserProfile, String> {
	
	
	//user profile is for data collection
	
		Optional<UserProfile> findByMobileNumber(Long mobileNumber);
		
		Optional<UserProfile> findByEmail(String email);
		
		//optional is used for any op except crud

}
