/**
 * This class implements an integer set that supports six operations, namely, 
 * testing emptiness, membership, insertion, removal, sorting and printing.
 * 
 * @author Sam Johnson and Steven Yee
 * @version 1.0 01/30/2014 
 */

public class IntegerSet {
    
  public static final int MAX_SIZE = 1000; // Maximum capacity

  private int elements[];
  private int size;                       // The actual size

  /**
   * Creates an array of MAX_SIZE capacity and initializes the set's size to
   * 0 (i.e., it creates an empty set).
   */
  public IntegerSet() {
    elements = new int[MAX_SIZE];
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   *
   * @return A boolean value for whether or not the array is empty.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns true if this set contains the integer n.
   * 
   * @param n Where n is the integer the user is checking for
   * @return A boolean value for whether or not Integer n is contained in the array
   */
  public boolean contains(int n) {
	for(int i = 0; i < size; i++){
		if(elements[i] == n){
			return true;
		}
	}
	return false;
  }

  /**
   * Inserts an integer n into the array elements[] and increments size by 1.
   *
   * @param n Where n is the integer the user wants to add
   */
   
  public void insert(int n) {

    // Fill in the blank here.
	if(!contains(n)){
		elements[size] = n;
		size++;
	}
    System.out.println("Inserting " + n + "...");
  }

  /**
   * Removes an integer n from the array elements[] and decrements size by 1.
   * 
   * @param n Where n is the integer that the user wants to remove
   */
  public void remove(int n) {
	if(!contains(n)){
		return; //Check
	}	
	else{
		int index = 0;
		for(int i = 0; i < size; i++){
        		if(elements[i] == n){
            			index = i;
        		}
    		}
		for(int c = 0;c < (size - index) - 1; c++){
			elements[index+c] = elements[index+c+1];
		}
		size--;
	}

    System.out.println("Removing " + n + "...");
  }

  /**
   * Sorts the integer of the array elements[] in the increasing order.
   */
  public void sort() {

    // Fill in the blank here.
	for(int i = 0; i < size; i++){
		int currentLowest, cLIndex, temp;
		currentLowest = elements[i];
		cLIndex = i; 
		for(int c = i+1; c < size; c++){
			if(currentLowest > elements[c]){
				currentLowest = elements[c];
				cLIndex = c;
			} 
		}
		temp = elements[i];
		elements[i] = elements[cLIndex];
		elements[cLIndex] = temp;
		
	}
    System.out.println("Sorting...");
  }

  /**
   * Prints all the elements of the array elements[].  Note that it uses 
   * the size as the loop bound.
   */
  public void print() {
    for (int i = 0; i < size; i++)
      System.out.print(elements[i] + " ");
    System.out.println();
  }

}
