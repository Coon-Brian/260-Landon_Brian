/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.control;

import static byui.cit260.mathcadia.control.GameControl.mathcadia;
import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Item;
import byui.cit260.mathcadia.model.Monster;
import byui.cit260.mathcadia.model.Player;
import byui.cit260.mathcadia.model.Question;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *This control class takes care of all methods related to the player fighting
 * monsters, using items, and increasing stats.
 * @author Brian, Landon
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
            System.out.println("Insert an answer: A,B,C,D  or use an item with U\n");
            System.out.println(questions.get(0).getProblem());
            
            
            String answer = userInput.nextLine().toUpperCase();
            
            if(answer.equals("U")){
                BattleControl.useItem();
                continue;
            }
            
            Question oldQuestion = questions.get(0);
            //remove first question from list
            questions.remove(0);
            //now add the question to the back for recycling
            questions.add(oldQuestion);
            
            //check user answer
            if(oldQuestion.getAnswer().equals(answer)){
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
    
    //searches the player inventory arraylist and selects an item to use
    public static void useItem(){
        
        boolean itemUsed = false;
        Player hero = Game.getPlayer();
        while(!itemUsed){
        if(hero.getPlayerInventory().size() > 0)
            System.out.println("\nWhich item would you like to use? "
                                + "(Put in a number between 1 and " + 
                        hero.getPlayerInventory().size() + " Q to cancel)");
        else
            System.out.println("You don't have any items, press Q to return");
        hero.displayInventory();
        //get user answer
        String itemPos = userInput.nextLine();
        //check for cancel
        if(itemPos.equals("Q"))
            break;
        
        int itemSlot = -1;
        try {
            itemSlot = Integer.parseInt(itemPos);
        }catch(NumberFormatException nf){
            System.out.println("You must enter a number between 1 and " + 
                        hero.getPlayerInventory().size() + " Q to cancel)");      
                    }
        
        //this number will tell us what bonus to give
        int itemNum = -1;
        
        
        
        //loop through player inventory for match
        for(int i = 0; i < hero.getPlayerInventory().size(); i++){
            //if it matches return the enum ordinal number
            if(i+1 == itemSlot){
                
                itemNum = hero.getPlayerInventory().get(i).ordinal();
                //remove item from inventory
                hero.getPlayerInventory().remove(i);
                break;
            }
                
        }
        //give the hero their bonus
        switch(itemNum){
            case 0:
                hero.addHealth(Item.ExtraCredit.getBonusValue());
                System.out.println("you gained " + 
                        Item.ExtraCredit.getBonusValue() + " Health Points!\n");
                break;
            case 1:
                hero.addKnowledge(Item.Knowledge.getBonusValue());
                System.out.println("you gained " + 
                        Item.Knowledge.getBonusValue() + " Knowledge!\n");
                break;
            case 2:
                hero.addPower(Item.Power.getBonusValue());
                System.out.println("you gained " + 
                        Item.Power.getBonusValue() + " Power!\n");
                break;
            case 3:
                hero.addExperience(Item.Experience.getBonusValue());
                System.out.println("you gained " + 
                        Item.Experience.getBonusValue() + " Experience Points!\n");
                //check to see if they leveled up
                BattleControl.checkLevelUp();
                break;
            default:
                System.out.println("Item not found... Please try again or cancel");
                continue;
        }
        
        itemUsed = true;
        }
    }
    
}
