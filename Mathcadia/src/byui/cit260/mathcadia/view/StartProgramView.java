/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import buyi.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.model.Player;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class StartProgramView {
    
    private String promptMessage;
    Scanner userInput;
    
    public StartProgramView() {
        this.promptMessage = "\nPlease enter your name: ";
        
        // display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
                "\n********************************************************"
              + "\n*                                                      *"
              + "\n*                      MATHCADIA                       *"
              + "\n*              pronounced math - k - dia               *"
              + "\n*                                                      *"
              + "\n* You are a student of the prestigious university      *"
              + "\n* known as Mathcadia, a school that studies in the     *"
              + "\n* mystic arts of mathematics and magic. You and your   *"
              + "\n* best friend Matica (as in the software Mathematica), *"
              + "\n* work together to unlock the power of algebraic       *"
              + "\n* spells by solving problems involving different       *"
              + "\n* aspects of math. Your knowledge in the math arts     *"
              + "\n* can be used to fight monsters and unlock special     *"
              + "\n* abilities. You and Matica are both working to gain   *"
              + "\n* the title of Math Master and finally graduate from   *"
              + "\n* your studies.                                        *"
              + "\n*                                                      *"          
              + "\n* You will be studying for an exam by sparring with    *"
              + "\n* monsters. You will have to advance through 20        *"
              + "\n* different training rooms by solving math problems    *"
              + "\n* and will gain experience with each battle. As you    *"
              + "\n* defeat monsters, you will solve fewer problems.      *"
              + "\n* In the final room, you will have to face the dreaded *"
              + "\n* Math Midterm Monster!                                *"
              + "\n*                                                      *"          
              + "\n*               Have fun and good luck!                *"
              + "\n*                                                      *"
              + "\n********************************************************"  
        );
    }

    public void displayStartProgramView() {
        
        boolean done = false;
        do{
            String playersName = getPlayersName();
            if (playersName.toUpperCase().equals("Q"))
                return;
            done = this.doAction(playersName);
            
        } while(!done);
    }
    
    private String getPlayersName(){
        Scanner keyBoard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + this.promptMessage);
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
    
    public boolean doAction(String playerName){
        if (playerName.length() < 2){
            System.out.println("\nInvalid Player name: " + 
                    "the name must be greater than one character in length");
            return false;
        }
        
        Player player = GameControl.createPlayer(playerName);
        
        if (player == null){
            System.out.println("\nError creating the player");
            return false;
        }
        
        this.displayNextView(player);
        
        return true;
    }

    private void displayNextView(Player player) {
        System.out.print("\nmessage Here!");
        
        
        MainMenuView mainMenu = new MainMenuView();
        
        mainMenu.displayMainMenuView();
    }
}
