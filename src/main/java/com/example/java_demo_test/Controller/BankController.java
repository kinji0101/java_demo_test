package com.example.java_demo_test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;

@RestController
public class BankController {
	
	@Autowired
	private BankService bankservice;
	@PostMapping("/add_account")
	public BankResponse addAccount(@RequestBody BankRequest bankRequest) {
		return bankservice.addAccount(bankRequest);
	}
	
//	@PostMapping("/add_account")
//	public BankResponse addnewpwd(@RequestBody BankRequest bankRequest) {
//		return bankservice.addAccount(bankRequest);
//	}

	
//	@RequestMapping(value ="/get_amount",method = RequestMethod.POST)
	@PostMapping("/get_amount")
	public BankResponse getAmount(@RequestBody BankRequest bankRequest) {
//		Bank bank = new Bank("AAA",1000);
//		BankResponse response = bankservice.getAmount(bankRequest);
//		return response;
		return  bankservice.getAmount(bankRequest);
	}
	
	@PostMapping("/deposit_amount")
	public BankResponse deposit(@RequestBody BankRequest bankRequest) {
//		Bank bank = new Bank("AAA",1000);
//		BankResponse response = bankservice.getAmount(bankRequest);
//		return response;
		return  bankservice.deposit(bankRequest);
	}
	
	@PostMapping("/withdraw_amount")
	public BankResponse withdraw(@RequestBody BankRequest bankRequest) {
//		Bank bank = new Bank("AAA",1000);
//		BankResponse response = bankservice.getAmount(bankRequest);
//		return response;
		return  bankservice.withdraw(bankRequest);
	}

}
 