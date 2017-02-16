/*

 */
package mathcadia;

import byui.cit260.mathcadia.model.BattleRoom;
import byui.cit260.mathcadia.model.Bedroom;
import byui.cit260.mathcadia.model.Item;
import byui.cit260.mathcadia.model.Library;
import byui.cit260.mathcadia.model.Location;
import byui.cit260.mathcadia.model.Monster;
import byui.cit260.mathcadia.model.Player;
import byui.cit260.mathcadia.model.PuzzleRoom;
import byui.cit260.mathcadia.model.Question;
import byui.cit260.mathcadia.model.Character;
import byui.cit260.mathcadia.view.StartProgramView;

/**
 *
 * @author Brian
 */
public class Mathcadia {

    /**
     * @param args the command line arguments
     */
    private static Player player;
 
    public static void main(String[] args) {
    
        // create StartProgramViewOrig and display the start progam view
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();

    }

    
     public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Mathcadia.player = player;
    }
}
