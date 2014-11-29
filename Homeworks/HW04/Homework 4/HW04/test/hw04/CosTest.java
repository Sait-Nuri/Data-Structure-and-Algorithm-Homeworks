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
public class CosTest {
    
    public CosTest() {
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
     * Test of execute method, of class Cos.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Cos instance = new Cos(new MyDouble(60));
        double expResult = -0.9524129804151563;
        double result = instance.execute();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Cos.
     */
    @Test
    public void testSetValue() throws Exception {
        System.out.println("setValue");
        Operand val = new MyDouble(15);
        Cos instance = new Cos(new MyDouble(12));
        instance.setValue(val);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
