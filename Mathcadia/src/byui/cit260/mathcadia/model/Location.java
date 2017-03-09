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
public class Location implements Serializable{
    
    protected Integer roomNumber = 1;
    protected String roomName;
    protected Item roomItem;
    protected String roomFileName;
    
    public Location(){    
        
        
        
    }
    
    public Location (String file, Integer roomNum){
        
        roomFileName = "text/" + file;
        this.roomNumber = roomNum;
        roomName = "";
        
    }

    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public Item getRoomItem() {
        return roomItem;
    }

    public String getLocationStory() {
        return roomFileName;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomItem(Item roomItem) {
        this.roomItem = roomItem;
    }

    public void setLocationStory(String locationStory) {
        this.roomFileName = locationStory;
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
        hash = 37 * hash + Objects.hashCode(this.roomItem);
        hash = 37 * hash + Objects.hashCode(this.roomFileName);
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
        if (!Objects.equals(this.roomItem, other.roomItem)) {
            return false;
        }
        if (!Objects.equals(this.roomFileName, other.roomFileName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "roomNumber=" + roomNumber + ", roomName=" + roomName + ", roomItems=" + roomItem + ", locationStory=" + roomFileName + '}';
    }
    
}
