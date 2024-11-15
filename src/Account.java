import java.JavaCaseStudy.jaggu;
abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String accountHolderName;
    
    public Account(String accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract void calculateInterest();

    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
}
