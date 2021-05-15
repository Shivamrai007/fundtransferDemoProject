package com.ft.fund.transfer.FundTransferDemo.service;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.ft.fund.transfer.FundTransferDemo.model.Transaction;

public interface FundTransferService {

	public int initiateFundTransfer(@ModelAttribute Transaction transaction);
}