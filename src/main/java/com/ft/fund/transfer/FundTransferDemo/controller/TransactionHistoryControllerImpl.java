package com.ft.fund.transfer.FundTransferDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ft.fund.transfer.FundTransferDemo.model.Transaction;
import com.ft.fund.transfer.FundTransferDemo.service.TransactionHistoryService;

@Controller
public class TransactionHistoryControllerImpl {

	@Autowired
	TransactionHistoryService transactionHistoryService;

	/**
	 *
	 */
	@RequestMapping(value = "/getAllTransactionsByUserId", method = RequestMethod.GET)
	public ModelAndView getAllTransactionsByUserId(int userId, Model model) {
		List<Transaction> transactionsList = transactionHistoryService.getAllTransactionsByUserId(userId);
		model.addAttribute("transactionsList", transactionsList);
		model.addAttribute("userId", userId);
		return new ModelAndView("transactionHistory");
	}

}