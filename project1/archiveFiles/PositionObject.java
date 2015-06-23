/** 
* File: PositionObject.java
*
* The implementation of Position<E> to be used with ArraySequence.java.
* 
* @author Sam Johnson
* @version 1.0, 03/17/2014
*/

public class PositionObject<E> implements Position<E>{
	protected E element;
	protected int index;
	
	public PositionObject(int i, E e){
		element = e;
		index = i;
	}
	
	/** Return the element at the PositionObject.
	* @return The element at the PositionObject.
	*/
	public E element(){
		return element;
	}
	
	/** Sets the element at the PositionObject.
	* @param e The input element.
	*/
	public void setElement(E e){
		element = e;
	}
	
	/** Returns the index of the PositionObject.
	* @return The index of the PositionObject.
	*/
	public int getIndex(){
		return index;
	}
	
	/** Sets the index of the PositionObject.
	* @param i The input index.
	*/
	public void setIndex(int i){
		index = i;	
	}
}