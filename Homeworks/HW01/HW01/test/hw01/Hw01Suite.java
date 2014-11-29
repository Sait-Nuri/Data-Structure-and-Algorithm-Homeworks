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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author said
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({hw01.VisualDataTest.class, hw01.ParsedFormatTest.class, hw01.VisualConsoleTest.class, hw01.ArrayBasedVisualTest.class, hw01.ListBasedVisualTest.class, hw01.VisualUserInterfaceTest.class, hw01.VisualAppTest.class, hw01.CanvasTest.class, hw01.VisualGUITest.class, hw01.VisualTest.class})
public class Hw01Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
