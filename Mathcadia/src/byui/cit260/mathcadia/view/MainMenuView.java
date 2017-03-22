/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.model.Game;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
            default:
                System.out.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    } 

    private void startNewGame() {
        
        
        GameControl.createNewGame(Game.getPlayer());
        
        RoomView bedroom;
        String fileName = "bedroom.txt";
        bedroom = new RoomView("text/" + fileName);
        bedroom.display();
        
    }

    private boolean loadSaveGame() {
        
        if(!gameStarted){
            System.out.println("You have not started a game yet!");
        }
        else
            System.out.println("\nContinuing game...");
        return gameStarted;
    }

    private void saveGame() {
        System.out.println("\nSaving game...");
    }

    private void exitGame() {
        System.out.println("\nExiting game...");
        System.exit(0);
    }
}
