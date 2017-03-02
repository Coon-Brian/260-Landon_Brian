/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class HelpMenuView extends View{
    
    
    public HelpMenuView(){
        super("\nHelp Menu:" +
                    "\nP - What is the purpose of the game\n" +
                    "\nM - How to move in the game\n" +
                    "\nR - Rules of the game\n" +
                    "\nQ - Return to the game");
    }
    
   
    @Override
    public boolean doAction(String menuOption){
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "P":
                this.displayObjective();
                break;
            case "M":
                this.displayMovement();
                break;
            case "R":
                this.displayRules();
                break;
            case "Q":
                //return to previous menu
                return true;
            default:
                System.out.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        
        
        return false;
    } 

    private void displayObjective() {
            
    }

    private void displayMovement() {

    }

    private void displayRules() {

    }
    
}
