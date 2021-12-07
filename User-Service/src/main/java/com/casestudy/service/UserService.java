package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.casestudy.model.Userdetails;

public interface UserService {

public Userdetails addUser(Userdetails user);
	
	public List<Userdetails> getUsers();
	
	
	
	public ResponseEntity<Object> deleteById(int id);

	public ResponseEntity<Object> updateuser(int id, Userdetails user);

	public Optional<Userdetails> getuser(int id);
	
	
}
