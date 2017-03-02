/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import buyi.cit260.mathcadia.control.GameControl;
import java.io.FileNotFoundException;
import java.util.Scanner;
import mathcadia.Mathcadia;

/**
 *
 * @author Brian
 */
public class MainMenuView extends View{
    
    public MainMenuView(){
        super("\n------------------------------"
                  + "\n|          Main Menu         |"
                  + "\n------------------------------"
                  + "\n N - Start new game"
                  + "\n L - Load saved game"
                  + "\n H - Help menu"
                  + "\n S - Save game"
                  + "\n E - Exit Game"
                  + "\n------------------------------");
    }
    
    @Override
    public boolean doAction(String menuOption){
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "N":
                this.startNewGame();
                break;
            case "L":
                this.loadSaveGame();
                break;
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
                System.out.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    } 

    private void startNewGame() {
        GameControl.createNewGame(Mathcadia.getPlayer());
        
        RoomView bedroom;
        String fileName = "bedroom.txt";
        bedroom = new RoomView("text/" + fileName);
        bedroom.display();
        
    }

    private void loadSaveGame() {
        System.out.println("\nLoading game...");
    }

    private void saveGame() {
        System.out.println("\nSaving game...");
    }

    private void exitGame() {
        System.out.println("\nExiting game...");
    }
}
