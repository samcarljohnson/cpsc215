/**
* Finds the greatest common divisor of two numbers using two different methods
*
* @author Sam Johnson, Basileal Imana
* @version 1.0, 01/22/2014
* @see java.util.Scanner
*/ 

import java.io.*;                       // I/O classes
import java.util.Scanner;               // Scanner class

public class GCD {

  public GCD() {}                       // Default constructor

  /**
   * bruteForceGcd() computes and returns gcd(m, n) by simply enumerating 
   * all common divisors of n and m and return the largest of all such 
   * divisors.
   * @param m First Integer
   * @param n Second Integer
   * @return Greatest common Divisor
   */
  public int bruteForceGcd(int m, int n) {
    int gcd = 1;
	int s;
	int l;
	if(m>n){
		s = n;
		l = m;
	}
	else{
		s = m;
		l = n;
	}
	for(int i=2; i <= s; i++){
		if(s%i == 0){
			if(l%i == 0){
				gcd = i;
			}
		}
	}


	return gcd;
  } // bruteForceGCD()

  /**
   * euclideanGcd() computes and returns gcd(m, n), where m < n, using 
   * the Euclidean algorithm.
   * @param m First Integer
   * @param n Second Integer
   * @return Greatest common Divisor
   */
  public int euclideanGcd(int m, int n) {
	int x = m;
	int y = n;
	int r;

	while(x != 0){
		r = y%x;
		y = x;
		x = r;
	}    

	return y;
  } // euclidianGcd()

  public static void main(String argv[]) throws IOException
  {
    Scanner s = new Scanner(System.in);
    System.out.println("This program assumes m < n.");
    System.out.print("Enter an integer value for m: ");
    int m = s.nextInt();
    System.out.print("Enter an integer value for n: ");
    int n = s.nextInt();

    GCD gcd = new GCD();
    int bf = gcd.bruteForceGcd(m, n);
    int euclidean = gcd.euclideanGcd(m, n);
    System.out.println("By the brute-force method, gcd(" + m + ", " + n + 
		       ") = " + bf + ".");
    System.out.println("By the Euclidean algorithm, gcd(" + m + ", " + n +
		       ") = " + euclidean + ".");
  } // main()

} // GCD
