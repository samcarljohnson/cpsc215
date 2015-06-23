/**
 * This is a simple menu driven program that maintains a directory of Trinity
 * students and their campus phone numbers.
 *
 * @author Sam Johnson
 * @version 1.0, 04/27/2014
 */
import java.io.*;
import java.util.*;

public class johnson{
  protected static BinarySearchTreeMap<String, Integer> directory;
  
  public static void main(String args[]){
    directory = new BinarySearchTreeMap<String, Integer>();
    open();
  }
  
  /**
   * This method lists the menu of choices and calls the respective method.
   * @return none
   */
  public static void open(){
    displayMenu();
    int intSelection = 0;
    while(intSelection == 0){
      Scanner scan  = new Scanner(System.in);
      String menuSelection = scan.nextLine();
      intSelection = testIntSelection(menuSelection, 1, 7);
    }
    switch(intSelection){
      case 1: one();
        open();
        break;
      case 2: two();
        open();
        break;
      case 3: three();
        open();
        break;
      case 4: four();
        open();
        break;
      case 5: five();
        open();
        break;
      case 6: six();
        open();
        break;
      case 7: seven();
        open();
        break;
    }
  }
  
  /**
   * This method lists all of the entries in the directory.
   * @param strSelection the input string to check.
   * @param lower Lower bound of the acceptable integer range.
   * @param upper Upper bound of the acceptable integer range.
   * @return A valid integer input.
   */
  public static int testIntSelection(String strSelection, int lower, int upper){
    try{
      int intSelection = Integer.parseInt(strSelection);
      if((intSelection <= lower) || (intSelection > upper)){
        System.out.print("Please enter a digit " + lower + "-" + upper + ": ");
        return 0;
      }
      else{
        return intSelection;
      }
    }
    catch(Exception e){
      System.out.print("Please enter a digit 1-7: ");
    }
    return 0;
  }
  
  /**
   * This method performs a search of the directory.
   * @return none
   */
  public static void one(){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the name of the entry you would like to search: ");
    String name = scan.nextLine();
    Integer val = directory.get(name);
    if(val != null){
      System.out.println(name + "'s number is: " + val + ".");
    }
    else{
      System.out.println("That name is not contained in the directory.");
    }
    open();
  }
  
  /**
   * This method performs adds a person to the directory.
   * @return none
   */
  public static void two(){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the name the person you would like to add: ");
    String name = scan.nextLine();
    System.out.print("Enter the phone number of the person you would like to add: ");
    int number = 0;
    while(number == 0){
      String inputNum = scan.nextLine();
      number = testIntSelection(inputNum, 10000, 99999);
    }
    directory.put(name, number);
    System.out.println("Added " + name + " to the directory!");
    open();
  }
  
  /**
   * This method removes a person from the directory.
   * @return none
   */
  public static void three(){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the name of the person you would like to remove: ");
    String name = scan.nextLine();
    Integer returned = directory.remove(name);
    if(returned != null){
      System.out.println("Successfully removed " + name + " from the directory!");
      directory.remove(name);
    }
    else
      System.out.println(name + " is not in the directory.");
  }
  
  /**
   * This method lists all of the entries in the directory.
   * @return none
   */
  public static void four(){
    Scanner scan = new Scanner(System.in);
    System.out.print("List of the entries currently contained in the directory:\n");
    Iterator<Entry<String, Integer>> iter = directory.entrySet().iterator();
    while(iter.hasNext()){
      Entry<String, Integer> currentEntry = iter.next();
      System.out.println("{\"" + currentEntry.getKey() + "\", " +
                         currentEntry.getValue() + "}");
    }
  }
  
  /**
   * This method lists all of the names in the directory.
   * @return none
   */
  public static void five(){
    Scanner scan = new Scanner(System.in);
    System.out.print("List of the names currently contained in the directory:\n");
    Iterator<String> key_iter = directory.keySet().iterator();
    while(key_iter.hasNext()){
      String currentEntry = key_iter.next();
      System.out.println("{\"" + currentEntry + "\"}");
    }
  }
  
  /**
   * This method lists all of the phone numbers in the directory.
   * @return none
   */
  public static void six(){
    Scanner scan = new Scanner(System.in);
    System.out.print("List of the phone numbers currently contained in the directory:\n");
    Iterator<Integer> val_iter = directory.values().iterator();
    while(val_iter.hasNext()){
      Integer currentEntry = val_iter.next();
      System.out.println("{ " + currentEntry + " }");
    }
  }
  
  /**
   * This method exits the directory.
   * @return none
   */
  public static void seven(){
    System.exit(0);
  }
  
  /**
   * This method lists the directory's menu.
   * @return none
   */
  public static void displayMenu(){
    System.out.print("\n ----- TRINITY COLLEGE TELEPHONE DIRECTORY -----\n\n1.Search an entry in the directory; in particular, given a name as input from the user, output the name and his/her telephone number if his/her entry is in the directory.\n2.Add a new entry for a given name and telephone number to the directory.\n3.Remove an entry from the directory; in particular, given a name as input from the user, remove his/her entry from the directory.\n4.List all entries (as legible name-number pairs) from the directory in the alphabetical order by last names.\n5.List all names from the directory.\n6.List all telephone numbers from the directory.\n7.Terminate the session.\n\nEnter a number 1-7 to use the directory: ");
  }

}