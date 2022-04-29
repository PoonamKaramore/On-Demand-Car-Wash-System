package com.carwash.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.logger.GlobalResource;
import com.carwash.model.Orders;
import com.carwash.service.OrderService;



@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class Ordercontroller {
	
	@Autowired
	private OrderService orderService;
	


	//logger 
		private Logger logger = GlobalResource.getLogger(Ordercontroller.class);
		
	
	//washer can view all the orders placed by the end-user
		 @GetMapping("/get-orders")
		    public ResponseEntity<List<Orders>> getAll() {
			 String methodName="(Get All the order Details Of Customer)";
		        logger.info(methodName+"Called");
		        try {
		            List<Orders> list = orderService.getAllOrders();
		            return ResponseEntity.of(Optional.of(list));
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		        }
		    }
		 
		// this is use to get the Order details of a particular id
			@GetMapping("/orderid/{id}")
			public ResponseEntity<Orders> getOrderById(@PathVariable("id") int id) {
				String methodName = "(Get Data  Of Order by id)";
				logger.info(methodName + "Called");

				try {
					Orders order = orderService.getOrdersByorderId(id);
					return ResponseEntity.of(Optional.of(order));
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}

			}
			// this is used to reject the order
			@DeleteMapping("/reject/{id}")
			public ResponseEntity<Orders> deleteOrder(@PathVariable("id") int id) {
				String methodName="(delete order )";
		        logger.info(methodName+"Called");
		        try {
				  orderService.deleteorder(id);
				  return new ResponseEntity<Orders>(HttpStatus.OK);
		        }catch(Exception e) {
		        	e.printStackTrace();
		        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		        }
				
			}
		    
		 // to place an order by the end-users 
		    @PostMapping("/add-order")
		    public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
		    	String methodName="(Add order details )";
		        logger.info(methodName+"Called");
		        try {
		        	orderService.addOrder(order);
		            return ResponseEntity.ok().body(order);
		        } catch (Exception e) {
		            e.printStackTrace();
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		        }
		    }
		    
		    

}
