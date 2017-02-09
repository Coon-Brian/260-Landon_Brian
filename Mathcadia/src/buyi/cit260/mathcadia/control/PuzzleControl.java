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
    
    
}
