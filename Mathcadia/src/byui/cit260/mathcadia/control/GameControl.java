/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.control;

import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Player;
import byui.cit260.mathcadia.model.Question;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class GameControl {

    public static Game mathcadia;
    
    public static Player createPlayer(String name) {
        
        if (name == null){
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        Game.setPlayer(player);
        
        return player;
    }

    public static void createNewGame(Player player) {
        
        //All of our code for setting up the game is in the constructor
        mathcadia = new Game();
        
        //the static variable player has already been set, so we don't need to 
        //do it again
        
        //for debugging
        //System.out.println(mathcadia.toString());
        //System.out.println(mathcadia.getPlayer().toString());
    }
    
    public static void saveGame(Player player){
        System.out.println("\nSaving game...");
    }
    
    
    
    
    public ArrayList<Question> buildQuestions(){
        ArrayList<Question> questions = new ArrayList<>();
        String problem = "";
        
         File file = new File("text/questions.txt");
        Scanner fileReader;
        try {
            fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                //reset question
                Question currentQuestion = new Question();
                //read in 5 lines of question text
                for(int i = 0; i < 5; i++){
                 problem += fileReader.nextLine() + "\n";
                }
                //read in answer
                currentQuestion.setAnswer(fileReader.nextLine());
                currentQuestion.setProblem(problem);
                
                //add current question to list of questions
                questions.add(currentQuestion);
                //skip blank line
                fileReader.nextLine();
                //reset variable
                problem = "";
            
        }
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
        
        
        return questions;
    }
        
}
