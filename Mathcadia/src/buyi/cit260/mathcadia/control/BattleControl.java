/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.mathcadia.control;

import static buyi.cit260.mathcadia.control.GameControl.mathcadia;
import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Monster;
import byui.cit260.mathcadia.model.Player;
import byui.cit260.mathcadia.model.Question;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class BattleControl {
    
    
    
    public static void battleMonster(){
        ArrayList<Question> questions = mathcadia.getQuestions();
        Player hero = Game.getPlayer();
        Monster monster = new Monster();
        System.out.println("nothing here yet!");
        //iterate through array of questions here...
        //1.display question
        //2. get answer from user
        //3. remove current question from front of array and add it 
        //   to the back of array
        //3.check if answer is correct 
        //4.if it is, player attacks
        //5.else monster attacks
        //6. if neither is dead, start over at step 1;
        
        
    }
    
    
    
}
