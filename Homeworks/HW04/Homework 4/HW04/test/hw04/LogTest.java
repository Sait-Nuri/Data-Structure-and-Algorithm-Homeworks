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
public class LogTest {
    
    public LogTest() {
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
     * Test of setValue method, of class Log.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetValue() throws Exception {
        System.out.println("setValue");
        Operand val = new MyDouble(12);
        Log instance = new Log(null);
        instance.setValue(val);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class Log.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Log instance = new Log(new MyDouble(5));
        double expResult = 1.6094379124341003;
        double result = instance.execute();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
