/** 
* File: MyTextEditor.java
*
* Implementation of the SimpleTextEditor interface.
* 
* @author Sam Johnson
* @version 1.0, 03/17/2014
* @see IndexOutOfBoundsException
* @see InvalidPositionException
* @see BoundaryViolationException
* @see EmptyDequeException
*/

public class MyTextEditor implements SimpleTextEditor{
	protected ArraySequence<String> S;
	protected int cursor;
	
	public MyTextEditor(){
		S = new ArraySequence<String>();
		cursor = -1;
	}

	/** Returns true if the text is completely empty (and cursor is at line -1).
	* @return True if the text editor is empty (has no lines), false otherwise.
	*/
	public boolean isEmpty(){
		return (S.isEmpty() && cursor == -1);
	}

	/** Returns the current number of lines of text. 
	* @return The size of the list.
	*/
	public int size(){
		return S.size();
	}

	/** Returns true if the cursor is at the last line in the text or the text 
	* is empty.
	* @return True if the cursor is at the last line in the text editor.
	*/
	public boolean isCursorAtLastLine(){
		return (S.atIndex(cursor) == S.last());
	}

	/** Sets the cursor to be the text line after its current position.
	*/
	public void cursorDown() throws BoundaryViolationException{
		S.atIndex(cursor++);
	}

	/** Sets the cursor to be the text line before its current position.
	*/
	public void cursorUp() throws BoundaryViolationException{
		S.atIndex(cursor--);
	}

	/** Sets the cursor to be the line ranked i (the first line is line 0).
	* @param i The input line number.
	*/
	public void moveCursorToLine(int i) throws BoundaryViolationException{
		S.atIndex(cursor = i);
	}

	/** Returns the line number (rank) of the current cursor line.
	* @return The line number the cursor is on.
	*/
	public int cursorLineNum(){
		return cursor+1;
	}

	/** Inserts a string s in the line after the current cursor, moving the
	* cursor to the line inserted.
	* @param s The input string.
	*/
	public void insertAfterCursor(String s){
		cursor++;
		S.add(cursor, s);
	}

	/** Inserts a string s in the line before the current cursor, moving the
	* cursor to the line inserted.
	* @param s The input string.
	*/
	public void insertBeforeCursor(String s) throws BoundaryViolationException{
		S.atIndex(cursor);
		S.add(cursor, s);
	}

	/** Replaces the string at the current cursor with the String s, keeping
	* the cursor at this line.
	* @param s The input string.
	*/
	public void replaceAtCursor(String s) throws BoundaryViolationException{
		S.atIndex(cursor);
		S.set(cursor, s);
	}

	/** Removes the entire line at the current cursor, setting the cursor to now
	* be the position of the next line, unless the cursor was the last line, 
	* in which case the cursor should move to the new last line.
	*/
	public void removeAtCursor() throws BoundaryViolationException{
		if(S.atIndex(cursor) == S.last()){
			S.remove(cursor);
			cursor--;
		}
		else{
			S.remove(cursor);
		}
	}

	/** Prints the entire text to the console.
	*/
	public void print(){
		for(int i = 0; i < S.size(); i++){
			System.out.print(S.atIndex(i).element());
		}
	}
}