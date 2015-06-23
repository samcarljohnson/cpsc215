/** 
* File: Johnson.java
*
* The tester file for MyTextEditor.java/ArraySequence.java
* 
* @author Sam Johnson
* @version 1.0, 03/17/2014
* @see IndexOutOfBoundsException
* @see InvalidPositionException
* @see BoundaryViolationException
* @see EmptyDequeException
*/

public class Johnson{
	public static void main(String argv[]){
		
		MyTextEditor T = new MyTextEditor();
		
		System.out.println("\n------initial.txt------\n");
		//Test one uses the lines that you see as different lines in the text editor.

		T.insertAfterCursor("Narnia...where the woods are thick and cool, where Talking Beasts are called to\n");
		T.insertAfterCursor("life, the land beyond the wardrobe, the secret country known only to Peter,\n");
		T.insertAfterCursor("Susan, Edmund, and Lucy. Narnia...where horses talk and hermits like company,\n");
		T.insertAfterCursor("where evil men turn into donkeys, where boys go into battle. \n");
		T.insertAfterCursor("Narnia...the land between the lamp-post and the castle of Cair Paravel,\n");
		T.insertAfterCursor("where animals talk, where magical things happen,the world of wicked dragons \n");
		T.insertAfterCursor("and magic spells, where the very best is brought out of even the worst people,\n");
		T.insertAfterCursor("where anything can happen(and most oftan does). \n");
		T.insertAfterCursor("Narnia...where owls are wise, where some of the giants like to\n");
		T.insertAfterCursor("snack on humans (and, if carefully cooked, on Marsh-wiggles, too), \n");
		T.insertAfterCursor("where a prince is put under an evil spell. \n");
		T.insertAfterCursor("Narnia...where dwarfs are loyal and tough and strong-or are they?\n");

		T.print();

		System.out.println("\n\n------middle.txt------\n");
		//Tests every method from MyTextEditor to change the text from initial.txt to match middle.txt
		
		if(!T.isEmpty())
			T.cursorUp();
		T.insertAfterCursor("\n");
		T.moveCursorToLine(4);
		T.insertBeforeCursor("\n");
		for(int i = 0; i < 4; i++)
			T.cursorDown();
		T.insertAfterCursor("\n");
		T.moveCursorToLine(0);
		T.replaceAtCursor("Narnia... where the woods are thick and cool, where Talking Beasts are called to\n");
		T.moveCursorToLine(3);
		T.removeAtCursor();
		T.insertBeforeCursor("where evil men turn into donkeys, where boys and girls go into battle.\n");
		T.cursorDown();
		T.cursorDown();
		T.replaceAtCursor("Narnia... the land between the lamp-post and the castle of Cair Paravel,\n");
		T.cursorDown();
		T.replaceAtCursor("where animals talk, where magical things happen, the world of wicked deans\n");
		T.moveCursorToLine(10);
		T.replaceAtCursor("Narnia... where professors are wise, where some of the giants like to\n");
		int currentLine = T.cursorLineNum();
		T.moveCursorToLine(currentLine);
		T.replaceAtCursor("snack on students (and, if carefully cooked, on Marsh-wiggles, too),\n");
		while(!T.isCursorAtLastLine())
			T.cursorDown();
		T.replaceAtCursor("Narnia... where dwarfs are loyal and tough and strong-or are they?\n");
		
		T.print();
		
		System.out.println("\n\n------final.txt------\n");
		//Converts middle.txt to final.txt using methods from MyTextEditor
		
		T.moveCursorToLine(2);
		T.replaceAtCursor("Susan, Edmund, and Lucy.\n");
		T.insertAfterCursor("\n");
		T.cursorDown();
		T.replaceAtCursor("Narnia... where horses talk and hermits like company,\n");
		T.cursorDown();
		T.replaceAtCursor("where evil men turn into donkeys, where boys and girls go into battle.\n");
		T.insertAfterCursor("\n");
		T.moveCursorToLine(10);
		T.replaceAtCursor("where anything can happen (and most often does). \n");
		T.moveCursorToLine(12);
		T.replaceAtCursor("Narnia... where owls are wise, where some of the giants like to\n");
		T.moveCursorToLine(16);
		T.replaceAtCursor("Narnia... where dwarfs are loyal and tough and strong---or are they really?\n");
		T.print();
	}
}