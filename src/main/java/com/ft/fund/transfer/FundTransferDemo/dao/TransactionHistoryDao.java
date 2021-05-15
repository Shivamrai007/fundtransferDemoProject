package com.ft.fund.transfer.FundTransferDemo.dao;

import java.util.List;

import com.ft.fund.transfer.FundTransferDemo.model.Transaction;

public interface TransactionHistoryDao {

	public List<Transaction> getAllTransactionsByUserId(int userId);

}