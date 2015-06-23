/** 
* File: ArraySequence.java
*
* An array based implementation of a sequence.
* 
* @author Sam Johnson
* @version 1.0, 03/17/2014
* @see IndexOutOfBoundsException
* @see InvalidPositionException
* @see BoundaryViolationException
* @see EmptyDequeException
*/

public class ArraySequence<E> implements Sequence<E>, PositionList<E>, IndexList<E>, Deque<E>{
	
	protected PositionObject<E> S[];
	protected int capacity = 16;
	protected int size = 0;
	
	public ArraySequence(){
		S = (PositionObject<E>[]) new PositionObject[capacity];
	}
	
	// ----- IndexList Methods ----- //
	
	/** Returns the size of the list.
	* @return The size of the array sequence.
	*/
	public int size(){
		return size;
	}

	/** Checks whether the list is empty.
	* @return True if the list is empt, false otherwise.
	*/
	public boolean isEmpty(){
		return (size() == 0);
	}
	
	/** Checks whether the index r is in the range between 0 and n - 1.
	* @param r The index to check.
	* @param n The capacity of the array sequence.
	*/
	public void checkIndex(int r, int n) throws IndexOutOfBoundsException{
		if ((r < 0) || (r >= n))
			throw new IndexOutOfBoundsException("Given index is out of bounds.");
	}
	
	/** Inserts an element at the given index.
	* @param r The input index.
	* @param e the element to add to the index.
	*/
	public void add(int r, E e) throws IndexOutOfBoundsException{
		checkIndex(r, size() + 1);
		// Here we double the size of the array if there is an overflow.
		if (size == capacity){
			capacity *= 2;
			PositionObject<E>[] B =(PositionObject<E>[]) new PositionObject[capacity];
			for (int i = 0; i < size; i++) 
				B[i] = S[i];
			S = B;
		}
		if (r == size){
			S[r] = new PositionObject<E>(r, e);
			size++;
		}
		else{
			for(int i = size-1; i >= r; i--){ 
				S[i].setIndex(i+1);
				S[i+1] = S[i];	// shift elements up to make room for the add
			}
			S[r] = new PositionObject<E>(r, e); // Add a new PositionObject to the array
			size++;
		}
	}
	
	/** Returns the element at index r, without removing it.
	* @param r The input index.
	* @return The element a the input index.
	*/
	public E get(int r) throws IndexOutOfBoundsException {
		checkIndex(r, size());
		return S[r].element();
	}

	/** Removes the element stored at the given index.
	* @param r The input index
	* @return The element that was removed.
	*/
	public E remove(int r) throws IndexOutOfBoundsException {
		checkIndex(r, size());
		E temp = S[r].element();
		for(int i = r; i < size-1; i++){
			S[i].setIndex(i-1);   
			S[i] = S[i+1];	// shift elements down after the remove
		}
		size--;
		return temp;
	}

	/** Replaces the element at index r with e, returning the element.
	* @param r The input index.
	* @param e The input element.
	* @param The element that was at the input index before the set.
	*/
	public E set(int r, E e) throws IndexOutOfBoundsException {
		checkIndex(r, size());
		E temp = S[r].element();
		S[r].setElement(e);
		return temp;
	}
	
	// ----- PositionList Methods ----- //
	
	/** Returns the first node in the list.
	* @return The first Position of the list.
	*/
	public Position<E> first(){
		return S[0];
	}

	/** Returns the last node in the list.
	* @return The last Position in the list.
	*/
	public Position<E> last(){
		return S[size()-1];
	}

	/** Returns the node after a given node in the list.
	* @param p The input Position.
	* @return The next position in the list.
	*/
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		PositionObject<E> po = (PositionObject<E>) p;
		if(po.getIndex() < 0 || po.getIndex() >= size){
			throw new InvalidPositionException("This is not a valid position.");
		}
		if(po.getIndex() == size - 1){
			throw new BoundaryViolationException("The next position is out of bounds.");
		}
		return S[po.getIndex()+1];
	}

	/** Returns the node before a given node in the list.
	* @param p The input Position.
	* @return The previous position in the list.
	*/
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		PositionObject<E> po = (PositionObject<E>) p;
		if(po.getIndex() < 0 || po.getIndex() >= size){
			throw new InvalidPositionException("This is not a valid position.");
		}
		if(po.getIndex() == 0){
			throw new BoundaryViolationException("The previous position is out of bounds.");
		}
		return S[po.getIndex()-1];
	}

	/** Inserts an element at the front of the list. Also a deque method.
	* @param e The input element.
	*/
	public void addFirst(E e){
		add(0, e);	// Send to the add method above.
	}

	/** Inserts and element at the back of the list. Also a deque method.
	* @param e The input element.
	*/
	public void addLast(E e){
		add(size, e);	// Send to the add method above.
	}

	/** Inserts an element after the given node in the list.
	* @param p The input Position.
	* @param e The input element.
	*/
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		PositionObject<E> po = (PositionObject<E>) p;
		if(po.getIndex() < 0 || po.getIndex() >= size){
			throw new InvalidPositionException("This is not a valid position.");
		}
		int index = po.getIndex();
		add(index+1, e);	// Send to the add method above.
	}

	/** Inserts an element before the given node in the list.
	* @param p The input Position.
	* @param e The input element.
	*/
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		PositionObject<E> po = (PositionObject<E>) p;
		if(po.getIndex() < 0 || po.getIndex() >= size){
			throw new InvalidPositionException("This is not a valid position.");
		}
		int index = po.getIndex();
		add(index-1, e);	
	}
	
	/** Removes a node from the list, returning the element stored there. 
	* @param p The input Position.
	* @return The element that was removed.	
	*/
	public E remove(Position<E> p) throws InvalidPositionException{
		PositionObject<E> po = (PositionObject<E>) p;
		if(po.getIndex() < 0 || po.getIndex() >= size){
			throw new InvalidPositionException("This is not a valid position.");
		}
		int index = po.getIndex();
		return remove(index);
	}

	/** Replaces the element stored at the given node, returning old element. 
	* @param p The input Position.
	* @param e The input element.
	* @return The element that was at position p before the set.	
	*/
	public E set(Position<E> p, E e) throws InvalidPositionException{
		PositionObject<E> po = (PositionObject<E>) p;
		if(po.getIndex() < 0 || po.getIndex() >= size){
			throw new InvalidPositionException("This is not a valid position.");
		}
		int index = po.getIndex();
		return set(index, e);
	}
	
	// ----- Sequence Methods ----- //
	
	/** Returns the position containing the element at the given index. 
	* @param r The input index.
	* @return The position at index r.
	*/
	public Position<E> atIndex(int r) throws BoundaryViolationException{
		if ((r < 0) || (r >= size())){
			throw new BoundaryViolationException("The index is out of bounds.");
		}
		return S[r];
	}

	/** Returns the index of the element stored at the given position. 
	* @param p The input Position.
	* @return The index of the position p.
	*/
	public int indexOf(Position<E> p) throws InvalidPositionException{
		PositionObject<E> po = (PositionObject<E>) p;
		if(po.getIndex() < 0 || po.getIndex() >= size){
			throw new InvalidPositionException("This is not a valid position.");
		}
		return po.getIndex();
	}
	
	// ----- Deque Methods ----- //
	
	/** Returns the first element; an exception is thrown if deque is empty. 
	* return The first element in the list.
	*/
	public E getFirst() throws EmptyDequeException{
		if(isEmpty()){
			throw new EmptyDequeException("There are no elements.");
		}
		return S[0].element();
	}
	
	/** Returns the last element; an exception is thrown if deque is empty. 
	* @return The last element in the list.
	*/
	public E getLast() throws EmptyDequeException{
		if(isEmpty()){
			throw new EmptyDequeException("There are no elements.");
		}
		return S[size()-1].element();	
	}
	
	/** Removes the first element; an exception is thrown if deque is empty. 
	* @return The element that was removed.
	*/
	public E removeFirst() throws EmptyDequeException{
		if(isEmpty()){
			throw new EmptyDequeException("There are no elements.");
		}
		return remove(0);
	}
	
	/** Removes the last element; an exception is thrown if deque is empty. 
	* @return The element that was removed.
	*/
	public E removeLast() throws EmptyDequeException{
		if(isEmpty()){
			throw new EmptyDequeException("There are no elements.");
		}
		return remove(size()-1);
	}
}