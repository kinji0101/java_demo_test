package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.Restaurant;
import com.example.java_demo_test.vo.RestaurantRequest;
import com.example.java_demo_test.vo.RestaurantResponse;

public interface RestaurantService {
	
	public RestaurantResponse addRestaurant(RestaurantRequest request);
	
	public List<Restaurant> getRestaurant();
	 
	public RestaurantResponse getRestaurantById(String id);

	
//	public List<Restaurant> getRestaurantByCity(String city);
//	
//	public List<Restaurant> getRestaurantByStar(int star);

	

}
