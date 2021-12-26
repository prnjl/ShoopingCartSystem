package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.casestudy.exception.EmptyInputException;
import com.casestudy.exception.ProductNotFoundException;
import com.casestudy.model.Product;
import com.casestudy.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> product= productRepository.findAll();
		if(product.isEmpty()) {
			throw new EmptyInputException("222","Product Not Found!");
		}else
		{
			return product;
			
		}
	}

	@Override
	public Optional<Product> getProductById(int productId) {
		Optional<Product> findByid =productRepository.findById(productId);
		if(findByid.isEmpty()){
			throw new ProductNotFoundException("222","Product Not Found!");
		}else
		{
			return productRepository.findById(productId);
			
		}
	}

	@Override
	public Product addProduct(Product product) {
		if(product.getProductName().isBlank() || product.getProductName().length()==0) {
			throw new EmptyInputException("786","value can not be null");
		}
		else
			return productRepository.save(product);
	}

	@Override
	public String updateProduct(Product product, int productId) {
		boolean isProductExist= productRepository.existsById(productId);
		if(isProductExist) {
		    productRepository.save(product);
		    return "Product updated"+productId;
		}
		else {
			throw new ProductNotFoundException("234" ,"Product Not Found");
		}
	}

	@Override
	public String deleteByProductId(Product product,  int productId) {
		
		boolean isProductExist= productRepository.existsById(productId);
		if(isProductExist) {
		    productRepository.deleteById(productId);
		    return "Product deleted"+productId;
		}
		else {
			throw new ProductNotFoundException("647" ,"Product Not Found");
		}
	}
	
	
	@Override
	public List<Product> getProductByName(String productName) {
		
		List<Product> name= productRepository.findByProductName(productName);
		if(name.isEmpty()) {
			throw new ProductNotFoundException("987", "not Found !!");
		}
		else {
           return name;
		}
}
	@Override
	public List<Product> getProductByCategory(String category){
		
		List<Product> catagory= productRepository.findByCategory(category);
		
		if(catagory.isEmpty()) {
			throw new ProductNotFoundException("425", "cateory is not found");
		}
		else {
			return catagory;
		}
	}
	
	
	@Override
	public List<Product> getProductByType(String productType){
		
		List<Product> type= productRepository.findByProductType(productType);
		if(type.isEmpty()) {
			throw new ProductNotFoundException("425", "type is not found");
		}
		else {
			return type;
		}
	}
	
	@Override
	public Product deleteByProductName(String productName) {
		
		return productRepository.deleteByProductName(productName);
	}
	
	
	
}