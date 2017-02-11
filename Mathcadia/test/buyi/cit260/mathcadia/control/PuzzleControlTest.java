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

    /**
     * Test of calcVolumeOfCone method, of class PuzzleControl.
     */
    @Test
    public void testCalcVolumeOfCone() {
        System.out.println("calcVolumeOfCone");
        
        System.out.println("Test Case #1");
        double diameter = 5.0;
        double height = 7.0;
        PuzzleControl instance = new PuzzleControl();
        double expResult = 45.8149;
        double result = instance.calcVolumeOfCone(diameter, height);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("Test Case #2");
        diameter = -1.0;
        height = 7.0;
        expResult = -1;
        result = instance.calcVolumeOfCone(diameter, height);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("Test Case #3");
        diameter = 6.0;
        height = -1.0;
        expResult = -1;
        result = instance.calcVolumeOfCone(diameter, height);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("Test Case #4");
        diameter = 7.0;
        height = 8.0;
        expResult = -1;
        result = instance.calcVolumeOfCone(diameter, height);
        assertEquals(expResult, result, 0.0001);

        System.out.println("Test Case #5");
        diameter = 0.0;
        height = 7.0;
        expResult = -1;
        result = instance.calcVolumeOfCone(diameter, height);
        assertEquals(expResult, result, 0.0001);

        System.out.println("Test Case #6");
        diameter = 6.0;
        height = 0.0;
        expResult = -1;
        result = instance.calcVolumeOfCone(diameter, height);
        assertEquals(expResult, result, 0.0001);

        System.out.println("Test Case #7");
        diameter = 6.0;
        height = 7.0;
        expResult = 65.9734;
        result = instance.calcVolumeOfCone(diameter, height);
        assertEquals(expResult, result, 0.0001);
    }
    
}
