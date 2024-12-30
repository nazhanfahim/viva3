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
    
    private String heroName, heroElement;
    private double heroHP, heroAttack;

    public Hero(String heroName, String heroElement, double heroHP, double heroAttack) {
        this.heroName = heroName;
        this.heroElement = heroElement;
        this.heroHP = heroHP;
        this.heroAttack = heroAttack;
    }

    public double getHeroHP() {
        return heroHP;
    }
    
    
    public double calculateDamage(Villain enemy, int rsMultipilier){
      return 0;  
    }

    @Override
    public String toString() {
        return "Name: "+heroName+"\n"+"Element: "+heroElement+"\n"+"HP: "+heroHP+"\n"+"Attack: "+heroAttack+"\n";
    }

   
    
    
}
