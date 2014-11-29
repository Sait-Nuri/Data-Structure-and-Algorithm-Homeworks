/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw04;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author said
 */
public class InputTest {
    
    public InputTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of execute method, of class Input.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Input instance = new Input(new Variable("a"));
        double expResult = 0.0;
        //double result = instance.returnValue();
        //assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnValue method, of class Input.
     */
    @Test
    public void testReturnValue() {
        System.out.println("returnValue");
        Input instance = new Input(new Variable("a", 12));
        double expResult = 12;
        double result = instance.returnValue();
        //assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
