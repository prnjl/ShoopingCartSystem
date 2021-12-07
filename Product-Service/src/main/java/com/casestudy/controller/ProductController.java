package com.casestudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Product;
import com.casestudy.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	//THIS IS FOR loose coupling 
		@Autowired
		ProductService productService;

		@GetMapping("/getallProduct")
		public List<Product> getAllProducts() {
			return productService.getAllProducts();
		}
		@GetMapping("/getProductById/{productId}")
		public Optional<Product> getProductById(@PathVariable int productId){
			
			return productService.getProductById(productId);
		}
		@PostMapping("/addProduct")
		public Product addProduct(@RequestBody Product product) {
			
			return productService.addProduct(product);
		}
		
		@PutMapping("/updateProduct/{productId}")
		public String updateProduct(@RequestBody Product product,@PathVariable int productId ) {
			return productService.updateProduct(product, productId);
		}
		
		
		@DeleteMapping("/deleteProductById/{productId}")
		public String deleteByProductId(@RequestBody Product product,@PathVariable ("productId") int productId) {
			
			return productService.deleteByProductId(product, productId);
		}
		
		@GetMapping("/findProductbyname/{productName}")
		public List<Product> getProductByName(@PathVariable String productName) {
			
			return productService.getProductByName(productName);
		}
		
		@GetMapping("/Category/{category}")
		public List<Product>getProductByCategory(@PathVariable String category){
		  
		  return productService.getProductByCategory(category); 
		  }
		  
		  @GetMapping("Type/{productType}")
		  public List<Product> getProductByType(String productType){
		  
		  return productService.getProductByType(productType); 
		  }
		
			
}