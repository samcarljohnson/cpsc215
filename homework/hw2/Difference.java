/** Difference.java produces a progression where each value is the absolute
 *  value of the difference between the previous two values.  
 *
 *  @author Sam Johnson
 *  @version 1.0 01/31/2014
 *  @see Progression
 */

class Difference extends Progression {

  /** Previous value. */
  long prev;

  // Inherits variables first and cur.

  /** Default constructor setting 1 and 100 as the first two values. 
  */
  Difference() {
    this(1,100 );
  }

  /** Parametric constructor providing the first and second values.
   *
   *  @param value1 first value.
   *  @param value2 second value.
   */
  Difference(long value1, long value2) {
    first = value1;
    prev = value1 + value2; 
	// Could also be (value1 - value2) but absolute value makes 'prev' ambiguous
  }

  /** nextValue() Calculates the absolute value of the difference between the first
   *  and second value.
   *
   *  @return next value of the progression
   */
  protected long nextValue() {
    long temp = prev;
    prev = cur;
    cur -= temp;
	if(cur < 0)
		cur *= -1;
    return cur;
  }

  // Inherits methods firstValue() and printProgression(int).
}
