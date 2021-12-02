package com.casestudy.Profile.Service.daolayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.casestudy.Profile.Service.model.Role;
import com.casestudy.Profile.Service.model.UserProfile;
import com.casestudy.Profile.Service.repository.ProfileRepository;

public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	ProfileRepository proRepo;

	@Override
	public UserProfile addNewCustomerProfile(UserProfile userprofile) {
		
		userprofile.setRole(Role.customer);
		 UserProfile up=  proRepo.save(userprofile);
		return up;
		
		//need to empl of ewallet
		
	}

	@Override
	public List<UserProfile> getAllProfiles() {
	return (List<UserProfile>) proRepo.findAll();
	}

	@Override
	public String deleteProfile(String id ) {
		proRepo.deleteById(id);
		return "UserProfile" + id + "ID DELETED";
	}

	@Override
	public UserProfile addNewMerchantProfile(UserProfile userprofile) {
		userprofile.setRole(Role.merchant);
		 UserProfile up = proRepo.save(userprofile);
         return up;
	}
	@Override
	public UserProfile addNewDeliverProfile(UserProfile userprofile) {
		userprofile.setRole(Role.deliveryAgent);
		 UserProfile up = proRepo.save(userprofile);
        return up;
	}
	@Override
	//optional
	public Optional<UserProfile> findByMobileNo(Long mobileno) {
		Optional<UserProfile> up = proRepo.findByMobileNumber(mobileno);
		return up;
	}

	@Override
	public String getByUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProfile(UserProfile userprofile , String id) {
		proRepo.findById(id);
		proRepo.save(userprofile);
		return "updated"+id;
	}

	@Override
	public Optional<UserProfile> getByProfile(String id) {
		
		return proRepo.findById(id);
	}

}
