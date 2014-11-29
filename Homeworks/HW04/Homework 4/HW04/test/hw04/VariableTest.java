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
public class VariableTest {
    
    public VariableTest() {
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
     * Test of returnValue method, of class Variable.
     */
    @Test
    public void testReturnValue() {
        System.out.println("returnValue");
        Variable instance = new Variable("a", 12);
        double expResult = 12;
        double result = instance.returnValue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Variable.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Variable instance = new Variable("a", 12);
        instance.setValue(14);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVarName method, of class Variable.
     */
    @Test
    public void testGetVarName() {
        System.out.println("getVarName");
        Variable instance = new Variable("a");
        String expResult = "a";
        String result = instance.getVarName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setVarName method, of class Variable.
     */
    @Test
    public void testSetVarName() {
        System.out.println("setVarName");
        String varName = "a";
        Variable instance = new Variable("a");
        instance.setVarName(varName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
