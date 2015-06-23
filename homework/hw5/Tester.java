/** 
* Test program for the NodeDeque class 
* @author Sam Johnson
* @version 1.0, 02/24/2014
*/

public class Tester{
	public static void main(String [ ] args){
		NodeDeque<String> n = new NodeDeque<String>();
		
		// Test of size() and isEmpty() on an empty NodeDeque.
		System.out.println("Size of the Node Deque: " + n.size());
		System.out.println("Is this Node Deque empty? (T/F): " + n.isEmpty());
		
		// Testing the addFirst(), addLast(), getFirst(), getLast() methods.
		n.addFirst("Sam");
		System.out.println("The first element is: " + n.getFirst());
		n.addLast("Joe");
		System.out.println("The last element is: " + n.getLast());
		
		// First test of size() and isEmpty() on a populated NodeDeque.
		System.out.println("Size of the Node Deque: " + n.size());
		System.out.println("Is this Node Deque empty? (T/F): " + n.isEmpty());
		System.out.println("Adding 3 elements to the front and 3 to the back of the deque...");
		n.addLast("TJ");
		n.addFirst("Brandon");
		n.addLast("Ryan");
		n.addFirst("Tim");
		n.addLast("Mike");
		n.addFirst("Bill");
		
		// After adding more elements to the NodeDeque, tests the removeFirst()
		// removeLast() functions and they're return values for correctness.
		System.out.println("Size of the Node Deque: " + n.size());
		System.out.println("Is this Node Deque empty? (T/F): " + n.isEmpty());
		System.out.println("Removing first element, " + n.removeFirst() + "...");
		System.out.println("Size of the Node Deque: " + n.size());
		System.out.println("Removing last element, " + n.removeLast() + "...");
		System.out.println("Size of the Node Deque: " + n.size());
		System.out.println("The first element is: " + n.getFirst());
		System.out.println("The last element is: " + n.getLast());
		
	
	}
}