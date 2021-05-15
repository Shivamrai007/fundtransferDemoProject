package com.ft.fund.transfer.FundTransferDemo.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ft.fund.transfer.FundTransferDemo.dao.FundTransferDao;
import com.ft.fund.transfer.FundTransferDemo.model.Transaction;

/**
 * @author shivam.rai
 *
 */
@Repository
public class FundTransferDaoImpl implements FundTransferDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 *
	 */
	@Override
	public int initiateFundTransfer(Transaction transaction) {
		 sessionFactory.openSession().save(transaction);
		 return 1;
	}

}