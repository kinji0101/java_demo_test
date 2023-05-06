package com.example.java_demo_test.vo;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu2;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu2Response {


	public String mealname;

	private int price;

	private String messege;
	
	@JsonProperty("Menu2_list")
	private List<Menu2> Menu2List;
	
	@JsonProperty("order_menu")
	private Map<String,Integer> orderMap;
	
	@JsonProperty("original_Total_Price")
	private int originalTotalPrice;
	
	@JsonProperty("Total_Price")
	private int totalPrice;

	public Menu2Response() {

	}
	

	public Menu2Response(Map<String, Integer> orderMap, int originalTotalPrice, int totalPrice) {
		super();
		this.orderMap = orderMap;
		this.originalTotalPrice = originalTotalPrice;
		this.totalPrice = totalPrice;
	}


	public Menu2Response(Map<String, Integer> orderMap, int totalPrice) {
		super();
		this.orderMap = orderMap;
		this.totalPrice = totalPrice;
	}


	public Map<String, Integer> getOrderMap() {
		return orderMap;
	}


	public void setOrderMap(Map<String, Integer> orderMap) {
		this.orderMap = orderMap;
	}


	public int getOriginalTotalPrice() {
		return originalTotalPrice;
	}


	public void setOriginalTotalPrice(int originalTotalPrice) {
		this.originalTotalPrice = originalTotalPrice;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getMealname() {
		return mealname;
	}

	public void setMealname(String mealname) {
		this.mealname = mealname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public List<Menu2> getMenu2List() {
		return Menu2List;
	}

	public void setMenu2List(List<Menu2> menu2List) {
		Menu2List = menu2List;
	}

	public Menu2Response(String mealname, int price, String messege) {
		super();
		this.mealname = mealname;
		this.price = price;
		this.messege = messege;
	}

	public Menu2Response(String mealname, int price) {
		super();
		this.mealname = mealname;
		this.price = price;
	}

	public Menu2Response(String messege) {
		super();
		this.messege = messege;
	}

	public Menu2Response(String mealname, String messege) {
		super();
		this.mealname = mealname;
		this.messege = messege;
	}

	public Menu2Response(List<Menu2> menu2List,String messege) {
		super();
		this.messege = messege;
		Menu2List = menu2List;
	}
	

}
