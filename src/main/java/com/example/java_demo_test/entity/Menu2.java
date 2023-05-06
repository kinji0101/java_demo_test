package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu2")
public class Menu2 {

	@Id // 表示主鍵
	@Column(name = "mealname")
	private String mealname;

	@Column(name = "price")
	private int price;

	public Menu2() {

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

	public Menu2(String mealname, int price) {
		super();
		this.mealname = mealname;
		this.price = price;
	}

	public Menu2(String mealname) {
		super();
		this.mealname = mealname;
	}
	




	
	

}
