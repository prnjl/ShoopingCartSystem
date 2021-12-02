package com.casestudy.CartService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.casestudy.CartService.service.CartServiceImpl;

@SpringBootApplication
@EnableMongoRepositories
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

	@Bean
	CartServiceImpl CartService() {
		return new CartServiceImpl();
	}
}
