/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import java.util.List;

/**
 *
 * @author Landon
 */
public class Map {
    
    Location currentRoom;
    List<Location> roomList;
    
    public void buildLocationList(){
        
    }

    public Location getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int index) {
        this.currentRoom = roomList.get(index);
    }
    
    public void setCurrentRoom(String roomName){
        
    }
    
    
    
}
