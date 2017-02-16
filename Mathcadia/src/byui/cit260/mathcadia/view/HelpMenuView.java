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
public class HelpMenuView {
    
    private String menu;
    
    public HelpMenuView(){
        this.menu = "\nHelp Menu:" +
                    "\nP - What is the purpose of the game\n" +
                    "\nM - How to move in the game\n" +
                    "\nR - Rules of the game\n" +
                    "\nQ - Return to the game";
    }
    
    public void displayHelpMenuView(){
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
