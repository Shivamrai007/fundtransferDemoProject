package com.ft.fund.transfer.FundTransferDemo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ft.fund.transfer.FundTransferDemo.dao.TransactionHistoryDao;
import com.ft.fund.transfer.FundTransferDemo.model.Transaction;

/**
 * @author shivam.rai
 *
 */
@Repository
public class TransactionHistoryDaoImpl implements TransactionHistoryDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 *
	 */
	public List<Transaction> getAllTransactionsByUserId(int userId) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Transaction WHERE userId=:userId");
		query.setParameter("userId", userId + "");
		List<Transaction> results = query.list();
		return results;
	}
}