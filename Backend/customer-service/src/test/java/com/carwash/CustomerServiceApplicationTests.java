package com.carwash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.carwash.model.Customer;
import com.carwash.repository.CustomerRepository;
import com.carwash.service.CustomerService;

@SpringBootTest
class CustomerServiceApplicationTests {

	CustomerService customerService = mock(CustomerService.class);
	
	@Test
	public void getAllCustomers() {
		when(customerService.getAllCustomers()).thenReturn(Stream
				.of(new Customer(37,"poonam21", "poonamk@gmail.com","123","Poonam Karamore","ram nagar ,pune","9087675430",true,"customer"),
						new Customer(95,"payalm21", "payalqre@gmail.com","abc","Payal Mundhada","bajaj nagar ,mumbai","9086543430",true,"customer")).collect(Collectors.toList()));
		assertEquals(2, customerService.getAllCustomers().size());
	}
	
	@Test
	void updateCustomer() {
		Customer customer = new Customer(1,"riyak", "riya65@gmail.com", "abc","Riya karwa", "Suman nagar,pune","9870923789",false, "customer");
		when(customerService.updateCustomer(customer)).thenReturn(customer);
		assertEquals(customer, customerService.updateCustomer(customer));
		
	}



}




























//@Test
//public void addCustomer() {
//	Customer customer = new Customer(37,"rajat12", "rajats@gmail.com","ab12","Rajat Singh","pune","9087675430",true,"customer");
//	when(customerService.addCustomer(customer)).thenReturn(customer);
//	assertEquals(customer, customerService.addCustomer(customer));
//}
