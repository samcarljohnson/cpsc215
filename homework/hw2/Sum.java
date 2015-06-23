/** Sum.java produces a progression where each value is the sum of all previous values
 *
 *  @author Sam Johnson
 *  @version 1.0 01/31/2014
 *  @see Progression
 */

class Sum extends Progression {

  /** Previous value. */
  long prev;

  // Inherits variables first and cur.

  /** Default constructor setting 1 as the starting value 
  */
  Sum() {
    this(1);
  }

  /** Parametric constructor providing the first and second values.
   *
   *  @param value1 first value.
   *  @param value2 second value.
   */
  Sum(long value1) {
    first = value1;
    prev = value1;
  }

  /** nextValue() Calculates the absolute value of the difference between the first
   *  and second value.
   *
   *  @return next value of the progression
   */
  protected long nextValue() {
    long temp = cur;
    prev = cur;
    cur += temp;
    return cur;
  }

  // Inherits methods firstValue() and printProgression(int).
}

