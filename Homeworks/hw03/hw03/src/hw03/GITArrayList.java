/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw03;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author said
 * @param <E>
 */
public class GITArrayList<E> implements GITList<E>{

    private KWArrayList<E> theArray;    
    private static final int INITIAL_SIZE = 10;
    
    public GITArrayList() {
        theArray = new KWArrayList();        
    }   
    
    /**
     * @param index index of the list to which item to be added
     * @param obj item
     * Asymtotic notation: Avarage-case:O(n)
     */
    @Override
    public void add(int index, E obj) {        
        KWArrayList<E> theData = new KWArrayList();
        
        for(int i = 0; i < theArray.size(); i++){
            if(i == index)
                theData.add(obj);
            
            theData.add(theArray.get(i));
        }
        theArray = theData;
    }

    /**
     * @param item item to be added to first index of the list
     * Asymtotic notation: worst-case:O(n)
     */
    @Override
    public void addFirst(E item) {
        KWArrayList<E> theData = new KWArrayList();
        theData.add(item);
        for (int i = 0; i < theArray.size(); i++) {
            theData.add(theArray.get(i));
        }
        theArray = theData;
    }

    /**
     * @param item item to be added to last index of the list     
     * Asymtotic notation:O(1)
     */
    @Override
    public void addLast(E item) {
        theArray.add(item);
    }

    /**
     * @param index index of the list to return
     * @return element get by indicated by index
     * Asymtotic notation: O(1);
     */
    @Override
    public E get(int index) {
        return theArray.get(index);
    }

    /**
     * @return first item of the list
     * Asymtotic notation: O(1)
     */
    @Override
    public E getFirst() {
        return theArray.get(0);
    }

    /**
     * @return last item of the list
     * Asymtotic notation: O(1)
     */
    @Override
    public E getLast() {
        return theArray.get(theArray.size()-1);
    }

    /**
     * @return size of the list
     * Asymtotic notation: O(1)
     */
    @Override
    public int getSize() {
        return theArray.size();
    }

    /**
     * @param index index of item to be removed
     * Asymtotic notation: O(n)
     */
    @Override
    public void remove(int index) {
        this.listIterator(index).remove();
    }
    
    /**
     * @return iterator
     * Asymtotic notation: O(1)
     */
    @Override
    public Iterator<E> iterator() {
        return new GITArrayIter(0);
    }

    /**
     * @return ListIterator
     * Asymtotic notation: O(1)
     */
    @Override
    public ListIterator<E> listIterator() {
        return new GITArrayIter(0);
    }

    /**
     * @return ListIterator
     * @param index index to iterate the list
     * Asymtotic notation: O(n)
     */
    private ListIterator<E> listIterator(int index) {
        return new GITArrayIter(index);
    }
    
    private class GITArrayIter implements ListIterator<E>{
        
        private int index;
        private int lastIndexReturned;
        
        public GITArrayIter(){
            index = 0;
            lastIndexReturned = -1;
        }
        
        /**
        * @param index
        * Asymtotic notation: O(n)
        */
        public GITArrayIter(int index) {
            if (index < 0 || index > theArray.size()) {
                throw new IndexOutOfBoundsException(
                "Invalid index " + index);
            }
            while(this.index != (index+1) ){
                next();                
            }
        }

        /**
        * @return  Returns true if this list iterator has more elements when 
        * traversing the list in the forward direction. 
        * Asymtotic notation: O(1)
        */
        @Override
        public boolean hasNext() {            
            return index+1 < theArray.size();
        }

        /**
        * @return  Returns the next element in the list and advances the cursor 
        * position. This method may be called repeatedly to iterate through the 
        * list, or intermixed with calls to previous() to go back and forth. 
        * Asymtotic notation: O(1)
        */
        @Override
        public E next() {
            if (!hasNext() && (theArray.size() == index) ) {
                throw new NoSuchElementException();
            }            
            lastIndexReturned = index;
            index++;
            return theArray.get(lastIndexReturned);
        }

        /**
        * @return true if this list iterator has more elements when traversing 
        * the list in the reverse direction. 
        * Asymtotic notation: O(1)
        */
        @Override
        public boolean hasPrevious() {
            if(index == 0)
                return false;
            
            return theArray.get(index-1) != null;
        }

        /**
        * @return Returns the previous element in the list and moves the cursor 
        * position backwards. This method may be called repeatedly to iterate 
        * through the list backwards, or intermixed with calls to next() to go back and forth.
        * Asymtotic notation: O(1)
        */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }                   
            
            index--;
            lastIndexReturned = index;
            return theArray.get(index);
        }

        /**
        * @return Returns the index of the element that would be returned by a 
        * subsequent call to next().
        * Asymtotic notation: O(1)
        */
        @Override
        public int nextIndex() {
            return index + 1;
        }

        /**
        * @return Returns the index of the element that would be returned by a 
        * subsequent call to previous(). 
        * Asymtotic notation: O(1)
        */
        @Override
        public int previousIndex() {
            return index - 1;
        }

        /**
        * Removes from the list the last element that was returned by next() or 
        * previous() (optional operation).
        * Asymtotic notation: O(n)
        */
        @Override
        public void remove() throws UnsupportedOperationException{
            if (lastIndexReturned == -1) {
                throw new IllegalStateException();
            }            
            
            KWArrayList<E> newArray = new KWArrayList();
            for (int i = 0; i < theArray.size(); i++) {
                if(i != lastIndexReturned)
                    newArray.add(theArray.get(i));
            }
            theArray = newArray;            
        }

        /**
        * @param e Replaces the last element returned by next() or previous() with
        * the specified element (optional operation).
        * @throws UnsupportedOperationException - if the add method is not supported by this list iterator
        * @throws ClassCastException - if the class of the specified element prevents it from being added to this list
        * @throws IllegalArgumentException - if some aspect of this element prevents it from being added to this list
        * Asymtotic notation: O(n)
        */
        @Override
        public void set(E e) {
            if (lastIndexReturned == -1) {
                throw new IllegalStateException();
            }            
            
            KWArrayList<E> newArray = new KWArrayList();
            for (int i = 0; i < theArray.size(); i++) {
                if(i == lastIndexReturned)
                    newArray.add(e);
                else
                    newArray.add(theArray.get(i));
            }
            theArray = newArray;                                                                        
        }

        /**
        * @param e Inserts the specified element into the list (optional operation).   
        * @throws UnsupportedOperationException - if the add method is not supported by this list iterator
        * @throws ClassCastException - if the class of the specified element prevents it from being added to this list
        * @throws IllegalArgumentException - if some aspect of this element prevents it from being added to this list
        * Asymtotic notation: O(1)
        */
        @Override
        public void add(E e) {
            theArray.add(e);
        }
        
    }
        
    @Override
    public boolean addAll(GITList<E> l) {
        if( l == null )
            throw new NullPointerException("The list does not exist...");
        
        if(l.getSize() == 0)
            return false;
        
        for (int i = 0; i < l.getSize(); i++) {
            theArray.add(l.get(i));
        }
        
        return true;
    }

    /**
    * Asymtotic notation: O(n)
    */
    @Override
    public boolean containsAll(GITList<E> l) {
        boolean contains = false;
        
        if( l == null )
            throw new NullPointerException("The list does not exist...");                
        
        ListIterator<E> iter = this.listIterator(0);
        
        while(iter.hasNext()){
            E theData = iter.next();
            for (int i = 0; i < l.getSize(); i++) {
                if(l.get(i).equals(theData))
                    contains = true;
            }
            if(!contains)
                return false;
            
            contains = false;
        }
        return true;
    }

    /**
    * Asymtotic notation: O(n)
    */
    @Override
    public boolean removeAll(GITList<E> l) {
        if(l == null)
            throw new IllegalStateException("The list does not exist");
        
        if(l.getSize() == 0)
            return true;
        
        Iterator<E> iter = l.listIterator();
        while(iter.hasNext()){
            E theData = iter.next();
            for (int i = 0; i < this.getSize(); i++) {
                if(theData.equals(theArray.get(i)))
                    theArray.remove(i);
            }
        }
        return true;
    }

    /**
    * Asymtotic notation: O(n)
    */
    @Override
    public boolean retainAll(GITList<E> l) {
        boolean delete = true;
        
        ListIterator<E> myiter = this.listIterator();
        while (myiter.hasNext()) {            
            E myData = myiter.next();
            for (int i = 0; i < l.getSize(); i++) {
                if(myData.equals(l.get(i)))
                    delete = false;
            }
            if(delete){
                myiter.previous();
                myiter.remove();
            }
            delete = true;
        }
        return true;
    }    

}
