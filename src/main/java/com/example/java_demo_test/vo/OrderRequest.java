package com.example.java_demo_test.vo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {
	
	@JsonProperty("order_menu")
	private Map<String,Integer>orderMap;

	public Map<String, Integer> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, Integer> orderMap) {
		this.orderMap = orderMap;
	}
	

}
