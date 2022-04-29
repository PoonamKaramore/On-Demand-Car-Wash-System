package com.carwash.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.model.AdminDetails;
import com.carwash.model.Customer;
import com.carwash.model.WashPacks;
import com.carwash.model.Washer;
import com.carwash.service.AdminService;
import com.carwash.service.WashPacksService;
import com.carwash.util.Globalresource;



@CrossOrigin("*")
@RestController
@RequestMapping(path="/admin")
public class CarServicecontroller {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private WashPacksService washpacksservice;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//logger 
	private Logger logger = Globalresource.getLogger(CarServicecontroller.class);

	// this is use to get the admin details
	 @GetMapping("/get-profile")
	    public ResponseEntity<List<AdminDetails>> getdetail() {
		 String methodName="(Get All Details Of Admin)";
	        logger.info(methodName+"Called");
	        try {
	            List<AdminDetails> list = adminService.getdetail();
	            return ResponseEntity.of(Optional.of(list));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
		
	//to view all the washpack
	 @GetMapping("/allwashpacks")
	 public ResponseEntity<List<WashPacks>> getpack() {
		 String methodName="(Get All washpacks Details )";
	        logger.info(methodName+"Called");
	        try {
	            List<WashPacks> list = washpacksservice.getpack();
	            return ResponseEntity.of(Optional.of(list));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	 // get single washpack
	 @GetMapping("/getwashpack/{id}")
	 public ResponseEntity<WashPacks> getwashpackbyId(@PathVariable("id") int id) {
		 String methodName="(Get All washpacks Details by id )";
	        logger.info(methodName+"Called");
	        try {
	  		  return new ResponseEntity<WashPacks>(washpacksservice.getwashpackbyId(id),HttpStatus.OK);
	          }catch(Exception e) {
	          	e.printStackTrace();
	          	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	          }
	  		
	    }
	 
	//to add washpack
	 @PostMapping("/addwashpacks")
	    public ResponseEntity<WashPacks> savepack(@RequestBody WashPacks pack) {
		 String methodName="(add washpack)";
	        logger.info(methodName+"Called");
	        try {
	        	washpacksservice.savepack(pack);
	            return ResponseEntity.ok().body(pack);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    } 
	// to edit the existing washpack
	@PutMapping("/update-pack")
    public ResponseEntity<WashPacks> updatewashpack(@RequestBody WashPacks pack) {
		String methodName="(update washpack Details )";
        logger.info(methodName+"Called");
        try {
            return ResponseEntity.ok().body(this.washpacksservice.updatewashpack(pack));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	//to delete the washpack	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<WashPacks> deletewashpack(@PathVariable("id") int id) {
		String methodName="(delete washpack by id)";
        logger.info(methodName+"Called");
        try {
		  washpacksservice.deletewashpack(id);
		  return new ResponseEntity<WashPacks>(HttpStatus.OK);
        }catch(Exception e) {
        	e.printStackTrace();
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
		
	}
    
	// to get all the customer details
    @GetMapping("/getcustomers")
	 public List<Customer> getcustomer(){
    	String methodName="(Get All customer Details )";
        logger.info(methodName+"Called");
    
		 String baseurl="http://customer-service/customer/get-profile";
		 Customer[] customer=restTemplate.getForObject(baseurl, Customer[].class);
		return Arrays.asList(customer);
    }
	 
    // to get all the washer details
    @GetMapping("/getwashers")
	 public List<Washer> getwasher(){
   	String methodName="(Get All washers Details)";
       logger.info(methodName+"Called");
		 String baseurl="http://localhost:8085/washer/get-profile";
		 Washer[] washer=restTemplate.getForObject(baseurl, Washer[].class);
		return Arrays.asList(washer);
	 }
    		
}	
		