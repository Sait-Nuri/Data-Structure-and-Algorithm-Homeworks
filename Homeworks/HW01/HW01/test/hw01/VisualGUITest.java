/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author said
 */
public class VisualGUITest {
    
    public VisualGUITest() {
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
     * Test of main method, of class VisualGUI.
     */
    @Test
    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        VisualGUI.main(args);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of command method, of class VisualGUI.
     */
    @Test
    public void testCommand() {
        System.out.println("command");
        VisualGUI instance = new VisualGUI();
        instance.command();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
