package com.example.demo.exceptions;

public class InSufficientBalanceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InSufficientBalanceException(String message) {
		super(message);
	}

}
