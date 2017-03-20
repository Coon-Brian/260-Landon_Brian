/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import byui.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.exceptions.QuestionReaderException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Landon
 */
public class Game {

   

  
    private static Player player;
    //this array holds the experience values needed to level up
    private static int[] levelUp = { 0, 100, 300, 600, 1000, 1500, 2100, 2800 }; 

    private String gameFile;
    private Location currentRoom;
    private GameControl gameHandler;
    private ArrayList<Question> questions;
    private int bestScore;
    public static boolean endGame = false;
    
    
    
    public Game(){ 
        gameHandler = new GameControl();
        gameFile = "";
        currentRoom = new Location();
        bestScore = 0;
        try{
        questions = gameHandler.buildQuestions();
        }catch (QuestionReaderException QR){
            System.out.println(QR.getMessage());
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
    
    public String getGameFile() {
        return gameFile;
    }

    public void setGameFile(String gameFile) {
        this.gameFile = gameFile;
    }

    public Location getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Location currentRoom) {
        this.currentRoom = currentRoom;
    }

    public GameControl getGameHandler() {
        return gameHandler;
    }

    public void setGameHandler(GameControl gameHandler) {
        this.gameHandler = gameHandler;
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

    private void displayQuestions() {
        for(int i = 0; i < questions.size();i++)
        System.out.println(this.questions.get(i).getProblem());
        
        
    }
    
     @Override
    public String toString() {
        return "Game{" + "gameFile=" + gameFile + ", currentRoom=" + currentRoom + ", gameHandler=" + gameHandler + ", questions=" + questions + ", bestScore=" + bestScore + '}';
    }
}
