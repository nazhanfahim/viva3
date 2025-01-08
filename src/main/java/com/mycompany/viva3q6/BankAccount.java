/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3_qs5;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author TenZo
 */
public class BankAccount {
   
     private String accountNumber, accountHolderName;    
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String  accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited RM" + amount + " into account " + accountNumber + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew RM" + amount + " from account " + accountNumber + ". New balance: $" + balance);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount!");
            return false;
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Display account information
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber + ", Type: " + accountHolderName + ", Balance: $" + balance);
    }


    // Convert to CSV format
    public String toCSV() {
        return "Account," + accountNumber + "," + accountHolderName + "," + balance;
    }

    // Static method to create BankAccount from CSV
    public static BankAccount fromCSV(String csvLine) {
        String[] fields = csvLine.split(",");
        return new BankAccount(fields[1], fields[2], Double.parseDouble(fields[3]));
    }
}