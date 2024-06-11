package javafxapplication2;


/*


 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author first
 */

import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class Controller {
    
    private engine engineE = new engine();
    
    public Controller(){
        
    }
    public void setPlayerName(String name){
        engineE.setPlayerName(name);
    }
    
    public  void move(char move, Pane middlePane , Pane topPane , Button next){
        middlePane.getChildren().clear();
        topPane.getChildren().clear();
        int[][] box;
                    
        switch (move) {
            //q for reset
            case 'q':
                engineE.resetAll();
                box = engineE.getBox();
                middlePane = GUI.getMiddlePane(box , middlePane);
                                    
                break;
            // p for start
            case 'p':
                engineE.setAll();
                box = engineE.getBox();
                middlePane = GUI.getMiddlePane(box , middlePane);
                                                
                break;
            case 'n':
                next.setVisible(false);
                box = engineE.getBox();
                middlePane = GUI.getMiddlePane(box , middlePane);
                break;
            case 'a':
            case 'w':
            case 's':
            case 'd':
                engineE.movePlayer(move);
                engineE.conditionUpdate();
                box = engineE.getBox();
                middlePane = GUI.getMiddlePane(box , middlePane);
                
                break;
        }
        
                    
        
        if(engineE.getGameOver() == true){
            
            engineE  = new engine();
            System.out.println("empty");
            middlePane.getChildren().clear();
            Label gameOver = GUI.label("Game Over", 30, 30);
            middlePane.getChildren().add(gameOver);
        }
        
        if(engineE.getGameFinish()){
            engineE.setLevelUp();
            engineE.setAll();
            engineE.setGameFinishFasle();
            
            
            box = engineE.getBox();
            middlePane = GUI.getMiddlePane(box , middlePane);
            

            Label gameFinish = GUI.label("Game Finish", 30, 30);  
            
            next.setVisible(true);
            
            middlePane.getChildren().clear();
            middlePane.getChildren().addAll(gameFinish);
        }
        
        int score , stamina , level , highScore;
        String name;
        score = engineE.getScore();
        stamina = engineE.getStamina();
        level = engineE.getLevel();
        highScore = engineE.getHighestScore();
        name = engineE.getHighestScoreName();
        
        
        GUI.getTopPane(topPane, score, stamina, level, highScore ,name);
    }
   
}
