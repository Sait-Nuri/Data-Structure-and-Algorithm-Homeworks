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
public class VisualTest {
    
    public VisualTest() {
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
     * Test of addNewVisualData method, of class Visual.
     */
    @Test
    public void testAddNewVisualData() {
//        System.out.println("addNewVisualData");
//        VisualData vd = null;
//        Visual instance = new VisualImpl();
//        instance.addNewVisualData(vd);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of loadData method, of class Visual.
     */
    @Test
    public void testLoadData() {
        System.out.println("loadData");
        Visual instance = new VisualImpl();
        instance.loadData();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Visual.
     */
    @Test
    public void testGetData() {
//        System.out.println("getData");
//        Visual instance = new VisualImpl();
//        VisualData[] expResult = null;
//        VisualData[] result = instance.getData();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of parser method, of class Visual.
     */
    @Test
    public void testParser() {
//        System.out.println("parser");
//        String line = "";
//        Visual instance = new VisualImpl();
//        ParsedFormat expResult = null;
//        ParsedFormat result = instance.parser(line);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of parseFunc method, of class Visual.
     */
    @Test
    public void testParseFunc() {
//        System.out.println("parseFunc");
//        String str1 = "";
//        Visual instance = new VisualImpl();
//        String expResult = "";
//        String result = instance.parseFunc(str1);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of parseRange method, of class Visual.
     */
    @Test
    public void testParseRange() {
//        System.out.println("parseRange");
//        String str1 = "";
//        String str2 = "";
//        Visual instance = new VisualImpl();
//        double[] expResult = null;
//        double[] result = instance.parseRange(str1, str2);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of parseColor method, of class Visual.
     */
    @Test
    public void testParseColor() {
        System.out.println("parseColor");
        String str = "red";
        Visual instance = new VisualImpl();
        Color expResult = Color.red;
        Color result = instance.parseColor(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class VisualImpl implements Visual {

        public void addNewVisualData(VisualData vd) {
        }

        public void loadData() {
        }

        public VisualData[] getData() {
            return null;
        }

        public ParsedFormat parser(String line) {
            return null;
        }

        public String parseFunc(String str1) {
            return "";
        }

        public double[] parseRange(String str1, String str2) {
            return null;
        }

        public Color parseColor(String str) {
            return null;
        }
    }
    
}
