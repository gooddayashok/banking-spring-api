package com.example.demo.controller;

public class HelloWorldBean {

	public String message;
	public HelloWorldBean(String message) {
	   this.message=message;
		}
	
	@Override
	public String toString() {
		return "Hello world [message="+message+"]";
	}

}
