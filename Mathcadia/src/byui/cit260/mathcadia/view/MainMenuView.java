/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import buyi.cit260.mathcadia.control.GameControl;
import java.util.Scanner;
import mathcadia.Mathcadia;

/**
 *
 * @author Brian
 */
public class MainMenuView {
    
    private String menu;
    
    public MainMenuView(){
        this.menu = "\n------------------------------"
                  + "\n|          Main Menu         |"
                  + "\n------------------------------"
                  + "\n N - Start new game"
                  + "\n L - Load saved game"
                  + "\n H - Help menu"
                  + "\n S - Save game"
                  + "\n E - Exit Game"
                  + "\n------------------------------";
    }
    
    public void displayMainMenuView(){
        boolean done = false;
        
        do{
            String menuOption = this.getMenuOption();
            if(menuOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(menuOption);
        }while (!done);
        
        
    }
    
    private String getMenuOption(){
        Scanner keyBoard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + this.menu);
            value = keyBoard.nextLine();
            value = value.trim();
            if (value.length() < 1){
                System.out.println("\nInvald value: value cannot be blank");
                continue;
            }
            break;
        }
        return value;
    }
    
    private boolean doAction(String menuOption){
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
                help.displayHelpMenuView();
                break;
            case "S":
                this.saveGame();
                break;
            case "E":
                this.exitGame();
                break;
            default:
                System.out.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    } 

    private void startNewGame() {
        GameControl.createNewGame(Mathcadia.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
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
