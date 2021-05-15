package com.ft.fund.transfer.FundTransferDemo.dao;

import com.ft.fund.transfer.FundTransferDemo.model.Account;

public interface AccountDao {

	public Account getAccountByUserId(int userId);

	public boolean updateAccount(Account account);
	
	public Account getAccountByAccountNumber(String accountNumber);
	
}