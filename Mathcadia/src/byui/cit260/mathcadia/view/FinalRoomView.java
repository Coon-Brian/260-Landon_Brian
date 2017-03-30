/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.PuzzleControl;
import byui.cit260.mathcadia.model.Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mathcadia.Mathcadia;


/**
 *
 * @author Landon
 */
public class FinalRoomView extends View{
    

    public FinalRoomView(String filename){
       super("\n------------------------------"
                  + "\n|      Final Room Menu       |"
                  + "\n------------------------------"
                  + "\n F - Answer Question"
                  + "\n H - Help Menu"
                  + "\n S - Save Game"
                  + "\n M - Main Menu"
                  + "\n------------------------------",filename);
    }    
       

    @Override
    public boolean doAction(String menuOption) {
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "F":
                this.fightBoss();
                break;
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.display();
                break;
            case "S":
                this.saveGame();
                break;    
            case "M":
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
                break;                
            default:
                this.console.println("\n Invalid selection, Please try again.");
                break;
        }
    
        return false;
    }

    private void fightBoss() {
        try {
            this.console.println("What is your answer?");
            String answer = keyboard.readLine();
            
            if (answer.equals("5"))
                readFinalStory("text/win.txt");
            else
                readFinalStory("text/lose.txt");
            
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Error reading input");
        }
    }

    private void readFinalStory(String filename) {
        
        String storyText = "";
        File file = new File(filename);
        Scanner fileReader;
        try {
            fileReader = new Scanner(file);
            while (fileReader.hasNextLine()){
             storyText += fileReader.nextLine() + "\n";
        }
        } catch (FileNotFoundException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
        
        
        this.console.println(storyText);
        
        this.console.println("Game Over! You have finished the challenges!");
        this.console.println("Your final grade was " + Game.getPlayer().getPercent());
        
    }

    
}
