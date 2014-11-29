package hw06;

/**
 *
 * @author ahmedius
 * @param <E>
 */
public interface PriorityQueue<E>{
    
    /**
     * Insert an item into the priority queue. 
     * @param item The item to be inserted
     * @return boolean, is item inserted or not
     * @throws NullPointerException if the item to be inserted is null.
     */
    public boolean offer(E item);
    
    /**
     * Remove an item from the priority queue.
     *
     * @return The item with the smallest priority.If queue is empty,
     * throw exception.
     */
    public E remove();
    
    /**
     * Remove an item from the priority queue.
     *
     * @return The item with the smallest priority value or null if empty.
     */
    public E poll();
    
    //Get smallest element, if queue is empty, return null.
    public E peek();
    
    //Get smallest element, if queue is empty, throw exception.
    public E element();
    
}
