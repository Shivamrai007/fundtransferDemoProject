package com.ft.fund.transfer.FundTransferDemo.service;

import com.ft.fund.transfer.FundTransferDemo.model.Account;

public interface AccountService {

	public Account getAccountByUserId(int userId);

	public boolean updateAccountBalanceByUserId(int userId, String balance);
	
	public boolean updateAccountBalanceByAccountNumber(String accountNumber, String balance);
	
	public Account getAccountByAccountNumber(String accountNumber);
}