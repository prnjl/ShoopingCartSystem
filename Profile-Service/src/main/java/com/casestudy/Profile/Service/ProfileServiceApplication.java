package com.casestudy.Profile.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.casestudy.Profile.Service.daolayer.ProfileServiceImpl;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

	@Bean 
	public ProfileServiceImpl proService() {
		return new ProfileServiceImpl();
	}
}
