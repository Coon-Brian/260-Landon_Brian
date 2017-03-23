/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import byui.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.exceptions.QuestionReaderException;
import byui.cit260.mathcadia.view.ErrorView;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Landon
 */
public class Game implements Serializable {

  
    private static Player player;
    //this array holds the experience values needed to level up
    private static int[] levelUp = { 0, 100, 300, 600, 1000, 1500, 2100, 2800 }; 
    private int roomNumber;
    private ArrayList<Question> questions;
    private int bestScore;
    public static boolean endGame = false;
    
    
    
    public Game(){ 
        bestScore = 0;
        roomNumber = 25;
        try{
        questions = GameControl.buildQuestions();
        }catch (QuestionReaderException QR){
            ErrorView.display(this.getClass().getName(), QR.getMessage());
        }
        
    }
    
    //non-default contructor
    public Game(Player player){
        
    }
    
      public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Game.player = player;
    }
  

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
    
    
    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
    
    
    public static int[] getLevelUp() {
        return levelUp;
    }
    
     public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    //for debugging
    private void displayQuestions() {
        for(int i = 0; i < questions.size();i++)
        System.out.println(this.questions.get(i).getProblem());
        
        
    }
    
      @Override
    public String toString() {
        return "Game{" + "player=" + player + ", roomNumber=" + roomNumber + ", questions=" + questions + ", bestScore=" + bestScore + '}';
    }
}
