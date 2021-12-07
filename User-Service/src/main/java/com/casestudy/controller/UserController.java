package com.casestudy.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.casestudy.exception.ApiRequestException;
import com.casestudy.model.AuthenticationRequest;
import com.casestudy.model.AuthenticationResponse;
import com.casestudy.model.Orders;
import com.casestudy.model.Product;
import com.casestudy.model.Userdetails;
import com.casestudy.service.MyUserDetailsService;
import com.casestudy.service.UserService;
import com.casestudy.util.JwtUtil;

public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	 }
	
	 @PostMapping(value ="/adduser")
	 public Userdetails saveUser(@Valid @RequestBody Userdetails user) {
	 	return service.addUser(user);
	 }
 
	 @GetMapping("/allusers")
	 public List<Userdetails> findAllUsers() {
	 	return service.getUsers();
	 }
	 
	 @GetMapping("/allusers/{id}")
	 public Optional<Userdetails> getuser(@PathVariable int id)
	 		throws ApiRequestException
	 {
		 return service.getuser(id);
		
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Object> deleteById(@PathVariable int id)
	 {
		 return service.deleteById(id);
		
	 }
	 @GetMapping("/allproduct")
	 public List<Product>getAllProducts(){
		 String url="http://localhost:8789/api/product/getallProduct";
		 Product[] product=restTemplate.getForObject(url, Product[].class);
		return Arrays.asList(product);
	 }

		/*
		 * @PostMapping("/addorder") public String addorder(@RequestBody Orders order) {
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * HttpEntity<Orders> entity = new HttpEntity<Orders>(order,headers); return
		 * restTemplate.exchange( "http://localhost:8081/addorder", HttpMethod.POST,
		 * entity, String.class).getBody(); }
		 */
	
	

}
