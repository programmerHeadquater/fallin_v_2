/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication2;


import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.event.EventHandler;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import static javafxapplication2.GUI.getButton;
import static javafxapplication2.GameEngine.displayBox;
import static javafxapplication2.GameEngine.movePlayer;
import static javafxapplication2.GameEngine.positionX;
import static javafxapplication2.GameEngine.positionY;
import static javafxapplication2.GameEngine.setBox;
import static javafxapplication2.GameEngine.setPrize;
import static javafxapplication2.GameEngine.setTrap;
public class main extends Application {
       
   public Controller controller = new Controller();
    @Override
    public void start(Stage primaryStage) {
       
       Pane topPane;
       Pane middlePane;
       Pane bottomPane;
       
       topPane = GUI.getTopPane();
       middlePane = GUI.getMiddlePane();
       bottomPane = new Pane();
       
       topPane.setVisible(false);
       middlePane.setVisible(false);
               bottomPane.setVisible(false);
       Pane name = new Pane();
       
       Button nameOk;
       nameOk = getButton("Ok",200,0);
       Text enterName = new Text("Enter you Name");
       TextField textField = new TextField();
       textField.setPromptText("Enter your name");
       name.getChildren().addAll(enterName,textField,nameOk);
       
       nameOk.setOnAction(e -> {
           String playerName = textField.getText();
           if(" ".equals(playerName)){
               
           }else{
               controller.setPlayerName(playerName);
               name.setVisible(false);
               topPane.setVisible(true);
               middlePane.setVisible(true);
               bottomPane.setVisible(true);
           }
       });
       
       Button up , down , right , left , start , reset, next;
       
       up = getButton("up",40,20);
       down = getButton("down",90,20);
       right = getButton("right",160,20);
       left = getButton("left",220,20);
       start = getButton("start",110,70);
       reset = getButton("reset", 110,70);
       next = getButton("Next",170,70);
       reset.setVisible(false);
       next.setVisible(false);
       
       up.setOnAction(e -> {       controller.move('w', middlePane, topPane , next);       });
       down.setOnAction(e -> {     controller.move('s',middlePane, topPane, next );       });
       right.setOnAction(e -> {    controller.move('a',middlePane, topPane , next);        });
       left.setOnAction(e -> {     controller.move('d',middlePane, topPane, next);        });
       start.setOnAction(e -> {    controller.move('p',middlePane, topPane,next);   start.setVisible(false);  reset.setVisible(true);   });
       reset.setOnAction(e -> {    controller.move('q',middlePane, topPane, next);   reset.setVisible(false);  start.setVisible(true);   });
       next.setOnAction(e -> {     controller.move('n', middlePane, topPane , next);    });
       
       bottomPane.getChildren().addAll(up, down, right, left, start , reset , next);
       VBox vbox = new VBox();
       
       
       
       vbox.setPadding(new Insets(20)); // Adjust padding here
       vbox.getChildren().addAll(name,topPane,middlePane,bottomPane);
        
        
        
        // Layout
        
        // Scene
        Scene scene = new Scene(vbox, 400, 600);

        // Stage
        primaryStage.setTitle("fallin");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
