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
public class Team {
    
    Random g=new Random();
    private Hero [] deck;
    private Hero[] heroList= new Hero[4];
    private double initialTeamHP=0;
    private double teamHP;
    
    public Team(Hero[] heroes){
        this.deck=heroes;
    }
    
    public void formTeam(){
        for (int i=0; i<heroList.length;i++){
            heroList[i]=deck[g.nextInt(0, 15)];
            initialTeamHP=heroList[i].getHeroHP();
        }
        this.teamHP=initialTeamHP;
    }
    
    public void teamGetDamaged(double damage){
        teamHP-=damage;
        if(teamHP<0){
            teamHP=0;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
    for (int i = 0; i < heroList.length; i++) {
        result.append("Hero ").append(i + 1).append("\n");
        result.append(heroList[i].toString()).append("\n");
    }
    return result.toString();
    }
    
    
}
