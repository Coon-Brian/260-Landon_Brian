/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.control.LocationControl;
import byui.cit260.mathcadia.model.Game;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mathcadia.Mathcadia;

/**
 *
 * @author Brian
 */
public class MainMenuView extends View{
    boolean gameStarted;
    
    public MainMenuView(){
        super("\n------------------------------"
                  + "\n|          Main Menu         |"
                  + "\n------------------------------"
                  + "\n N - Start new game"
                  + "\n L - Load saved game or continue current game"
                  + "\n H - Help menu"
                  + "\n S - Save game"
                  + "\n E - Exit Game"
                  + "\n------------------------------");
        gameStarted = false;
    }
    
    @Override
    public boolean doAction(String menuOption){
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "N":
                this.startNewGame();
                gameStarted = true;
                break;
            case "L":
                this.loadSaveGame();
                return gameStarted;
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.display();
                break;
            case "S":
                this.saveGame();
                break;
            case "E":
                this.exitGame();
                return true;
            default:
                this.console.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    } 

    private void startNewGame() {
        
        
        GameControl.createNewGame(Game.getPlayer());
        this.console.println("\nStarting new game...\n\n");
        RoomView bedroom;
        String fileName = "bedroom.txt";
        bedroom = new RoomView("text/" + fileName);
        bedroom.display();
        
    }

    private boolean loadSaveGame() {
        
        this.console.println("\n\nEnter the file path for file where game is saved");
        
        String filePath = "";
        try {
            filePath = this.keyboard.readLine();
        } catch (IOException ex) {
           ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
        try{
            GameControl.loadGame(filePath);
            gameStarted = true;
        }catch (Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        if(!gameStarted){
            this.console.println("You have not started a game yet!");
        }
        else{
            this.console.println("\nLoading Game...\n\n");
            int roomNum = Mathcadia.getMathcadia().getRoomNumber();
            //create a view based on the location room
            //bedroom number is 25, library is 50, puzzle rooms increment by 100
            //every other room is the same number as the battle room
            switch(roomNum){
                case 25:
                    RoomView bedroom;
                    String fileName = "bedroom.txt";
                    bedroom = new RoomView("text/" + fileName);
                    bedroom.display();
                    break;
                case 50:
                    RoomView library = new RoomView("text/library.txt");
                    library.display();
                    break;
                case 100:
                    PuzzleRoomView puzzleRoom1 = new PuzzleRoomView(1);
                    puzzleRoom1.display();
                    break;
                case 200:
                    PuzzleRoomView puzzleRoom2 = new PuzzleRoomView(2);
                    puzzleRoom2.display();
                    break;
                case 300:
                    PuzzleRoomView puzzleRoom3 = new PuzzleRoomView(3);
                    puzzleRoom3.display();
                    break;
                default:
                    LocationControl.battleRoomNumber = roomNum;
                    BattleRoomView battleRoom = new BattleRoomView();
                    battleRoom.display();
            }
           
        }
            
            
        return gameStarted;
    }

   

    private void exitGame() {
        this.console.println("\nExiting game...");
        //System.exit(0);
    }
}
