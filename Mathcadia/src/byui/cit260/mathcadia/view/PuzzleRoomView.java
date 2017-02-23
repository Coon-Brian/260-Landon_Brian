/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import buyi.cit260.mathcadia.control.LocationControl;
import byui.cit260.mathcadia.model.Location;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Landon
 */
public class PuzzleRoomView {
    private String menu;
    private String puzzle;
    
    public PuzzleRoomView(){
        this.menu = "\n------------------------------"
                  + "\n|      Game Play Menu        |"
                  + "\n------------------------------"
                  + "\n P - Solve Puzzle"
                  + "\n L - Return to Library"
                  + "\n E - Search Room"
                  + "\n F - Save game"
                  + "\n H - Help Menu"
                  + "\n Q - Quit"
                  + "\n------------------------------";
    }    
    public void GamePlayMenuView(){
        boolean done = false;
        System.out.println("Welcome to battle room " + Location.getRoomNumber());
        do{
            String menuOption = this.getMenuOption();
            if(menuOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(menuOption);
        }while (!done);
        
    }    

    private String getMenuOption() {
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

    private boolean doAction(String menuOption) {
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "P":
                this.solvePuzzle();
                break;
            case "L":
                RoomView library;
             try {
                    library = new RoomView("text/library.txt");
                    library.displayRoomView();
                } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                }
                break;
            case "E":
                LocationControl.searchRoom();
                break;
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.displayHelpMenuView();
                break;
            case "Q":
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.displayMainMenuView();
                break;                
            default:
                System.out.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    }


    private void solvePuzzle() {
        System.out.println("Puzzle goes here");
    }
}
