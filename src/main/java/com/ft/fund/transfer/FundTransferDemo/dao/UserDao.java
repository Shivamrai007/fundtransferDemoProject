package com.ft.fund.transfer.FundTransferDemo.dao;

import com.ft.fund.transfer.FundTransferDemo.model.User;

public interface UserDao {

	public User doLogin(User user);

	public User getUserByUserId(int userId);

}
