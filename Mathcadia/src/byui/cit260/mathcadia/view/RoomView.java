/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.control.LocationControl;
import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Library;
import java.util.Scanner;

/**
 *
 * @author Landon
 */
public class RoomView extends View {
    
    private String currentFile;
    private boolean read;
    private boolean searched;
    
    public RoomView(String filename){
       super("\n------------------------------"
                  + "\n|          Main Menu         |"
                  + "\n------------------------------"
                  + "\n L - Go to Library"
                  + "\n B - Go to battle Room"
                  + "\n E - Explore Room"
                  + "\n H - Help menu"
                  + "\n S - Save game"
                  + "\n Q - Exit Room"
                  + "\n I - Display inventory"
                  + "\n------------------------------", filename);
        
       currentFile = filename;
       read = false;
       searched = false;
    }
    
    
    
    @Override
    public String getInput(){
        Scanner keyBoard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        
        
        
        while (!valid){
            //here we are checking if the player is currently
            //in the library, if they are display alternative menu
            if("text/library.txt".equals(currentFile) && !read){
            this.displayLibraryMenu();
            read = true;
        } else{
            System.out.println("\n" + this.displayMessage);
            value = keyBoard.nextLine();
            value = value.trim();
            if (value.length() < 1){
                System.out.println("\nInvald value: value cannot be blank");
                continue;
            }
            break;
        }
        }
        return value;
        
        
    }
    
    @Override
    public boolean doAction(String menuOption){
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "L":
                //read the file from our text directory
                RoomView library = new RoomView("text/library.txt");
                library.display();
                break;
            case "B":
                BattleRoomView battleRoom = new BattleRoomView();
                battleRoom.display();
                break;
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.display();
                break;
            case "S":
                GameControl.saveGame(Game.getPlayer());
                break;
            case "Q":
                this.exitGame();
                break;
            case "E":
                if(!searched){
                LocationControl.searchRoom();
                searched = true;
                }
                else{
                    System.out.println("You've already searched this room!");
                }
                break;
            case "I":
                Game.getPlayer().displayInventory();
                break;
            default:
                System.out.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    } 
    
    private void exitGame(){
        
    }

    private void displayLibraryMenu() {
        System.out.println("Read from the Library? (y/n)");
        Scanner keyBoard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid){
            value = keyBoard.nextLine();
            value = value.trim();
            if (value.length() < 1){
                System.out.println("\nInvald value: value should be Y or N");
                continue;
            }
            break;
        }
        
        switch(value.toUpperCase()){
            case "Y":
                Library library = new Library();
                library.openWebBrowser();
                System.out.println("Once you're done reading, head to the battle room!");
                break;
            case "N":
                System.out.println("Well then let's go fight");
                break;
            default:
                System.out.println("\nInvald value: value should be Y or N");
                break;
        }
    }
}
