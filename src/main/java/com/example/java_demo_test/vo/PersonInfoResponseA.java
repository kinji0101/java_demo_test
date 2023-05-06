package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfoResponseA {

	private String id;

	private String name;

	private int age;

	private String message;

	public PersonInfoResponseA() {

	}

	public PersonInfoResponseA(String id) {
		super();
		this.id = id;
	}

	public PersonInfoResponseA(String id, String name, int age, String message) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
