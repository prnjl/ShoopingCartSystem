package com.casestudy.Profile.Service.daolayer;

import java.util.List;
import java.util.Optional;

import com.casestudy.Profile.Service.model.UserProfile;

public interface ProfileService {
	
	public UserProfile addNewCustomerProfile(UserProfile userprofile);
	public List <UserProfile> getAllProfiles(); 
	public Optional<UserProfile> getByProfile(String id);
	public  String deleteProfile(String id);
	public  UserProfile addNewMerchantProfile( UserProfile userprofile);
	public UserProfile addNewDeliverProfile(UserProfile userprofile);
	public Optional<UserProfile> findByMobileNo(Long mobileNo);
	public String getByUserName();
	
	String updateProfile(UserProfile userprofile ,  String id);
	

}



















