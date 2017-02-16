/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

/**
 *
 * @author Landon
 */
public class Game {

  
    private static Player player;
    
    Game(){
        
    }
    
      public Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Game.player = player;
    }
}
