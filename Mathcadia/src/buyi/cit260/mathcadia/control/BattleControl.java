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
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class BattleControl {
    
    private static Scanner userInput = new Scanner(System.in);
    
    public static void battleMonster(){
        ArrayList<Question> questions = mathcadia.getQuestions();
        Player hero = Game.getPlayer();
        Monster monster = new Monster();
        //iterate through array of questions here...
        //1.display question
        //2. get answer from user
        //3. remove current question from front of array and add it 
        //   to the back of array
        //3.check if answer is correct 
        //4.if it is, player attacks
        //5.else monster attacks
        //6. if neither is dead, start over at step 1;
        
        while(hero.isAlive() && monster.isAlive()){
            System.out.println("Insert an answer: A,B,C, or D\n");
            System.out.println(questions.get(0).getProblem());
            
            
            String answer = userInput.nextLine();
            
            Question oldQuestion = questions.get(0);
            //remove first question from list
            questions.remove(0);
            //now add the question to the back for recycling
            questions.add(oldQuestion);
            
            //check user answer
            if(oldQuestion.getAnswer().equals(answer.toUpperCase())){
                int damage = hero.attack(monster);
                System.out.println("You did " + damage + " damage to the monster\n");
            }
            else{
                int damage = monster.attack(hero);
                System.out.println("The monster did " + damage + " damage to you!\n");
            }
            
            if(!monster.isAlive()){
                System.out.println("The monster is dead!");
                hero.addExperience(LocationControl.battleRoomNumber * 100);
                System.out.println("you gained " + LocationControl.battleRoomNumber * 100 + " experience points!");
                BattleControl.checkLevelUp();
            }
            if(!hero.isAlive()){
                System.out.println("Hero! You are totally dead!");
                Game.endGame = true;
            }
            
        }
        
        
    }
    
    //check if the player has enough experience to level up
    public static void checkLevelUp(){
        
        int[] levels = Game.getLevelUp();
        Player hero = Game.getPlayer();
        //get experience points to measure 
        int experience = hero.getExp();
        int counter = 0;

        for(int i = 0; i < levels.length; i++){
            if(experience >= levels[i])
                counter++;
            else
                break;
        }

        if(counter > hero.getLevel()){
            System.out.println("You have leveled up!\n");
            hero.levelUp();
        }
    }
    
}
