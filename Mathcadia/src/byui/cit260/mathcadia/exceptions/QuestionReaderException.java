/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.exceptions;

/**
 * Regulates the reading of questions from the text file into the game
 * 
 * it is used within the {@Link GameControl} class.
 * @author Landon
 */
public class QuestionReaderException extends Exception {

    public QuestionReaderException() {
    }

    public QuestionReaderException(String message) {
        super(message);
    }

    public QuestionReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionReaderException(Throwable cause) {
        super(cause);
    }

    public QuestionReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
