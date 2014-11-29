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
public class PrintTest {
    
    public PrintTest() {
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
     * Test of setValue method, of class Print.
     */
    @Test
    public void testSetValue() throws Exception {
        System.out.println("setValue");
        Operand val = new Variable("a", 12);
        Print instance = new Print(null);
        instance.setValue(val);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class Print.
     * @throws hw04.GITCompiler.UndefinedVariableException
     */
    @Test
    public void testExecute() throws GITCompiler.UndefinedVariableException {
        System.out.println("execute");
        Print instance = new Print(null);
        instance.setValue(new Variable("a", 12));
        double expResult = 12;
        double result = instance.execute();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnValue method, of class Print.
     * @throws hw04.GITCompiler.UndefinedVariableException
     */
    @Test
    public void testReturnValue() throws GITCompiler.UndefinedVariableException {
        System.out.println("returnValue");
        Print instance = new Print(null);
        instance.setValue(new Variable("a", 12));
        double expResult = 12;
        double result = instance.returnValue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
