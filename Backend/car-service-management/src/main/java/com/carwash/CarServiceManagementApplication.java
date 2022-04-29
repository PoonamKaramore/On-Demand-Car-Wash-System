package com.carwash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableEurekaClient
@SpringBootApplication
public class CarServiceManagementApplication {
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CarServiceManagementApplication.class, args);
	}

	
}	
	
	
	
	













	
	
	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Starting code");
//		
//		AdminDetails admin = new AdminDetails();
//		
//		admin.setId(1000);
//		admin.setName("Poonam Karamore");
//		admin.setEmail("Poonamk@gmail.com");
//		admin.setPassword("Poonam@123");
//		admin.setPhone("9968401230");
//		admin.setProfile("default.png");
//		
//		Role role = new Role();
//		
//		role.setRoleId(12L);
//		role.setRole("ADMIN");
		
	


