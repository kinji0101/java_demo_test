package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonInfoRequest {

	@JsonProperty("person_info")
	private PersonInfo personInfo;

	@JsonProperty("person_info_list")
	private List<PersonInfo> personInfoList;

	private String id;

	private int age;
	
	private int age2;

	private String city;

	public PersonInfoRequest() {

	}
	
	

	public int getAge2() {
		return age2;
	}



	public void setAge2(int age2) {
		this.age2 = age2;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PersonInfoRequest(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public List<PersonInfo> getPersonInfoList() {
		return personInfoList;
	}

	public void setPersonInfoList(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}
}
