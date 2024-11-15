package com.JavaCaseStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		// Initialize accounts and the end-of-day report
		ArrayList<Account> accounts = new ArrayList<>();
		EndOfDayReport report = new EndOfDayReport();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nWelcome to Bank Of Money (BOM) Bank");
			System.out.println("1. Create Savings Account");
			System.out.println("2. Create Salary Account");
			System.out.println("3. Create Current Account");
			System.out.println("4. Create Loan Account");
			System.out.println("5. Deposit");
			System.out.println("6. Withdraw");
			System.out.println("7. End of Day Report");
			System.out.println("8. displayAccountDetails");
			System.out.println("9. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// Create Savings Account
				System.out.print("Enter account holder's name: ");
				String savingsName = scanner.next();
				System.out.print("Enter initial balance: ");
				double savingsBalance = scanner.nextDouble();
				Account savingsAccount = new SavingsAccount("SA" + (accounts.size() + 1), savingsBalance, savingsName);
				accounts.add(savingsAccount);
				System.out.println("Savings account created successfully!");
				savingsAccount.displayAccountDetails();
				break;

			case 2:
				// Create Salary Account
				//Inter Name of account Holder
				System.out.print("Enter account holder's name: ");
				String salaryName = scanner.next();
				//inter intial balance
				System.out.print("Enter initial balance: ");
				double salaryBalance = scanner.nextDouble();
				Account salaryAccount = new SalaryAccount("SAL" + (accounts.size() + 1), salaryBalance, salaryName);
				accounts.add(salaryAccount);
				System.out.println("Salary account created successfully!");
				salaryAccount.displayAccountDetails();
				break;

			case 3:
				// Create Current Account
				System.out.print("Enter account holder's name: ");
				String currentName = scanner.next();
				System.out.print("Enter initial balance: ");
				double currentBalance = scanner.nextDouble();
				System.out.print("Enter overdraft limit: ");
				double overdraftLimit = scanner.nextDouble();
				Account currentAccount = new CurrentAccount("CA" + (accounts.size() + 1), currentBalance, currentName,
						overdraftLimit);
				accounts.add(currentAccount);
				System.out.println("Current account created successfully!");
				currentAccount.displayAccountDetails();
				break;

			case 4:
				// Create Loan Account
				System.out.print("Enter account holder's name: ");
				String loanName = scanner.next();
				System.out.print("Enter loan amount: ");
				double loanAmount = scanner.nextDouble();
				Account loanAccount = new LoanAccount("LA" + (accounts.size() + 1), loanAmount, loanName);
				accounts.add(loanAccount);
				System.out.println("Loan account created successfully!");
				loanAccount.displayAccountDetails();
				break;

			case 5:
				// Deposit
				System.out.print("Enter account number: ");
				String depositAccountNumber = scanner.next();
				Account depositAccount = findAccountByNumber(accounts, depositAccountNumber);
				if (depositAccount != null) {
					System.out.print("Enter deposit amount: ");
					double depositAmount = scanner.nextDouble();
					depositAccount.deposit(depositAmount);
					report.addTransaction(new Transaction(depositAccountNumber, depositAmount, "Deposit"));
					System.out.println("Deposit successful!");
				} else {
					System.out.println("Account not found.");
				}
				break;

			case 6:
				// Withdraw
				System.out.print("Enter account number: ");
				String withdrawAccountNumber = scanner.next();
				Account withdrawAccount = findAccountByNumber(accounts, withdrawAccountNumber);
				if (withdrawAccount != null) {
					System.out.print("Enter withdrawal amount: ");
					double withdrawAmount = scanner.nextDouble();
					if (withdrawAccount.withdraw(withdrawAmount)) {
						report.addTransaction(new Transaction(withdrawAccountNumber, withdrawAmount, "Withdraw"));
						System.out.println("Withdrawal successful!");
					}
				} else {
					System.out.println("Account not found.");
				}
				break;

			case 7:
				// End of Day Report
				report.generateReport();
				break;
			case 8:
					 
						
					
				break;
			case 9:
				// Exit
				System.out.println("Thank you for using XYZ Bank's system. Goodbye!");
				scanner.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	private static Account findAccountByNumber(ArrayList<Account> accounts, String accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}
}
