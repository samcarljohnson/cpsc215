/**
 * This class converts a temperature from Fahrenheit to Celsius.
 *
 * @author Sam Johnson
 * @version 1.0, 01/22/2014
 * @see java.util.Scanner
 */

import java.io.*;                       // I/O classes
import java.util.Scanner;               // Scanner class

public class Temperature {              

  public static void main(String argv[]) throws IOException {
    Scanner s = new Scanner(System.in);

    System.out.print("Enter a temperature in Fahrenheit: ");
    int temperature = s.nextInt();
    System.out.print(temperature);
    System.out.print(" degrees in Fahrenheit is ");
    System.out.print((5.0*(temperature - 32.0))/9.0);
    System.out.println(" degrees in Celsius.");
  } // main()

} // Temperature
