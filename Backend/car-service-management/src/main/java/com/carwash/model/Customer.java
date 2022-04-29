package com.carwash.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customerdetails")
public class Customer {
	
	@Id
	private int id;
	
	@Email(message = "Invalid Email Address")
	private String email;
	
	private String password;
	
	@NotBlank(message = "Name is Required")
	private String customername;
	
	private String address;
	  
	private String phoneNo;
	
	private boolean enabled=true;
	
	private String role;
	 
	
    //default constructor
	public Customer() {
		
	}

	//constructor
	public Customer(int id, @Email(message = "Invalid Email Address") String email, String password,
			@NotBlank(message = "Name is Required") String customername, String address, String phoneNo,
			boolean enabled, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.customername = customername;
		this.address = address;
		this.phoneNo = phoneNo;
		this.enabled = enabled;
		this.role = role;
	}

	//getters and setters
	public String getCustomername() {
		return customername;
	}	

	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	  
	public String getPhoneNo() {
		return phoneNo; 
     }
	
	public void setPhoneNo(String phoneNo) { 
		this.phoneNo = phoneNo; 
	}
	 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}


