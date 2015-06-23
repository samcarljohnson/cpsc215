/**
 * This class implements a set of strings using a linked list to support five 
 * operations, namely, testing emptiness, membership, insertion, removal, and 
 * printing.
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
	//Node returned = new Node("false", head);	
	return null; //doesn't exist	
  }

  /**
   * Returns true if the set contains a string s.
   */
  public boolean contains(String s) {
	Node n = find(s);
	if(n == null)
		return false;
	else
		return true;
  }

  /**
   * Inserts a string s into the list and increments size by 1.
   */
  public void insert(String s) {
    if (!contains(s)) {
		Node n = new Node(s,head);
		head = n;
		size++; 
      System.out.println("Inserting " + s + "...");
    }
    else
      System.out.println("Inserting " + s + "..., but " + s + 
                         " already exists.");
  }

  /**
   * Removes a string s from the list and decrements size by 1.
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
			//Node next = n.getNext();
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
