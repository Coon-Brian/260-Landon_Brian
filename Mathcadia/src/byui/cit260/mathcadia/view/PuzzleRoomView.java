/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.control.LocationControl;
import byui.cit260.mathcadia.control.PuzzleControl;
import byui.cit260.mathcadia.model.Game;
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
                  + "\n|      Puzzle Menu        |"
                  + "\n------------------------------"
                  + "\n P - Solve Puzzle"
                  + "\n F - Save game"
                  + "\n E - Explore Room"
                  + "\n H - Help Menu"
                  + "\n Q - Quit"
                  + "\n------------------------------", "text/puzzle01.txt");
    }    
      


    @Override
    public boolean doAction(String menuOption) {
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "P":
                this.solvePuzzle();
                break;
            case "S":
                GameControl.saveGame(Game.getPlayer());
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
        boolean passedTest = false;
        
        while(!passedTest){
            System.out.println("Enter the height of door");
            Scanner keyBoard = new Scanner(System.in);
            int height = keyBoard.nextInt();
            System.out.println("Enter the bottom length of door");
            int length = keyBoard.nextInt();



            passedTest = PuzzleControl.calcDoorSize(height, length);
            if(passedTest){
                System.out.println("GOOD JOB BRO!");
            }
            else{
                System.out.println("Incorrect: you are still trapped!");
            }
        }
    }
}
