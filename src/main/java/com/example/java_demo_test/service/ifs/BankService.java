package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;

public interface BankService {
	
	//新增帳號密碼
	public BankResponse addAccount(BankRequest bankRequest);
	

//	public void getAmount1(BankRequest bankRequest);
	public BankResponse getAmount(BankRequest bankRequest);

	public BankResponse deposit(BankRequest bankRequest);

	public BankResponse withdraw(BankRequest bankRequest);

	public BankResponse updatePassword(BankRequest BankUpdateRequest);
}
