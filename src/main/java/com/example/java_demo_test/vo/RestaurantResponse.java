package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantResponse {
	
	@JsonProperty("restaurant")
	private Restaurant restaurant;
	
	
	@JsonProperty("restaurant_list")	
	private List<Restaurant> restaurantList;
	
	private String message;
	
	public  RestaurantResponse() {
		
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}



	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public RestaurantResponse(String message) {
		super();
		this.message = message;
	}

	public RestaurantResponse(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public RestaurantResponse(List<Restaurant> restaurantList, String message) {
		this.restaurantList = restaurantList;
		this.message = message;
	}
	
	

}
