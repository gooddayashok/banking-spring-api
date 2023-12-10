package com.example.demo.database.models;

import java.time.LocalDateTime;
import java.util.*;

public class MiniStatement {
	private String accNo;
	private List<Statement> statements = new ArrayList<Statement>();

	public MiniStatement(String accNo) {
		this.accNo = accNo;
	}
	
	public void addStatement(String statement) {
		if(statements.size()==5) {
			statements.remove(0);
		}
		
		statements.add(new Statement(LocalDateTime.now(), statement));
	}
	
	public String[] getStatments() {
		int size = statements.size();
		String[] stats = new String[statements.size()];
		for(int i = size;i>0;i--) {
			stats[size-i] = accNo+ " " +statements.get(i-1).toString();
		}
		
		return stats;
	}
}
