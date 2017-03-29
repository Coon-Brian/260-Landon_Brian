/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.control;

import byui.cit260.mathcadia.exceptions.PuzzleControlException;

/**
 *
 * @author Brian
 */
public class PuzzleControl {
    
    /**
     * calcDoorSize(height, bottomLength)
     * Description:
     * The user enters the height and bottom length of a trapezoid door to 
     * determine if they can fit. If the area of the door is too small (less than
     * 10) or too large (greater than 25), a false Boolean value is returned. 
     * 
     * @param height
     * @param bottomLength
     * @return boolean
    */
    public static boolean calcDoorSize(int height, int bottomLength){
       
        int topLength = 3;
        
        //perform calculation
        float area = (height * (topLength * bottomLength)) / 2;
        
        if (area <= 10){
            return false;
        }
        else if (25 < area)
            return false;
        
        //passed the boundaries, the user can fit
        return true;
        
    }
    
    /** e
    * Description: the user is asked to enter a number greater than 100 and then 
    * a smaller number greater than 2 that is a factor of the first. They will 
    * input two numbers. The function tests if the smaller number is a factor of
    * the larger. If it is, the function returns the other factor.
    * @param largeNum
    * @param potentialF 
    * @author Landon Shumway
    */
    public static int isFactor(String largeNum, String potentialF)throws PuzzleControlException{
        //make sure input is valid
        // if the string contains anything but int, return failed
       // if (!largeNum.matches("^\\d*$") || !potentialF.matches("^\\d*$"))
        
        int number = 0;
        int potentialFactor = 0;
       
        //convert input to int
        try{
            number = Integer.parseInt(largeNum);
            potentialFactor = Integer.parseInt(potentialF);
        }catch(NumberFormatException nf){
            System.out.println("You must enter a valid integer. "
            + " Try again or press Q to quit.");
            throw new PuzzleControlException("");
        }
        
        
        if (number <= 100 || potentialFactor <= 2)
            throw new PuzzleControlException("You entered a number that was too large"
                                                    + " or a factor that was too small");

        //check if it is a factor, return other factor if true
        if (number % potentialFactor == 0)
            return number / potentialFactor;
        else 
            throw new PuzzleControlException("Your potential factor was not an actual factor");

    }
    
     /**
     * Brian Coon individual assignment
     * calcVolumeOfCone(diameter, height)
     * Description:
     * The user is given a cone paper cup to fill with water. They are to find
     * the diameter and the height that will fill the cup with a volume higher
     * than 40 without spilling, a volume of 65.9734. Errors will be returned
     * if a negative number or 0 is entered for diameter or height. An error will
     * also be returned if the volume is 40 or less and higher than 65.9735.
     * @param diameter
     * @param height
     * @return 
    */  
    public static boolean calcVolumeOfCone(int diameter, int height) {
        
        // checks to see if diameter is too small or large
        if (diameter <= 0 || diameter >= 7){
            return false;
        }
        // checks to see if height is too small
        if (height <= 0) {
            return false;
        }
        // calrulation for volume
        double radius = diameter / 2;
        double volume = (Math.PI * Math.pow(radius, 2) * height) /3;
        
         // volume not enough
        if (volume <= 40) {
            return false;
        }
        // volume too much
        if (volume > 65.9735) { 
            return false;
        }
        else 
            return true;
    } 
}
