/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.viva3q6;
import java.util.*;
/**
 *
 * @author Dell
 */
public class Game {
    
    
    public void battle(Team team, Villain enemy){
        Random cb=new Random();
        team.resetHP();
        enemy.resetHP();
        enemy.resetCD();
        
        while(team.teamHP>0&&enemy.villainHP>0){
        String[] Elements = {"Water", "Fire", "Earth", "Light", "Dark"};    
        String[] runestones = new String[3];
            System.out.println("");
            System.out.print("Runestones dissolved: ");
            for (int i = 0; i < 3; i++) {
                runestones[i] = Elements[cb.nextInt(Elements.length)];
                System.out.print(runestones[i]+" ");
            }    
            System.out.println("");
            // Count runestones
            int[] runestoneCount = new int[5]; // Count the amount of runestones dissolved for each type to get accurate number for runestone multiplier
            for (String runestone : runestones) {
                switch (runestone) {
                    case "Water": runestoneCount[0]++; break;
                    case "Fire": runestoneCount[1]++; break;
                    case "Earth": runestoneCount[2]++; break;
                    case "Light": runestoneCount[3]++; break;
                    case "Dark": runestoneCount[4]++; break;
                }
            }
            // Heroes attack
            for (Hero hero : team.heroList) {
                int rsMultiplier = runestoneCount[getElementIndex(hero.heroElement)];
                if (rsMultiplier > 0) {
                    double damage = hero.calculateDamage(enemy, rsMultiplier);
                    enemy.getDamaged(damage);
                    System.out.printf("%s attacks %s for %.2f damage!\n", hero.heroName, enemy.villainName, damage);
                }
            }
            // Enemy attacks if currentCd is 1
            if (enemy.villainCurrentCD == 1 && enemy.villainHP > 0) {
                team.teamGetDamaged(enemy.getAttack());
                System.out.printf("%s attacks the team for %.2f damage!\n", enemy.villainName, enemy.getAttack());
                enemy.resetCD();
            } else {
                enemy.decreaseCD();
            }

            // Display remaining HP
            System.out.printf("Team HP: %.2f, %s HP: %.2f\n", team.teamHP, enemy.villainName, enemy.villainHP);
        }

        // Print battle result
        if (enemy.villainHP <= 0) {
            System.out.println("The team wins the battle!");
        } else {
            System.out.println("The team loses the battle!");
        }
        }
        
        
        
        public int getElementIndex(String element) {
        switch (element) {
            case "Water": return 0;
            case "Fire": return 1;
            case "Earth": return 2;
            case "Light": return 3;
            case "Dark": return 4;
            default: return -1;
        }
}
}
