/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;


/**
 *
 * @author Landon
 */
public class FinalRoomView extends View{
    

    public FinalRoomView(){
       super("\n------------------------------"
                  + "\n|      Final Room Menu       |"
                  + "\n------------------------------"
                  + "\n F - Proceed to final battle"
                  + "\n L - Back to Library"
                  + "\n H - Help Menu"
                  + "\n S - Save Game"
                  + "\n M - Main Menu"
                  + "\n------------------------------");
    }    
       

    @Override
    public boolean doAction(String menuOption) {
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "F":
                this.fightBoss();
                break;
            case "L":
                RoomView library;
                library = new RoomView("text/library.txt");
                library.display();
                break;
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.display();
                break;
            case "S":
                this.saveGame();
                break;    
            case "M":
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
                break;                
            default:
                this.console.println("\n Invalid selection, Please try again.");
                break;
        }
    
        return false;
    }

    private void fightBoss() {
        this.console.println("\nProceeding to final battle...");
    }

    private void saveGame() {
        this.console.println("\nSaving the game from final room...");
    }
}
