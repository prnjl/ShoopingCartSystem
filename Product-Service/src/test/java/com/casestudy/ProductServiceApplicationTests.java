package com.casestudy;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.model.Product;
import com.casestudy.repository.ProductRepository;


//@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {

	/*
	 * @Autowired private ProductService proService;
	 */

   @Autowired
	private ProductRepository proRepository;

	/*
	 * @Test public void getAllProductTest() {
	 * when(proRepository.findAll()).thenReturn(Stream.of (new
	 * Product(4,"fridge","samsung","cool","pic.jpg",51000.0,4,"medium"),new
	 * Product(2,"smartphone","motorola","abcd","pic.jpg",2000.0,4,"screentouch"))
	 * .collect(Collectors.toList()));
	 * assertEquals(2,proService.getAllProducts().size()); }
	 * 
	 * @Test public void addProduct() throws EmptyInputException { Product product =
	 * new Product(2,"bulb","Havells","HavellsIndiaLtd","pic.jpg",500.0,4,"medium");
	 * when(proRepository.save(product)).thenReturn(product);
	 * assertEquals(product,proService.addProduct(product)); }
	 * 
	 * @Test public void deleteByProductId() throws EmptyInputException {
	 * 
	 * Product product = new
	 * Product(5,"Clock","Titan","abcd","cat.jpg",4000.0,5,"good");
	 * proService.deleteByProductId(product, 5);
	 * verify(proRepository,times(1)).delete(product); }
	 * 
	 * @Test public void updateProduct() throws EmptyInputException { Product
	 * product = new
	 * Product(4,"Philips","PhilipsIndiaLtd","","bulb.jpg",200.0,0,"good");
	 * proService.updateProduct(product, 4);
	 * verify(proRepository,times(1)).save(product); }
	 * 
	 * @Test public void deleteByProductIdTest() throws EmptyInputException { String
	 * test = proService.deleteByProductId(null, 4);
	 * assertEquals("Id deleted ",test); Product product = new
	 * Product(4,"Toy","Ship","Toys","doc.jpd",2000.0,0,"good");
	 * proRepository.save(product); }
	 * 
	 * 
	 * 
	 * 
	 * @Test public void getProductByIdTest() { // // int productId = 2; //
	 * when(proRepository.findById(productId)) // .thenReturn(Optional.of(Stream.of
	 * (new // Product(2,"Mobile","Realme","abcd","pic.jpg",5000.0,4,"medium"),new
	 * // Product(6,"Laptop","HP","abcd","pic.jpg",5000.0,4,"medium")) //
	 * collect(Collectors.toList()))); } //
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test public void addProductTest() { Product pd =new Product();
	 * pd.setProductId(2); pd.setProductType("Mobile"); pd.setProductName("Realme");
	 * pd.setCategory("abcd"); pd.setImage("pic.jpg"); pd.setPrice(null);
	 * pd.setRating(4); pd.setDescription("Medium"); proRepository.save(pd);
	 * assertNotNull(proRepository.findById(2).get()); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test public void getProductBynameTest() { String productName ="Realme";
	 * when(proRepository.findByProductName(productName)).thenReturn(Stream.of( new
	 * Product(2,"Mobile","Realme","abcd","pic.jpg",5000,4,"medium")).
	 * collect(Collectors.toList())); } / / public void getProductByCategoryTest() {
	 * String category ="abcd";
	 * when(proRepository.findByProductName(category)).thenReturn(Stream.of( new
	 * Product(2,"Mobile","Realme","abcd","pic.jpg",5000,4,"medium")).
	 * collect(Collectors.toList())); }
	 * 
	 * public void getProductByTypeTest() { String type="Mobile";
	 * when(proRepository.findByProductName(type)).thenReturn(Stream.of( new
	 * Product(2,"Mobile","Realme","abcd","pic.jpg",5000,4,"medium")).
	 * collect(Collectors.toList())); }
	 * 
	 * 
	 * 
	 * @Test public void deleteByProductIdTest() { Product product=new
	 * Product(2,"Mobile","Realme","abcd","pic.jpg",5000,4,"medium");
	 * proService.deleteByProductId(product,2);
	 * verify(proRepository,times(1)).delete(product); }
	 * 
	 * @Test public void updateByProductIdTest() { Product product = new
	 * Product(2,"Mobile","Realme","abcd","pic.jpg",5000,4,"medium");
	 * proService.updateProduct(product, 2); verify(proRepository,times(1)); }
	 * 
	 */
	@Test
	public void testupdate() {
		Product p = proRepository.findById(2).get();
		p.setPrice(300.00);
		proRepository.save(p);
		assertNotEquals(600.00,proRepository.findById(2).get().getPrice());

		}

	@Test
	public void testCreate() {
		Product p = new Product();
		p.setProductId(2);
		p.setProductType("gadgets");
		p.setProductName("iphone");
		p.setCategory("Electronics");
		p.setImage("img.jpg");
		p.setPrice(500.00);
		p.setDescription("good");
		p.setRating(5);
		proRepository.save(p);
		assertNotNull(proRepository.findById(2).get());
	}
	@Test
	public void testDelete() {
		proRepository.deleteById(1);
	assertThat(proRepository.existsById(1)).isFalse();
	}
	@Test
	public void testReadAll() {
	List<Product> list = proRepository.findAll();
	assertThat(list).size().isGreaterThan(0);
	}
	
}