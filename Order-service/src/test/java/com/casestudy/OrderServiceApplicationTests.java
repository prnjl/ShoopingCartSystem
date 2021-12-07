/*
 * package com.casestudy;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * import java.util.stream.Collectors; import java.util.stream.Stream;
 * 
 * import org.assertj.core.util.Arrays; import org.junit.jupiter.api.Test;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean;
 * 
 * import com.casestudy.model.Address; import com.casestudy.model.Orders; import
 * com.casestudy.model.Product; import
 * com.casestudy.repository.OrdersRepository; import
 * com.casestudy.service.OrderService;
 * 
 * @SpringBootTest class OrderServiceApplicationTests {
 * 
 * @Test void contextLoads() { }
 * 
 * @Autowired private OrderService orderService;
 * 
 * @MockBean private OrdersRepository orderRepo;
 * 
 * @Test public Orders getAllOrdersTest() {
 * when(orderRepo.findAll()).thenReturn(Stream.of ((T) new
 * Orders(1,"2021/07/25",123,234.22,"Paytm","Paid",2 ,Arrays.asList(new Product(
 * 2,"name"),Arrays.asList(new Address(1,"pankaj",
 * "345678","23","UP","2334411","UP" ))))) .collect(Collectors.toList()));
 * assertEquals(1,orderService.getAllOrders().size());
 * 
 * }
 * 
 * new
 * Orders(1,"2021-07-25",123,234.22,"Paytm","Paid",2,1,"Clothe",123,"pankaj",
 * "345678,23","varanasi",""2334411"))
 * 
 * .collect(Collectors.toList()));
 * //assertEquals(2,orderService.getAllOrders().size()); }
 * 
 * @Test public void addOrder() { Orders order = new Orders(1, "2021-07-25",
 * 123, 234212.0, "Paytm", "Paid", 2, 1, "Clothe", 123, "pankaj", "345678",
 * "23", "varanasi", "UP", "2334411");
 * when(orderRepo.save(order)).thenReturn(order); assertEquals(order,
 * orderService.addOrder(order)); } }
 */