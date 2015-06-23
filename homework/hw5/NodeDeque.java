/**
* File: NodeDeque.java
*
* This is a full implementation of the class NodeDeque which 
* uses Nodes to implement a deque.
* @author Sam Johnson
* @version 1.0, 02/24/2014
* @see EmptyDequeException
* @see Deque
*/

public class NodeDeque<E> implements Deque<E> {

	protected DLNode<E> header, trailer;  // sentinels
	protected int size;                   // number of elements

	public NodeDeque() {
		header = new DLNode<E>();
		trailer = new DLNode<E>();
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;
	}

	/**
	* Returns the number of elements in the NodeDeque.
	* @return number of elements in the NodeDeque.
	*/
	public int size() {   
		return size;
	}

	/** 
	* Returns whether the NodeDeque is empty.
	* @return true is the NodeDeque is empty, false if it is not.
	*/
	public boolean isEmpty() {    
		if (size == 0)
		  return true;
		return false;
	}

	/** 
	* Returns the first element; an exception is thrown if NodeDeque is empty.
	* @return the first element in the NodeDeque.
	* @exception EmptyDequeException if the deque is empty.
	*/
	public E getFirst() throws EmptyDequeException {  
		if (isEmpty())
		  throw new EmptyDequeException("Deque is empty.");
		return header.getNext().getElement();
	}

	/** 
	* Returns the last element; an exception is thrown if NodeDeque is empty.
	* @return the last element in the NodeDeque.
	* @exception EmptyDequeException if the deque is empty.
	*/
	public E getLast() throws EmptyDequeException {  
		if (isEmpty())
		  throw new EmptyDequeException("Deque is empty.");
		return trailer.getPrev().getElement();
	}

	/**
	* Inserts an element to be the first in the NodeDeque.
	* @param o The element to be added to the front of the NodeDeque.
	* @return none
	*/
	public void addFirst(E o) {  
		DLNode<E> second = header.getNext();
		DLNode<E> first = new DLNode<E>(o, header, second);
		second.setPrev(first);
		header.setNext(first);
		size++;
	}

	/**
	* Inserts an element to be the last in the NodeDeque.
	* @param o The element to be added to the end of the NodeDeque.
	* @return none
	*/
	public void addLast(E o){
		DLNode<E> secondLast = trailer.getPrev();
		DLNode<E> last = new DLNode<E>(o, secondLast, trailer);
		secondLast.setNext(last);
		trailer.setPrev(last);
		size++;
	}

	/** 
	* Removes the first element; an exception is thrown if NodeDeque is empty.
	* @return The element that was removed from the front of the NodeDeque.
	* @exception EmptyDequeException if the deque is empty.
	*/
	public E removeFirst() throws EmptyDequeException {
		if (isEmpty())
		  throw new EmptyDequeException("Deque is empty.");
		DLNode<E> first = header.getNext();
		E o = first.getElement();
		DLNode<E> second = first.getNext();
		header.setNext(second);
		second.setPrev(header);
		size--; 
		return o;
	}

	/** 
	* Removes the last element; an exception is thrown if NodeDeque is empty.
	* @return The element that was removed from the end of the NodeDeque.
	* @exception EmptyDequeException if the deque is empty.
	*/
	public E removeLast() throws EmptyDequeException {
		if (isEmpty())
		  throw new EmptyDequeException("Deque is empty.");
		DLNode<E> last = trailer.getPrev();
		E o = last.getElement();
		DLNode<E> secondtolast = last.getPrev();
		trailer.setPrev(secondtolast);
		secondtolast.setNext(trailer);
		size--; 
		return o;
	}
}
