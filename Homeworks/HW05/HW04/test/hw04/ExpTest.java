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
public class ExpTest {
    
    public ExpTest() {
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
     * Test of setValue method, of class Exp.
     */
    @Test
    public void testSetValue() throws Exception {
        System.out.println("setValue");
        Operand val = new Exp(new MyDouble(12));
        Exp instance = new Exp();
        instance.setValue(new MyDouble(val.returnValue()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class Exp.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Exp instance = new Exp(new MyDouble(12));
        double expResult = 162754.79141900392;
        double result = instance.execute();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
