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

/**
 *
 * @author Brian
 */
public class Mathcadia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library roomTest = new Library();
        String roomInfo = roomTest.toString();
        System.out.print(roomInfo);

        BattleRoom gym = new BattleRoom();
        String gymInfo = gym.toString();
        System.out.print(gymInfo);

    }

    
}
