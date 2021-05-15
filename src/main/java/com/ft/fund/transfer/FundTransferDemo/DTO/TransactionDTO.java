package com.ft.fund.transfer.FundTransferDemo.DTO;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author shivam.rai
 *
 */
public class TransactionDTO {

	@NotEmpty(message = "Enter Valid Account Number")
	private String accountNumber;

	@NotEmpty(message = "Enter Amount")
	private String amount;

	@NotEmpty(message = "Enter Transaction Type")
	private String transactionType;

	@NotEmpty(message = "Enter Description")
	private String description;
	private String userId;
	private String selfAccountNumber;

	public TransactionDTO(String accountNumber, String amount, String transactionType, String description,
			String userId) {
		super();

		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionType = transactionType;
		this.description = description;
		this.userId = userId;
	}
	
	public TransactionDTO() {
		
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSelfAccountNumber() {
		return selfAccountNumber;
	}

	public void setSelfAccountNumber(String selfAccountNumber) {
		this.selfAccountNumber = selfAccountNumber;
	}

	
}