/**
* File: DequeQueue.java
*
* This is a full implementation of the class DequeQueue.
* This uses methods from NodeDeque specific to a queue.
* @author Sam Johnson
* @version 1.0, 02/24/2014
* @see EmptyQueueException
* @see Queue
*/

public class DequeQueue<E> implements Queue<E>{

	protected NodeDeque<E> queue;
	
	public DequeQueue(){
		queue = new NodeDeque<E>();
	}
	/** 
	* Returns the number of elements in the queue.
	* @return number of elements in the queue.
	*/
	public int size(){
		return queue.size();
	}  

	/** 
	* Returns whether the queue is empty.
	* @return true if the queue is empty, false otherwise.
	*/
	public boolean isEmpty(){
		return queue.isEmpty();
	}

	/**
	* Inspects the element at the front of the queue.
	* @return element at the front of the queue.
	* @exception EmptyQueueException if the queue is empty.
	*/
	public E front() throws EmptyQueueException{
		return queue.getFirst();
	}

	/** 
	* Inserts an element at the rear of the queue.
	* @param element new element to be inserted.
	*/
	public void enqueue(E element){
		queue.addLast(element);
	}

	/** 
	* Removes the element at the front of the queue.
	* @return element removed.
	* @exception EmptyQueueException if the queue is empty.
	*/
	public E dequeue() throws EmptyQueueException{
		return queue.removeFirst();
	}

}