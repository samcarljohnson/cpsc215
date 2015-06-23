/**
 * File: WordCount.java
 * 
 * This Java application counts the occurrence of each word in a given 
 * text file (specified as a command-line argument).
 *
 * @author Takunari Miyazaki
 * @author Sam Johnson
 * @author Diego Lobo
 * @see java.io.File
 * @see java.io.FileInputStream
 * @see java.io.FileNotFoundException
 * @see java.io.IOException
 * @see java.io.InputStreamReader
 * @see java.util.StringTokenizer
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordCount {

  public static void main(String args[]) {
    String inString = null;
    if (args.length < 1) {
      System.out.println("Usage: java WordCount sourcefile");
      return;
    }

    // Reads the file named as the command-line argument
    try {
      File f = new File(args[0]);
      InputStreamReader iStream = 
        new InputStreamReader(new FileInputStream(f));
      int length = (int)f.length();
      char input[] = new char[length];
      iStream.read(input);
      inString = new String(input);
      StringTokenizer st = 
        new StringTokenizer(inString, "`~?!*:;,.()- '\"\n");

      // Complete this blank.
			TreeMap<String,Integer> map1 = new TreeMap();
		
			while(st.hasMoreTokens()){
				String in_str = st.nextToken();
				if(map1.firstEntry() == null){
					map1.put(in_str, 1);
				}
				else{
					if(map1.containsKey(in_str)){
						int new_count = map1.get(in_str) + 1;  
						map1.put(in_str, new_count);
					}
					else{
						map1.put(in_str, 1);
					}
				}
			} //done making map
			
			//Tests the alphabetical ordering of the map
			System.out.print(map1.entrySet() + "\n\n");
			//Tests the most-to-least ordering of the map
			ArrayList listSet = new ArrayList(map1.entrySet());
			MapEntryComparator<Map.Entry<String, Integer>> comp = 
				new MapEntryComparator<Map.Entry<String, Integer>>();
			Collections.sort(listSet, comp);
			System.out.print(listSet);
    } 
    catch (FileNotFoundException e) {
      System.err.println("Error: File " + args[0] + " not found");
      e.printStackTrace();
    } 
    catch (IOException e) {
      System.err.println("Error: I/O exception");
      e.printStackTrace();
    }
  }
}
