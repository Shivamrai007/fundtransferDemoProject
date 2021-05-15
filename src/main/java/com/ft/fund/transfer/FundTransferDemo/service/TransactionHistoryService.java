package com.ft.fund.transfer.FundTransferDemo.service;

import java.util.List;

import com.ft.fund.transfer.FundTransferDemo.model.Transaction;

public interface TransactionHistoryService {

	public List<Transaction> getAllTransactionsByUserId(int userId);

}