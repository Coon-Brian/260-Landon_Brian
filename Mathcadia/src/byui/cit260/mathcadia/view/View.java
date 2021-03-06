
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.GameControl;
import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Item;
import byui.cit260.mathcadia.model.Player;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mathcadia.Mathcadia;

/**
 *
 * @author Brian
 */
public abstract class View implements ViewInterface{
    
    protected String displayMessage;
    protected String roomText = "";
    protected boolean searched;
    
    protected final BufferedReader keyboard = Mathcadia.getInFile();
    protected final PrintWriter console = Mathcadia.getOutFile();
    
    public View(){
    }
    public View(String message){
        this.displayMessage = message;
    }
    public View(String menu, String fileName){
        displayMessage = menu;
        
         File file = new File(fileName);
        Scanner fileReader;
        try {
            fileReader = new Scanner(file);
            while (fileReader.hasNextLine()){
            this.roomText += fileReader.nextLine() + "\n";
        }
        } catch (FileNotFoundException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
        
        
    }
    
    @Override
    public void display(){  //code copied from displayMainMenuView()
        boolean done = false;
        if (roomText != null)
            this.console.println(roomText);
        
        do{
            String menuOption = this.getInput(); // created method to resolve error message (see below)
            if(menuOption.toUpperCase().equals("Q"))  // not sure if it was the right thing to do. 
                return;
            
            done = this.doAction(menuOption);
        }while (!done);
        
    } 
    @Override
    public String getInput(){ // code copied from displayMainMenuView()
        
        String value = "";
        boolean valid = false;
        
        while (!valid){
            this.console.println("\n" + this.displayMessage); // created field "menu" to resolve error
            try {
                value = this.keyboard.readLine();
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
        return value;
    }    
    
    protected void saveGame() {
        this.console.println("\n\nEnter the file path for file where the game "
        + "is to be saved.");
        
        String filePath = "";
        try {
            filePath = this.keyboard.readLine();
        } catch (IOException ex) {
           ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
        try{
            GameControl.saveGame(Mathcadia.getMathcadia(), filePath);
        }catch(Exception ex){
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
        
    }
    
    protected void printPlayerInventory(){
         this.console.println("\n\nEnter the file path for file where the player's "
        + "stats will be printed.");
        
        String filePath = "";
        try {
            filePath = this.keyboard.readLine();
        } catch (IOException ex) {
           ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
        try{
            this.writeInventory(filePath);
        }catch(Exception ex){
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    private void writeInventory(String filePath) {
        PrintWriter inventoryWriter = null;
        try {
            //get lists of hero stats
            Player hero = Game.getPlayer();
            
            //create printwrite to write to specified file
            inventoryWriter = new PrintWriter(filePath);
            
             inventoryWriter.println( hero.getName() + "'s Inventory:" + System.lineSeparator());
             inventoryWriter.println( " ItemName                                Bonus Value" + System.lineSeparator()
                              + "---------------------------------------------------------");

             for (Item currentItem: hero.getPlayerInventory()){
                 inventoryWriter.println(String.format("%-25s %25s ", 
                         currentItem.getItemName(), currentItem.getBonusValue() + " points"));
                 
             }
             
            
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }  finally {
            inventoryWriter.close();
        }
        
       
        this.console.println("Inventory successfully printed!");
        
    }

}
