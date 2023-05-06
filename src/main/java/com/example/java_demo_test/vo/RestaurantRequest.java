package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestaurantRequest {
	
	@JsonProperty("restaurant")
	private Restaurant restaurant;
	
	@JsonProperty("restaurant_list")
	private List<Restaurant> restaurantList;
	
	private String id;
	
	private String city;
	
	private int star;
	
	public RestaurantRequest() {
		
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	
	

}
