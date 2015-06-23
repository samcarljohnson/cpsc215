/** MyCaesar.java creates a Caesar cipher based off of a unique key.
 *
 * @author Sam Johnson
 * @version 1.0, 02/07/2014
 */

public class MyCaesar{
	/* INSTANCE VARIABLES */
	public static final int ALPHASIZE = 26; // English alphabet (uppercase only)
	public static final char[] alpha = {'A','B','C','D','E','F','G','H', 'I',
    'J','K','L','M', 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	protected char[] encrypt = new char[ALPHASIZE];  // Encryption array
	protected char[] decrypt = new char[ALPHASIZE];  // Decryption array
	
	/** Default constructor that initializes a Caesar cipher with the key 
	 * "", starting at index position 24 in the encrypt character array.
	 */
	public MyCaesar(){
		this("", 24);
	}
	
	/** Parametric constructor that initializes a Caesar cipher with the key 
	 * s, starting at index position n in the encrypt character array.
	 *
	 * @param s A string that is used in modifying the original Caesar cipher.
	 * @param n An integer that represents the the first index value to be used
	 * 			when creating a new Caesar cipher.
	 */
	public MyCaesar(String s, int n) throws KeywordException, IntegerKeyException{
		int index = n-1; // Stands as the next value in the encrypt array
		boolean contains; // Used in checking for repetition in the first else block
		int inputLen = s.length();
		char[] inputS = s.toCharArray();
		
		/* EXCEPTION TESTING */
		// Ensures that n is within the bounds [0, 26].
		if((n < 1)||(n>26))
			throw new IntegerKeyException("The value for n was not in the range [0,26]");
		
		// Tests for distinct characters in the input character array.
		char[] testSet = new char[ALPHASIZE]; 
		for(int l = 0; l < inputLen; l++){
			contains = false;
			for(int k = 0; k < ALPHASIZE; k++){
				if(testSet[k] == inputS[l])
					contains = true;
			}
			// If the letter of index l in the alphabet makes it through
			// the above for loop without having contains being set to
			// true, this letter is added to testSet and can therefore
			// not be contained again in the input character string.
			if(!contains){
				testSet[l] = inputS[l];
			}
			else{
				throw new KeywordException("The input string was not made of unique values.");
			}
		}
		
		// Ensures that the input string is made of all capital letters.
		boolean allUppercase = s.equals(s.toUpperCase());
		if(!allUppercase)
			throw new KeywordException("The input string was not completely upper case characters.");
		/* END EXCEPTION TESTING */
		
		// The following for loop defines the encrypt character array using parametes s and n.
		for (int i=0; i < ALPHASIZE; i++){
			// If less than (inputLen) values have been added to encrypt,
			// simply add the appropriate char from the input string to encrypt.
			if(i < inputLen){
				encrypt[index] = inputS[i];
			}
			else{
				for(int c = 0; c < ALPHASIZE; c++){
					contains = false;
					for(int k = 0; k < ALPHASIZE; k++){
						if(encrypt[(k + n) % ALPHASIZE] == alpha[c])
							contains = true;
					}
					// If the letter of index c in the alphabet makes it through
					// the above for loop without having contains being set to
					// true, this is the next letter to add to the array.
					if(!contains){
						encrypt[index] = alpha[c];
						break;
					}
				}
			}
			index = (index + 1) % ALPHASIZE; // Increment the next available index
		}
		
		// The following for loop defines the decrypt character array.
		for (int i=0; i<ALPHASIZE; i++){ 
			decrypt[encrypt[i] - 'A'] = alpha[i]; // decrypt is reverse of encrypt
		}
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
		/* BEGINNING OF PART 2 TESTING */
		// Tests ("BLUE", 5) 
		System.out.println("Tests the case: (\"BLUE\", 5)");
		MyCaesar cipher = new MyCaesar("BLUE", 5); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt));
		String message = "the eagle is in play; meet at joe's.";
		message = cipher.encrypt(message);
		System.out.println(message); // the ciphertext
		message = cipher.decrypt(message);
		System.out.println(message); // should be plaintext again
		
		// Tests default constructor 
		System.out.println("\nTests the default constructor:");
		MyCaesar cipher1 = new MyCaesar(); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher1.encrypt));
		System.out.println("Decryption order = " + new String(cipher1.decrypt));
		String message1 = "the eagle is in play; meet at joe's.";
		message1 = cipher1.encrypt(message1);
		System.out.println(message1); // the ciphertext
		message1 = cipher1.decrypt(message1);
		System.out.println(message1); // should be plaintext again
		
		// Tests ("RED", 10) 
		System.out.println("\nTests the case: (\"RED\", 10):");
		MyCaesar cipher2 = new MyCaesar("RED", 10); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher2.encrypt));
		System.out.println("Decryption order = " + new String(cipher2.decrypt));
		String message2 = "the eagle is in play; meet at joe's.";
		message2 = cipher2.encrypt(message2);
		System.out.println(message2); // the ciphertext
		message2 = cipher2.decrypt(message2);
		System.out.println(message2); // should be plaintext again
		
		// Tests ("BROWN", 7) 
		System.out.println("\nTests the case: (\"BROWN\", 7):");
		MyCaesar cipher3 = new MyCaesar("BROWN", 7); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher3.encrypt));
		System.out.println("Decryption order = " + new String(cipher3.decrypt));
		String message3 = "the eagle is in play; meet at joe's.";
		message3 = cipher3.encrypt(message3);
		System.out.println(message3); // the ciphertext
		message3 = cipher3.decrypt(message3);
		System.out.println(message3); // should be plaintext again
		
		// Tests ("WHITE", 11) 
		System.out.println("\nTests the case: (\"WHITE\", 11):");
		MyCaesar cipher4 = new MyCaesar("WHITE", 11); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher4.encrypt));
		System.out.println("Decryption order = " + new String(cipher4.decrypt));
		String message4 = "the eagle is in play; meet at joe's.";
		message4 = cipher4.encrypt(message4);
		System.out.println(message4); // the ciphertext
		message4 = cipher4.decrypt(message4);
		System.out.println(message4); // should be plaintext again
		
		// Tests ("BLACK", 14) 
		System.out.println("\nTests the case: (\"BLACK\", 14):");
		MyCaesar cipher5 = new MyCaesar("BLACK", 14); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher5.encrypt));
		System.out.println("Decryption order = " + new String(cipher5.decrypt));
		String message5 = "the eagle is in play; meet at joe's.";
		message5 = cipher5.encrypt(message5);
		System.out.println(message5); // the ciphertext
		message5 = cipher5.decrypt(message5);
		System.out.println(message5); // should be plaintext again
		
		/* BEGINNING OF PART 3 TESTING */
		// Tests ("BLUEE", 5) 
		System.out.println("Tests the case: (\"BLUEE\", 5)");
		MyCaesar cipher = new MyCaesar("BLUEE", 5); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher.encrypt));
		System.out.println("Decryption order = " + new String(cipher.decrypt));
		String message = "the eagle is in play; meet at joe's.";
		message = cipher.encrypt(message);
		System.out.println(message); // the ciphertext
		message = cipher.decrypt(message);
		System.out.println(message); // should be plaintext again
		
		// Tests ("REDREDREDREDREDREDREDREDRED", 10) 
		System.out.println("\nTests the case: (\"REDREDREDREDREDREDREDREDRED\", 10):");
		MyCaesar cipher2 = new MyCaesar("REDREDREDREDREDREDREDREDRED", 10); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher2.encrypt));
		System.out.println("Decryption order = " + new String(cipher2.decrypt));
		String message2 = "the eagle is in play; meet at joe's.";
		message2 = cipher2.encrypt(message2);
		System.out.println(message2); // the ciphertext
		message2 = cipher2.decrypt(message2);
		System.out.println(message2); // should be plaintext again
		
		// Tests ("BROWN", 28) 
		System.out.println("\nTests the case: (\"BROWN\", 28):");
		MyCaesar cipher3 = new MyCaesar("BROWN", 28); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher3.encrypt));
		System.out.println("Decryption order = " + new String(cipher3.decrypt));
		String message3 = "the eagle is in play; meet at joe's.";
		message3 = cipher3.encrypt(message3);
		System.out.println(message3); // the ciphertext
		message3 = cipher3.decrypt(message3);
		System.out.println(message3); // should be plaintext again
		
		// Tests ("WHITE", -1) 
		System.out.println("\nTests the case: (\"WHITE\", -1):");
		MyCaesar cipher4 = new MyCaesar("WHITE", -1); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher4.encrypt));
		System.out.println("Decryption order = " + new String(cipher4.decrypt));
		String message4 = "the eagle is in play; meet at joe's.";
		message4 = cipher4.encrypt(message4);
		System.out.println(message4); // the ciphertext
		message4 = cipher4.decrypt(message4);
		System.out.println(message4); // should be plaintext again
		
		// Tests ("BLACKK", 30) 
		System.out.println("\nTests the case: (\"BLACKK\", 30):");
		MyCaesar cipher5 = new MyCaesar("BLACKK", 30); // Create a Caesar cipher object
		System.out.println("Encryption order = " + new String(cipher5.encrypt));
		System.out.println("Decryption order = " + new String(cipher5.decrypt));
		String message5 = "the eagle is in play; meet at joe's.";
		message5 = cipher5.encrypt(message5);
		System.out.println(message5); // the ciphertext
		message5 = cipher5.decrypt(message5);
		System.out.println(message5); // should be plaintext again
	}

}