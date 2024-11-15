package com.JavaCaseStudy;

class SalaryAccount extends SavingsAccount {
	private int monthsInactive = 0;

	public SalaryAccount(String accountNumber, double balance, String accountHolderName) {
		super(accountNumber, balance, accountHolderName);
	}

	public void incrementInactivity() {
		monthsInactive++;
		if (monthsInactive >= 2) {
			freezeAccount();
		}
	}

	private void freezeAccount() {
		System.out.println("Account " + accountNumber + " is frozen due to inactivity.");
		// Implement freeze logic
	}

	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		monthsInactive = 0; // Reset inactivity counter
	}
}
