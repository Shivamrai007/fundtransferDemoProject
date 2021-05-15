package com.ft.fund.transfer.FundTransferDemo.service.impl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft.fund.transfer.FundTransferDemo.controller.UserControllerImpl;
import com.ft.fund.transfer.FundTransferDemo.dao.AccountDao;
import com.ft.fund.transfer.FundTransferDemo.model.Account;
import com.ft.fund.transfer.FundTransferDemo.service.AccountService;


/**
 * @author shivam.rai
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	
	 private Logger logger = Logger.getLogger(AccountServiceImpl.class);

	/**
	 *
	 */
	public Account getAccountByUserId(int userId) {
		return accountDao.getAccountByUserId(userId);
	}

	/**
	 *
	 */
	@Override
	public boolean updateAccountBalanceByUserId(int userId, String balance) {
		
		Account account = getAccountByUserId(userId);
		account.setBalance(Double.parseDouble(balance));
		return accountDao.updateAccount(account);
	}
	
	public boolean updateAccountBalanceByAccountNumber(String accountNumber, String balance) {
		
		Account account = getAccountByAccountNumber(accountNumber);
		
		if (account == null) {
			 logger.info("Account Not Found with this Account Number");
		}
		
		account.setBalance(Double.parseDouble(balance));
		return accountDao.updateAccount(account);
	}
	
	public Account getAccountByAccountNumber(String accountNumber) {
		return accountDao.getAccountByAccountNumber(accountNumber);
	}

}