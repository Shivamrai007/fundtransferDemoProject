package com.ft.fund.transfer.FundTransferDemo.dao;

import com.ft.fund.transfer.FundTransferDemo.model.Transaction;

public interface FundTransferDao {

	public int initiateFundTransfer(Transaction transaction);
}