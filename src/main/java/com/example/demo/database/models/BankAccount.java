package com.example.demo.database.models;

import com.example.demo.utils.IdGenerator;

public class BankAccount {
	private String accountNumber;
	private Double balance=0.0;
	private String name;
	
	public BankAccount(String name) {
		this.name = name;
		this.accountNumber = IdGenerator.Instance().GenerateTimeStampId();
	}
	
	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
}
