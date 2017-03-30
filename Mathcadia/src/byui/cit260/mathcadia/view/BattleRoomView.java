/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

import byui.cit260.mathcadia.control.BattleControl;
import byui.cit260.mathcadia.control.LocationControl;
import byui.cit260.mathcadia.exceptions.BattleControlException;
import byui.cit260.mathcadia.model.Game;
import mathcadia.Mathcadia;

/**
 *
 * @author Landon
 */
public class BattleRoomView extends View{
    
    //this determines if the player beat the monster and is moving to next room
    boolean roomPassed;
    
    public BattleRoomView(){
        super("\n------------------------------"
                  + "\n|      Battle Room Menu      |"
                  + "\n------------------------------"
                  + "\n D - Display Battle Instructions"
                  + "\n F - Fight Monster"
                  + "\n L - Return to Library"
                  + "\n E - Explore Room"
                  + "\n S - Save game"
                  + "\n H - Help Menu"
                  + "\n I - Display Inventory"
                  + "\n U - Use Item"
                  + "\n Q - Leave Game"
                  + "\n------------------------------");
        searched = false;
        roomPassed = false;
    }    
    
    @Override
    public void display(){
        boolean done = false;
        this.console.println("\nWelcome to battle room #" + LocationControl.battleRoomNumber);
        this.console.println("Your grade is currently at " + Game.getPlayer().getPercent());
        do{
            String menuOption = this.getInput();
            if(menuOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(menuOption);
        }while (!done);
        //if the monster is beat, moved to next room, otherwise just exit
        if(roomPassed)
            nextBattleRoom();
    }    

    @Override
    public boolean doAction(String menuOption) {
        String choice = menuOption.toUpperCase();
        
        switch (choice){
            case "F":
                this.startBattle();
                return true;
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
                    this.console.println("You've already searched this room!");
                }
                break;
            case "S":
                this.saveRoom();
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
                try {
                    BattleControl.useItem();
                } catch (BattleControlException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                }
                break;
            case "Q":
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
                break; 
            case "D":
                HelpMenuView battleHelp = new HelpMenuView();
                battleHelp.displayRules();
                break;
            default:
                this.console.println("\n Invalid selection, Please try again.");
                break;
        }
                       
        return false;
    }

    private void startBattle() {
        this.console.println("A monster approaches...\n");
        //user fights monster
        BattleControl.battleMonster();
        //check if it's time to display next puzzle
        checkPuzzleRoom();
        roomPassed = true;
    }

   
    
    private void nextBattleRoom(){
        this.console.println("Moving to next battle room");
        LocationControl.battleRoomNumber++;
        this.display();
        searched = false;
        roomPassed = false;
    }
    
    private void checkPuzzleRoom(){
        if(LocationControl.battleRoomNumber == 2){
            PuzzleRoomView puzzleRoom1 = new PuzzleRoomView(1);
            puzzleRoom1.display();
        }
        if(LocationControl.battleRoomNumber == 14){
            PuzzleRoomView puzzleRoom2 = new PuzzleRoomView(2);
            puzzleRoom2.display(); 
            //display the final room
            FinalRoomView bossRoom = new FinalRoomView("text/bossRoom.txt");
            bossRoom.display();
        }
        if(LocationControl.battleRoomNumber == 7){
            PuzzleRoomView puzzleRoom3 = new PuzzleRoomView(3);
            puzzleRoom3.display();
           
        }
        
        
    }
    //set the room number the same as the current battle room
    private void saveRoom() {
        Mathcadia.getMathcadia().setRoomNumber(LocationControl.battleRoomNumber);
    }
}
