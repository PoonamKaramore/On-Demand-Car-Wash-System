package com.carwash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.carwash.model.Washer;
import com.carwash.service.WasherService;

@SpringBootTest
class WasherServiceApplicationTests {

	WasherService washerService = mock(WasherService.class);
	
	@Test
	public void getAllCustomers() {
		when(washerService.getAllWasher()).thenReturn(Stream
				.of(new Washer(37, "poonamk@gmail.com","123","Poonam Karamore","9087675430","cross street , pune",true,"washer"),
						new Washer(95, "payalqre@gmail.com","abc","Payal Mundhada","9086543430","Yashwant nagar, mumnai",true,"washer")).collect(Collectors.toList()));
		assertEquals(2, washerService.getAllWasher().size());
	}
	
	@Test
	void updateWasher() {
		Washer washer = new Washer(1, "riya65@gmail.com", "abc","Riya karwa","9870923789","Manish Nagar, mumbai",true, "washer");
		when(washerService.updateWasher(washer)).thenReturn(washer);
		assertEquals(washer, washerService.updateWasher(washer));
		
	}
	
}
