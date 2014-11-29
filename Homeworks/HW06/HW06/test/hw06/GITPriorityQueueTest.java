/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw06;

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
public class GITPriorityQueueTest {
    
    GITPriorityQueue instance;
    Object item1;
    Object item2;
    Object item3;
    Object item4;
    Object item5;
    Object item6;
    Object item7;
    Object item8;
    
    public GITPriorityQueueTest() {
        instance = new GITPriorityQueue();
                
        item1 = new Integer("15");
        item2 = new Integer("10");
        item3 = new Integer("20");
        item4 = new Integer("17");
        item5 = new Integer("2");
        item6 = new Integer("12");
        item7 = new Integer("13");
        item8 = new Integer("1");
        
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        instance.offer((Integer) item1);        
        instance.offer((Integer) item2);        
        instance.offer((Integer) item3);        
        instance.offer((Integer) item4);        
        instance.offer((Integer) item5);        
        instance.offer((Integer) item6);        
        instance.offer((Integer) item7);        
        instance.offer((Integer) item8);        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of offer method, of class GITPriorityQueue.
     */
    @Test
    public void testOffer() {
        System.out.println("offer");
        
        
        boolean expResult = true;
        boolean result = instance.offer(new Integer("0"));     
        
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class GITPriorityQueue.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");

        Object expResult = new Integer("1");
        int cmp;
        cmp = ((Integer)expResult).compareTo((Integer)instance.remove());
        assertTrue(cmp == 0);        
    }

    /**
     * Test of poll method, of class GITPriorityQueue.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        Object expResult = new Integer("1");
        Object result = instance.poll();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of peek method, of class GITPriorityQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        Object expResult = new Integer("1");
        Object result = instance.peek();
        assertEquals(expResult, result);

    }

    /**
     * Test of element method, of class GITPriorityQueue.
     */
    @Test
    public void testElement() {
        System.out.println("element");
        Object expResult = new Integer("1");
        Object result = instance.element();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method, of class GITPriorityQueue.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        boolean expResult = true;
        boolean result = instance.isFull(instance.root);
        assertEquals(expResult, result);
    }
    
}
