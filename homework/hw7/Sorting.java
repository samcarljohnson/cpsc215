/**
 * File: Sorting.java
 *
 * We compare the performances of sorting algorithms by counting the numbers 
 * of comparisons performed.
 *
 * @author Takunari Miyazaki
 * @author Sam Johnson
 * @see ArrayIndexList
 * @see IndexList
 * @see Integer
 * @see Iterator
 * @version 1.0, 04/09/2014
 */

public class Sorting {

  /** This method prints the elements of an array list L. */
  public static <E> void printIndexList(IndexList<E> L) {
    Iterator<E> i = L.iterator();
    while (i.hasNext())
      System.out.print(i.next().toString() + " ");
    System.out.println();
  }

  /** This method swaps two elements of an array list L at indices i and j. */
  public static <E> void swap(IndexList<E> L, int i, int j) {
    E e = L.get(i);
    L.set(i, L.get(j));
    L.set(j, e);
  }

  /** 
  * This method bubble-sorts (in place) the elements of an array list L. 
  *
  * @param L The IndexList to sort.
  * @return The amount of comparisons performed.
  */
	public static <E> int bubblesort(IndexList<E> L){
		int count = 0;
  	int n = L.size();
    for (int i = 1; i < n; i++) {  // count how many times
    	//This next loop becomes shorter and shorter
    	for (int j = 0; j < n-i; j++) {
				count++;
    		if (((Comparable) L.get(j)).compareTo(L.get(j+1)) > 0){
    			swap(L, j, j+1);
    		}
    	}
    }
    return count;
	}

  /** 
  * This method selection-sorts the elements of an array list L. 
  *
  * @param L The IndexList to sort.
  * @return The amount of comparisons performed.
  */
	public static <E> int selectionsort(IndexList<E> L){
		int count = 0;       
  	int n = L.size();
		for (int i = 0; i < n-1; i++){
  		int minIndex = i;
  		for (int j = i+1; j < n; j++){
				count++;
  			if (((Comparable) L.get(j)).compareTo(L.get(minIndex)) < 0){     
  				minIndex = j;
				}
			}
			if(minIndex != i)
				swap(L, i, minIndex);
  	}
  	return count;
  }

  /** 
  * This method heap-sorts (in place) the elements of an array list L. 
  *
  * @param L The IndexList to sort.
  * @return The amount of comparisons performed.
  */
  public static <E> int heapsort(IndexList<E> L) {
    int count = 0;
		int n = L.size();
    //The first phase builds a heap, one at a time, of heapsize.
    for (int heapsize = 0; heapsize < n; heapsize++) {
      int i = heapsize;
      while (i > 0) {
				int j = (i - 1)/2;
				count++;
				if (((Comparable) L.get(i)).compareTo(L.get(j)) > 0) {
	  			swap(L, i, j);
	  			i = j;
				}
				else
    			break;
      }
    }
    
		//The second phase is completed below.
    while(n > 0){
      swap(L, 0, n - 1);
      --n; //Leave the sorted element alone
      int i = 0; //"Unordered Node's" index
			int leftIdx = 1; //Initialize to 0's left child
			int rightIdx = 2; //Initialize to 0's right child
			int greatestNode = -1;
      //Begin pushing unOrNode down the heap.
      while(leftIdx < n || rightIdx < n){
				//Checks if leftIdx is within the heap and then if max heap
				//order has been violated (L[leftIdx] > L[i])
				count++;
				if(leftIdx < n && ((Comparable) L.get(leftIdx)).compareTo(L.get(i)) > 0){
						greatestNode = leftIdx;
					}
				else
					greatestNode = i; //For the first iteration set greatestNode to i
				//Checks if rightIdx is within the heap and then if
				//L[rightIdx] is greater than L[greatestNode]
				count++;
				if(rightIdx < n){
					if(((Comparable) L.get(rightIdx)).compareTo(L.get(greatestNode)) > 0){
						greatestNode = rightIdx;
					}
				}
				//If there's swapping required, do it...
        if(greatestNode != i){
					swap(L, i, greatestNode);
          i = greatestNode;
        }
				//...Otherwise, we're done
				else
					break;
				//After the swap, set new values for leftIdx and rightIdx 
        leftIdx = (i * 2) + 1;
				rightIdx = (i * 2) + 2;
    	}   
  	}
		return count; 
  }

  /** This method compares the performaces of sorting algorithms. */
  public static void main(String args[]) {
    java.util.Random r = new java.util.Random();

    //Instantiate a list of 20 random integers between 0 and 19.
    IndexList<Integer> L20 = new ArrayIndexList<Integer>();
    for (int i = 0; i < 20; i++)
      L20.add(i, new Integer(Math.abs(r.nextInt()) % 20));

		//Instantiate a list of 20 random integers between 0 and 19.
    IndexList<Integer> L20b = new ArrayIndexList<Integer>();
    for (int i = 0; i < 20; i++)
	    L20b.add(i, new Integer(Math.abs(r.nextInt()) % 20));

		//Instantiate a list of 20 random integers between 0 and 19.
    IndexList<Integer> L20s = new ArrayIndexList<Integer>();
    for (int i = 0; i < 20; i++)
      L20s.add(i, new Integer(Math.abs(r.nextInt()) % 20));

    //Test heap sort.
    System.out.println("Testing heap sort...");
    System.out.print("Input:  ");
    printIndexList(L20);
    heapsort(L20);
    System.out.print("Output: ");
    printIndexList(L20);

		//Test bubble sort.
    System.out.println("\nTesting bubble sort...");
    System.out.print("Input:  ");
    printIndexList(L20b);
    bubblesort(L20b);
    System.out.print("Output: ");
    printIndexList(L20b);

		//Test selection sort.
    System.out.println("\nTesting selection sort...");
    System.out.print("Input:  ");
    printIndexList(L20s);
    selectionsort(L20s);
    System.out.print("Output: ");
    printIndexList(L20s);
    
    //Test Comparisons for n = 10.
    IndexList<Integer> L10 = new ArrayIndexList<Integer>();
    for (int i = 0; i < 10; i++)
      L10.add(i, new Integer(Math.abs(r.nextInt()) % 10));
    IndexList<Integer> L10b = new ArrayIndexList<Integer>();
    for (int i = 0; i < 10; i++)
      L10b.add(i, new Integer(Math.abs(r.nextInt()) % 10));
    IndexList<Integer> L10s = new ArrayIndexList<Integer>();
    for (int i = 0; i < 10; i++)
      L10s.add(i, new Integer(Math.abs(r.nextInt()) % 10));
      
    int heapComp1 = heapsort(L10);
    int bubbleComp1 = bubblesort(L10b);
    int selectionComp1 = selectionsort(L10s);
    
		//Comparison results for n = 10.
    System.out.print("\n");
		System.out.println("For n = 10, Bubble sort performs " + bubbleComp1 + 
			" comparisons.");
		System.out.println("For n = 10, Selection sort performs " + selectionComp1 + 
			" comparisons.");
		System.out.println("For n = 10, Heap sort performs " + heapComp1 + 
    	" comparisons.");
		
		//Test comparisons for n = 100.
		IndexList<Integer> L100 = new ArrayIndexList<Integer>();
    for (int i = 0; i < 100; i++)
      L100.add(i, new Integer(Math.abs(r.nextInt()) % 100));
    IndexList<Integer> L100b = new ArrayIndexList<Integer>();
    for (int i = 0; i < 100; i++)
      L100b.add(i, new Integer(Math.abs(r.nextInt()) % 100));
    IndexList<Integer> L100s = new ArrayIndexList<Integer>();
    for (int i = 0; i < 100; i++)
      L100s.add(i, new Integer(Math.abs(r.nextInt()) % 100));
      
    int heapComp2 = heapsort(L100);
    int bubbleComp2 = bubblesort(L100b);
    int selectionComp2 = selectionsort(L100s);
    
		//Test comparisons for n = 100.
    System.out.print("\n");
		System.out.println("For n = 100, bubble sort performs " + bubbleComp2 + 
			" comparisons.");
		System.out.println("For n = 100, selection sort performs " + selectionComp2 + 
			" comparisons.");
		System.out.println("For n = 100, heap sort performs " + heapComp2 + 
    	" comparisons.");
  }
}
