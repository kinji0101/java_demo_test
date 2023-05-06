package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankUpdateRequest {
	
	@JsonProperty("old_password")
	private String oldPwd;
	
	@JsonProperty("new_password")
	private String newPwd;
	
	private String account;
	
	public BankUpdateRequest() {
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	




}
