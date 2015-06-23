/** Class for doing encryption and decryption using the Caesar Cipher.
 * 
 * @author Sam Johnson
 * @version 1.0, 02/07/2014
 */
public class Caesar {

  public static final int ALPHASIZE = 26; // English alphabet (uppercase only)
  public static final char[] alpha = {'A','B','C','D','E','F','G','H', 'I',
    'J','K','L','M', 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  protected char[] encrypt = new char[ALPHASIZE];  // Encryption array
  protected char[] decrypt = new char[ALPHASIZE];  // Decryption array

  /** Constructor that initializes the encryption and decryption arrays */
  public Caesar() {
    for (int i=0; i<ALPHASIZE; i++) 
      encrypt[i] = alpha[(i + 3) % ALPHASIZE]; // rotate alphabet by 3 places
    for (int i=0; i<ALPHASIZE; i++) 
      decrypt[encrypt[i] - 'A'] = alpha[i]; // decrypt is reverse of encrypt
  }

	/** Encryption method 
	 * 
	 * @param plaintext The string that needs encrypting
	 * @return An encrypted string
	 */
  public String encrypt(String plaintext) {
    char[] mess = plaintext.toCharArray();  // the message array
    for (int i=0; i<mess.length; i++)       // encryption loop
      if (Character.isLowerCase(mess[i]))   // we have a letter to change
        mess[i] = encrypt[Character.toUpperCase(mess[i]) - 'A'];   // use letter as an index
    return new String(mess);
  }

  	/** Decryption method 
	 * 
	 * @param ciphertext The string that needs decrypting
	 * @return An decrypted string
	 */
  public String decrypt(String ciphertext) {
    char[] mess = ciphertext.toCharArray(); // the message array
    for (int i=0; i<mess.length; i++)       // decryption loop
      if (Character.isUpperCase(mess[i]))   // we have a letter to change
        mess[i] = Character.toLowerCase(decrypt[mess[i] - 'A']);   // use letter as an index
    return new String(mess);
  }

  /** Simple main method for testing the Caesar cipher */
  public static void main(String[] args) {
    Caesar cipher = new Caesar();           // Create a Caesar cipher object
    System.out.println("Encryption order = " + new String(cipher.encrypt));
    System.out.println("Decryption order = " + new String(cipher.decrypt));
    String message = "the eagle is in play; meet at joe's.";
    message = cipher.encrypt(message);
    System.out.println(message);             // the ciphertext
    message = cipher.decrypt(message);
    System.out.println(message);             // should be plaintext again
  }

}
