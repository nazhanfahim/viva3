package com.mycompany.v3q3;
import java.util.ArrayList;
public class PetAdoptionCentre {
    
    ArrayList<Pet> pets = new ArrayList<>();
    
    
    public void addPet(Pet pet){
        pets.add(pet);
    }
    
    public void adoptPet(Pet pet, Adopter adopter){
            pet.adopt(adopter.getAdopter()); 
            
    }
    
    public void viewAvailablePets(){
        for (Pet pet:pets){
            if(pet.isAvailable()){
            pet.getDetails();}
        }
    }
    
    public Pet getPetByName(String petName){
        for (Pet pet:pets){
            if(pet.getName().contains(petName)){
            pet.getDetails();
            return pet;
        }
    }
       return null;
}
    public ArrayList<Pet> getList() {
       return pets;
   }
    
}
