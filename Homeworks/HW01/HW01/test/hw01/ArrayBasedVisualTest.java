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
public class ArrayBasedVisualTest {
    
    public ArrayBasedVisualTest() {
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
     * Test of getData method, of class ArrayBasedVisual.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        ArrayBasedVisual instance = new ArrayBasedVisual();
        VisualData[] expResult = new VisualData[3];
        
        expResult[0].setFunction("sin(x)");
        expResult[1].setFunction("x");
        expResult[2].setFunction("log(x)");
        
        expResult[0].setColor(Color.red);
        expResult[1].setColor(Color.green);
        expResult[2].setColor(Color.yellow);
        
        double ranges[] = new double[2];
        
        ranges[0] = -3.0;
        ranges[1] = 3.0;
        expResult[0].setRanges(ranges);
        
        ranges[0] = -10;
        ranges[1] = 50;
        expResult[1].setRanges(ranges);
        
        ranges[0] = -50;
        ranges[1] = 50;        
        expResult[2].setRanges(ranges);
        
        VisualData[] result = instance.getData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addNewVisualData method, of class ArrayBasedVisual.
     */
    @Test
    public void testAddNewVisualData() {
        System.out.println("addNewVisualData");
        VisualData vd = null;
        ArrayBasedVisual instance = new ArrayBasedVisual();
        instance.addNewVisualData(vd);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parser method, of class ArrayBasedVisual.
     */
    @Test
    public void testParser() {
        System.out.println("parser");
        String line = "sin(x), -3.0, 3.0, red";
        ArrayBasedVisual instance = new ArrayBasedVisual();
        ParsedFormat expResult = new ParsedFormat();       
        
        expResult.setFunction("sin(x)");
        expResult.setColor(Color.red);
        double ranges[] = new double[2];
        ranges[0] = -3.0;
        ranges[1] = 3.0;
        expResult.setRanges(ranges);
        
        ParsedFormat result = instance.parser(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parseFunc method, of class ArrayBasedVisual.
     */
    @Test
    public void testParseFunc() {
        System.out.println("parseFunc");
        String foo = "sin(x)";
        ArrayBasedVisual instance = new ArrayBasedVisual();
        String expResult = "sin(x)";
        String result = instance.parseFunc(foo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parseRange method, of class ArrayBasedVisual.
     */
    @Test
    public void testParseRange() {
        System.out.println("parseRange");
        String preParsedRange1 = " -3.0";
        String preParsedRange2 = " 3.0";
        ArrayBasedVisual instance = new ArrayBasedVisual();
        double[] expResult = new double[2];
        expResult[0] = -3.0;
        expResult[1] = 3.0;
        
        double[] result = instance.parseRange(preParsedRange1, preParsedRange2);
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parseColor method, of class ArrayBasedVisual.
     */
    @Test
    public void testParseColor() {
        System.out.println("parseColor");
        String preParsedColor = "red";
        ArrayBasedVisual instance = new ArrayBasedVisual();
        Color expResult = Color.red;
        Color result = instance.parseColor(preParsedColor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ArrayBasedVisual.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ArrayBasedVisual instance = new ArrayBasedVisual();
        String expResult = "";
        String result = instance.toString();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadData method, of class ArrayBasedVisual.
     */
    @Test
    public void testLoadData() {
        System.out.println("loadData");
        ArrayBasedVisual instance = new ArrayBasedVisual();
        //ArrayBasedVisual.pf = new  
        //instance.loadData();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
