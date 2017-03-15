/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.BattleControl;
import byui.cit260.mathcadia.control.LocationControl;
import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Location;

/**
 *
 * @author Landon
 */
public class BattleRoomView extends View{
    
    
    public BattleRoomView(){
        super("\n------------------------------"
                  + "\n|      Game Play Menu        |"
                  + "\n------------------------------"
                  + "\n F - Fight Monster"
                  + "\n L - Return to Library"
                  + "\n E - Explore Room"
                  + "\n S - Save game"
                  + "\n H - Help Menu"
                  + "\n I - Display Inventory"
                  + "\n U - Use Item"
                  + "\n Q - Leave Battle Room"
                  + "\n P - (DEBUG) go to puzzle room #1"
                  + "\n------------------------------");
        searched = false;
    }    
    
    @Override
    public void display(){
        boolean done = false;
        System.out.println("\nWelcome to the battle room! ");
        System.out.println("Your grade is currently at " + Game.getPlayer().getPercent());
        do{
            String menuOption = this.getInput();
            if(menuOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(menuOption);
        }while (!done);
        
    }    

    @Override
    public boolean doAction(String menuOption) {
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "F":
                this.startBattle();
                break;
            case "L":
                RoomView library;
                library = new RoomView("text/library.txt");
                library.display();
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
            case "S":
                this.saveGame();
                break;
            case "H":
                HelpMenuView help = new HelpMenuView();
                help.display();
                break;
            case "I":
                Game.getPlayer().displayInventory();
                break;
            case "U":
                BattleControl.useItem();
                break;
            case "Q":
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
                break; 
            case "P":
                PuzzleRoomView puzzleRoom1 = new PuzzleRoomView();
                puzzleRoom1.display();
                break; 
            default:
                System.out.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    }

    private void startBattle() {
        System.out.println("A monster approaches...\n");
        BattleControl.battleMonster();
        if(LocationControl.battleRoomNumber == 1){
            PuzzleRoomView puzzleRoom1 = new PuzzleRoomView();
            puzzleRoom1.display();
        }
    }

    private void saveGame() {
       System.out.println("saving game...");
    }
}
