/**
 * File: Tester.java
 *
 * This is a simple test driver application to test your BinarySearchTreeMap 
 * class.  It should perform the following operations.
 * 1. Insert all strings contained in the array S into the binary search 
 *    tree bst using the strings as keys and arbitrary integers as values.
 * 2. Print all entries as legible key-value pairs using the method 
 *    entrySet().
 * 3. Test the methods get(), put() and remove().
 * 4. Print all values using the method values().
 * 5. Print all keys using the method keys().
 *
 * @author Sam Johnson
 * @version 1.0, 04/27/2014
 */

public class Tester {

  public static void main(String args[]) {
    BinarySearchTreeMap<String, Integer> bst 
      = new BinarySearchTreeMap<String, Integer>();
    String S[] = {"gamma", "phi", "beta", "alpha", "delta", "lambda", 
      "epsilon", "zeta" };
		
    // Complete the blank here to perform 1, 2, 3, 4 and 5.
    
    //----- Part 1 -----
    System.out.println("----- Part 1 -----");
    System.out.println("Inserting the contents of S into the tree...\n");
    for(int i = 0; i < S.length; i++){
      bst.put(S[i], i);
    }
    
    //----- Part 2 -----
    System.out.println("----- Part 2 -----\n");
		Iterator<Entry<String, Integer>> iter = bst.entrySet().iterator();
    while(iter.hasNext()){
      Entry<String, Integer> currentEntry = iter.next();
      System.out.println("{\"" + currentEntry.getKey() + "\", " +
                       currentEntry.getValue() + "}");
    }
    
    //----- Part 3 -----
    System.out.println("\n----- Part 3 -----");
    System.out.println("\nTesting get(\"alpha\") -> old value: " + bst.get("alpha"));
    System.out.println("Testing put(\"alpha\", 50) -> old value: " + bst.put("alpha", 50));
    System.out.println("Testing put(\"sam\", 21) -> old value: " + bst.put("sam", 21));
    System.out.println("Testing remove(\"sam\") -> old value: " + bst.remove("sam"));
    System.out.println("\nWhat the new map looks like: ");
    iter = bst.entrySet().iterator();
    while(iter.hasNext()){
      Entry<String, Integer> currentEntry = iter.next();
      System.out.println("{\"" + currentEntry.getKey() + "\", " +
                         currentEntry.getValue() + "}");
    }
    
    //----- Part 4 -----
    System.out.println("\n----- Part 4 -----\n");
		Iterator<Integer> val_iter = bst.values().iterator();
    while(val_iter.hasNext()){
      Integer currentEntry = val_iter.next();
      System.out.println("{ " + currentEntry + " }");
    }
    
    //----- Part 5 -----
    System.out.println("\n----- Part 5 -----\n");
		Iterator<String> key_iter = bst.keySet().iterator();
    while(key_iter.hasNext()){
      String currentEntry = key_iter.next();
      System.out.println("{\"" + currentEntry + "\"}");
    }
    
    
    
  }

}
