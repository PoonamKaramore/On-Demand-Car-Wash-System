package com.carwash.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washerdetails")
public class Washer {
	
	@Id
	private int washerId;
	
	@Email(message = "Invalid Email Address")
	private String email;
	
	private String password;
	
	@NotBlank(message = "Name is Required")
	private String name;
	  
	private String phoneNo;
	
	//default constructor
	public Washer() {
		
	}

	//constructor
	public Washer(int washerId, String email, String password, String name, String phoneNo) {
		super();
		this.washerId = washerId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public int getWasherId() {
		return washerId;
	}

	public void setWasherId(int washerId) {
		this.washerId = washerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

	
}
