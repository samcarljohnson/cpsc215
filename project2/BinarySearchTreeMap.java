/**
 * File: BinarySearchTreeMap.java
 *
 * Realization of a map by means of a binary search tree
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @author Sam Johnson
 * @see Entry
 * @see InvalidEntryException
 * @see InvalidKeyException
 * @see Iterable
 * @see LinkedBinaryTree
 * @see Map
 * @see Position
 * @see java.util.ArrayList
 *
 * @author Sam Johnson
 * @version 1.0, 04/28/2014
 */
import java.util.ArrayList;

public class BinarySearchTreeMap<K,V> extends LinkedBinaryTree<Entry<K,V>> 
  implements Map<K,V> {

  protected Comparator<K> C; // comparator
  protected Position<Entry<K,V>> actionPos; // a node variable 
  protected int numEntries = 0; // number of entries

  /** Creates a BinarySearchTreeMap with a default comparator. */
  public BinarySearchTreeMap()  { 
    C = new DefaultComparator<K>(); 
    addRoot(null);
  }

  public BinarySearchTreeMap(Comparator<K> c)  { 
    C = c; 
    addRoot(null);
  }
  
  /** Nested class for location-aware binary search tree entries. */
  protected static class BSTEntry<K,V> implements Entry<K,V> {
    protected K key;
    protected V value;
    protected Position<Entry<K,V>> pos;
    BSTEntry() { /* default constructor */ }
    BSTEntry(K k, V v, Position<Entry<K,V>> p) { 
      key = k; value = v; pos = p;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public Position<Entry<K,V>> position() { return pos; }
  }

  /** Extracts the key of the entry at a given node of the tree. */
  protected K key(Position<Entry<K,V>> position)  {
    return position.element().getKey();
  }

  /** Extracts the value of the entry at a given node of the tree. */  
  protected V value(Position<Entry<K,V>> position)  { 
    return position.element().getValue(); 
  }

  /** Extracts the entry at a given node of the tree. */  
  protected Entry<K,V> entry(Position<Entry<K,V>> position)  { 
    return position.element();
  }

  /** Replaces an entry with a new entry (and reset the entry's location). */
  protected V replaceEntry(Position <Entry<K,V>> pos, Entry<K,V> ent) {
    ((BSTEntry<K,V>) ent).pos = pos;
    return replace(pos, ent).getValue();
  }

  /** Checks whether a given key is valid. */  
  protected void checkKey(K key) throws InvalidKeyException {
    if(key == null) // just a simple test for now
      throw new InvalidKeyException("null key");
  }

  /** Checks whether a given entry is valid. */
  protected void checkEntry(Entry<K,V> ent) throws InvalidEntryException {
    if (ent == null || !(ent instanceof BSTEntry))
      throw new InvalidEntryException("invalid entry");
  }

  /** Auxiliary method for inserting an entry at an external node.  Inserts e 
   *  at v, expanding v to be internal with empty external children, and then 
   *  returns e. 
	 *	@param v The position to insert at.
	 *	@return The entry that was inserted.
	 */
  protected Entry<K,V> insertAtExternal(Position<Entry<K,V>> v, Entry<K,V> e) {
		/* This code was submitted but incorrect...
     if(isInternal(v))
			throw new InvalidPositionException("This is not a valid position.");
		insertLeft(v, new BSTEntry<K,V>());
		insertRight(v, new BSTEntry<K,V>());
		replaceEntry(v,e);

		numEntries++;
		return e;
    */
     
    // Correct code below...
    if (isExternal(v)){
      replace(v, e);
      numEntries++;
      BSTEntry<K,V> newEmpty = new BSTEntry<K,V>();
      insertLeft(v, newEmpty);
      insertRight(v, newEmpty);
      return e;
    }
    else
      System.out.println("The node passed wasn't external");
    return null;
  }

  /** Auxiliary method for removing an external node and its parent.  Removes 
   *  v and its parent, replacing v's parent with v's sibling. 
	 *	@param v The position to remove.
	 */
  protected void removeExternal(Position<Entry<K,V>> v) throws InvalidPositionException{
		if(isInternal(v))
			throw new InvalidPositionException("This is not a valid position.");
    Position<Entry<K,V>> parent = parent(v);
    Entry<K,V> sibling = sibling(v).element();
    remove(v);
    replace(parent, sibling);
    remove(parent);
    numEntries--;
  }

  /** Auxiliary method used by get, put, and remove. */
  protected Position<Entry<K,V>> treeSearch(K key, Position<Entry<K,V>> pos) {
    if (isExternal(pos)) return pos; // key not found; return external node
    else {
      K curKey = key(pos);
      int comp = C.compare(key, curKey);
      if (comp < 0) 
	return treeSearch(key, left(pos)); // search left subtree
      else if (comp > 0)
	return treeSearch(key, right(pos)); // search right subtree
      return pos; // return internal node where key is found
    }
  }

  // methods of the map ADT

  /** Returns the number of entries in the map. */
  public int size() { return numEntries; }

  /** Tests whether the map is empty. */
  public boolean isEmpty() { return size() == 0; }

  /** Returns a value whose associated key is k. */
  public V get(K key) throws InvalidKeyException {
    checkKey(key); // may throw an InvalidKeyException
    Position<Entry<K,V>> curPos = treeSearch(key, root());
    actionPos = curPos; // node where the search ended
    if (isInternal(curPos)) return value(curPos);
    return null;
  }

  /** Inserts an entry with a given key k and value v into the map, returning 
   *  the old value whose associated key is k if it exists. */
  public V put(K k, V x) throws InvalidKeyException {
    checkKey(k); // may throw an InvalidKeyException
    Position<Entry<K,V>> insPos = treeSearch(k, root());
    BSTEntry<K,V> e = new BSTEntry<K,V>(k, x, insPos);
    actionPos = insPos; // node where the entry is being inserted
    if (isExternal(insPos)) { // we need a new node, key is new
      insertAtExternal(insPos, e).getValue();
      return null;
    }
    return replaceEntry(insPos, e); // key already exists
  }

  /** Removes from the map the entry whose key is k, returning the value of 
   *  the removed entry. */
  public V remove(K k) throws InvalidKeyException  {
    checkKey(k); // may throw an InvalidKeyException
    Position<Entry<K,V>> remPos = treeSearch(k, root());
    if (isExternal(remPos)) return null; // key not found
    Entry<K,V> toReturn = entry(remPos); // old entry 
    if (isExternal(left(remPos))) remPos = left(remPos); // left case
    else if (isExternal(right(remPos))) remPos = right(remPos); // right case
    else { // entry is at a node with internal children
      Position<Entry<K,V>> swapPos = remPos; // find node for moving entry
      remPos = right(swapPos);
      do remPos = left(remPos);
      while (isInternal(remPos));
      replaceEntry(swapPos, (Entry<K,V>) parent(remPos).element());
    }
    actionPos = sibling(remPos); // sibling of the leaf to be removed
    removeExternal(remPos);
    return toReturn.getValue();
  }

	/** Helper method that returns an array of the Entries in 'inorder' fashion
	 *	@param root Root node to traverse from.
	 *  @param list An ArrayList containing the entries of the binary tree, T. 
	 */	
	public void inorder(Position<Entry<K,V>> v, ArrayList<Position<Entry<K,V>>> list){
	 if (hasLeft(v))
		 inorder(left(v), list);
	 list.add(list.size(), v);
	 if (hasRight(v))
		 inorder(right(v), list);
 }

  /** Returns an iterable collection of the keys of all entries stored in the 
   *  map (in inorder). 
   * @return An iterable collection of keys.
   */
  public Iterable<K> keySet() {
		ArrayList<Position<Entry<K,V>>> positions = new ArrayList<Position<Entry<K,V>>>();
		NodePositionList<K> returned = new NodePositionList<K>();
	 	if(!isEmpty())
			inorder(root(), positions);
	 	for(int i = 0; i < positions.size(); i++){
 			Position<Entry<K,V>> pos = positions.get(i);
 			if(pos.element().getKey() != null){
				K key = pos.element().getKey();
 				returned.addLast(key);
			}
	 	}
    return returned;
  }

  /** Returns an iterable collection of the values of all entries stored in 
   *  the map (in inorder). 
   * @return An iterable collection of values.
   */
  public Iterable<V> values() {
		ArrayList<Position<Entry<K,V>>> positions = new ArrayList<Position<Entry<K,V>>>();
		NodePositionList<V> returned = new NodePositionList<V>();
	 	if(!isEmpty())
			inorder(root(), positions);
	 	for(int i = 0; i < positions.size(); i++){
 			Position<Entry<K,V>> pos = positions.get(i);
 			if(pos.element().getValue() != null){
				V val = pos.element().getValue();
 				returned.addLast(val);
			}
	 	}
    return returned;
  }

  /** Returns an iterable collection of all entries stored in the map (in 
   *  inorder). 
   * @return An iterable collection of entries.
   */
  public Iterable<Entry<K,V>> entrySet() {
		ArrayList<Position<Entry<K,V>>> positions = new ArrayList<Position<Entry<K,V>>>();
		NodePositionList<Entry<K,V>> returned = new NodePositionList<Entry<K,V>>();
	 	if(!isEmpty())
			inorder(root(), positions);
	 	for(int i = 0; i < positions.size(); i++){
 			Position<Entry<K,V>> pos = positions.get(i);
 			if((pos.element().getKey() != null) && (pos.element().getValue() != null)){
				Entry<K,V> ent = pos.element();
 				returned.addLast(ent);
			}
	 	}
    return returned;
  }

}
