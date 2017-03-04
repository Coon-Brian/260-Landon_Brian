/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import buyi.cit260.mathcadia.control.GameControl;
import java.util.List;

/**
 *
 * @author Landon
 */
public class Game {

  
    private static Player player;
    private String gameFile;
    private Location currentRoom;
    private GameControl gameHandler;
    private List<Question> questions;
    
    
    public Game(){ 
        gameHandler = new GameControl();
        questions = gameHandler.buildQuestions();
        
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    private void displayQuestions() {
        for(int i = 0; i < questions.size();i++)
        System.out.println(this.questions.get(i).getProblem());
        
        
    }
}
