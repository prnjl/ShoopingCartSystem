package com.casestudy.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.model.Orders;
import com.casestudy.model.Pay;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/page")
	public String getOrders(){ 

		String url="http://localhost:9090";
		
		//Object[] obj= restTemplate.getForObject(url, Object[].class);
		//return  restTemplate.getForObject("http://Paypal-API-Service/", Orders.class);
		return "http://localhost:9090/";
	
	}
		
}
