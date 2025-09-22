import java.util.*;

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract Class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters/Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; } // restricted

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Abstract Method
    public abstract double calculateInterest();
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable {
    private double loanLimit;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
        this.loanLimit = 50000; // example
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% annual interest
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= loanLimit) {
            System.out.println("Loan Approved for Savings Account: " + amount);
        } else {
            System.out.println("Loan Denied! Exceeds limit for Savings Account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; // must have min balance
    }
}

// Current Account
class CurrentAccount extends BankAccount implements Loanable {
    private double loanLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
        this.loanLimit = 100000; // example
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // 2% annual interest
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= loanLimit) {
            System.out.println("Loan Approved for Current Account: " + amount);
        } else {
            System.out.println("Loan Denied! Exceeds limit for Current Account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 20000; // must have min balance
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount sa = new SavingsAccount("SA123", "Alice", 20000);
        CurrentAccount ca = new CurrentAccount("CA456", "Bob", 50000);

        accounts.add(sa);
        accounts.add(ca);

        // Polymorphism: Calculate Interest dynamically
        for (BankAccount acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() + 
                               " | Holder: " + acc.getHolderName() + 
                               " | Balance: " + acc.getBalance() + 
                               " | Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
                loanAcc.applyForLoan(30000);
            }
            System.out.println("------------------------------------");
        }
    }
}
