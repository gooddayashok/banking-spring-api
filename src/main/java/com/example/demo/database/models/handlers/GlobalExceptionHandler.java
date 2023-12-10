package com.example.demo.database.models.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exceptions.AccountNotExistException;
import com.example.demo.exceptions.InSufficientBalanceException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ AccountNotExistException.class })
	public ResponseEntity<Object> handleAccountNotExistException(AccountNotExistException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	
	@ExceptionHandler({ InSufficientBalanceException.class })
	public ResponseEntity<Object> handleAccountNotExistException(InSufficientBalanceException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}
}
