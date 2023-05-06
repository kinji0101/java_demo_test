package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankResponse {

	private String account;

	private Integer amount;

	private String messege;

	private String deposit;

	private String withdraw;

	private String pwd;
	
	

	public BankResponse() {
	}

//	public BankResponse(String account, String pwd) {
//		super();
//		this.account = account;
//		this.pwd = pwd;
//	}

	public BankResponse(String account, String messege) {
//		super();
		this.account = account;
		this.messege = messege;
	}

	public BankResponse(String account, Integer amount, String messege, String deposit, String withdraw) {
		super();
		this.account = account;
		this.amount = amount;
		this.messege = messege;
		this.deposit = deposit;
		this.withdraw = withdraw;
	}

	public BankResponse(String account, Integer amount, String messege) {
		super();
		this.account = account;
		this.messege = messege;
		this.amount = amount;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMessege() {
		return messege;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

}
