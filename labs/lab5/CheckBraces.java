/**
 * This program reads a text file specified in a command-line argument 
 * into a string named inString.  It also has a code segment to echo 
 * print inString.  To execute, assuming an input file is named filename 
 * and exists in the same directory as CheckBraces.class, type
 *
 *   java CheckBraces filename
 * 
 * @author Sam Johnson
 * @author Ian Weist
 * @version 1.0, 02/20/2014
 */

import java.io.*;

public class CheckBraces {

  public static void main(String args[]) {
    String inString = null;
    if (args.length < 1) {
      System.out.println("Usage: java CheckBraces sourcefile");
      return;
    }

    // Read the file named as the command-line argument
    try {
      File f = new File(args[0]);
      InputStreamReader inStream = 
        new InputStreamReader(new FileInputStream(f));
      int length = (int) f.length();
      char input[] = new char[length];
      inStream.read(input);
      inString = new String(input);
    } 
    catch (FileNotFoundException e) {
      System.err.println("Error: File " + args[0] + " not found");
      e.printStackTrace();
    }
    catch (IOException e) {
      System.err.println("Error: I/O exception");
      e.printStackTrace();
    }

    // Echo print the file
    for (int k = 0; k < inString.length(); k++)
      System.out.print(inString.charAt(k));
    System.out.println();

ArrayStack<Character> s = new ArrayStack<Character>();
	for(int i=0; i < inString.length(); i++){
		if(inString.charAt(i) == '{' || inString.charAt(i) == '(' || inString.charAt(i) == '[' ){
			s.push(inString.charAt(i));
		}
		else if(inString.charAt(i) == '}' ){
			if(s.size() == 0){
				System.out.println("Unmatched brace at character " +i+ ": No opening brace for " +inString.charAt(i)+ ".");
				break;
			}
			else if(s.top() == '{' ){
				s.pop();
			}
			else{
				System.out.println("Unmatched brace at character " +i+ ": Found " +inString.charAt(i)+ " expecting " +s.top());
				break;
			}
		}
		else if(inString.charAt(i) == ')'){
			if(s.size() == 0){
				System.out.println("Unmatched brace at character " +i+ ": No opening brace for " +inString.charAt(i) +".");
				break;
			}
			else if(s.top() == '(' ){
				s.pop();
			}
			else{
				System.out.println("Unmatched brace at character " +i+ ": Found " +inString.charAt(i)+ " expecting " +s.top());
				break;
			}
		}
		else if(inString.charAt(i) == ']'){
			if(s.size() == 0){
				System.out.println("Unmatched brace at character " +i+ ": No opening brace for " +inString.charAt(i) +".");
				break;
			}
			else if(s.top() == '[' ){
				s.pop();
			}
			else{
				System.out.println("Unmatched brace at character " +i+ ": Found " +inString.charAt(i)+ " expecting " +s.top());
				break;
			}
		}
	}
  }





}
