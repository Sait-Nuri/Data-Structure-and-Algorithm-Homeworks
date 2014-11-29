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
public class OperandTest {
    
    public OperandTest() {
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
     * Test of returnValue method, of class Operand.
     */
    @Test
    public void testReturnValue() {
        System.out.println("returnValue");
        Operand instance = new MyDouble(12);
        double expResult = 12;
        double result = instance.returnValue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Operand.
     * @throws java.lang.Exception
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testSetValue() throws Exception {
        System.out.println("setValue");
        Operand val = new MyDouble(12);
        Operand instance = new MyDouble();
        instance.setValue(val);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
