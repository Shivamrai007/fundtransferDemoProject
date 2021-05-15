package com.ft.fund.transfer.FundTransferDemo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft.fund.transfer.FundTransferDemo.dao.FundTransferDao;
import com.ft.fund.transfer.FundTransferDemo.model.Transaction;
import com.ft.fund.transfer.FundTransferDemo.service.FundTransferService;

/**
 * @author shivam.rai
 *
 */
@Service
@Transactional
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	FundTransferDao fundTransferDao;

	/**
	 *
	 */
	@Override
	public int initiateFundTransfer(Transaction transaction) {
		return fundTransferDao.initiateFundTransfer(transaction);
	}

}