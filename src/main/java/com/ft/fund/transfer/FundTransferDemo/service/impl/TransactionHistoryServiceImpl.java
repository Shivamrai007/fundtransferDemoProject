package com.ft.fund.transfer.FundTransferDemo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft.fund.transfer.FundTransferDemo.dao.TransactionHistoryDao;
import com.ft.fund.transfer.FundTransferDemo.model.Transaction;
import com.ft.fund.transfer.FundTransferDemo.service.TransactionHistoryService;

/**
 * @author shivam.rai
 *
 */
@Service
@Transactional
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

	@Autowired
	TransactionHistoryDao transactionHistoryDao;

	/**
	 *
	 */
	public List<Transaction> getAllTransactionsByUserId(int userId) {
		return transactionHistoryDao.getAllTransactionsByUserId(userId);
	}
}