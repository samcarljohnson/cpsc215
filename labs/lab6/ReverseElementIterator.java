/**
 * File: ReverseElementIterator.java
 *
 * This class implements an iterator for the ADT node list.
 *
 * @author Sam Johnson
 * @author Suhas Maringanti
 * @version 1.0, 03/06/2014
 * @see NoSuchElementException
 */

public class ReverseElementIterator<E> implements Iterator<E> {

  protected PositionList<E> list;  // the underlying list
  protected Position<E> cursor;    // the next position

  /** Creates a reverse element iterator over the given list. 
  *	  This is the constructor.
  * @param L A NodePositionList to iterate over.
  */
  public ReverseElementIterator(PositionList<E> L) {
    list = L;
    cursor = (list.isEmpty())? null : list.last();
  }

  /** Tests whether there are elements left in the iterator. 
  * @return true if there is another element in the iterator.
  */
  public boolean hasNext() { return (cursor != null); }

  /** Returns the next element in the iterator. 
  * @return the next element in the iterator.
  */
  public E next() throws NoSuchElementException {
    if (cursor == null)
      throw new NoSuchElementException("No next element");
    E toReturn = cursor.element();
    cursor = (cursor == list.first())? null : list.prev(cursor);
    return toReturn;
  }

}
