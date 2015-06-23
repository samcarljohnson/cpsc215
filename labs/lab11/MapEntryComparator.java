/**
 * File: MapEntryComparator.java
 * 
 * This class defines a comparator for Map.Entry<String, Integer> objects.
 *
 * @author Takunari Miyazaki
 * @author Sam Johnson
 * @author Diego Lobo
 * @see java.util.Comparator
 * @see java.util.Map.Entry
 */

import java.util.*;

public class MapEntryComparator<E> implements Comparator<E> {

  /**
   * Returns a negative integer, zero, or a positive integer as the first 
   * argument is less than, equal to, or greater than the second.
   *
   * @param a First entry.
   * @param b Second entry.
   * @return Negative # if a<b, Positive # if a>b, 0 if a=b.
   */
  public int compare(E a, E b) {
    // Complete this method.
		return -1 * ((Map.Entry<String,Integer>)a).getValue().compareTo(((Map.Entry<String,Integer>)b).getValue());
  }

}
