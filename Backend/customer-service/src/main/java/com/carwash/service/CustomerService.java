package com.carwash.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.carwash.model.Customer;
import com.carwash.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	public CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id);
	}

	public String addCustomer(Customer customer) {
		Random random = new Random();
		customer.setId(random.nextInt(9999));	
		customerRepository.save(customer);
		return "Details added successfully";

	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	public Customer findByUsername(String username) throws Exception {
		Customer customer = customerRepository
                .findAll()
                .stream()
                .filter(a -> a.getCustomername().equalsIgnoreCase(username))
                .findAny().orElse(null);
		if (customer == null) {
			throw new Exception("Sorry, Customer with the provided Username not found" +
					",Please provide the correct Username");
		}
		else {
			return customerRepository.findByUsername(username);
		}
	}

}
	



























//public void addCardetail(CarDetails carDetails) {
//	customerRepository.save(carDetails);		
//}
//
//public CarDetails updateCardetail(CarDetails carDetails) {
//	return customerRepository.save(carDetails);
//}










