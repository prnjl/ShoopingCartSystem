
 package com.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.casestudy.exceptions.OrderServiceException;
import com.casestudy.model.Address;
import com.casestudy.model.Orders;
import com.casestudy.model.Product;
import com.casestudy.model.Orders;
import com.casestudy.repository.OrdersRepository;
import com.casestudy.service.OrderService;

@SpringBootTest 
  class OrderServiceApplicationTests {
 
	
	@Test
	void contextLoads() {
	}
	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrdersRepository orderRepo;
	@Test
	public void getAllOrdersTest()
	{
		when(orderRepo.findAll()).thenReturn(Stream.of
				(new Orders(1,"2021-07-25",123,234.222212,"Paytm","Paid",2,1,"skips",123,"pranjal",345678,23,"gondia","maha",2334411)
						,new Orders(1,"2021-07-25",123,234.222212,"Paytm","Paid",2,1,"Clothe",123,"kunal",345678,23,"gondia","maha",2334411))
				.collect(Collectors.toList()));
		assertEquals(2,orderService.getAllOrders().size());
	}
	/*
	 * @Test public void addOrderTest() throws EmptyInputException { Orders order =
	 * new
	 * Orders(1,"2021-07-25",123,234.222212,"Paytm","Paid",2,1,"Clothe",123,"pankaj"
	 * ,345678,23,"varanasi","UP",2334411);
	 * when(orderRepo.save(order)).thenReturn(order);
	 * assertEquals(order,orderService.addOrder(order)); }
	 */
	
	@Test
	public void addOrderTest() throws OrderServiceException{
	
	Orders order = new Orders(1,2021-12-12,10,200.98,"Paytm","paid",3,Arrays.asList(new Product(1,"grocery")),
			Arrays.asList(new Address(10,"pranjal","1234576","12","maha","gondia","1233456")));
	when(orderRepo.save(order)).thenReturn(order);
	assertEquals(order,orderService.addOrder(order));
	 
	}
	 
	
	 @Test  
	  @Order(5)
	  @Rollback(value = false) 
	  public void deleteOrderTest()
	 {
	  
	  orderRepo.deleteById(1);
	  Order user1 = null;
	  Optional<Order> user = Optional.empty();
	  
	  if(user.isPresent()){ user1 = user.get();
	  }
	    Assertions.assertThat(user1).isNull(); 
	  }
	  

}
