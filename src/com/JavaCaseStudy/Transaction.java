package com.JavaCaseStudy;

import java.sql.Date;

class Transaction {
    private String accountNumber;
    private Date date;
    private double amount;
    private String type; // Deposit, Withdraw, Loan Payment, etc.

    public Transaction(String accountNumber, double amount, String type) {
        this.accountNumber = accountNumber;
        this.date = new Date(0);
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction: " + type + " of Rs." + amount + " for account " + accountNumber + " on " + date;
    }
}


