/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import buyi.cit260.mathcadia.control.GameControl;
import buyi.cit260.mathcadia.control.LocationControl;
import byui.cit260.mathcadia.model.Library;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import mathcadia.Mathcadia;

/**
 *
 * @author Landon
 */
public class RoomView {
    
    private String menu;
    private String roomText = "";
    private String currentFile = "";
    
    public RoomView(String filename) throws FileNotFoundException{
        
        this.currentFile = filename;
        
        this.menu = "\n------------------------------"
                  + "\n|          Main Menu         |"
                  + "\n------------------------------"
                  + "\n L - Go to Library"
                  + "\n B - Go to next battle Room"
                  + "\n F - Explore Room"
                  + "\n H - Help menu"
                  + "\n S - Save game"
                  + "\n E - Exit Game"
                  + "\n------------------------------";
        
        File file = new File(filename);
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextLine()){
            this.roomText += fileReader.nextLine() + "\n";
        }
        
    }
    
    public void displayRoomView() throws FileNotFoundException{
        boolean done = false;
        System.out.print(roomText);
        
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
        
        //here we are checking if the player is currently
        //in the library, if they are display alternative menu
        if("text/library.txt".equals(currentFile)){
            this.displayLibraryMenu();
        }
        
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
    
    private boolean doAction(String menuOption) throws FileNotFoundException{
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "L":
                //read the file from our text directory
                RoomView library = new RoomView("text/library.txt");
                library.displayRoomView();
                break;
            case "B":
                //get the file from Location Control, this changes everytime 
                //it is used and takes the player to the next room
                String fileName = LocationControl.getBattleLocationFile();
                RoomView battleRoom = new RoomView("text/" + fileName);
                battleRoom.displayRoomView();
                break;
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.displayHelpMenuView();
                break;
            case "S":
                GameControl.saveGame(Mathcadia.getPlayer());
                break;
            case "E":
                this.exitGame();
                break;
            case "F":
                LocationControl.searchRoom();
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
                break;
            case "N":
                System.out.println("Well then let's go fight");
                break;
        }
    }
}
