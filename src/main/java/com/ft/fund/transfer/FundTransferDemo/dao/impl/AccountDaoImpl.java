package com.ft.fund.transfer.FundTransferDemo.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ft.fund.transfer.FundTransferDemo.dao.AccountDao;
import com.ft.fund.transfer.FundTransferDemo.model.Account;

/**
 * @author shivam.rai
 *
 */
@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 *
	 */
	public Account getAccountByUserId(int userId) {

		Session currentSession = sessionFactory.getCurrentSession();
		// currentSession.beginTransaction();
		Query query = currentSession.createQuery("from Account where userId=:userId");
		query.setParameter("userId", userId + "");

		List<Account> accountList = query.list();

		if (accountList.isEmpty()) {
			return null;
		}

		Account account = accountList.get(0);
		return account;

	}

	public Account getAccountByAccountNumber(String accountNumber) {

		Session currentSession = sessionFactory.getCurrentSession();
		// currentSession.beginTransaction();
		Query query = currentSession.createQuery("from Account where accountNo=:accountNo");
		query.setParameter("accountNo", accountNumber + "");

		List<Account> accountList = query.list();

		if (accountList.isEmpty()) {
			return null;
		}

		Account account = accountList.get(0);
		return account;

	}

	/**
	 *
	 */

	public boolean updateAccount(Account account) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(account);
		transaction.commit();
		session.close();

		return true;
	}

	

}