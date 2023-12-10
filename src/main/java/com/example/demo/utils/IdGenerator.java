package com.example.demo.utils;

import java.time.*;
import java.time.ZoneOffset;

public class IdGenerator {
	private static IdGenerator _idGenerator;
	
	private IdGenerator() {}
	
	public String GenerateTimeStampId() {
		LocalDateTime date = LocalDateTime.now(); 
		long millis = date.toEpochSecond(ZoneOffset.of("Z"));
		
		return ""+millis+"";
	}
	
	public static IdGenerator Instance() {
		if(_idGenerator==null) {
			_idGenerator=new IdGenerator();
		}
		
		return _idGenerator;
	}
}
