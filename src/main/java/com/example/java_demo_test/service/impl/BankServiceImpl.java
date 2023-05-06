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
			// ���`�y�{
			// 1.��DB,�T�{��(�T�{�b��,�K�X)
			// �ثe�S��Ʈw,���y�����
			Bank bank = new Bank("ABC", "A123", 1000);
			// �����
			if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
//				BankResponse response = new BankResponse();
//				response.setAccount(bank.getAccount());
//				response.getAmount(bank.getAmount());
				// �W���T�浥��U���@��
//				BankResponse response = new BankResponse(bank.getAccount(),bank.getAmount());
				return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "���\");
			}
//			BankResponse response = new BankResponse();
//			return response;
//			return new BankResponse();
			// 2.�T�{����,�A�hDB���ӱb�����l�B
			return new BankResponse(bankRequest.getAccount(), null, "�b�����~�αK�X���~!");
		}

		@Override
		public BankResponse deposit(BankRequest bankRequest) {
			Bank bank = new Bank("ABC", "A123", 1000);
			if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
				bank.setAmount(bank.getAmount() + bankRequest.getDeposit());
				return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "���\");
			}
			return new BankResponse(bankRequest.getAccount(), null, "�b�����~�αK�X���~!");
		}

		@Override
		public BankResponse withdraw(BankRequest bankRequest) {
			Bank bank = new Bank("ABC", "A123", 1000);
			if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
				bank.setAmount(bank.getAmount() - bankRequest.getWithdraw());
				return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "���\");
			}
			return new BankResponse(bankRequest.getAccount(), null, "�b�����~�αK�X���~!");
		}

		@Override
		public BankResponse addAccount(BankRequest bankRequest) {
			String reqAccount = bankRequest.getAccount();
			if (StringUtils.hasText(reqAccount) || !StringUtils.hasText(reqAccount)) {
				return new BankResponse(reqAccount, "�b���αK�X���o����");
			}
			// �ˬd�b���ϧ_�w�s�b
			if (bankDao.existsById(reqAccount)) {
				return new BankResponse(reqAccount, "�b���w�s�b");
			}
			Bank bank = new Bank(reqAccount, bankRequest.getPwd());
			Bank result = bankDao.save(bank);
			if (StringUtils.hasText(result.getAccount())) {
				return new BankResponse(result.getAccount(), "�s�W�b�����\");
			}
			return new BankResponse(result.getAccount(), "�s�W�b������");
		}

		@Override
		public BankResponse updatePassword(BankRequest bankUpdateRequest) {
			// �ˬdrequest�����b��,�s�±K�X���ର��
			String reqAccount = bankUpdateRequest.getAccount();
			String reqOldPwd = bankUpdateRequest.getAccount();
			String reqNewPwd = bankUpdateRequest.getAccount();
			if (!StringUtils.hasText(reqAccount) || !StringUtils.hasText(reqOldPwd) || !StringUtils.hasText(reqNewPwd)) {
				return new BankResponse(reqAccount, "�b���αK�X���o����");
			}
			// �ھ�request �����b���hDB�������,�ݱb���O�_�s�b
			Optional<Bank> op = bankDao.findById(reqAccount);
			if (op.isPresent()) {// �P�_�� Optional �� Bank ����O�_�s�b(�]�t���P�_ Bank �O�_��null)
				return new BankResponse(reqAccount, "�b�����s�b");
			}
			// �NOptional����Bank���X;�e���OBank�s�b(�ϥ�.isPresent()�P�_)
			Bank bank = op.get();
			// �b���s�b,���ۤ��ӱb�����±K�X
			if (!reqOldPwd.equals(bank.getPwd())) {
				return new BankResponse(reqAccount, "�b���K�X���~");
			}
			// ��K�X
			bank.setPwd(reqNewPwd);
			// �N�a���s�K�X��bank�s�^��Ʈw
			bankDao.save(bank);
			return new BankResponse(reqAccount, "�ק�K�X���\");

//		@Override
//		public void deposit(Bank bank, int depositAmount) {
//			System.out.println("�b�� :" +bank.getAccount());
//			System.out.println("�l�B :" +bank.getAmount());
//			System.out.println("�s�ڪ��B :" +depositAmount);
//			bank.setAmount(bank.getAmount()+depositAmount);
//			System.out.println("�s�ګ�l�B :" +bank.getAmount());
//		}
	//
//		@Override        
//		public void withdraw(Bank bank, int withdrawAmount) {
//			System.out.println("�b�� :" + bank.getAccount());
//			System.out.println("�l�B :" + bank.getAmount());
//			System.out.println("���ڪ��B :" + withdrawAmount);
//			if(bank.getAmount()<withdrawAmount) {
//				System.out.println("�l�B����");
//			}else{
//				bank.setAmount(bank.getAmount()- withdrawAmount);
//			System.out.println("���ګ�l�B :" +bank.getAmount());
//		}		                                                                                                                                                          
//		}

		}
	}