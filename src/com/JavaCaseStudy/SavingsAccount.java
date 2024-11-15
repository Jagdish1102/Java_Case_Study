package com.JavaCaseStudy;

class SavingsAccount extends Account {
	private static final double Min_Balance = 10000;
	private static final double Interest_Rate = 0.03; // Example 3% interest

	public SavingsAccount(String accountNumber, double balance, String accountHolderName) {
		super(accountNumber, balance, accountHolderName);
	}

	@Override
	public void deposit(double amount) {
		balance=balance+amount;
	}
		// withdraw
		//If you withdraw amount is greater than minimum balance than this function retuen false
	@Override
	public boolean withdraw(double amount) {       
		if (balance - amount >= Min_Balance) {
			balance=balance-amount;
			return true;
		} else {
			System.out.println("Insufficient balance. Minimum balance of " + Min_Balance + " required.");
			return false;
		}
	}
		// Thise Function Calculate interest and add remening balance
	@Override
	public void calculateInterest() {
		balance = balance + (balance *  Interest_Rate );  
	}
}
