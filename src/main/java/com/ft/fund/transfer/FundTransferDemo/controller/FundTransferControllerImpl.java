package com.ft.fund.transfer.FundTransferDemo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import com.ft.fund.transfer.FundTransferDemo.DTO.TransactionDTO;
import com.ft.fund.transfer.FundTransferDemo.model.Account;
import com.ft.fund.transfer.FundTransferDemo.model.Transaction;
import com.ft.fund.transfer.FundTransferDemo.service.AccountService;
import com.ft.fund.transfer.FundTransferDemo.service.FundTransferService;

/**
 * @author shivam.rai
 *
 */
@Controller
public class FundTransferControllerImpl {

	@Autowired
	FundTransferService fundTransferService;

	@Autowired
	AccountService accountService;
	
	 private Logger logger = Logger.getLogger(FundTransferControllerImpl.class);

	/**
	 *
	 */
	@RequestMapping(value = "/openFundTrasferPage", method = RequestMethod.GET)
	public ModelAndView openFundTrasferPage(@ModelAttribute("transactionDTO") TransactionDTO transactionDTO, int userId,String selfAccountNumber,
			Model model) {
		model.addAttribute("userId", userId);
		model.addAttribute("selfAccountNumber", selfAccountNumber);
		return new ModelAndView("fundTransfer");
	}

	/**
	 *
	 */
	@RequestMapping(value = "/initiateFundTransfer", method = RequestMethod.POST)
	public ModelAndView initiateFundTransfer(@ModelAttribute("transactionDTO") @Valid TransactionDTO transactionDTO,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("userId", transactionDTO.getUserId());
			return new ModelAndView("fundTransfer");
		}

		String userId = transactionDTO.getUserId();

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		String date = df.format(calobj.getTime());
		Transaction transaction = new Transaction(0, transactionDTO.getAccountNumber(), transactionDTO.getAmount(),
				date, transactionDTO.getTransactionType(), transactionDTO.getDescription(), userId);

		Account benificieryaccount = accountService.getAccountByAccountNumber(transactionDTO.getAccountNumber());

		if (benificieryaccount == null) {
			 logger.info("Account is not Valid");
			model.addAttribute("message", "Fund Transfer Failed!");
			return new ModelAndView("showCustomMessage");
			
		} else {

			int status = fundTransferService.initiateFundTransfer(transaction);
			
			Transaction transactionbenificery = new Transaction(0, transactionDTO.getSelfAccountNumber(), transactionDTO.getAmount(),
					date, "CREDIT", "CREDITED FROM ACC NO : "+transactionDTO.getAccountNumber(), benificieryaccount.getUserId());
			fundTransferService.initiateFundTransfer(transactionbenificery);

			if (status > 0) {

				Account account = accountService.getAccountByUserId(Integer.parseInt(userId));
				if (account.getBalance() > Double.parseDouble(transactionDTO.getAmount())) {
					double balance = account.getBalance() - Double.parseDouble(transactionDTO.getAmount());
					boolean updateStatus = accountService.updateAccountBalanceByUserId(Integer.parseInt(userId),
							balance + "");

					double benficieryUpdatedBalance = benificieryaccount.getBalance()
							+ Double.parseDouble(transactionDTO.getAmount());

					 accountService.updateAccountBalanceByAccountNumber(
							transactionDTO.getAccountNumber(), benficieryUpdatedBalance + "");

					if (updateStatus) {
						//System.out.println("Update Status : " + updateStatus);

						ModelAndView modelAndView = new ModelAndView("redirect:" + "/openAccountSummary");
						modelAndView.addObject("userId", userId);
						return modelAndView;
					} else {
						model.addAttribute("message", "Fund Transfer Failed! Wrong account Number");
						return new ModelAndView("showCustomMessage");
					}
				} else {
					model.addAttribute("message", "Your Balance is low for this transaction!");
					return new ModelAndView("showCustomMessage");

				}

			} else {
				model.addAttribute("message", "Fund Transfer Failed!");
				return new ModelAndView("showCustomMessage");
			}

		}
		

	}

}