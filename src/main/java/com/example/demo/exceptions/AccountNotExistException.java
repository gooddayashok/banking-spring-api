package com.example.demo.exceptions;

public class AccountNotExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotExistException(String message) {
		super(message);
	}

}
