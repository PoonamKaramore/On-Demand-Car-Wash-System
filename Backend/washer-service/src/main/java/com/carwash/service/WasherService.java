package com.carwash.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carwash.model.Washer;
import com.carwash.repository.WasherRepository;


@Service
public class WasherService {
	
	@Autowired
	public WasherRepository washerRepository;
	
	public List<Washer> getAllWasher() {
		return washerRepository.findAll();
	}

	public String addWasher(Washer washer) {
		Random random = new Random();
		washer.setWasherId(random.nextInt(9999));
		washerRepository.save(washer);
		return "Details added successfully";

	}
	
	public Washer updateWasher(Washer washer) {
		return washerRepository.save(washer);
		
	}

}
