package com.mycompany.v3q3;

public class Pet {
    String name, species, breed, healthRecord, adopterName;
    int age;
    boolean isAdopted=false;
    
    public Pet(String n, String s, String b, int a, String h){
    name=n;
    species=s;
    breed=b;
    age=a;
    healthRecord=h;
}
    public void adopt(String adopter){
        isAdopted=true;
        adopterName=adopter;
        
    }
    public void getDetails(){
        System.out.println("PetName: "+ name);
        System.out.println("Species: "+ species);
        System.out.println("Breed: "+ breed);
        System.out.println("Age: "+age);
        System.out.println("HealthRecord: "+healthRecord);
        if(isAdopted){
            System.out.println("Adopted: adopted");
        }
        else{
            System.out.println("Adopted: not adopted");
        }
       
            System.out.println("AdopterName: null");
        
        
    }
    public String getName(){
        return name;
    }
    public String getSpecies(){
        return species;
    }
   
    public int getAge(){
        return age;
    }
    public boolean isAvailable() {
        return !isAdopted;
    }
}
