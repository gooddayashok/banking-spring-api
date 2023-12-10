package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String helloWorld()
	{
			return "Hello world";
	}
	
	@GetMapping(path="/hello-world-bean")
	public String helloWorldbean(String message)
	{
			return new HelloWorldBean(message).toString() ;
	}
}
