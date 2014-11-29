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
public class GITLinkedListTest {
    
    private static GITLinkedList<String> list;
    
    public GITLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        list = new GITLinkedList();
        
    }
    
    @AfterClass
    public static void tearDownClass() {        
        
    }
    
    @Before
    public void setUp() {
        list.addFirst("1");
        list.addLast("2");
        list.addLast("3");
    }
    
    @After
    public void tearDown() {
        list = new GITLinkedList<String>();
    }

    /**
     * Test of add method, of class GITLinkedList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int index = 0;
        Object obj = new String("Adam");
        list.add(index, obj.toString());
        
        GITLinkedList instance = new GITLinkedList();
        instance = list;
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addFirst method, of class GITLinkedList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Object obj = new String("Adam");
        list.addFirst(obj.toString());
        
        GITLinkedList instance = new GITLinkedList();
        instance = list;
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addLast method, of class GITLinkedList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Object obj = new String("Adam");
        list.addLast(obj.toString());
        
        GITLinkedList instance = new GITLinkedList();
        instance = list;
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class GITLinkedList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 1;
        GITLinkedList instance = new GITLinkedList();
        Object expResult = new String("2");
        Object result = list.get(index);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFirst method, of class GITLinkedList.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        GITLinkedList instance = new GITLinkedList();
        Object expResult = new String("1");
        Object result = list.getFirst();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLast method, of class GITLinkedList.
     */
    @Test
    public void testGetLast() {
        System.out.println("getLast");
        GITLinkedList instance = new GITLinkedList();
        Object expResult = new String("3");
        instance = list;
        Object result = instance.getLast();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class GITLinkedList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        GITLinkedList instance = new GITLinkedList();
        Iterator expResult = list.iterator();
        
        instance = list;
        Iterator result = instance.iterator();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class GITLinkedList.
     */
    @Test
    public void testListIterator() {
        System.out.println("listIterator");
        GITLinkedList<String> instance = new GITLinkedList();
        ListIterator expResult = list.listIterator();
        
        instance = list;
        ListIterator result = instance.listIterator();
        
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class GITLinkedList.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        GITLinkedList<String> instance = new GITLinkedList();
        
        boolean expResult = true;
        boolean result = instance.addAll(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of containsAll method, of class GITLinkedList.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        GITLinkedList<String> instance = new GITLinkedList();
        boolean expResult = false;
        boolean result = instance.containsAll(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class GITLinkedList.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        GITLinkedList<String> instance = new GITLinkedList();
        boolean expResult = false;
        boolean result = instance.removeAll(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class GITLinkedList.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        GITLinkedList<String> instance = new GITLinkedList();
        boolean expResult = true;
        boolean result = instance.retainAll(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class GITLinkedList.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        GITLinkedList<String> instance = new GITLinkedList();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSize method, of class GITLinkedList.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int size = 2;
        GITLinkedList<String> instance = new GITLinkedList();
        instance.setSize(size);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class GITLinkedList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int i = 1;
        GITLinkedList<String> instance = new GITLinkedList();
        instance = list;
        
        instance.remove(i);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
