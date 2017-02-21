/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * This class holds the methods that are similar between all of the rooms
 * 
 * @author Landon Shumway
 * @since 1/26/17
 */
public abstract class Location implements Serializable{
    
    protected Integer roomNumber;
    protected String roomName;
    protected List<Item> roomItems;
    protected static List<String> battleRoomFileNames;
    
    public Location(){    
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public List<Item> getRoomItems() {
        return roomItems;
    }

    public static List<String> getLocationStory() {
        return battleRoomFileNames;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomItems(List<Item> roomItems) {
        this.roomItems = roomItems;
    }

    public void setLocationStory(List<String> locationStory) {
        this.battleRoomFileNames = locationStory;
    }
    
    
    
    //displays the differnt options the user may enter
    abstract void displayOptions();
    //displays the menu instructions
    abstract void displayMenuText();
    
    public char getUserInput(){
    //returning dummy variable until later
        return 'a';    
    }
    
    public void readStoryFile(String fileName){
        
    }
    
    public Item searchRoom(){
        return null;
    }
    
    public boolean promptSave(){
        boolean answer = false;
        return answer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.roomNumber);
        hash = 37 * hash + Objects.hashCode(this.roomName);
        hash = 37 * hash + Objects.hashCode(this.roomItems);
        hash = 37 * hash + Objects.hashCode(this.battleRoomFileNames);
        return hash;
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.roomName, other.roomName)) {
            return false;
        }
        if (!Objects.equals(this.roomNumber, other.roomNumber)) {
            return false;
        }
        if (!Objects.equals(this.roomItems, other.roomItems)) {
            return false;
        }
        if (!Objects.equals(this.battleRoomFileNames, other.battleRoomFileNames)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "roomNumber=" + roomNumber + ", roomName=" + roomName + ", roomItems=" + roomItems + ", locationStory=" + battleRoomFileNames + '}';
    }
    
}
