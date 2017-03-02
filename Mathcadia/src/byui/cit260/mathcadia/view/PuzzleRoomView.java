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

/**
 *
 * @author Landon
 */
public class PuzzleRoomView extends View {
    
    private String puzzle;
    
    public PuzzleRoomView(){
        super("\n------------------------------"
                  + "\n|      Game Play Menu        |"
                  + "\n------------------------------"
                  + "\n P - Solve Puzzle"
                  + "\n L - Return to Library"
                  + "\n E - Search Room"
                  + "\n F - Save game"
                  + "\n H - Help Menu"
                  + "\n Q - Quit"
                  + "\n------------------------------");
    }    
      


    @Override
    public boolean doAction(String menuOption) {
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "P":
                this.solvePuzzle();
                break;
            case "L":
                RoomView library;
                library = new RoomView("text/library.txt");
                library.display();
                break;
            case "E":
                LocationControl.searchRoom();
                break;
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.display();
                break;
            case "Q":
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
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
