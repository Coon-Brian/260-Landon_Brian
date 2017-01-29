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
 * This class will initiate a battle between a player and a monster
 * 
 * @author Landon Shumway
 * @since 1/26/17
 */
public class BattleRoom extends Location implements Serializable {
    
    private Monster roomMonster;
    private List<Question> equations;
    
    public BattleRoom(){
        roomMonster = null;
        equations = null;
        roomNumber = 5;
        roomName = "Battle-Room 5";
        roomItems = null;
        locationStory = null;
    }
    
    BattleRoom(Integer roomNum, Monster monster){
        setRoomNumber(roomNum);
        roomMonster = monster;
    }

    public Monster getRoomMonster() {
        return roomMonster;
    }

    public List<Question> getEquations() {
        return equations;
    }

    public void setRoomMonster(Monster roomMonster) {
        this.roomMonster = roomMonster;
    }

    public void setEquations(List<Question> equations) {
        this.equations = equations;
    }
    
    @Override
    public void displayMenuText(){
        
    }
    
    @Override
    public void displayOptions(){
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.roomMonster);
        hash = 97 * hash + Objects.hashCode(this.equations);
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
        final BattleRoom other = (BattleRoom) obj;
        if (!Objects.equals(this.roomMonster, other.roomMonster)) {
            return false;
        }
        if (!Objects.equals(this.equations, other.equations)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BattleRoom{" + "roomNumber=" + roomNumber + ", roomName=" + roomName + ", roomItems=" + roomItems + ", locationStory=" + locationStory + ", roomMonster=" + roomMonster + ", equations=" + equations + '}';
    }
    
    
}
