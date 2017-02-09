/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.mathcadia.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Landon
 */
public class PuzzleControlTest {
    
    public PuzzleControlTest() {
    }

    /**
     * Test of calcDoorSize method, of class PuzzleControl.
     */
    @Test
    public void testCalcDoorSize() {
        System.out.println("calcDoorSize");
        
        System.out.println("Test Case #1");
        int height = 4;
        int bottomLength = 2;
        PuzzleControl instance = new PuzzleControl();
        boolean expResult = true;
        boolean result = instance.calcDoorSize(height, bottomLength);
        assertEquals(expResult, result);
        
        System.out.println("Test Case #2");
        height = 0;
        bottomLength = 2;
        expResult = false;
        result = instance.calcDoorSize(height, bottomLength);
        assertEquals(expResult, result);
        
        System.out.println("Test Case #3");
        height = 10;
        bottomLength = 2;
        expResult = false;
        result = instance.calcDoorSize(height, bottomLength);
        assertEquals(expResult, result);
        
        System.out.println("Test Case #4");
        height = 5;
        bottomLength = 0;
        expResult = false;
        result = instance.calcDoorSize(height, bottomLength);
        assertEquals(expResult, result);
        
        System.out.println("Test Case #5");
        height = 4;
        bottomLength = 10;
        expResult = false;
        result = instance.calcDoorSize(height, bottomLength);
        assertEquals(expResult, result);
        
    }
    
}
