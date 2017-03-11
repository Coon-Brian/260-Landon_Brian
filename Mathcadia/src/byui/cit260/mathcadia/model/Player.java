/*
 *
 */
package byui.cit260.mathcadia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Brian
 */
public class Player extends Character implements Serializable{
    private String userName;
    private ArrayList<Item> playerInventory;
    private int level;

    public Player() {
        userName = "";
        playerInventory = new ArrayList<>();
        experience = 0;
        bestScore = 0;
        gradePoints = 1000;
        knowledge = 5;
        power = 2;
        level = 1;
    }
    
    public Player(String name){
        userName = name;
        playerInventory = new ArrayList<>();
        experience = 0;
        bestScore = 0;
        gradePoints = 1000;
        knowledge = 1;
        power = 1;
    }
    

    
    
    public void addItem(Item item){
        this.playerInventory.add(item);
    }
    
    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    /* This function takes in a string and an Integer, it adds an item to
    our map(or "item holder") and sets the string as the name of our item and 
    the Integer as the number of items
    */
    public void setPlayerInventory(ArrayList<Item> items) {
        this.playerInventory = items;
    }
    
    public double getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    
    @Override
    public Boolean isAlive(){
        //if the player's grade is still above 69% they are alive
        return gradePoints > 699;
    }


    public void displayInventory(){
        System.out.println("____  THIS IS YOUR INVENTORY  ____" + "\n");
        for (Item currentItem: playerInventory){
            System.out.println("--- " + currentItem.getItemName());
        }
    }
    
    
    /** This method test to see if an item is found within the inventory.
     * if it is then it is used and taken out of the inventory. A boolean is
     * returned based on whether an item was actually used.
     * @param itemName
     */
    public boolean useItem(String itemName){
        boolean itemNotUsed = false;
        return false;
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
        return "Player{" + "userName=" + userName + ", playerInventory=" + playerInventory + ", experience=" + experience + ", bestScore=" + bestScore +
                ", gradePoints=" + gradePoints + ", knowledge=" + knowledge + ", power=" + power + '}';
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
    
    public void levelUp(){
        this.level++;
        this.knowledge = level * 5;
        this.power = level * 2;
        
    }
    
}
