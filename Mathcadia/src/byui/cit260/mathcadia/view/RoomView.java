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
import java.io.IOException;
import mathcadia.Mathcadia;

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
                  + "\n|          Room Menu         |"
                  + "\n------------------------------"
                  + "\n L - Read from Library"
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
        
        String value = "";
        boolean valid = false;
        
        
        
        
        while (!valid){
            //here we are checking if the player is currently
            //in the library, if they are display alternative menu
            if("text/library.txt".equals(currentFile) && !read){
            this.displayLibraryMenu();
            read = true;
        } else{
                //let the user know they are in the bedroom
                if(!"text/library.txt".equals(currentFile))
                    this.console.print("\n" + "You are currently in the Bedroom");
                //display normal message
            this.console.println(this.displayMessage);
                try {
                    value = keyboard.readLine();
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(),"Trouble reading input:" + ex.getMessage());
                }
            value = value.trim();
            if (value.length() < 1){
                this.console.println("\nInvald value: value cannot be blank");
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
                this.saveRoom();
                this.saveGame();
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
                    this.console.println("You've already searched this room!");
                }
                break;
            case "I":
                Game.getPlayer().displayInventory();
                break;
            default:
                this.console.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    } 
    
    private void exitGame(){
        
    }

    private void displayLibraryMenu() {
        this.console.println("Read from the Library? (y/n)");
      
        String value = "";
        boolean valid = false;
        
        while (!valid){
            try {
                value = keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"Trouble reading input:" + ex.getMessage());
            }
            value = value.trim();
            if (value.length() < 1){
                this.console.println("\nInvald value: value should be Y or N");
                continue;
            }
            break;
        }
        
        switch(value.toUpperCase()){
            case "Y":
                Library library = new Library();
                library.openWebBrowser();
                this.console.println("Once you're done reading, head to the battle room!");
                break;
            case "N":
                this.console.println("Well then let's go fight");
                break;
            default:
                this.console.println("\nInvald value: value should be Y or N");
                break;
        }
    }

    private void saveRoom() {
        
        this.console.println(Mathcadia.getMathcadia().getRoomNumber());
        //if the room is the library, save room as 50
       if("text/library.txt".equals(currentFile)){
           Mathcadia.getMathcadia().setRoomNumber(50);
       }
       //else set it to the bedroom number of 25
       else{
           Mathcadia.getMathcadia().setRoomNumber(25);
       }
    }
}
