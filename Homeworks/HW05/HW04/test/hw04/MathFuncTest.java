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
public class MathFuncTest {
    
    public MathFuncTest() {
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
     * Test of returnValue method, of class MathFunc.
     */
    @Test
    public void testReturnValue() {
        System.out.println("returnValue");
        MathFunc instance = new Sqrt(new MyDouble(16));
        double expResult = 4;
        double result = instance.returnValue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRadian method, of class MathFunc.
     */
    @Test
    public void testGetRadian() {
        System.out.println("getRadian");
        MathFunc instance = new Sqrt(new MyDouble(16));
        MyDouble expResult = new MyDouble(16);
        MyDouble result = instance.getRadian();
        assertEquals(expResult.returnValue(), result.returnValue(), 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class MathFuncImpl extends MathFunc {

        public MathFuncImpl() {
            super(null);
        }

        @Override
        public double execute() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
