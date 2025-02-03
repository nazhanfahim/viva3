/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.viva3q6;

/**
 *
 * @author Dell
 */
public class Hero {
    
    protected String heroName, heroElement;
    protected double heroHP, heroAttack;

    public Hero(String heroName, String heroElement, double heroHP, double heroAttack) {
        this.heroName = heroName;
        this.heroElement = heroElement;
        this.heroHP = heroHP;
        this.heroAttack = heroAttack;
    }

    public double getHeroHP() {
        return heroHP;
    }
    
    public String getElement() {
        return heroElement;
    }

    public double getAttack() {
        return heroAttack;
    }
    
    public double calculateDamage(Villain enemy, int rsMultipilier){
      double dominanceMultiplier = 1.0;
        switch (this.heroElement) {
            case "Water":
                if (enemy.getElement().equals("Fire")) dominanceMultiplier = 2.0;
                else if (enemy.getElement().equals("Earth")) dominanceMultiplier = 0.5;
                break;
            case "Fire":
                if (enemy.getElement().equals("Earth")) dominanceMultiplier = 2.0;
                else if (enemy.getElement().equals("Water")) dominanceMultiplier = 0.5;
                break;
            case "Earth":
                if (enemy.getElement().equals("Light")) dominanceMultiplier = 2.0;
                else if (enemy.getElement().equals("Fire")) dominanceMultiplier = 0.5;
                break;
            case "Light":
                if (enemy.getElement().equals("Dark")) dominanceMultiplier = 2.0;
                else if (enemy.getElement().equals("Earth")) dominanceMultiplier = 0.5;
                break;
            case "Dark":
                if (enemy.getElement().equals("Water")) dominanceMultiplier = 2.0;
                else if (enemy.getElement().equals("Light")) dominanceMultiplier = 0.5;
                break;
        }
        
        //Calculate damage
        double damage=this.heroAttack*dominanceMultiplier*rsMultipilier-enemy.getDefense();
        return Math.max(damage, 1); //Math.max function is a built-in Java method that returns the larger of two values.
    }

    @Override
    public String toString() {
        return "Name: "+heroName+"\n"+"Element: "+heroElement+"\n"+"HP: "+heroHP+"\n"+"Attack: "+heroAttack+"\n";
    }

   
    
    
}
