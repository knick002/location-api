package com.nitin.locationapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LocationApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationApiApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("test contextloads");
	}

}
