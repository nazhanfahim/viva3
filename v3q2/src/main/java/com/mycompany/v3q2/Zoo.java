package com.mycompany.v3q2;
import java.util.ArrayList;
import java.util.Scanner;
public class Zoo {
    Scanner kb=new Scanner(System.in);
    int size;
    ArrayList<Creature> creatures = new ArrayList<>();
    
    public Zoo(int s){
        size=s;
    }
    
    public void addCreature(String n, double p, String h){
        if(creatures.size()<size){
            Creature myCreature=new Creature(n,p,h);
            creatures.add(myCreature);
            System.out.println(n+" added to the zoo.");
    }
        else{
                System.out.println("Zoo is full! Cannot add more creatures.");
            }
        System.out.println("");
    }
    public void feedCreature(String n, double food){
        for(Creature creature: creatures){
            if(creature.getSpecies().contains(n)){
                creature.feed(food);
                return;
            }
        }
        
    }
    
    public void displayAllCreatures(){
        for(Creature creature: creatures){
            creature.displayInfo();
        }
    }
}

