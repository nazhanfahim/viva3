package com.mycompany.v3q2;


public class Creature {
    String species,habitat;
    double magicPower;
    
    public Creature(String n, double p, String h){
        species=n;
        magicPower=p;
        habitat=h;
    }
    public void displayInfo(){
        System.out.println("Species: "+species);
        System.out.println("Magic Power: "+magicPower);
        System.out.println("Habitat: "+habitat);
        System.out.println("");
    }
    
    public void feed(double foodAmount){
        magicPower+=foodAmount;
        System.out.println(species+"'s magic power is increased to "+magicPower);
        System.out.println("");
    }
    
    public String getSpecies(){
        return species;
    }
}
