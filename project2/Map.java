/**
 * File: Map.java
 *
 * An interface for the ADT map.
 *
 * @author Takunari Miyazaki
 * @see Entry
 * @see InvalidKeyException
 * @see Iterable
 */

public interface Map<K,V> {

  /** Returns the number of entries in the map. */
  public int size();

  /** Tests whether the map is empty. */
  public boolean isEmpty();

  /** Returns a value whose associated key is k. */
  public V get(K k) throws InvalidKeyException;

  /** Insert an entry with a given key k and value v into the map, returning 
   *  the old value whose associated key is k if it exists. */
  public V put(K k, V v) throws InvalidKeyException;

  /** Removes from the map the entry whose key is k, returning the value of 
   *  the removed entry. */
  public V remove(K k) throws InvalidKeyException;

  /** Returns an iterable collection of all keys in the map. */
  public Iterable<K> keySet();

  /** Returns an iterable collection of all values in the map. */
  public Iterable<V> values();

  /** Returns an iterable collection of all key-value entries in the 
   *  map. */
  public Iterable<Entry<K,V>> entrySet();

}