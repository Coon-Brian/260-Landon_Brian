
package byui.cit260.mathcadia.view;

import java.util.Scanner;

/**
 *
 * @author Brian
 */
public abstract class View implements ViewInterface{
    
    protected String displayMessage;
    private String menu;
    
    public View(){
    }
    public View(String message){
        this.displayMessage = message;
    }
    
    @Override
    public void display(){  //code copied from displayMainMenuView()
        boolean done = false;
        
        do{
            String menuOption = this.getMenuOption(); // created method to resolve error message (see below)
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
            System.out.println("\n" + this.menu); // created field "menu" to resolve error
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

    private String getMenuOption() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
