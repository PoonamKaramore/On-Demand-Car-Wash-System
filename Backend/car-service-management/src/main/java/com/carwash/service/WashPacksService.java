package com.carwash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.WashPacks;
import com.carwash.repository.WashPacksRepository;

@Service
public class WashPacksService {
	
	@Autowired
	WashPacksRepository washpacksrepository;


	public String savepack(WashPacks pack) {			
		washpacksrepository.save(pack);
		return " Pack saved successfully with id :"+pack.getId();
	}


	public List<WashPacks> getpack() {
		
		return washpacksrepository.findAll();
	}

	public  WashPacks updatewashpack(WashPacks pack) {
		return washpacksrepository.save(pack);
		
	}
	
	public WashPacks getwashpackbyId(int id) {
		
		return washpacksrepository.findById(id);
	}
	
	public String deletewashpack(int id) {
				
		washpacksrepository.deleteById(id);
		return "pack deleted with id "+id;
	}

}
