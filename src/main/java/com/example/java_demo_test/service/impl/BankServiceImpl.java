package com.example.java_demo_test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.Active;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;


	@Service
	public class BankServiceImpl implements BankService {

		@Autowired
		private BankDao bankDao;

		@Override
		public BankResponse getAmount(BankRequest bankRequest) {
			// 正常流程
			// 1.撈DB,確認資(確認帳號,密碼)
			// 目前沒資料庫,先造假資料
			Bank bank = new Bank("ABC", "A123", 1000);
			// 比對資料
			if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
//				BankResponse response = new BankResponse();
//				response.setAccount(bank.getAccount());
//				response.getAmount(bank.getAmount());
				// 上面三行等於下面一行
//				BankResponse response = new BankResponse(bank.getAccount(),bank.getAmount());
				return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "成功");
			}
//			BankResponse response = new BankResponse();
//			return response;
//			return new BankResponse();
			// 2.確認完後,再去DB撈該帳號的餘額
			return new BankResponse(bankRequest.getAccount(), null, "帳號錯誤或密碼錯誤!");
		}

		@Override
		public BankResponse deposit(BankRequest bankRequest) {
			Bank bank = new Bank("ABC", "A123", 1000);
			if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
				bank.setAmount(bank.getAmount() + bankRequest.getDeposit());
				return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "成功");
			}
			return new BankResponse(bankRequest.getAccount(), null, "帳號錯誤或密碼錯誤!");
		}

		@Override
		public BankResponse withdraw(BankRequest bankRequest) {
			Bank bank = new Bank("ABC", "A123", 1000);
			if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
				bank.setAmount(bank.getAmount() - bankRequest.getWithdraw());
				return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "成功");
			}
			return new BankResponse(bankRequest.getAccount(), null, "帳號錯誤或密碼錯誤!");
		}

		@Override
		public BankResponse addAccount(BankRequest bankRequest) {
			String reqAccount = bankRequest.getAccount();
			if (StringUtils.hasText(reqAccount) || !StringUtils.hasText(reqAccount)) {
				return new BankResponse(reqAccount, "帳號或密碼不得為空");
			}
			// 檢查帳號使否已存在
			if (bankDao.existsById(reqAccount)) {
				return new BankResponse(reqAccount, "帳號已存在");
			}
			Bank bank = new Bank(reqAccount, bankRequest.getPwd());
			Bank result = bankDao.save(bank);
			if (StringUtils.hasText(result.getAccount())) {
				return new BankResponse(result.getAccount(), "新增帳號成功");
			}
			return new BankResponse(result.getAccount(), "新增帳號失敗");
		}

		@Override
		public BankResponse updatePassword(BankRequest bankUpdateRequest) {
			// 檢查request中的帳號,新舊密碼不能為空
			String reqAccount = bankUpdateRequest.getAccount();
			String reqOldPwd = bankUpdateRequest.getAccount();
			String reqNewPwd = bankUpdateRequest.getAccount();
			if (!StringUtils.hasText(reqAccount) || !StringUtils.hasText(reqOldPwd) || !StringUtils.hasText(reqNewPwd)) {
				return new BankResponse(reqAccount, "帳號或密碼不得為空");
			}
			// 根據request 中的帳號去DB撈取資料,看帳號是否存在
			Optional<Bank> op = bankDao.findById(reqAccount);
			if (op.isPresent()) {// 判斷中 Optional 的 Bank 物件是否存在(包含有判斷 Bank 是否為null)
				return new BankResponse(reqAccount, "帳號不存在");
			}
			// 將Optional中的Bank取出;前提是Bank存在(使用.isPresent()判斷)
			Bank bank = op.get();
			// 帳號存在,接著比對該帳號的舊密碼
			if (!reqOldPwd.equals(bank.getPwd())) {
				return new BankResponse(reqAccount, "帳號密碼錯誤");
			}
			// 改密碼
			bank.setPwd(reqNewPwd);
			// 將帶有新密碼的bank存回資料庫
			bankDao.save(bank);
			return new BankResponse(reqAccount, "修改密碼成功");

//		@Override
//		public void deposit(Bank bank, int depositAmount) {
//			System.out.println("帳號 :" +bank.getAccount());
//			System.out.println("餘額 :" +bank.getAmount());
//			System.out.println("存款金額 :" +depositAmount);
//			bank.setAmount(bank.getAmount()+depositAmount);
//			System.out.println("存款後餘額 :" +bank.getAmount());
//		}
	//
//		@Override        
//		public void withdraw(Bank bank, int withdrawAmount) {
//			System.out.println("帳號 :" + bank.getAccount());
//			System.out.println("餘額 :" + bank.getAmount());
//			System.out.println("提款金額 :" + withdrawAmount);
//			if(bank.getAmount()<withdrawAmount) {
//				System.out.println("餘額不足");
//			}else{
//				bank.setAmount(bank.getAmount()- withdrawAmount);
//			System.out.println("提款後餘額 :" +bank.getAmount());
//		}		                                                                                                                                                          
//		}

		}
	}