/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw03;

import java.util.Iterator;
import java.util.ListIterator;
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
public class GITArrayListTest {
    private GITArrayList<String> myArray;
    
    public GITArrayListTest() {
        myArray = new GITArrayList<>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        myArray.addFirst("1");
        myArray.addLast("2");
        myArray.addLast("3");
    }
    
    @After
    public void tearDown() {
        myArray = new GITArrayList<>();
    }

    /**
     * Test of add method, of class GITArrayList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int index = 0;
        String obj = "1";
        GITArrayList instance = new GITArrayList();
        instance.add(index, obj);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addFirst method, of class GITArrayList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        String item = "1";
        GITArrayList instance = new GITArrayList();
        instance.addFirst(item);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addLast method, of class GITArrayList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        String item = "1";
        GITArrayList instance = new GITArrayList();
        instance.addLast(item);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class GITArrayList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 2;        
        String expResult = "3";
        String result = myArray.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFirst method, of class GITArrayList.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");        
        String expResult = "1";
        String result = myArray.getFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLast method, of class GITArrayList.
     */
    @Test
    public void testGetLast() {
        System.out.println("getLast");
        GITArrayList instance = new GITArrayList();
        String expResult = "3";
        String result = myArray.getLast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class GITArrayList.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");        
        int expResult = 3;
        int result = myArray.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class GITArrayList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 2;
        GITArrayList instance = new GITArrayList();
        instance.addFirst("1");
        instance.addLast("2");
        instance.addLast("3");
        instance.remove(index);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class GITArrayList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        GITArrayList instance;
        instance = myArray;
        Iterator expResult = myArray.listIterator();
        Iterator result = instance.iterator();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class GITArrayList.
     */
    @Test
    public void testListIterator() {
        System.out.println("listIterator");
        GITArrayList instance;
        instance = myArray;
        ListIterator expResult = myArray.listIterator();
        ListIterator result = instance.listIterator();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class GITArrayList.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        GITArrayList instance = new GITArrayList();
        boolean expResult = true;
        boolean result = instance.addAll(myArray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of containsAll method, of class GITArrayList.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        GITArrayList instance = new GITArrayList();
        instance.addFirst("1");
        instance.addLast("2");
        boolean expResult = true;
        boolean result = instance.containsAll(myArray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class GITArrayList.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        GITArrayList instance = new GITArrayList();
        instance.addFirst("1");
        boolean expResult = true;
        boolean result = instance.removeAll(myArray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class GITArrayList.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        GITArrayList instance = new GITArrayList();
        instance.addFirst("1");
        boolean expResult = true;
        boolean result = instance.retainAll(myArray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
