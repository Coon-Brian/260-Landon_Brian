/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.mathcadia.control;

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
    public boolean calcDoorSize(int height, int bottomLength){
       
        int topLength = 3;
        
        //check to make sure the input is integers
        if (height != (int)height || bottomLength != (int)bottomLength){
          //we will place an error here later
            return false;  
        }
        
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
     /**
     * Brian Coon individual assignment
     * calcVolumeOfCone(diameter, height)
     * Description:
     * The user is given a cone paper cup to fill with water. They are to find
     * the diameter and the height that will fill the cup with a volume higher
     * than 40 without spilling, a volume of 65.9735. Errors will be returned
     * if a negative number or 0 is entered for diameter or height. An error will
     * also be returned if the volume is 40 or less and higher than 65.9735.
     * @param diameter
     * @param height
     * @return 
    */  
    public double calcVolumeOfCone(double diameter, double height) {
        
        // checks to see if diameter is too small or large
        if (diameter <= 0 || diameter >= 7){
            return -1;
        }
        // checks to see if height is too small
        if (height <= 0) {
            return -1;
        }
        // calrulation for volume
        double radius = diameter / 2;
        double volume = (Math.PI * Math.pow(radius, 2) * height) /3;
        
         // volume not enough
        if (volume <= 40) {
            return -1;
        }
        // volume too much
        if (volume > 65.9735) { 
            return -1;
        }
        else 
            return volume;
    } 
}
