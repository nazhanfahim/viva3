/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3q4;

public class Exhibit {
    String title;
    String artist;
    int year;
    String type;
    String description;
    
    public Exhibit(String title, String artist, int year, String type, String description){
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.type = type;
        this.description = description;
    }
    
    String getDetails(){
        return "Title: " + title + "\n" +
                "Artist: " + artist + "\n" +
                "Year: " + year + "\n" +
                "Type: " + type + "\n" +
                "Description: " + description + "\n";                
    }
    
    public String getArtist(){
        return artist;
    }
    
    public int getYear(){
        return year;
    }
    
    public String getType(){
        return type;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDescription(){
        return description;
    }
}
