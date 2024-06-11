/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2;

/**
 *
 * @author first
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class File {
    public static String[] read(){
        String[] line = new String[4];
        
        try {
            // Create a BufferedReader object to read from the file
            BufferedReader reader = new BufferedReader(new FileReader("highScore"));

            // Read each line from the file and print it
            int i = 0;
            while ((line[i] = reader.readLine()) != null) {
                i++;
            }

            // Close the reader to release resources
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return line;
    }
    public static void write(String name , int score){
        // Create a BufferedWriter object to write to the file
            
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("HighScore"));

            // Write some text to the file
            writer.write(name + " \n");
            writer.write(score + "\n");

            // Close the writer to release resources
            writer.close();

            System.out.println("Data has been written to : "+name + " " + score );
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void check(){
        String[] line;
        write("puskal",50);
        line = read();
        System.out.println(line[0] + "line 0");
        System.out.println(line[1] + "line 1");
    }
    public static void main(String arg[]){
        check();
    }
}
