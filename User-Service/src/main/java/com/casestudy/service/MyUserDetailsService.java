package com.casestudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.casestudy.model.Userdetails;
import com.casestudy.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  Userdetails user=repository.findByName(username);
		  
		  
		  return new User(user.getUsername() ,user.getPassword(),new ArrayList<>());
		 
		
		 // return new User("pranjal", "pranjal123", new ArrayList<>());
		 
    }

	
}