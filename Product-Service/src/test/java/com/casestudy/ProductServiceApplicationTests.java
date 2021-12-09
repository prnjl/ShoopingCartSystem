package com.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

import com.casestudy.exception.EmptyInputException;
import com.casestudy.model.Product;
import com.casestudy.repository.ProductRepository;
import com.casestudy.service.ProductService;

@SpringBootTest
class ProductServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private ProductService proService;
	
	@MockBean
	private ProductRepository proRepository;
	
	@Test
	public void getAllProductTest()
	{
		when(proRepository.findAll()).thenReturn(Stream.of
				(new Product(2,"Mobile","Realme","abcd","pic.jpg",5000,4,"medium"),new Product(6,"Laptop","HP","abcd","pic.jpg",5000,4,"medium"))
				.collect(Collectors.toList()));
		assertEquals(2,proService.getAllProducts().size());
	}
	@Test
	public void addProduct() throws EmptyInputException
	{
		Product product = new Product(2,"Mobile","Realme","abcd","pic.jpg",5000,4,"medium");
		when(proRepository.save(product)).thenReturn(product);
		assertEquals(product,proService.addProduct(product));
	}
	
	@Test  
	  @Order(5)
	  @Rollback(value = false) 
	  public void deleteCartTest(){
	  
	  //Cart employee = cartRepo.findById((int) 1L).get();
	  
	  proRepository.deleteById(1);
	  
	  //employeeRepository.deleteById(1L);
	  
	  Product employee1 = null;
	  
	  Optional<Product> optionalEmployee = proRepository.findById(2);
	  
	  if(optionalEmployee.isPresent()){ employee1 = optionalEmployee.get(); }
	  
	  Assertions.assertThat(employee1).isNull(); }
	

}
