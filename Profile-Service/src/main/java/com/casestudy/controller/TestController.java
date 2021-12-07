package com.casestudy.controller;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.User;
import com.casestudy.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	private final UserRepository userRepository;
	public TestController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('MODERATOR') or hasRole('MERCHANT')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('MERCHANT')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/allUsers")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable String id) {
		  userRepository.deleteById(id);
		
	}
}