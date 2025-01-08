/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3q4;
import java.io.*;
import java.util.*;

public class Museum {
    ArrayList<Exhibit> collection;
    
    public Museum(){
        this.collection = new ArrayList<>();
    }
    
    public void loadExhibits(String filename) { 
        try {
            Scanner input = new Scanner(new FileInputStream(filename));
            while(input.hasNextLine()) {
                String line = input.nextLine();
                //one line = one item; split parts of the item
                String []parts = line.split(";", 5);
                if(parts.length == 5) {
                    String title = parts[0].trim();
                    String artist = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    String type = parts[3].trim();
                    String description = parts[4].trim();         
                    
                    //put everything into arraylist collection
                    collection.add(new Exhibit(title, artist, year, type, description));
                }
                else{
                    System.out.println("Invalid line: " + line);
                }
            }            
            input.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public void searchExhibitsByArtist(String artist){
        for(Exhibit exhibit : collection){
            if(exhibit.getArtist().equalsIgnoreCase(artist)){
                System.out.println(exhibit.getDetails());
            }
        }
    }
    
    public void searchExhibitsByType(String type) {
        for(Exhibit exhibit : collection){
            if(exhibit.getType().equalsIgnoreCase(type)){
                System.out.println(exhibit.getDetails());
            }
        }
    }
    
    public void searchExhibitsByYear(int year) {
        for(Exhibit exhibit : collection){
            if(exhibit.getYear()==year){
                System.out.println(exhibit.getDetails());
            }
        }
    }
    
    public void viewAllExhibits(){
        for(Exhibit exhibit : collection){
            System.out.println(exhibit.getDetails());
        }
    }
    
    public void searchExhibitsByTitle(String title) {
        for(Exhibit exhibit : collection){
            if(exhibit.getTitle().equalsIgnoreCase(title)){
                System.out.println(exhibit.getDetails());
            }
        }
    }
    
    public void searchExhibitsByDescription(String description) {
        for(Exhibit exhibit : collection){
            if(exhibit.getDescription().equalsIgnoreCase(description)){
                System.out.println(exhibit.getDetails());
            }
        }
    }
}
