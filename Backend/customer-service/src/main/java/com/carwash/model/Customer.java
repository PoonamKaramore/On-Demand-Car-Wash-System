package com.carwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customerdetails")
public class Customer {
	
	@Id
	private int id;
	private String username;
	private String email;	
	private String password;	
	private String customername;	
	private String address;	  
	private String phoneNo;	
	private boolean enabled=true;	
	private String role;
	 
	
    //default constructor
	public Customer() {
		
	}

	//constructor
	public Customer(int id, String username, String email, String password, String customername, String address,
			String phoneNo, boolean enabled, String role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.customername = customername;
		this.address = address;
		this.phoneNo = phoneNo;
		this.enabled = enabled;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	

}


