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
                    "\nR - How to battle in the game\n" +
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
                this.console.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        
        
        return false;
    } 

    private void displayObjective() {
            this.console.println("\nThe purpose of the game is to improve your " +
                                "\nknowledge in algebra by answering multiple choice questions.\n" +
                                "Your study will make the game easier for you to complete the levels" +
                                "\nof the game until you finally defeat the ultimate midterm boss" +
                                "\nand become Math Master!\n");
    }

    private void displayMovement() {
        this.console.println("\nThis game moves in a linear fashion. As you defeat " +
                                "\nmonsters you will progress through the battle rooms (20 in total)." +
                                "\nYou can return to the library at any time when you're not fighting" +
                                "\nto study more. You can also explore each room one time to collect items" +
                                "\nThat will help you in your journey.\n");
    }

    public void displayRules() {

        this.console.println("\nWhen you choose to fight a monster, you will be given a multiple choice " +
                                "\nquestion. If you answer correctly you do damage to the monster. If not," +
                                "\nthen the monster will do damage to you and you will lose grade points." +
                                "\nYou will continue answering questions until either the monster's health" +
                                "\nreaches 0 or your grade drops below 70%. If this happens you will lose the" +
                                "\nGame.\n\nUse items to increase your stats in battle. Knowledge is your" +
                                "\nattack strength, Power is your defense rating. Good Luck!\n");
    }
    
}
