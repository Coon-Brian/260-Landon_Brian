/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.control;

import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Item;
import byui.cit260.mathcadia.model.Location;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Brian
 */
public class LocationControl {
    
    public static int battleRoomNumber = 1;
    
    public static String getBattleLocationFile(){
        String fileName = null;
        return fileName;
    }
    
    
    /************************************
     * This method generates a random number and selects an item from our
     * enum list based on that number and returns it to the player. 
     * It iterates through the item list using the Enhanced for-loop
     * @return 
     */
    public static Item searchRoom(){
        Item roomItem = null;
        System.out.println("Searching Room ...");
        //use random int to generate item
        Random rand = new Random();
        int itemNumber = rand.nextInt(4);
        //insert item iterating code here...
        for(Item currentItem: Item.values()){
            if(itemNumber == currentItem.ordinal())
                roomItem = currentItem;
        }
        
        
        if(roomItem == null){
            System.out.println("nothing here");
            return null;
        }
        else{
            System.out.println("You found a " + roomItem.getItemName() + "!");
            Game.getPlayer().addItem(roomItem);
            return roomItem;
        }
            
    }
    
    public int getBattleRoomNum(){
        return battleRoomNumber;
    }
    
    public void nextBattleNumber(){
        battleRoomNumber++;
    }
}
