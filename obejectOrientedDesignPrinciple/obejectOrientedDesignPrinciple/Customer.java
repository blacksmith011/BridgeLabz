import java.util.ArrayList;
import java.util.List;

class Customers {
    private String name;
    private List<Account> accounts;

    public Customers(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println("Account ID: " + acc.getAccountId() + ", Balance: " + acc.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class Account {
    private static int counter = 1000;
    private int accountId;
    private double balance;

    public Account(double initialBalance) {
        this.accountId = counter++;
        this.balance = initialBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }
}

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialBalance) {
        Account account = new Account(initialBalance);
        customer.addAccount(account);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened in " + bankName + " for " + customer.getName() + " with balance: " + initialBalance);
    }

    public void showCustomers() {
        System.out.println("Bank: " + bankName + " Customers:");
        for (Customer c : customers) {
            System.out.println(c.getName());
        }
    }
}

public class Customer {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank");

        Customers c1 = new Customers("Alice");
        Customers c2 = new Customers("Bob");

        bank.openAccount(c1, 5000);
        bank.openAccount(c1, 2000);
        bank.openAccount(c2, 10000);

        System.out.println();
        c1.viewBalance();
        c2.viewBalance();

        System.out.println();
        bank.showCustomers();
    }
}
