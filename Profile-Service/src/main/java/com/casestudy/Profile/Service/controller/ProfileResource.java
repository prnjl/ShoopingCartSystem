package com.casestudy.Profile.Service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.casestudy.Profile.Service.daolayer.ProfileServiceImpl;
import com.casestudy.Profile.Service.model.UserProfile;

@Controller
@RequestMapping("/userprofile")
public class ProfileResource {

	//controller class

	    @Autowired
		ProfileServiceImpl proService;
		
		@PostMapping("/addcustomer")
	    public UserProfile addNewCustomerProfile(@RequestBody UserProfile userprofile) {
			return proService.addNewCustomerProfile(userprofile);
		}
	    public UserProfile addNewMerchantProfile() {
			return null;
		}
	    public UserProfile deliveryProfile() {
			return null;
		}
	    @GetMapping("/findAllUser")
	    public List <UserProfile> getAllProfiles() {
			return proService.getAllProfiles();
		}
	    @GetMapping("/getbyid/{id}")
	    public Optional<UserProfile> getByProfile(@PathVariable ("id") String id) {
			return proService.getByProfile(id);
		}
	     
	     @PutMapping("/updatecustomer/{id}")
	     public String updateProfile(@RequestBody UserProfile userprofile,@PathVariable ("id") String id) {
	    	proService.getByProfile(id);
        return proService.updateProfile(userprofile ,id);
	    	
	    	  
		}
	     @DeleteMapping("/delete/{id}")
	     public String deleteProfile(@PathVariable ("id") String id) {
		
	    	 return proService.deleteProfile(id);
		}
	     
	    public UserProfile getByUserName() {
			return null;
		}
	    

	}
