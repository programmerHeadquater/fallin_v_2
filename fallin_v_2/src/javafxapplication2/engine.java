/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author first
 */
public class engine {
       String name;
       private int[][] box = new int[10][10];
       private int x;
       private int y;
       private int level;
       private int trap;
       private int prize;
       private boolean gameOver;
       private int stamina;
       private char move;
       private String condition;
       private int score;
       private boolean gameFinish;

    public engine() {
        this.x = 9;
        this.score = 0;
        this.x = 9;
        this.y = 9;
        this.level = 1;
        this.trap = level + 4; // if (trap > 1 + prize level -> abourt increament
        this.prize = 10;
        this.stamina = 30;
        this.gameOver = false;
        this.gameFinish = false;
       
       box[x][y] = 9;
    }
       
    public void setAll(){
        setBox();
        setPlayer();
        setPrize();
        setTrap();
    }
    public void setPlayer(){
        box[9][9] = 9;
    }
    public int random(){
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        
        return randomNumber;
    }
    public void setBox(){
        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
            box[i][j]= 0;
//            

            }

        }
    }
    
    private void setTrap(){
        for( int i = 0 ; i < trap ; i++){
            int ranX = random();
            int ranY = random();
            if(ranX == x && ranY == y){
                i--;
                }
            else if(ranX == 9 && ranY == 9){
                i--;
                }
            else if(box[ranX][ranY] == 0 ){
                box[ranX][ranY] = 2;
            }
            else{
                i--;
            }
        }
    }
    private void setPrize(){
       for( int i = 0 ; i < prize ; i++){
            int ranX = random();
            int ranY = random();
                        

            if(ranX == x && ranY == y){
                i--;
                continue;
            }
            if(box[ranX][ranY] == 0 ){
                box[ranX][ranY] = 1;
            }
            else{
                //decreasing loop for recall
                i--;
            }
        } 
    }
    protected void movePlayer(char move){
        this.move = move;
        switch (move) {
                    case 'a' -> {
                        
                        if( y <= 0){
                            condition = "fail";
                            break;
                        }
                        else{
                            if(box[x][y-1] == 2){
                                condition = "dead";
                                break;
                            }
                            if(box[x][y-1] == 1){
                                box[x][y] = 0;
                                box[x][y-1] = 9;
                                condition = "prize left move";
                                break;
                            }
                            box[x][y] = 0;
                            box[x][y-1] = 9;
                            condition = "left move";
                            break;
                        }   
                    }
                    case 'd' -> {
                        if( y >= 9){
                            condition = "fail";
                            break;
                        }
                        else{
                            if(box[x][y+1] == 2){
                                condition = "dead";
                                break;
                            }
                            if(box[x][y+1] == 1){
                                box[x][y] = 0;
                                box[x][y+1] = 9;
                                condition = "prize right move";
                                break;
                            }
                            box[x][y] = 0;
                            box[x][y+1] = 9;
                            condition = "right move";
                            break;
                        }   
                    }
                    case 's' -> {
                        if( x >=  9){
                            condition = "fail";
                            break;
                        }
                        else{
                            if(box[x+1][y] == 2){
                                condition = "dead";
                                break;
                            }
                            if(box[x+1][y] == 1){
                                box[x][y] = 0;
                                box[x + 1][y] = 9;
                                condition = "prize down move";
                                break;
                                
                            }
                            box[x][y] = 0;
                            box[x + 1][y] = 9;
                            condition = "down move";
                            break;
                            
                        }   
                    }   
                    //up
                    case 'w' -> {
                        if( x <= 0){
                            condition = "fail";
                            break;
                        }
                        
                        else{
                            if(box[x-1][y] == 2){
                                condition = "dead";
                                break;
                            }
                            if(box[x-1][y] == 1){
                                box[x][y] = 0;
                                box[x-1][y] = 9;
                                condition = "prize up move";
                                break;
                            }
                            box[x][y] = 0;
                            box[x-1][y] = 9;
                            condition = "up move";
                            break;
                        }   
                    }                    
                }
        
        
    }
    private void positionX(){
        if(condition.contains("up")){
            x = x-1;
            
            
        }
        if(condition.contains("down")){
            x = x + 1;
            
            
        }
       
    }
    private void positionY(){
        if(condition.contains("left")){
            y = y - 1;
            
            
        }
        if(condition.contains("right")){
            y = y + 1;
            
            
        }
       
    }
    private void gameOver(){
        if(condition.contains("dead")){
                gameOver = true;
            }
            
    }
    private void stamina(){
        
            if(condition.contains("move")){
                stamina = stamina -1; 
                if(stamina <= 0 ){
                    gameOver = true;
                }
            }
            
    }
    
    private void score(){
        
            if(condition.contains("prize")){
                score = score + 1;
            }
    }
    
    
    protected void conditionUpdate(){

            if(condition.contains("dead")){
                gameOver = true;
            }
            if(condition.contains("fail")) {
                
            }
            if(condition.contains("prize")){
                score = score + 1;
                stamina = stamina -1; 
            }
            if(condition.contains("move")){
                stamina = stamina -1; 
            }
            positionX();
            positionY();
            if(x == 0 && y == 0){
                gameFinish = true;
            }
            condition = "";
    }
    
    public int[][] getBox(){
        return box;
    }
    public int getScore(){
        return score;
    }
    public int getStamina(){
        return stamina;
    }
    public int getLevel(){
        return level;
    }
    
    public int getHighestScore(){
        String[] data = File.read();
        int highScore = Integer.parseInt(data[1]);
        if(score > highScore){
            System.out.println("on getHighestScore : ");
            File.write(name, score);
            return score;
        }
        return highScore;
    }
    public String getHighestScoreName(){
        String[] data = File.read();
        int highScore = Integer.parseInt(data[1]);
        if(score > highScore){
            return this.name;
        }
        return data[0];
    }
    
    public boolean getGameOver(){
        return gameOver;
    }
    public boolean getGameFinish(){
        return gameFinish;
    }

    
    
    public void setLevelUp(){
        level = level + 1;
        trap = trap + 2;
        gameFinish = false;
        x = 9;
        y = 9;
        score = stamina + score;
        stamina = 30;
        
    }
    public void resetAll(){
        this.x = 9;
        this.score = 0;
        this.x = 9;
        this.y = 9;
        this.level = 1;
        this.trap = level + 4; // if (trap > 1 + prize level -> abourt increament
        this.prize = 10;
        this.stamina = 30;
        this.gameOver = false;
        setBox();
    }
    public void setGameFinishFasle(){
        gameFinish = false;
    }
    public void setPlayerName(String name){
        this.name = name;
    }
    
}
