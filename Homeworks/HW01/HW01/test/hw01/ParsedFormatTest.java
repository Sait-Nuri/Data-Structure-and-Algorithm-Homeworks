/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw01;

import java.awt.Color;
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
public class ParsedFormatTest {
    
    public ParsedFormatTest() {
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
     * Test of getColor method, of class ParsedFormat.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        ParsedFormat instance = new ParsedFormat();
        instance.setColor(Color.red);
        Color result = instance.getColor();
        
        Color expResult = Color.red;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class ParsedFormat.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color color = Color.red;
        ParsedFormat instance = new ParsedFormat();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFunction method, of class ParsedFormat.
     */
    @Test
    public void testGetFunction() {
        System.out.println("getFunction");
        ParsedFormat instance = new ParsedFormat();
        instance.setFunction("sin(x)");
        String result = instance.getFunction();
        String expResult = "sin(x)";
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFunction method, of class ParsedFormat.
     */
    @Test
    public void testSetFunction() {
        System.out.println("setFunction");
        String Function = "sin(x)";
        ParsedFormat instance = new ParsedFormat();
        instance.setFunction(Function);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRanges method, of class ParsedFormat.
     */
    @Test
    public void testGetRanges() {
//        System.out.println("getRanges");
//        ParsedFormat instance = new ParsedFormat();
//        double[] expResult = null;
//        double[] result = instance.getRanges();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setRanges method, of class ParsedFormat.
     */
    @Test
    public void testSetRanges() {
        System.out.println("setRanges");
//        double[] Ranges = null;
//        ParsedFormat instance = new ParsedFormat();
//        instance.setRanges(Ranges);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
