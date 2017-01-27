/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import java.util.List;

/**
 * This class holds the methods that are similar between all of the rooms
 * 
 * @author Landon Shumway
 * @since 1/26/17
 */
public abstract class Location{
    
    private Integer roomNumber;
    private String roomName;
    private List<String/*change to item*/> roomItems;
    private List<String> locationStory;
    
    Location(){    
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public List<String> getRoomItems() {
        return roomItems;
    }

    public List<String> getLocationStory() {
        return locationStory;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomItems(List<String> roomItems) {
        this.roomItems = roomItems;
    }

    public void setLocationStory(List<String> locationStory) {
        this.locationStory = locationStory;
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
    
    //public Item searchRoom()
    
    public boolean promptSave(){
        boolean answer = false;
        return answer;
    }
    
    
    
    
    
    
}
