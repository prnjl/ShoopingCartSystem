package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.casestudy.exception.ApiRequestException;
import com.casestudy.model.Userdetails;
import com.casestudy.repository.UserRepository;
import org.springframework.http.HttpStatus;
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public Userdetails addUser(Userdetails user) {
		return repository.save(user);
		
	}

	@Override
	public List<Userdetails> getUsers() {
	
		List<Userdetails> users = repository.findAll();
		System.out.println("Getting data from DB : " + users);
		return users;
	}
	@Override
	public ResponseEntity<Object> updateuser(int id, Userdetails user) {
		
		
		boolean isUserExist=repository.existsById(id);
		 if(isUserExist) {
		 	repository.save(user);
		    	return new ResponseEntity<Object>("user Updated Successfully with id "+id,HttpStatus.OK);
		 }
		 else
		 {
			 throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
		 }
		
	}


	@Override
	public ResponseEntity<Object> deleteById(int id) {
		boolean isUserExist=repository.existsById(id);
		 if(isUserExist) {
			 repository.deleteById(id);
			 return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		 }
		 else
		 {
		 	throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		 }
		
	}

	@Override
	public Optional<Userdetails> getuser(int id) {
		return Optional.of(repository.findById(id)
				 .orElseThrow( () -> new ApiRequestException("CUSTOMER NOT FOUND WITH THIS ID ::")));
		
	}

	

}