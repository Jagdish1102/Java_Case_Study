package com.JavaCaseStudy;

class CurrentAccount extends Account {
	private double OverDraftLimit;

	// This account allows to OverDraftLimit Limit
	// OverDradf Limit means U can withdraw amount Less Than Zero That means You get
	// Temperer Lone
	public CurrentAccount(String accountNumber, double balance, String accountHolderName, double OverDraftLimit) {
		super(accountNumber, balance, accountHolderName);
		this.OverDraftLimit = OverDraftLimit;
	}

	@Override
	public void deposit(double amount) {
		balance = balance + amount;
	}

	@Override
	public boolean withdraw(double amount) {
		if (balance - amount >= -OverDraftLimit) {
			balance = balance - amount;

			return true;
		} else { 
			System.out.println("Withdrawal denied. Overdraft limit reached.");
			return false;
		}
	}

	@Override
	public void calculateInterest() {
		// Current accounts typically do not earn interest
	}
}
