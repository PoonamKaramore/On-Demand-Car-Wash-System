package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.WashPacks;


@Repository
public interface WashPacksRepository extends MongoRepository<WashPacks, Integer> {
	
	public WashPacks findById(int id);

}


