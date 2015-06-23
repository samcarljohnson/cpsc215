/**
 * File: Tester.java
 *
 * This is a tester class
 *
 * @author Sam Johnson
 * @author Suhas Maringanti
 * @version 1.0, 03/06/2014
 */
 
public class Tester {

  /**
   * Prints all the elements of a given node list using an iterator.
   */
  public static <E> void print(PositionList<E> l) {
    Iterator<E> i = l.iterator();
    System.out.print("[");
    while (i.hasNext()) {
      System.out.print(i.next());
      if (i.hasNext())
	System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String args[]) {

	// Tests the cases given from the handout (in the book)
    NodePositionList<Integer> list = new NodePositionList<Integer>();
    list.addFirst(8);
    print(list);
    Position<Integer> p1 = list.first();
    list.addAfter(p1, 5);
    print(list);
    Position<Integer> p2 = list.next(p1);
    print(list);
    list.addBefore(p2,3);
    print(list);
    Position<Integer> p3 = list.prev(p2);
    print(list);
    list.addFirst(9);
    print(list);
    p2 = list.last();
    print(list);
    list.remove(list.first());
    print(list);
    list.set(p3, 7);
    print(list);
    list.addAfter(list.first(), 2);
    print(list);
    
    // Iterator Test
    Iterator<Integer> iter = list.iterator();
    System.out.println("Testing the Original Iterator");
    while(iter.hasNext()){
    	System.out.print(iter.next());
    }
    System.out.println();
     
    // Reverse Iterator Test
    Iterator<Integer> rIter = list.reverseIterator();
    System.out.println("Testing the Reverse Iterator");
    while(rIter.hasNext()){
    	System.out.print(rIter.next());
    }
    System.out.println();   
    
    // Every Other Iterator Test
    Iterator<Integer> eoIter = list.everyOtherIterator();
    System.out.println("Testing the Every Other Iterator");
    while(eoIter.hasNext()){
    	System.out.print(eoIter.next());
    }
    System.out.println(); 
    
    

  }

}
