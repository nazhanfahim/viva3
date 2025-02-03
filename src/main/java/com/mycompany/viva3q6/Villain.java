/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.viva3q6;

/**
 *
 * @author Dell
 */
public class Villain {
    
    protected String villainName;
    private String villainElement;
    private double villainMaxHP, villainAttack, villainDefense, villainInitialCD; 
    protected double villainHP, villainCurrentCD;
    
    public Villain(String villainName, String villainElement, double villainMaxHP, double villainAttack, double villainDefense, double villainInitialCD) {
        this.villainName = villainName;
        this.villainElement = villainElement;
        this.villainMaxHP = villainMaxHP;
        this.villainHP = villainMaxHP;
        this.villainAttack = villainAttack;
        this.villainDefense = villainDefense;
        this.villainInitialCD = villainInitialCD;
        this.villainCurrentCD = villainInitialCD;
    }
    
    public void getDamaged(double damage){
        villainHP-=damage;
        if(villainHP<0){
            villainHP=0;
        }

    }
    

    public String getElement() {
        return villainElement;
    }

    public double getAttack() {
        return villainAttack;
    }

    public double getDefense() {
        return villainDefense;
    }
    
    public void resetHP(){
        villainHP=villainMaxHP;
        }
    
    public void decreaseCD(){
        villainCurrentCD-=1;
    }
    
    public void resetCD(){
        villainCurrentCD=villainInitialCD;
    }
   
    @Override
    public String toString() {
        return "Name: "+villainName+"\n"+"Element: "+villainElement+"\n"+"HP: "+villainMaxHP+"\n"+"Attack: "+villainAttack+"\n"+
                "Defense: "+villainDefense+"\n"+"Initial CD: "+villainInitialCD+"\n"+"Current CD: "+villainCurrentCD+"\n";
    }
    
}
