package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.models.BankAccount;
import com.example.demo.services.BankAccountService;

@RestController
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;
	
	@PostMapping(path = "/open-account")
	public String OpenAccount(@RequestBody Map<String,Object> body)
	{
		return bankAccountService.openAccount(body.get("name").toString());
	}
	
	@GetMapping(path="/accounts")
	public List<BankAccount> GetAccounts(){
		return bankAccountService.getAccounts();
	}
	
	@GetMapping(path="/balance")
	public Double helloWorld(String number)
	{
	    return 100.00;
	}
	
	@PostMapping(path = "/deposite")
	public String DepositAmount(@RequestBody Map<String,Object> body)
	{
		return bankAccountService.depositAmount(body.get("acc_no").toString(),Double.parseDouble( body.get("amount").toString()));
	}
}
