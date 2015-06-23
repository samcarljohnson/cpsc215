/**
 * This class implements a set of strings using a linked list to support five 
 * operations, namely, testing emptiness, membership, insertion, removal, and 
 * printing.
 *
 * @author Sam Johnson and Adam Krog
 * @version 1.0, 02/06/2014
 */

public class StringSet {
    
  private Node head;
  private int size;                       // The actual size

  /**
   * Creates an empty list and initializes the set's size to 0 (i.e., it 
   * creates an empty set).
   */
  public StringSet() {
    head = null;
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns, if it exists, a node containing a string s.
   *
   * @param s String to find
   * @return The Node that contains the string or null if it's not present
   */
  private Node find(String s) {
  	Node n = head;
	for(int i = 0; i < size; i++){
		if(n.getElement().equals(s))
			return n;
		else{
			n = n.getNext();
		}
	}
	return null; //doesn't exist	
  }

  /**
   * Returns true if the set contains a string s.
   *
   * @param s String to find
   * @return True or false value that represents whether or not the
   * contains s
   */
  public boolean contains(String s) {
	Node n = find(s);
	if(n == null)
		return false;
	else
		return true;
  }

  /**
   * Inserts a string s into the list and increments size by 1, base on
   * alphabetical order.
   *
   * @param s Inserts a string into the linked list based on alphabetical order. 
   * @return none
   */
  public void insert(String s) {
    if (!contains(s)) {
		if(isEmpty()){
			Node n = new Node(s,null);
			head = n;
			size++;
		}
		else{
			Node inc = head;
			Node prev = new Node("empty", null);
			Node inserted = new Node(s,null);	
			for(int i = 0; i < size; i++){
				if(s.compareTo(inc.getElement()) < 0 && i == 0){
					inserted.setNext(head);
					head = inserted;
				}
				else if(s.compareTo(inc.getElement()) < 0){
					inserted.setNext(inc);
                                        prev.setNext(inserted);
				}
				else if(size-1 == i){
                                        inc.setNext(inserted);
				}
				else{
					prev = inc;
					inc = inc.getNext();
				}
			}
			size++;
		}
      System.out.println("Inserting " + s + "...");
    }
    else
      System.out.println("Inserting " + s + "..., but " + s + 
                         " already exists.");
  }

  /**
   * Removes a string s from the list and decrements size by 1.
   *
   * @param s String to be removed
   * @return none
   */
  public void remove(String s) {
    Node r = find(s);
    if (r == null) 
      System.out.println("Removing " + s + "..., but " + s +
		         " does not exist.");
    else {
		Node n = head;
		Node temp;
		for(int i = 0; i < size; i++){
			if(n.getNext() == r){
				temp = n;
				temp.setNext(n.getNext().getNext());
				r.setNext(temp);
				size--;
			}
			else
				n = n.getNext();
		}

      System.out.println("Removing " + s + "...");
    }
  }

  /**
   * Prints all the strings in the list.
   */
  public void print() {
    Node n = head;
    System.out.print("{ ");
    while (n != null) {
      System.out.print(n.getElement());
      if (n.getNext() != null) 
	System.out.print(", ");
      n = n.getNext();
    }
    System.out.println(" }");
  }

}
