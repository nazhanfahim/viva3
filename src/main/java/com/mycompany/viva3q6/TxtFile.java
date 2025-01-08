/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3q4;
import java.io.*;

public class TxtFile {
    public static void main(String[]args){
        String content =
                """
                Starry Night;Vincent van Gogh;1889;Painting;A famous painting that depicts a night sky swirling with stars.
                David;Michelangelo;1504;Sculpture;A marble statue representing the biblical hero David.
                The Persistence of Memory;Salvador DalA-;1931;Painting;A surreal painting featuring melting clocks.
                """;
    
        try{
            PrintWriter output = new PrintWriter(new FileOutputStream("Exhibits.txt"));
            output.print(content);
            output.close();
        }catch(IOException e){
            System.out.println("Error occurred: " + e);
        }
    }
}
