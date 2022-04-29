package com.carwash.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.model.Orders;
import com.carwash.model.RatingsAndReview;
import com.carwash.model.Washer;
import com.carwash.service.WasherService;
import com.carwash.util.Globalresource;

@CrossOrigin("*")
@RestController
@RequestMapping("/washer")
public class Washercontroller {
	
	     @Autowired
	     private WasherService washerService;
	     
	     @Autowired
	 	 private RestTemplate restTemplate;
	
	     //logger 
	     private Logger logger = Globalresource.getLogger(Washercontroller.class);

	
	//to get the washer details
		 @GetMapping("/get-profile")
		    public ResponseEntity<List<Washer>> getAllWasher() {
			 String methodName="(Get washer Details )";
		        logger.info(methodName+"Called");
		        try {
		            List<Washer> list = washerService.getAllWasher();
		            return ResponseEntity.of(Optional.of(list));
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		        }
		    }
		    
		 // to add washer details
		    @PostMapping("/add-profile")
		    public ResponseEntity<Washer> addWasher(@RequestBody Washer washer) {
		    	String methodName="(add washer Details )";
		        logger.info(methodName+"Called");
		        try {
		        	washerService.addWasher(washer);
		            return ResponseEntity.ok().body(washer);
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		        }
		    }
	        
		    // To update Washer details
		    @PutMapping("/update-profile/{id}")
		    public ResponseEntity<Washer> updateWasher(@RequestBody Washer washer, @PathVariable("id") int id) {
		    	String methodName="(update washer Details )";
		        logger.info(methodName+"Called");
		        try {
		        	Washer washer1 = washerService.updateWasher(washer);
		            return ResponseEntity.ok().body(washer1);
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		        }
		    }
		    // washer will receive wash requests from customer
		    @GetMapping("/getallorders")
			 public List<Orders> getallorders(){
		    	String methodName="(Get All orders from customer)";
		        logger.info(methodName+"Called");
				 String baseurl="http://localhost:8086/order/get-orders";
				 Orders[] orders=restTemplate.getForObject(baseurl, Orders[].class);
				return Arrays.asList(orders);
			 }
		    
			//customer can add rating and washer can view the ratings recieved from customer			
		    @GetMapping("/getratings")
			 public List<RatingsAndReview> getratings(){
		    	String methodName="(Get All ratings Details )";
		        logger.info(methodName+"Called");
				 String baseurl1="http://localhost:8083/customer/get-ratings";
				 RatingsAndReview[] ratings=restTemplate.getForObject(baseurl1, RatingsAndReview[].class);
				return Arrays.asList(ratings);
			 }
	

}
