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
public class GITCompilerTest {
    
    GITCompiler instance; 
    
    public GITCompilerTest() {
        instance = new GITCompiler("program.git");
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
     * Test of compileAndRun method, of class GITCompiler.
     */
    @Test
    public void testCompileAndRun() {
        System.out.println("compileAndRun");
        this.setUp();
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCurLineNum method, of class GITCompiler.
     */
    @Test
    public void testGetCurLineNum() {
        System.out.println("getCurLineNum");
        int expResult = 0;
        int result = instance.getCurLineNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of IsVar method, of class GITCompiler.
     */
    @Test
    public void testIsVar() {
        System.out.println("IsVar");
        String expr = "a";
        boolean expResult = false;
        boolean result = instance.IsVar(expr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of IsPrint method, of class GITCompiler.
     */
    @Test
    public void testIsPrint() {
        System.out.println("IsPrint");
        String expr = "print";
        boolean expResult = true;
        boolean result = instance.IsPrint(expr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of IsInput method, of class GITCompiler.
     */
    @Test
    public void testIsInput() {
        System.out.println("IsInput");
        String expr = "input";
        boolean expResult = true;
        boolean result = instance.IsInput(expr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of IsDouble method, of class GITCompiler.
     */
    @Test
    public void testIsDouble() {
        System.out.println("IsDouble");
        String expr = "12.03";
        boolean expResult = true;
        boolean result = instance.IsDouble(expr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Is_a_Variable method, of class GITCompiler.
     * @throws java.lang.Exception
     */
    @Test
    public void testIs_a_Variable() throws Exception {
        System.out.println("Is_a_Variable");
        String expr = "a";
        boolean expResult = true;
        boolean result = instance.Is_a_Variable(expr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of IsOperator method, of class GITCompiler.
     */
    @Test
    public void testIsOperator() {
        System.out.println("IsOperator");
        String expr = "+";
        boolean expResult = true;
        boolean result = instance.IsOperator(expr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of IsFunction method, of class GITCompiler.
     */
    @Test
    public void testIsFunction() {
        System.out.println("IsFunction");
        String expr = "sin";
        boolean expResult = true;
        boolean result = instance.IsFunction(expr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
