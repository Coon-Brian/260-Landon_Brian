/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.mathcadia.control;

import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Player;

/**
 *
 * @author Brian
 */
public class GameControl {

    public static Player createPlayer(String name) {
        
        if (name == null){
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        Game.setPlayer(player);
        
        return new Player();
    }

    public static void createNewGame(Player player) {
        //nothing here yet!
    }
    
}
