package com.carwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Order")
public class Orders {
	
	@Id
	private int orderId;
	private String customername;
	private String address;
	private String phoneNo;
	private String carname;
	private String carnumber;
	private String washpack; 
	private String date;
	private String time;
	private double totalamount;
	
	//default constructor
	public Orders() {
		
	}
	// constructor
	public Orders(int orderId, String customername, String address, String phoneNo, String carname, String carnumber,
			String washpack, String date, String time, double totalamount) {
		super();
		this.orderId = orderId;
		this.customername = customername;
		this.address = address;
		this.phoneNo = phoneNo;
		this.carname = carname;
		this.carnumber = carnumber;
		this.washpack = washpack;
		this.date = date;
		this.time = time;
		this.setTotalamount(totalamount);
	}
	
    //getters and setters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getWashpack() {
		return washpack;
	}
	public void setWashpack(String washpack) {
		this.washpack = washpack;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	
	
	

}
