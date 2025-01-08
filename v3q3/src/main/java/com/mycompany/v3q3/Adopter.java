package com.mycompany.v3q3;
import java.util.ArrayList;
public class Adopter {
    String name, preferredSpecies, preferredAgeRange;
    
    public Adopter(String n, String s, String a){
    name=n;
    preferredSpecies=s;
    preferredAgeRange=a;
}
    public void viewMatchingPets(PetAdoptionCentre centre){
        String[] ageRange = preferredAgeRange.split("-");
        int minAge=Integer.parseInt(ageRange[0]);
        int maxAge=Integer.parseInt(ageRange[1]);
        ArrayList<Pet> pets=centre.getList();
        for(Pet pet: pets){
            if(pet.getSpecies().equalsIgnoreCase(preferredSpecies)&&pet.getAge()>=minAge&&pet.getAge()<=maxAge&&pet.isAvailable()){
                pet.adopt(name);
        
}}}
            public String getAdopter(){
    return name;
}
}
