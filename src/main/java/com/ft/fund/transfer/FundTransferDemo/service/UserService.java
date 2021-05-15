package com.ft.fund.transfer.FundTransferDemo.service;

import com.ft.fund.transfer.FundTransferDemo.model.User;

public interface UserService {

	public User login(User user);

	public User getUserByUserId(int userId);
}