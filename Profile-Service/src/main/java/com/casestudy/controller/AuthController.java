package com.casestudy.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.ERole;
import com.casestudy.model.Role;
import com.casestudy.model.User;
import com.casestudy.payload.request.LoginRequest;
import com.casestudy.payload.request.SignupRequest;
import com.casestudy.payload.response.JwtResponse;
import com.casestudy.payload.response.MessageResponse;
import com.casestudy.repository.RoleRepository;
import com.casestudy.repository.UserRepository;
import com.casestudy.security.jwt.JwtUtils;
import com.casestudy.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	//FOR SIGN-IN

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}
	
	
	
	//FOR SIGNUP

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		

		// Create new user's account
		/*
		 * User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
		 * encoder.encode(signUpRequest.getPassword()));
		 */
		User user = new User();
		user.setUsername( signUpRequest.getUsername());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(signUpRequest.getPassword());
		
		 String  strRoles = signUpRequest.getRoles();
		
		System.out.println(strRoles);
		
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
	
		
					Optional<Role> userRole = roleRepository.findByName("ROLE_CUSTOMER");
					System.out.println(userRole);
//				
//					.orElseThrow(() -> new RuntimeException(" CUSTOMER is not found."));
//			System.out.println("hello"+userRole);
//			roles.add(userRole);
		} else {
			

			Optional<Role> userRole = roleRepository.findByName("ROLE_MERCHANT");
			System.out.println(userRole);
			
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName(ERole.ROLE_MERCHANT)
//							.orElseThrow(() -> new RuntimeException("MERCHANT is not found."));
//					roles.add(adminRole);
//
//					break;
//				case "mod":
//					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//							.orElseThrow(() -> new RuntimeException(" MODERATOR is not found."));
//					roles.add(modRole);
//
//					break;
//				default:
//					Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
//							.orElseThrow(() -> new RuntimeException(" CUSTOMER is not found."));
//					roles.add(userRole);
//				}
//			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}