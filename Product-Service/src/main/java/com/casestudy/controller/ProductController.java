package com.casestudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Product;
import com.casestudy.service.ProductService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/product")

public class ProductController {

	//THIS IS FOR loose coupling 
		@Autowired
		ProductService productService;

		//for fetching all product
		
		@GetMapping("/getallProduct")
		public List<Product> getAllProducts() {
			return productService.getAllProducts();
		}
		
		//for getting product by id
		
		
		@GetMapping("/getProductById/{productId}")
		public Optional<Product> getProductById(@PathVariable ("productId" ) int productId){
			
			return productService.getProductById(productId);
		}
		
		//adding the product
		
		@PostMapping("/addProduct")
		public Product addProduct(@RequestBody Product product) {
			
			return productService.addProduct(product);
		}

		//for updating the product by id
		
		@PutMapping("/updateProduct/{productId}")
		public String updateProduct(@RequestBody Product product,@PathVariable int productId ) {
			return productService.updateProduct(product, productId);
		}
		
		//for deleting the product by id
		
		@DeleteMapping("/deleteProductById/{productId}")
		public String deleteByProductId(@RequestBody Product product,@PathVariable ("productId") int productId) {
			
			return productService.deleteByProductId(product, productId);
		}
		
		//getting the product by its name
		
		@GetMapping("/findAllProducts/{productName}")
		public List<Product> getProductByName(@PathVariable String productName) {
			
			return productService.getProductByName(productName);
		}

		
		//getting the product by its category
		
		  @GetMapping("/Category/{category}")
		  
		  public List<Product>   getProductByCategory(@PathVariable String category){
		  
		  return productService.getProductByCategory(category); 
		  
		  }
		  
		//getting the product by its type
		  
		  
		  @GetMapping("Type/{productType}")
		  public List<Product> getProductByType(@PathVariable String productType){
		  
		  return productService.getProductByType(productType);
		  }
		
		
			
}