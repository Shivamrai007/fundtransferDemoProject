package com.ft.fund.transfer.FundTransferDemo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft.fund.transfer.FundTransferDemo.dao.UserDao;
import com.ft.fund.transfer.FundTransferDemo.model.User;
import com.ft.fund.transfer.FundTransferDemo.service.UserService;

/**
 * @author shivam.rai
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	/**
	 *
	 */
	public User login(User user) {
		return userDao.doLogin(user);
	}

	/**
	 *
	 */
	public User getUserByUserId(int userId) {
		return userDao.getUserByUserId(userId);
	}
}