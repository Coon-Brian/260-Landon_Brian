
package byui.cit260.mathcadia.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public abstract class View implements ViewInterface{
    
    protected String displayMessage;
    protected String roomText = "";
    protected boolean searched;
    
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
            System.out.print(ex.getMessage());
        }
        
        
    }
    
    @Override
    public void display(){  //code copied from displayMainMenuView()
        boolean done = false;
        if (roomText != null)
            System.out.println(roomText);
        
        do{
            String menuOption = this.getInput(); // created method to resolve error message (see below)
            if(menuOption.toUpperCase().equals("Q"))  // not sure if it was the right thing to do. 
                return;
            
            done = this.doAction(menuOption);
        }while (!done);
        
    } 
    @Override
    public String getInput(){ // code copied from displayMainMenuView()
        Scanner keyBoard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + this.displayMessage); // created field "menu" to resolve error
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

}
