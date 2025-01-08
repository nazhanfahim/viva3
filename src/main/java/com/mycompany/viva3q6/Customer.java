/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3_qs5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TenZo
 */
public class Customer {
      private String name;
    private String customerId;
    private List<BankAccount> accounts;

    // Constructor
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>();
    }

    // Add a bank account
    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account added for customer " + name + " (ID: " + account.getAccountNumber() + ").");
    }

    
    public void displayAccounts() {
    System.out.println("Accounts for customer: " + name);
    for (BankAccount account : accounts) {
        // Displaying account number, holder name, and balance
        System.out.println("Account Number: " + account.getAccountNumber() + 
                           ", Holder Name: " + account.getAccountHolderName() + 
                           ", Balance: " + account.getBalance());
    }
}
    public BankAccount getAccount(String accountNumber) {
    for (BankAccount account : accounts) {
        if (account.getAccountNumber().equals(accountNumber)) {
            return account;
        }
    }
    return null; // Account not found
}

    // Getters
    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
     
    public List<BankAccount> getAccounts() {
        return accounts;
    }
    public static Customer fromCSV(String csvLine) {
        String[] fields = csvLine.split(",");
        return new Customer(fields[2], fields[1]);
    }
    public String toCSV() {
        return "Customer," + customerId + "," + name;
    }
}



