package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.Menu2;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Menu2Request {

	private String mealname;

	private int price;

	@JsonProperty("Menu2_List")
	private List<Menu2> Menu2List;

	public Menu2Request() {

	}

	public List<Menu2> getMenu2List() {
		return Menu2List;
	}

	public void setMenu2List(List<Menu2> menu2List) {
		Menu2List = menu2List;
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

}
