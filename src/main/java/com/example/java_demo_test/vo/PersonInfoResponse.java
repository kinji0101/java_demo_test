package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfoResponse {

	@JsonProperty("person_info")
	private PersonInfo personInfo;

	@JsonProperty("person_info_list")
	private List<PersonInfo> personInfoList;

	private String message;

	public PersonInfoResponse() {

	}

	public PersonInfoResponse(List<PersonInfo> personInfoList, String message) {
		super();
		this.personInfoList = personInfoList;
		this.message = message;
	}

	public PersonInfoResponse(PersonInfo personInfo, String message) {
		super();
		this.personInfo = personInfo;
		this.message = message;
	}

	public PersonInfoResponse(String message) {
		super();
		this.message = message;
	}

	public PersonInfoResponse(PersonInfo personInfo) {
		super();
		this.personInfo = personInfo;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<PersonInfo> getPersonInfoList() {
		return personInfoList;
	}

	public void setPersonInfoList(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}

}
