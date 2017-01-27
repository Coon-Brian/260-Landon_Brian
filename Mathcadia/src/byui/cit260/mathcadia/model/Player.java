/*
 *
 */
package byui.cit260.mathcadia.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Brian
 */
public class Player extends Character implements Serializable{
    private String userName;
    private Map<String,Integer> playerInventory;
    private double experience;
    private double bestScore;

    public Player() {
        userName = "";
        playerInventory = new HashMap<>();
        experience = 0;
        bestScore = 0;
    }
    
    public Player(String name){
        userName = name;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, Integer> getPlayerInventory() {
        return playerInventory;
    }

    /* This function takes in a string and an Integer, it adds an item to
    our map(or "item holder") and sets the string as the name of our item and 
    the Integer as the number of items
    */
    public void setPlayerInventory(String itemName, Integer num) {
        this.playerInventory.put(itemName,num);
    }
    
    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public void addItem(String itemName){
        Integer numItems = playerInventory.get(itemName);
        //if the item added does not exist, create new spot for it
        if (numItems == null){
            playerInventory.put(itemName, 1);
        }
        //else increment the number of the item that currently exists
        else
            playerInventory.put(itemName, numItems + 1);
    }
    
    /** This method test to see if an item is found within the inventory.
     * if it is then it is used and taken out of the inventory. A boolean is
     * returned based on whether an item was actually used.
     * @param itemName
     */
    public boolean useItem(String itemName){
        boolean itemNotUsed = false;
        
        Integer numItems = playerInventory.get(itemName);
        //if the item requested does not exist, display error
        if (numItems == null){
            System.out.print("You cannot use that item!");
            //return false so that the player must choose again
            return false;
        }
        //else decrement the number that currently exists
        else
            playerInventory.put(itemName, numItems - 1);
        //if the item has run out, remove it from the inventory
        if (playerInventory.get(itemName) == 0)
            playerInventory.remove(itemName);
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.userName);
        hash = 37 * hash + Objects.hashCode(this.playerInventory);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.experience) ^ (Double.doubleToLongBits(this.experience) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.bestScore) ^ (Double.doubleToLongBits(this.bestScore) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "userName=" + userName + ", playerInventory=" + playerInventory + ", experience=" + experience + ", bestScore=" + bestScore + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.experience) != Double.doubleToLongBits(other.experience)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bestScore) != Double.doubleToLongBits(other.bestScore)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.playerInventory, other.playerInventory)) {
            return false;
        }
        return true;
    }
    
    
    
}
