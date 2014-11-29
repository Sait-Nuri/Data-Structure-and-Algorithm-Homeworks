/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw03;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author said
 * @param <E>
 */
public class GITLinkedList<E> implements GITList<E>{

    private final KWLinkedList theList;
    
    private int size;
    
    public GITLinkedList() {
        theList = new KWLinkedList();
        size = 0;
    }    
        
    /**
     * @param index index of the list to which item to be added
     * @param obj item
     * Asymtotic notation: worst-case O(n) 
     */
    @Override
    public void add(int index, E obj) {
        theList.add(index, obj);
        setSize(getSize() + 1);
    }

    /**
     * @param item item to be added to first index of the list
     * Asymtotic notation: worst-case O(1) 
     */
    @Override
    public void addFirst(E item) {
        theList.addFirst(item);
        setSize(getSize() + 1);
    }

    /**
     * @param item item to be added to last index of the list     
     * Asymtotic notation: worst-case O(1) 
     */
    @Override
    public void addLast(E item) {
        theList.addLast(item);
        setSize(getSize() + 1);
    }

    /**
     * @param index index of the list to return
     * @return element get by indicated by index
     * Asymtotic notation: worst-case O(1) 
     */
    @Override
    public E get(int index) {
        return (E)theList.get(index);
    }

    /**
     * @return first item of the list
     * Asymtotic notation: worst-case O(1) 
     */
    @Override
    public E getFirst() {
        return (E) theList.getFirst();
    }

    /**
     * @return last item of the list
     * Asymtotic notation: worst-case O(1) 
     */
    @Override
    public E getLast() {
        return (E) theList.getLast();
    }

    /**
     * @return iterator
     * Asymtotic notation: worst-case O(1) 
     */
    @Override
    public Iterator<E> iterator() {
        return theList.iterator();
    }

    /**
     * @return ListIterator
     * Asymtotic notation: worst-case O(1) 
     */
    @Override
    public ListIterator<E> listIterator() {
        return theList.listIterator();
    }

    /**
     * @param l a GITList
     * @return true if all elements of l are added in the list, false otherwise
     * Asymtotic notation: worst-case O(n) 
     */
    @Override
    public boolean addAll(GITList<E> l) {        
        
        if(l.getSize() == 0)
            return false;
        
        for (int i = 0; i < l.getSize(); i++) {
            theList.addLast(l.get(i));
        }
        
        return true;
    }

    /**
     * @param l a GITList
     * @return true if l contains all elements of l
     * Asymtotic notation: worst-case O(n) 
     */
    
    @Override
    public boolean containsAll(GITList<E> l) {
        if( (this.getSize() != l.getSize()) || (l == null) )
            return false;
        
        Iterator iter = l.listIterator();
        
        for (int i = 0; i < l.getSize(); i++) {
            if(theList.get(i).equals(iter.next()))
                return false;
        }
                
        return true;
    }

    /**
     * @param l a GITList
     * @return true if the elements of the list is removed with the same elements of l, false otherwise
     * Asymtotic notation: worst-case O(n) 
     */
    @Override
    public boolean removeAll(GITList<E> l) {
        
        boolean deleted = false;
        
        if(l.getSize() == 0)
            return false;                
        
        Iterator iter = l.listIterator();
        
        while(iter.hasNext()){
            E element = (E)iter.next();
            
            for (int i = 0; i < this.getSize(); i++) {                
                if(element.equals(this.get(i))){
                    remove(i);
                    deleted = true;
                }
            }
        }
        
        return deleted;
    }
    
    /**
     * @param l a GITList
     * @return true if the list retains all of l, false otherwise
     * Asymtotic notation: worst-case O(n) 
     */
    
    @Override
    public boolean retainAll(GITList<E> l) {                        
        
        boolean delete = true;
        
        if(l.getSize() == 0)
            return false;                
               
        ListIterator my_iter = theList.listIterator();
        
        while(my_iter.hasNext()){
            E cur_data = (E) my_iter.next();
            for(int i = 0; i < l.getSize(); i++ ){
                if(cur_data.equals(l.get(i))){
                   delete = false; 
                }
            }
            if(delete){
                my_iter.remove();
            }
            delete = true;
        }
        
        return true;
    }

    /**
     * @return the size
     * Asymtotic notation: worst-case O(1) 
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     * Asymtotic notation: worst-case O(1) 
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param index the size to set
     * Asymtotic notation: worst-case O(n) 
     */
    @Override
    public void remove(int index) {        
        
        ListIterator iter = theList.listIterator(index);
        iter.next();
        iter.remove();
        
    }
    
}
