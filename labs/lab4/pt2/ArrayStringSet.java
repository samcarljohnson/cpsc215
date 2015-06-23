/**
 * This class implements a set of strings using an array to support five 
 * operations, namely, testing emptiness, membership, insertion, removal and 
 * printing.
 * 
 * @author Sam Johnson
 * @version 1.0, 02/13/2014
 */

public class ArrayStringSet {

  public static final int MAX_SIZE = 1000; // Maximum capacity

  private String elements[];
  private int size;                       // The actual size

  /**
   * Creates an array of MAX_SIZE capacity and initializes the set's size to
   * 0 (i.e., it creates an empty set).
   */
  public ArrayStringSet() {
    elements = new String[MAX_SIZE];
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the index of a given string s if it exists or -1 if it does not.
   *
   * @param s The string to locate
   * @return The index of the string in the array or -1 if it doesn't exist
   */
  private int locate(String s) {
 	for(int i = 0; i < size; i++){
		if(elements[i].equals(s))
			return i;
	} 
	return -1;
  }

  /**
   * Returns true if the set contains a string s.
   *
   * @param s The string to seach for
   * @return True or false if the string is in the array
   */
  public boolean contains(String s) {
	if(locate(s) >= 0)
		return true;
	else
		return false;
  }

  /**
   * Puts a string s into the array and increments size by 1, keeping the 
   * elements sorted.
   *
   * @param s The string to put into the array
   * @return none
   */
  public void put(String s) {
    if (!contains(s)) {
		elements[size] = s;
		String temp_str = "";
		size++;
		if(size>1){
			for(int i = size-1; i > 0; i--){
				if(elements[i].compareTo(elements[i-1]) < 0){
					temp_str = elements[i-1];
					elements[i-1] = elements[i];
					elements[i] = temp_str;
				}
				else
					break;
			}
		}

      System.out.println("Putting " + s + "...");
    }
    else
      System.out.println("Putting " + s + "..., but " + s + 
                         " already exists.");
  }

  /**
   * Removes a string s from the array and decrements size by 1, keeping
   * the elements sorted.
   * 
   * @param s The string to remove from the array
   * @return none
   */
  public void remove(String s) {
    int i = locate(s);
    if (i == -1) 
      System.out.println("Removing " + s + "..., but " + s +
		         " does not exist.");
    else {
		elements[i] = elements[size-1]; // Swap for Part II of Assignment
		size--;
		int count = 0;
		String temp_str = "";
		for(count = i; count < size; count++){
			if(elements[count].compareTo(elements[count+1]) > 0){
				temp_str = elements[count+1];
				elements[count+1] = elements[count];
				elements[count] = temp_str;
			}
			else
				break;
		}
      System.out.println("Removing " + s + "...");
    }
  }

  /**
   * Prints all the strings in the array.
   */
  public void print() {    
    System.out.print("{ ");
    for (int i = 0; i < size - 1; i++)
      System.out.print(elements[i] + ", ");
    if (!isEmpty())
      System.out.print(elements[size - 1]);
    System.out.println(" }");
  }

}
