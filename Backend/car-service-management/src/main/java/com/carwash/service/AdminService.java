package com.carwash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.AdminDetails;
import com.carwash.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	public AdminRepository  adminRepository;
	
	public List<AdminDetails> getdetail() {
		return adminRepository.findAll();
	}



}
