import java.util.*;

/** Test program for the ArrayStringSet class */

public class Tester {

  public static void main(String args[]) {
 
    String s = "BOS";
    String t = "JFK";
       
    ArrayStringSet A = new ArrayStringSet();
    A.put(s);           // The string s is put into A so that 
                        // A = { "BOS" }.

    System.out.print("The set A = "); 
    A.print();

    A.put(t);           // The string t is put into A so that
                        // A = { "BOS", "JFK" }.

    A.put("BDL");       // The string "BDL" is put into A so that
                        // A = { "BDL", "BOS", "JFK"}.

    System.out.print("The set A = ");
    A.print();

    A.put("BOS");       // The string "BOS" is put into A but A should
                        // remain unchanged.

    System.out.print("The set A = "); 
    A.print();

    System.out.println("A.contains(\"JFK\") = " + A.contains("JFK"));

    A.remove("BOS");    // The string "BOS" is removed from A so that 
                        // A = {"BDL", "JFK"}.

    System.out.print("The set A = ");
    A.print();

    System.out.println("A.contains(\"BOS\") = " + A.contains("BOS"));

    ArrayStringSet B = new ArrayStringSet();

    Random r = new Random();
    int j;
    for (int i = 0; i < 26; i++) {
      j = r.nextInt(26);
      String u = "" + (char)('A' + j);
      B.put(u);
    }

    System.out.print("The set B = ");
    B.print();

    B.remove("K");
    B.put("T");

    System.out.print("The set B = ");
    B.print();

  }

}
