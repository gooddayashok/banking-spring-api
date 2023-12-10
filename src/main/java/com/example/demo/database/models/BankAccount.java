package com.example.demo.database.models;

import com.example.demo.utils.IdGenerator;

public class BankAccount {
	private String accountNumber;
	private Double balance=0.0;
	private String name;
    private MiniStatement miniStatement = null;
	
	public BankAccount(String name) {
		this.name = name;
		this.accountNumber = IdGenerator.Instance().GenerateTimeStampId();
		miniStatement = new MiniStatement(accountNumber);
		miniStatement.addStatement("Account opened.");
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
	
	public void Deposit(Double amount) {
		this.balance += amount;
		this.miniStatement.addStatement("Deposit "+amount+" Balance "+balance);
	}
	public void WithDraw(Double amount) {
		this.balance -= amount;
		this.miniStatement.addStatement("Withdraw "+amount+" Balance "+balance);
	}
	
	
	public String[] getStatement() {
		return miniStatement.getStatments();
	}
}
