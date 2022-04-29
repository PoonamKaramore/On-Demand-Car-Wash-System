package com.carwash.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.Orders;
import com.carwash.repository.OrdersRepository;



@Service
public class OrderService {
	
	@Autowired
	public OrdersRepository ordersRepository;
	
	public List<Orders> getAllOrders(){
		return ordersRepository.findAll(); 
	}
	
	public Orders getOrdersByorderId(int id) {
		return ordersRepository.findByOrderId(id);
	}
	
	public String deleteorder(int id) {
		
		ordersRepository.deleteById(id);
		return "pack deleted with id "+id;
	}
	
	public String addOrder(Orders order) {
		Random random = new Random();
		order.setOrderId(random.nextInt(9999));
		ordersRepository.save(order);
		return "Order placed";
	}
	

}
