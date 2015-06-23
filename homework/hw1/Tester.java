/**
 * Tester.java is a tester class for CreditCard.java
 *
 * @author Sam Johnson
 * @version 1.0, 01/25/2014
 */

public class Tester {

  public static void main(String[] args) {

    CreditCard card1 = new CreditCard("5391 0375 9387 5309", 
      "John Henry", "Fleet Bank", 0.0, 2500);
    CreditCard.printCard(card1);
    System.out.println("Charging 200 dollars on card1...");
    card1.chargeIt(200);
    System.out.println("Paying 100 dollars to card1...");
    card1.makePayment(100);
    CreditCard.printCard(card1);

    // Add your statements here.
    CreditCard card2 = new CreditCard("1234 5678 9123 4567",
      "Sam Johnson", "Chase Bank", 0.0, 2500);
    CreditCard.printCard(card2);
    System.out.println("Setting card2's credit limit to 1000...");
    card2.setLimit(1000);
    System.out.println("Changing card2's card holder name to Samuel Johnson...");
    card2.setName("Samuel Johnson");
    System.out.println("Charging 300 dollars on card2...");
    card2.chargeIt(300);
    System.out.println("Paying 100 dollars to card2...");
    card2.makePayment(100);
    System.out.println("Applying a 20 percent interest on card2...");
    card2.applyInterest(.2);
    System.out.println("Charging 800 dollars on card2...");
    
    // Checks on the return value from chargeIt() to determine if
    // the card is within it's limit
    if(card2.chargeIt(800)){
        card2.chargeIt(800);
    }
    else{
        System.out.println("Oops! It looks like you've tried to charge this card beyond the preset limit. We're sorry but your transaction was cancelled.");
    }
    CreditCard.printCard(card2);

  }

}
