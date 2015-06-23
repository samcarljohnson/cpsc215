/** MyProgression.java takes the absolute value of the difference of two numbers
 *  and multiplies them together to get the next number in the progression.  
 *
 *  @author Sam Johnson
 *  @version 1.0 01/31/2014
 *  @see Progression
 */

class MyProgression extends Progression {

  // Previous value
  long prev;

  // Inherits variables first and cur.

  /** Default constructor setting 2 and 1 as the starting values 
   *  2 and 1 are the values that I chose so that this series creates a 
   *  repeating pattern like that in Difference.
   */
  MyProgression() {
    this(2,1);
  }

  /** Parametric constructor providing the first and second values.
   *
   *  @param value1 first value.
   *  @param value2 second value.
   */
  MyProgression(long value1, long value2) {
    first = value1;
	prev = value2;
  }

  /** nextValue() Calculates the absolute value of the difference of the last 2
   *  terms and then multiplies that result by the previous term.
   *
   *  @return next value of the progression
   */
  protected long nextValue() {
    long oldcur = cur;
	long temp;
    temp = prev - cur;
	if(temp < 0)
		temp *= -1;
    cur = temp * prev;
	prev = oldcur;
    return cur;
  }

  // Inherits methods firstValue() and printProgression(int).
}
