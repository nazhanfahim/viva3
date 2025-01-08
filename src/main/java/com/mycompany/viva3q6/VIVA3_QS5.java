/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva3_qs5;

import java.util.Scanner;
import viva3_qs5.BankAccount;

/**
 *
 * @author TenZo
 */
public class VIVA3_QS5 {

    public static void main(String[] args) {
        Bank bank = new Bank("SimpleBank");
        bank.loadFromCSV("bank_data.csv");
        bank.handleBankOperations();
        
        
    }
}
    
    
