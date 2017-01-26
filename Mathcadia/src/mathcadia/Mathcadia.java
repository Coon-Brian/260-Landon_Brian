/*

 */
package mathcadia;

import byui.cit260.mathcadia.model.Player;

/**
 *
 * @author Brian
 */
public class Mathcadia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setUserName("George");
        playerOne.setPlayerInventory("Hammer, wrench");
        playerOne.setExperience(8.00);
        playerOne.setBestScore(6.00);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }

    
}
