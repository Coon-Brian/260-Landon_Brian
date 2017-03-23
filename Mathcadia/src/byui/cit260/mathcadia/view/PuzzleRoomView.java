/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.control.LocationControl;
import byui.cit260.mathcadia.control.PuzzleControl;
import byui.cit260.mathcadia.exceptions.PuzzleControlException;
import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Location;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Landon
 */
public class PuzzleRoomView extends View {
    
    private String puzzle;
    private int roomNum;
    
    public PuzzleRoomView(int roomNum){
        
        super("\n------------------------------"
                  + "\n|      Puzzle Menu        |"
                  + "\n------------------------------"
                  + "\n P - Solve Puzzle"
                  + "\n F - Save game"
                  + "\n E - Explore Room"
                  + "\n H - Help Menu"
                  + "\n Q - Quit"
                  + "\n------------------------------");
        
        this.displayPuzzle(roomNum);
        this.roomNum = roomNum;
    }    
      


    @Override
    public boolean doAction(String menuOption) {
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "P":
                this.solvePuzzle();
                return true;
            case "S":
                this.saveGame();
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
                this.console.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    }


    private void solvePuzzle() {
        boolean passedTest = false;
        
        switch(roomNum){
            case 1:
                solvePuzzleOne();
                break;
            case 2:
                try {
                solvePuzzleTwo();
                }catch(PuzzleControlException me){
                    ErrorView.display(this.getClass().getName(),"Error with puzzle two " + me.getMessage());
                }
                break;
            case 3:
                solvePuzzleThree();
                break;
        }
    }
    
    private void solvePuzzleOne(){
        boolean passedTest = false;
        
        while(!passedTest){
            
            try{
                
                this.console.println("Enter the height of door");
                
                String userHeight = this.keyboard.readLine();
                this.console.println("Enter the bottom length of door");
                String userLength = this.keyboard.readLine();
                int height = 0;
                int length = 0;
                
                try{
                    height = Integer.parseInt(userHeight);
                    length = Integer.parseInt(userLength);
                }catch(NumberFormatException nf){
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number");
                }
                
                
                passedTest = PuzzleControl.calcDoorSize(height, length);
                if(passedTest){
                    this.console.println("You passed the test and escaped!");
                }
                else{
                    this.console.println("Incorrect: you are still trapped!");
                }
            }catch(IOException ex){
                ErrorView.display(this.getClass().getName(),"Trouble reading input:" + ex.getMessage());
            }
        }
    }
    
    private void solvePuzzleTwo() throws PuzzleControlException {
         boolean passedTest = false;
        
        
        while(!passedTest){
             try {
                 this.console.println("Enter the large number");
                 
                 String largeNum = keyboard.readLine();
                 this.console.println("Enter the potential factor");
                 String pFactor = keyboard.readLine();
                 
                 
                 
                 int otherFactor = PuzzleControl.isFactor(largeNum, pFactor);
                 passedTest = true;
                 this.console.println("you passed the test!");
             } catch (IOException ex) {
                 ErrorView.display(this.getClass().getName(),"Trouble reading input:" + ex.getMessage());
             }
            
            
        }
    }
    
    private void solvePuzzleThree(){
         boolean passedTest = false;
        
        while(!passedTest){
            try{
                this.console.println("Enter the height of door");
                
                String userHeight = keyboard.readLine();
                this.console.println("Enter the bottom length of door");
                String userLength = keyboard.readLine();
                int height = 0;
                int length = 0;
                try{
                    height = Integer.parseInt(userHeight);
                    length = Integer.parseInt(userLength);
                }catch(NumberFormatException nf){
                    ErrorView.display(this.getClass().getName(),"You must enter a valid number");
                }
                
                
                
                passedTest = PuzzleControl.calcDoorSize(height, length);
                if(passedTest){
                    this.console.println("GOOD JOB BRO!");
                }
                else{
                    this.console.println("Incorrect: you are still trapped!");
                }
            }catch(IOException ex){
                 ErrorView.display(this.getClass().getName(),"Trouble reading input:" + ex.getMessage());
            }
        }
    }

    private void displayPuzzle(int roomNum) {
        String puzzleDescription = "";
        String fileName = "text/";
        
        switch(roomNum){
            case 1:
                fileName += "puzzle01.txt"; 
                break;
            case 2:
                fileName += "puzzle02.txt";
                break;
            case 3:
                fileName += "puzzle03.txt";
                break;
                
        }
        
        File file = new File(fileName);
                Scanner fileReader;
                try {
                    fileReader = new Scanner(file);
                    while (fileReader.hasNextLine()){
                    this.roomText += fileReader.nextLine() + "\n";
                }
                } catch (FileNotFoundException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                }
    }
}
