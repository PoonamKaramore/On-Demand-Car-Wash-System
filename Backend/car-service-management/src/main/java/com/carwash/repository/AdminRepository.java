package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.model.AdminDetails;

public interface AdminRepository extends MongoRepository<AdminDetails,Integer>{
	
	public AdminDetails findById(int id);
	

}
