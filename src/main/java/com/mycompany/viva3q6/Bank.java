/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3_qs5;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import viva3_qs5.BankAccount;
import viva3_qs5.Customer;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author TenZo
 */
public class Bank {
 private String bankName;
    private List<Customer> customers;

    // Constructor
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
       
    }

    // Add a customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer.getName() + " (ID: " + customer.getCustomerId() + ")");
    }

    // Display all customers
    public void displayAllCustomers() {
    System.out.println("Customers of bank: " + bankName);
    for (Customer customer : customers) {
         customer.displayAccounts();  
    }
}

    // Find a customer by ID
    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        System.out.println("Customer not found!");
        return null;
    }

    public void saveToCSV(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
           for (Customer customer : customers) {
                writer.write(customer.toCSV() + "\n");

                for (BankAccount account : customer.getAccounts()) {
                    writer.write(account.toCSV() + "\n");
                }
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Customer currentCustomer = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Customer")) {
                    currentCustomer = Customer.fromCSV(line);
                    customers.add(currentCustomer);
                } else if (line.startsWith("Account")) {
                    BankAccount account = BankAccount.fromCSV(line);
                    if (currentCustomer != null) {
                        currentCustomer.addAccount(account);
                    }
                }
            }
            System.out.println("Data loaded from " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleBankOperations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to " + bankName);

        while (true) {
            System.out.println("\n1. Add Customer\n2. Add Account\n3. Deposit\n4. Withdraw\n5. Display Customers\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    addCustomer(new Customer(name, customerId));
                    saveToCSV("bank_data.csv");
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextLine();
                    Customer customer = getCustomer(customerId);
                    if (customer != null) {
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter initial deposit: ");
                        double deposit = scanner.nextDouble();
                        scanner.nextLine();
                        customer.addAccount(new BankAccount(accountNumber, customer.getName(), deposit));
                         saveToCSV("bank_data.csv");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String accNumber = scanner.nextLine();
                    BankAccount account = null;
                    for (Customer c : customers) {
                        account = c.getAccount(accNumber);
                        if (account != null) break;
                    }
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        account.deposit(amount);
                         
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextLine();
                    account = null;
                    for (Customer c : customers) {
                        account = c.getAccount(accNumber);
                        if (account != null) break;
                    }
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        account.withdraw(amount);
                        
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    displayAllCustomers();
                    break;
               
                case 6:
                    System.out.println("Exiting bank system.");

                     saveToCSV("bank_data.csv");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
