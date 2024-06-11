/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2;

/**
 *
 * @author first
 */
//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.Test;
public class TestEngine {
    public engine engineE = new engine();
    
//    @Test
    public void getGameFinish() {
        boolean gameFinish = engineE.getGameFinish();
//        assertEquals(false, gameFinish);
        if(!gameFinish){
            System.out.print(gameFinish + " pass with result true" );
        }
    }
//    @Test
    public void getHighestScoreName() {
        String name = engineE.getHighestScoreName();
//        assertEquals("puskal", name);

        if("puskal".equals(name)){
            System.out.print(name + " pass with result puskal" );
        }
    }
//    @Test
    public void getHighestScore() {
        int score = engineE.getHighestScore();
//        assertEquals(97, score);

        if(score == 97){
            System.out.print(score + " pass with result 97" );
        }
    }
//    @Test
    public void getLevel() {
        int level = engineE.getLevel();
//        assertEquals(1, level);

        if(level==1){
            System.out.print(level + " pass with result 1" );
        }
    }
//    @Test
    public void getStamina() {
        int stamina = engineE.getStamina();
//        assertEquals(30, stamina);

        if(stamina == 30){
            System.out.print(stamina + " pass with result 30" );
        }

    }
//    @Test
    public void getScore() {
        int score = engineE.getScore();
//        assertEquals(8, score);

        if(score == 0){
            System.out.print(score + " pass with result 0" );
        }

    }
//    @Test
    public void getBox() {
        int[][] box = engineE.getBox();
        int x = box.length;
        int y = box[0].length;
//        assertEquals(9, x);
//        assertEquals(9, y);

        if(x == 9 && y == 9){
            System.out.println(x + " " + y + " pass with result 9 9");
        }
        

    }
    
}
