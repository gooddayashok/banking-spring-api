package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.models.BankAccount;
import com.example.demo.exceptions.AccountNotExistException;
import com.example.demo.exceptions.InSufficientBalanceException;
import com.example.demo.services.BankAccountService;

@RestController
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;

	@PostMapping(path = "/open-account")
	public String OpenAccount(@RequestBody Map<String, Object> body) {
		return bankAccountService.openAccount(body.get("name").toString());
	}

	@GetMapping(path = "/accounts")
	public List<BankAccount> GetAccounts() {
		return bankAccountService.getAccounts();
	}

	@GetMapping(path = "/balance")
	public Double helloWorld(String number) {
		return 100.00;
	}

	@GetMapping(path = "/statement")
	public String[] getStatement(String accNo) throws AccountNotExistException {
		return bankAccountService.getStatement(accNo);
	}

	@PostMapping(path = "/deposite")
	public ResponseEntity<String> DepositAmount(@RequestBody Map<String, Object> body) throws AccountNotExistException {
		bankAccountService.depositAmount(body.get("acc_no").toString(),
				Double.parseDouble(body.get("amount").toString()));

		return ResponseEntity.ok("Amount depoited.");
	}
	@PostMapping(path = "/withdraw")
	public ResponseEntity<String> WithDrawAmount(@RequestBody Map<String, Object> body) throws AccountNotExistException,InSufficientBalanceException {
		bankAccountService.withdrawAmount(body.get("acc_no").toString(),
				Double.parseDouble(body.get("amount").toString()));

		return ResponseEntity.ok("Amount withdraw.");
	}
}
