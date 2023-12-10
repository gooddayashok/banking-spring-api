package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.database.models.*;
import com.example.demo.exceptions.AccountNotExistException;
import com.example.demo.exceptions.InSufficientBalanceException;

@Service
public class BankAccountService {
	private List<BankAccount> _bankAccounts = new ArrayList<BankAccount>();

	public String openAccount(String name) {
		BankAccount account = new BankAccount(name);
		_bankAccounts.add(account);
		return account.getAccountNumber();
	}

	public List<BankAccount> getAccounts() {
		return _bankAccounts;
	}

	public String[] getStatement(String acc_no) throws AccountNotExistException {
		BankAccount account = GetBankAccount(acc_no);
		return account.getStatement();
	}

	public void depositAmount(String acc_no, double amount) throws AccountNotExistException {

		BankAccount account = GetBankAccount(acc_no);
		account.Deposit(amount);
	}

	public void withdrawAmount(String acc_no, double amount)
			throws InSufficientBalanceException, AccountNotExistException {

		BankAccount account = GetBankAccount(acc_no);
		if (account.getBalance() < amount) {
			throw new InSufficientBalanceException("In sufficient Balance in Account" + acc_no);
		}

		account.WithDraw(amount);
	}

	private BankAccount GetBankAccount(String accNo) throws AccountNotExistException {
		for (BankAccount bankAccount : _bankAccounts) {
			if (accNo.equalsIgnoreCase(bankAccount.getAccountNumber())) {
				return bankAccount;
			}
		}

		throw new AccountNotExistException("Account does not exist with number " + accNo);
	}
}
