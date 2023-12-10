package com.example.demo.database.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Statement {
	private LocalDateTime date;
	private String statement;

	public Statement(LocalDateTime date, String statement) {
		this.date = date;
		this.statement = statement;
	}

	@Override
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		return date.format(format) + " " + statement;
	}
}
