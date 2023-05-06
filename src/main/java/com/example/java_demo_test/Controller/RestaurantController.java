package com.example.java_demo_test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.service.ifs.RestaurantService;
import com.example.java_demo_test.vo.RestaurantRequest;
import com.example.java_demo_test.vo.RestaurantResponse;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService service;
	
	@PostMapping("/add_Restaurant")
	private RestaurantResponse addRestaurant(@RequestBody RestaurantRequest request) {
		return service.addRestaurant(request);
	}

}
