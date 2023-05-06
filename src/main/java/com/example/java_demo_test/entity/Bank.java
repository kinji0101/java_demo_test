package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

	// @Column: �Ψӫ��wDB��������쪺�Ƚᤩ�� Entity Bank �� account ���ݩ�
	// name = "account" : "account" �O��Ʈw bank �o�i���� account �o�����

	@Id // ��ܥD��
	@Column(name = "account")
	private String account;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "amount")
	private int amount;

	public Bank() {
	}

	public Bank(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}

	public Bank(String account, int amount) {
		super();
		this.account = account;
		this.amount = amount;
	}

	public Bank(String account, String pwd, int amount) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
