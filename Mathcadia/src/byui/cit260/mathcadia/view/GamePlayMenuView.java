/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import buyi.cit260.mathcadia.control.GameControl;
import java.util.Scanner;


/**
 *
 * @author Brian
 */
public class GamePlayMenuView {

    private String menu;
    
    public GamePlayMenuView(){
        this.menu = "\n------------------------------"
                  + "\n|      Game Play Menu        |"
                  + "\n------------------------------"
                  + "\n V - View the map"
                  + "\n H - Hint Menu"
                  + "\n M - Move to a different location"
                  + "\n L - List of Monsters"
                  + "\n F - Monsters Found"
                  + "\n H - Help Menu"
                  + "\n Q - Quit"
                  + "\n------------------------------";
    }    
    public void GamePlayMenuView(){
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
            case "V":
                this.viewMap();
                break;
            case "C":
                this.hintMen();
                break;
            case "M":
                this.moveLocation();
                break;
            case "L":
                this.listMonsters();
                break;
            case "F":
                this.foundMonsters();
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

    private void viewMap() {
        System.out.println("\nViewing map...");
        
    }

    private void hintMen() {
        System.out.println("\nHint menu...");
    }

    private void moveLocation() {
        System.out.println("\nMove to a new location...");
    }

    private void listMonsters() {
        System.out.println("\nList of monsters...");
    }

    private void foundMonsters() {
        System.out.println("\nMonsters that have been found...");
    }


}
