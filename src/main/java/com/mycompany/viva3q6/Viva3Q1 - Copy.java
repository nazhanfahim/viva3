/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva3.q1;
import java.util.*;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class Viva3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a PotionContainer object to manage potions
        PotionContainer container = new PotionContainer();

        // Adding potions to the container
        System.out.println("Adding potions to the container...");
        container.addPotion("Unicorn Tears", 200.0); // Add 200 ml of Unicorn Tears
        container.addPotion("Dragon Blood", 150.0); // Add 150 ml of Dragon Blood
        System.out.println("Potion container successfully initialized.\n");

        // Using potions
        System.out.println("=== Using Potions ===");
        container.usePotion("Unicorn Tears", 50.0); // Use 50 ml of Unicorn Tears
        System.out.println("Remaining volume of Unicorn Tears: " +
                           container.getRemainingVolume("Unicorn Tears") + " ml"); // Display remaining volume
        container.usePotion("Dragon Blood", 30.0); // Use 30 ml of Dragon Blood
        System.out.println("Remaining volume of Dragon Blood: " +
                           container.getRemainingVolume("Dragon Blood") + " ml"); // Display remaining volume

        // Attempting to use more potion than available
        System.out.println("\nAttempting to use more Dragon Blood than available...");
        container.usePotion("Dragon Blood", 200.0); // Try to use more Dragon Blood than exists
        System.out.println("Remaining volume of Dragon Blood: " +
                           container.getRemainingVolume("Dragon Blood") + " ml"); // Display remaining volume

        // Checking availability for brewing the Invisibility Draught
        System.out.println("\n=== Checking Potion Availability for Invisibility Draught ===");
        double requiredUnicornTears = 200.0; // Amount of Unicorn Tears required
        double requiredDragonBlood = 150.0; // Amount of Dragon Blood required
        boolean readyForInvisibilityDraught =
            container.isEnoughForPotion(requiredUnicornTears, requiredDragonBlood); // Check if requirements are met
        
        System.out.println("\nCan prepare Invisibility Draught?");
        if (readyForInvisibilityDraught) {
            // If enough ingredients are available
            System.out.println("Yes, we have enough Unicorn Tears and Dragon Blood!");
        } else {
            // If not enough ingredients are available
            System.out.println("No, we do not have enough ingredients to prepare the Invisibility Draught.");
        }

        // Print the final state of the potion inventory
        System.out.println("\nFinal state of the potion container:");
        container.printPotions(); // Display all potions in the container
     
    }
}


// Class to represent a single potion
class Potion {
    private String ingredient; // Name of the potion ingredient
    private double volume; // Volume of the potion

    // Constructor to initialize potion attributes
    public Potion(String ingredient, double volume) {
        this.ingredient = ingredient; // Set ingredient name
        this.volume = volume; // Set potion volume
    }

    // Getter for the ingredient name
    public String getIngredient() {
        return ingredient;
    }

    // Getter for the potion volume
    public double getVolume() {
        return volume;
    }

    // Method to consume a specified amount of the potion
    public void consume(double amount) {
        if (amount <= volume) {
            // Reduce the potion volume if enough is available
            volume -= amount;
        } else {
            // Print a message if not enough potion is available
            System.out.println("Not enough " + ingredient + " to consume " + amount + " ml.");
        }
    }
}




// Class to manage a collection of potions
class PotionContainer {
    private HashMap<String, Double> potions = new HashMap<>(); // HashMap to store potion names and their volumes

    // Method to add a potion to the container
    public void addPotion(String name, double volume) {
        potions.put(name, potions.getOrDefault(name, 0.0) + volume); // Add or update the potion volume
        System.out.println(volume + " ml of " + name + " added."); // Display a confirmation message
    }

    // Method to use a potion from the container
    public void usePotion(String name, double volume) {
        if (potions.containsKey(name)) { // Check if the potion exists in the container
            double currentVolume = potions.get(name); // Get the current volume of the potion
            if (currentVolume >= volume) {
                // Deduct the requested volume if sufficient amount exists
                potions.put(name, currentVolume - volume);
                System.out.println(volume + " ml of " + name + " used."); // Display usage confirmation
            } else {
                // Print a message if insufficient amount exists
                System.out.println("Not enough " + name + " available.");
            }
        } else {
            // Print a message if the potion does not exist in the container
            System.out.println(name + " is not in the container.");
        }
    }

    // Method to get the remaining volume of a specific potion
    public double getRemainingVolume(String name) {
        return potions.getOrDefault(name, 0.0); // Return the volume or 0.0 if the potion does not exist
    }

    // Method to check if enough potions are available to brew a specific potion
    public boolean isEnoughForPotion(double requiredUnicornTears, double requiredDragonBlood) {
        double unicornTears = potions.getOrDefault("Unicorn Tears", 0.0); // Get current Unicorn Tears volume
        double dragonBlood = potions.getOrDefault("Dragon Blood", 0.0); // Get current Dragon Blood volume
        return unicornTears >= requiredUnicornTears && dragonBlood >= requiredDragonBlood; // Check if sufficient
    }

    // Method to print all potions and their volumes
    public void printPotions() {
        System.out.println("\n=== Potion Inventory ==="); // Print header
        List<String> keys = new ArrayList<>(potions.keySet()); // Convert HashMap keys to a list
        for (int i = 0; i < keys.size(); i++) {
            // Iterate through the list and display potion name and volume
            String name = keys.get(i);
            System.out.println(name + ": " + potions.get(name) + " ml");
        }
    }
}



