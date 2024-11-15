package com.JavaCaseStudy;

import java.util.ArrayList;
import java.util.List;

class EndOfDayReport {
	private List<Transaction> transactions;

	public EndOfDayReport() {
		transactions = new ArrayList<>();
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public void generateReport() {
		System.out.println("End of Day Report:");
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}
}
