package com.ft.fund.transfer.FundTransferDemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ft.fund.transfer.FundTransferDemo.service.AccountService;
import com.ft.fund.transfer.FundTransferDemo.service.UserService;



/**
 * @author shivam.rai
 *
 */
@Controller
public class AccountSummaryControllerImpl {

	@Autowired
	AccountService accountService;

	@Autowired
	UserService userService;

	/**
	 *
	 */
	@RequestMapping(value = "/openAccountSummary", method = RequestMethod.GET)
	public ModelAndView openFundTransferPage(int userId, Model model) {
		model.addAttribute("userDetails", userService.getUserByUserId(userId));
		model.addAttribute("account", accountService.getAccountByUserId(userId));
		return new ModelAndView("accountSummary");
	}
}