package com.casestudy.model;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
@Document(collection="user")
public class Userdetails {

	@Id
	int Id;
	
	@NotEmpty(message = "Name must not be empty")
	String username;
	
	  @NotEmpty(message = "email must not be empty") String email;
	 
	@NotEmpty(message = "Password must not be empty")
	String password;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	  public String getEmail() { return email; }
	  
	  public void setEmail(String email) { this.email = email; }
	 

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Userdetails(int id, @NotEmpty(message = "Name must not be empty") String username, String email,
			@NotEmpty(message = "Password must not be empty") String password) {
		super();
		Id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Userdetails() {
		super();
	}

	@Override
	public String toString() {
		return "Userdetails [Id=" + Id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
