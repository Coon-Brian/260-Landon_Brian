/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.mathcadia.control;

import byui.cit260.mathcadia.model.Item;
import byui.cit260.mathcadia.model.Location;
import java.util.List;

/**
 *
 * @author Brian
 */
public class LocationControl {
    
    
    public static String getBattleLocationFile(){
        String fileName = Location.getLocationStory().get(0);
        Location.getLocationStory().remove(0);
        return fileName;
    }
    
    public static Item searchRoom(){
        System.out.println("Searching Room ... Nothing here");
        return null;
    }
}
