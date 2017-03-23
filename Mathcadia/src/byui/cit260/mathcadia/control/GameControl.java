/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.control;

import byui.cit260.mathcadia.exceptions.QuestionReaderException;
import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.model.Player;
import byui.cit260.mathcadia.model.Question;
import byui.cit260.mathcadia.view.ErrorView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import mathcadia.Mathcadia;

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
    
    public static void saveGame(Game mathcadia, String filepath)throws QuestionReaderException {
        try( FileOutputStream fops = new FileOutputStream(filepath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(mathcadia);
        } catch(Exception e) {
            throw new QuestionReaderException(e.getMessage());
        }
    }
    
    public static void loadGame(String filepath) throws QuestionReaderException{
        Game game = null;
        
        try(FileInputStream fips = new FileInputStream(filepath)){
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();
        }catch(Exception e){
            throw new QuestionReaderException(e.getMessage());
        }
        
        Mathcadia.setMathcadia(game);
    }
    
    
    
    
    public ArrayList<Question> buildQuestions() throws QuestionReaderException{
        ArrayList<Question> questions = new ArrayList<>();
        String problem = "";
        int lineNum = 0;
        
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
                 lineNum++;
                }
                //read in answer
                currentQuestion.setAnswer(fileReader.nextLine());
                lineNum++;
                if (currentQuestion.getAnswer().length() != 1)
                    throw new QuestionReaderException("ERROR: Answer does not meet "
                            + "correct length on line " + lineNum);
                
                currentQuestion.setProblem(problem);
                
                //add current question to list of questions
                questions.add(currentQuestion);
                //skip blank line, catch the error if there are no more lines
                try{
                fileReader.nextLine();
                lineNum++;
                }catch(NoSuchElementException ex){
                    break;
                }
                //reset variable
                problem = "";
            
        }
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
        
        
        return questions;
    }
        
}
