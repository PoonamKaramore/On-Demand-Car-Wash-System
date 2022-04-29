package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer,Integer>{
	
	public Washer findBywasherId(int id);

}
