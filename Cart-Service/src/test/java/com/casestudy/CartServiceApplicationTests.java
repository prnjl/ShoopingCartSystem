package com.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.casestudy.model.Cart;
import com.casestudy.model.Items;
import com.casestudy.repository.CartRepository;
import com.casestudy.service.CartService;


@SpringBootTest
class CartServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private CartService cartService;
	
	@MockBean
	private CartRepository CartRepository;

	@Test
	 public void getAllCartTest()
	 {
		when(CartRepository.findAll()).thenReturn(Stream.of
				(new Cart(2,100.0,"Clothe",20000.0,3),new Cart(2,1000.0,"Watch",1000.0,3))
				.collect(Collectors.toList()));
		assertEquals(2,cartService.getAllCart().size());
	 }
	@Test
	public void addCart() 
	{
		Cart cart = new Cart(2,1000.0,Arrays.asList(new Items("juice",100.0,3)));
	    when(CartRepository.save(cart)).thenReturn(cart);
	    assertEquals(cart,cartService.addCart(cart));
	}
}
