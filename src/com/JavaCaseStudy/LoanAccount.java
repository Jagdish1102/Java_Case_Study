package com.JavaCaseStudy;

class LoanAccount extends Account {
	private double loanAmount;
	private static final double INTEREST_RATE = 0.05; // Example 5% interest on loan

	public LoanAccount(String accountNumber, double loanAmount, String accountHolderName) {
		super(accountNumber, -loanAmount, accountHolderName);
		this.loanAmount = loanAmount;
	}

	@Override
	public void deposit(double amount) {
		balance += amount; // Reduce the outstanding loan balance
	}

	@Override
	public boolean withdraw(double amount) {
		System.out.println("Withdrawals not allowed on loan accounts.");
		return false;
	}

	@Override
	public void calculateInterest() {
		balance -= Math.abs(balance) * INTEREST_RATE; // Apply interest as negative balance
	}
}
