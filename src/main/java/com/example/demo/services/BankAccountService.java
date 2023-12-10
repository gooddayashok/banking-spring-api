package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.database.models.*;

@Service
public class BankAccountService {
	private List<BankAccount> _bankAccounts = new ArrayList<BankAccount>();
	
	public String openAccount(String name) {
		BankAccount account = new BankAccount(name);
		_bankAccounts.add(account);
		return account.getAccountNumber();
	}
	
	public List<BankAccount> getAccounts(){
		return _bankAccounts;
	}
	
	public String depositAmount(String acc_no,double amount)
	{
		if(!_bankAccounts.isEmpty())
		{
			int status=0;
		 for (BankAccount bankAccount : _bankAccounts) {
			 
			 if(acc_no.equalsIgnoreCase(bankAccount.getAccountNumber()))
			 {
				  
				Double amountFinal =bankAccount.getBalance()+ amount;
			    bankAccount.setBalance(amountFinal);
				 status=1;
	           return "amount successfully added" + bankAccount.toString();
			 }
			
		}
		 if(status==0)
		 {
			 return "amount  not added" ; 
			 
		 }
		 
		 
		}
		
		 return "amount  not added" ;
		
		
	}
	
}
