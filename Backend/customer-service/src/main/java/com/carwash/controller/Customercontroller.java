package com.carwash.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.model.AuthenticationRequest;
import com.carwash.model.AuthenticationResponse;
import com.carwash.model.Customer;
import com.carwash.model.Orders;
import com.carwash.model.RatingsAndReview;
import com.carwash.model.WashPacks;
import com.carwash.service.CustomerService;
import com.carwash.service.MyUserDetailsService;
import com.carwash.service.RatingsService;
import com.carwash.util.Globalresource;
import com.carwash.util.JwtUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class Customercontroller {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RatingsService ratingsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private RestTemplate restTemplate;
	
	//logger 
	private Logger logger = Globalresource.getLogger(Customercontroller.class);
	
	
	//to get the customer details
	 @GetMapping("/get-profile")
	    public ResponseEntity<List<Customer>> getAll() {
		 String methodName="(Get All Details Of Customer)";
	        logger.info(methodName+"Called");
	        try {
	            List<Customer> list = customerService.getAllCustomers();
	            return ResponseEntity.of(Optional.of(list));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	 
	// this is use to get the Order details of a particular id
	@GetMapping("/profile/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
		String methodName = "(Get Data  Of Order by id)";
		logger.info(methodName + "Called");

		try {
			Customer customer = customerService.getCustomerById(id);
			return ResponseEntity.of(Optional.of(customer));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	    
	 // to add customer details
	 @PostMapping("/add-profile")
	 public ResponseEntity<Customer> addCustomers(@RequestBody Customer customer) {
		 String methodName="(Add customer details Of Customer)";
	     logger.info(methodName+"Called");
	     
	     try {
	    	 customerService.addCustomer(customer);
	         return ResponseEntity.ok().body(customer);
	     } catch (Exception e) {
	    	 e.printStackTrace();
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }
	// to view ratings    
	    @GetMapping("/get-ratings")
	    public ResponseEntity<List<RatingsAndReview>> getAllRatings() {
	        try {
	            List<RatingsAndReview> list = ratingsService.getAllRatings();
	            return ResponseEntity.of(Optional.of(list));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	    
	 // to add ratings from end-user
	    @PostMapping("/add-ratings")
	    public ResponseEntity<RatingsAndReview> addRatings(@RequestBody RatingsAndReview ratings) {
	    	String methodName="(Get All Details Of Customer)";
	        logger.info(methodName+"Called");
	        try {
	            ratingsService.addRatings(ratings);
	            return ResponseEntity.ok().body(ratings);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	    
	    // to see all the available washpacks
	    @GetMapping("/getwashpacks")
		 public List<WashPacks> getpacks(){
	    	String methodName="(Get All wash-packs Details Of Customer)";
	        logger.info(methodName+"Called");
			 String baseurl="http://car-service-management/admin/allwashpacks";
			 WashPacks[] washPacks=restTemplate.getForObject(baseurl, WashPacks[].class);
			return Arrays.asList(washPacks);
		 }
	    
	    @PostMapping("/getorder")
		 public List<Orders> getallorders(){
	    	String methodName="(add-orders)";
	        logger.info(methodName+"Called");
			 String baseurl="http://order-service/order/add-order";
			 Orders[] order=restTemplate.getForObject(baseurl, Orders[].class);
			return Arrays.asList(order);
		 }
	    
	  //SECURITY REST APIS

		@PostMapping("/authenticate") // Authenticate a Customer (Existing)
		public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
				);
			}catch (BadCredentialsException e) {
				throw new Exception("Invalid Username or Password!",e);
			}
			UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
			String token = jwtUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticationResponse(token));
		}


		@GetMapping("/currentuser")
		public Object getCurrentUser(Authentication authentication){
			return authentication.getPrincipal();
		}

	    

}











//	    @PostMapping("/addCar/{id}")
//	    public ResponseEntity<CarDetails> addCardetail(@RequestBody CarDetails carDetails) {
//	        try {
//	            customerService.addCardetail(carDetails);
//	            return ResponseEntity.ok().body(carDetails);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	        }
//	    }
//	    
//	    @PutMapping("/updateCar/{id}")
//	    public ResponseEntity<CarDetails> updateCardetail(@RequestBody CarDetails carDetails) {
//	        try {
//	            customerService.updateCardetail(carDetails);
//	            return ResponseEntity.ok().body(carDetails);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	        }
//	    }
//}
	    
//	    
//	    @PostMapping("/addAddress/{id}")
//	    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
//	        try {
//	            customerService.addAddress(address);
//	            return ResponseEntity.ok().body(address);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	        }
//	    }
//	    
//	    @PutMapping("/updateAddress/{id}")
//	    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
//	        try {
//	            customerService.updateAddress(address);
//	            return ResponseEntity.ok().body(address);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	        }
//	    }


