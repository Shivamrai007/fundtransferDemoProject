package com.ft.fund.transfer.FundTransferDemo.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ft.fund.transfer.FundTransferDemo.model.Account;
import com.ft.fund.transfer.FundTransferDemo.model.User;
import com.ft.fund.transfer.FundTransferDemo.service.AccountService;
import com.ft.fund.transfer.FundTransferDemo.service.UserService;

/**
 * @author shivam.rai
 *
 */
@Controller
public class UserControllerImpl {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	 private Logger logger = Logger.getLogger(UserControllerImpl.class);

	/**
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLoginPage(@ModelAttribute("user") User user) {

		 logger.info("Welcome to FT Online Banking. Logger is initialised");
		return new ModelAndView("login");
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getDetails", method = RequestMethod.GET)
	public User getUserDetails() {
		User user = new User();
		user.setUsername("shivamrai");
		user.setPassword("123");
		User getUser = userService.login(user);
		return getUser;
	}

	/**
	 *
	 */
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return new ModelAndView("login");
		}

		// logger.debug("Hello this is a debug message");
		// logger.info("Hello this is an info message");

		User getUser = userService.login(user);

		if (getUser.getId() == 0) {
			logger.info("Wrong Credentials");
			model.addAttribute("message", "Wrong Credentials");
			return new ModelAndView("showCustomMessage");
		} else {
			logger.info("Login Successfull");
			Account account = accountService.getAccountByUserId(getUser.getId());
			model.addAttribute("userDetails", getUser);
			model.addAttribute("account", account);
			return new ModelAndView("accountSummary");
		}

	}
}
