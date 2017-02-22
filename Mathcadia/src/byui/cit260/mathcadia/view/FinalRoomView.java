/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Landon
 */
public class FinalRoomView {
    
    private String menu;

    public FinalRoomView(){
        this.menu = "\n------------------------------"
                  + "\n|      Final Room Menu       |"
                  + "\n------------------------------"
                  + "\n F - Proceed to final battle"
                  + "\n L - Back to Library"
                  + "\n H - Help Menu"
                  + "\n S - Save Game"
                  + "\n M - Main Menu"
                  + "\n------------------------------";
    }    
    public void finalMenuView(){
        boolean done = false;
        
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
           //to do: change all of these choices to match the menu and create
           //simple methods for them
            case "F":
                this.fightBoss();
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
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.displayHelpMenuView();
                break;
            case "S":
                this.saveGame();
                break;    
            case "M":
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.displayMainMenuView();
                break;                
            default:
                System.out.println("\n Invalid selection, Please try again.");
                break;
        }
    
        return false;
    }

    private void fightBoss() {
        System.out.println("\nProceeding to final battle...");
    }

    private void saveGame() {
        System.out.println("\nSaving the game from final room...");
    }
}
