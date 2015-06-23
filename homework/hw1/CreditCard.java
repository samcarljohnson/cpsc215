/**
 * CreditCard.java is a class implementing very simple credit cards.
 * 
 * @author Sam Johnson
 * @version 1.0, 01/25/2014
 * @see String
 */

public class CreditCard {

  // Instance variables:
  private String number;
  private String name;
  private String bank;
  private double balance;
  private int limit;

  // Constructor:
  CreditCard(String no, String nm, String bk, double bal, int lim) {
    number = no;
    name = nm;
    bank = bk;
    balance = bal;
    limit = lim;
  }

  // Accessor methods:
  public String getNumber() { return number; }
  public String getName() { return name; }
  public String getBank() { return bank; }
  public double getBalance() { return balance; }
  public int getLimit() { return limit; }

  // Add modifier methods here.
  public void setName(String str){
      name = str;
  }
  public void setLimit(int lim){
      limit = lim;
  }

  // Action methods:
    
  /**
   * chargeIt() charges an amount to the balance of a credit card
   *
   * @param price The price to be charged to the credit card
   * @return Returns true if the charge is under the card's credit
   * limit and false if it goes over
   */
  public boolean chargeIt(double price) { // Make a charge 
    if (price + balance > (double) limit) 
      return false; // There is not enough money left to charge it
    balance = balance + price;
    return true; // The charge goes through in this case
  }

  /**
   * applyInterest() applies a decimal interest rate to the balance
   * of a credit card.
   *
   * @param i The decimal percentage of interest to be charged on the
   * card's balance
   */
  public void applyInterest(double i){
      balance += (balance * i);
  }
  /**
   * makePayment() makes a payment on the outstanding balance of the
   * credit card and if the balance remains above $0, charges 10% interest
   *
   * @param payment The amount of the payment
   */
  public void makePayment(double payment) { // Make a payment
    balance = balance - payment;
      if(balance > 0){
          this.applyInterest(0.1);
      }
  }

  public static void printCard(CreditCard c) { // Print a card's information 
    System.out.println();
    System.out.println("Number = " + c.getNumber());
    System.out.println("Name = " + c.getName());
    System.out.println("Bank = " + c.getBank());
    System.out.println("Balance = " + c.getBalance()); // Implicit cast
    System.out.println("Limit = " + c.getLimit()); // Implicit cast
    System.out.println();
  }

}
