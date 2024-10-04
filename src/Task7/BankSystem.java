package Task7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankSystem {
    public static void main(String[] args) {
        Bank bank1 = new Bank("Privat");
        Bank bank2 = new Bank("Kredo");

        User user1 = new User("Danylo");
        User user2 = new User("Oleg");

        BankAccount account1 = new BankAccount("111", "UAH", 200);
        BankAccount account2 = new BankAccount("222", "UAH", 100);
        BankAccount account3 = new BankAccount("333", "USD", 10);

        user1.addAccount(account1);
        user1.addAccount(account3);

        user2.addAccount(account2);

        bank1.addAccount(account1);
        bank2.addAccount(account2);

        try {
            bank1.transfer(account1, bank2, account2, 100, user1, user2); //6%
            System.out.println("Danylo's UAH balance: " + account1.getBalance());
            System.out.println("Oleg's UAH balance: " + account2.getBalance());

            System.out.println("--------------------------------");

            bank1.transfer(account1, bank2, account2, 100, user1, user1); //2%
            System.out.println("Danylo's UAH balance: " + account1.getBalance());
            System.out.println("Oleg's UAH balance: " + account2.getBalance());

            System.out.println("--------------------------------");

            bank1.transfer(account3, bank1, account3, 1, user1, user1); //0%
            System.out.println("Danylo's USD balance: " + account3.getBalance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Bank {
    private final String name;
    private static final Map<String, BankAccount> accounts = new HashMap<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addAccount(BankAccount account) {
        if (accounts.containsValue(account)) {
            throw new IllegalArgumentException("Account already exists");
        }
        accounts.put(account.getAccountNumber(), account);
    }

    public void transfer(BankAccount fromAccount, Bank bankTo, BankAccount toAccount, double amount, User fromUser, User toUser) throws Exception {
        boolean isSameBank = this.name.equals(bankTo.name);
        boolean isSameUser = fromUser == toUser;

        double feePercentage = calculateFee(isSameBank, isSameUser);
        double totalAmountAfterFee = amount * (1 - feePercentage);

        fromAccount.withdraw(amount);
        toAccount.deposit(totalAmountAfterFee);
    }

    private double calculateFee(boolean isSameBank, boolean isSameUser) {
        if (isSameUser && isSameBank) {
            return 0.0;
        } else if (isSameUser) {
            return 0.02;
        } else if (isSameBank) {
            return 0.03;
        } else {
            return 0.06;
        }
    }
}

class BankAccount {
    private final String accountNumber;
    private final String currency;
    private double balance;

    public BankAccount(String accountNumber, String currency, double initialBalance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Not enough money.");
        }
        balance -= amount;
    }
}

class User {
    private final String name;
    private final List<BankAccount> accounts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public String getName() {
        return name;
    }
}

