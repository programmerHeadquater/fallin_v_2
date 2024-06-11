/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import java.io.File;

public  class GUI{
    
    public static Pane getTopPane(){
        Pane topPane = new Pane();
        topPane.setPadding(new Insets(20)); // Adjust padding her
        Label score, stamina , level , highestScore, highestScoreName;
        
        score = label("SCORE : ", 0 ,0);
        stamina = label("STAMINA: ", 0 , 30);
        level = label("LEVEL : ", 0 , 60);
        highestScoreName = label("Name: " , 150 , 0);
        highestScore = label("HIGHEST SCORE: ", 150 , 30);
        
        topPane.getChildren().addAll(score,stamina,level,highestScoreName,highestScore);
        
        
        
        
        return topPane;
    }
    public static Pane getMiddlePane(){
        //create Pane;
        int width = 30;
        int height = 30;
        Pane topPane = new Pane();
        for(int i =0 ; i < 10 ; i ++){
            for( int j = 0; j < 10 ; j++ ){
                // Create a rectangle
                Rectangle rectangle = new Rectangle(100, 100, 200, 150); // x, y, width, height
                rectangle.setX(j * width); // Set x coordinate
                rectangle.setY(i * height); // Set y coordinate
                rectangle.setWidth(30); // Set width
                rectangle.setHeight(30); // Set height
                rectangle.setFill(Color.BLUE); // Set the fill color
                rectangle.setStroke(Color.BLACK); // Set the border color

                // add to pane;
                topPane.getChildren().add(rectangle);
            }
        }
        return topPane;
    }
    
    public static Pane getBottomPane(){
        Pane bottomPane = new Pane();
        Button right , left , up , down , start ;
        
        up = getButton("up",80,0);
        down = getButton("down",80,30);
        right = getButton("right",60,20);
        left = getButton("left",120,20);
        start = getButton("start",110,70);
        
        bottomPane.getChildren().addAll(up,down,left,right,start);
        return bottomPane;
    }
    
    public  static Label label(String info , int x , int y){
        
        Label messageLabel = new Label(info);
        messageLabel.setWrapText(true); // Enable text wrapping
        messageLabel.setAlignment(Pos.CENTER); // Center align the text
        messageLabel.setLayoutX(x); // Adjust x position
        messageLabel.setLayoutY(y); // Adjust ygr position
        messageLabel.setFont(Font.font("Arial", 16));
        return messageLabel;
    }
    public static Button getButton(String name , int x , int y){
        
        
        Button button = new Button(name);
        button.setLayoutX(x); // Set X position
        button.setLayoutY(y);  // Set Y position
        
        return button;
    }
    
    
    public static Pane getMiddlePane(int[][] box , Pane middlePane){
        //create Pane;
        int width = 30;
        int height = 30;
        Pane resetMiddlePane;
        resetMiddlePane  = middlePane;
        for(int i =0 ; i < 10 ; i ++){
            for( int j = 0; j < 10 ; j++ ){
                // Create a rectangle
                
                Rectangle rectangle = new Rectangle(100, 100, 200, 150); // x, y, width, height
                rectangle.setX(j * width); // Set x coordinate
                rectangle.setY(i * height); // Set y coordinate
                rectangle.setWidth(30); // Set width
                rectangle.setHeight(30); // Set height
                rectangle.setStroke(Color.BLACK); // Set the border color
                
//                empty
                
                if(box[i][j] == 0){
                    rectangle.setFill(Color.WHITE); // Set the fill color
                }
//                prize
                if(box[i][j] == 1){
                    rectangle.setFill(Color.GREEN); // Set the fill color
                }
                //trap
                if(box[i][j] == 2){
                

                    rectangle.setFill(Color.RED); // Set the fill color
                }
                //player
                if(box[i][j] == 9){
                    
                    rectangle.setFill(Color.BLUE); // Set the fill color
//                    Image man = new Image("C:/Users/first/Documents/NetBeansProjects/JavaFXApplication2/man.gif"); 
//                    ImageView imageView = new ImageView(man);
//                    imageView.setLayoutX(j * width);
//                    imageView.setLayoutY(i * height);
//                    resetMiddlePane.getChildren().add(imageView);
                }
                
                

                // add to pane;
                resetMiddlePane.getChildren().add(rectangle);
            }
        }
        return resetMiddlePane;
    }
    
    public static void getTopPane(Pane topPane, int score, int stamina, int level , int highScore, String name){
        
        topPane.setPadding(new Insets(20)); // Adjust padding her
        Label scoreL, staminaL , levelL , highestScoreL , highestScoreNameL;
        
        scoreL = label("SCORE : " + score, 0 ,0);
        staminaL = label("STAMINA: " + stamina, 0 , 30);
        levelL = label("LEVEL : " + level, 0 , 60);
        highestScoreNameL = label("Name : " + name, 150 , 0);
        highestScoreL = label("HIGHEST SCORE: " + highScore, 150 , 30);
        topPane.getChildren().addAll(scoreL,staminaL,levelL,highestScoreNameL,highestScoreL);
        
        
    }
}
