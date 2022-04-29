package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.Orders;

@Repository
public interface OrdersRepository extends MongoRepository<Orders,Integer> {
	
	public Orders findByOrderId(int id);

}
