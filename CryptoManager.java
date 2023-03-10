
/**
 * Class: CMSC203 
 *  Program: Assignment #3
 *  Instructor: Ahmed Tarek
 * Description: This program encrypts and decrypts using the Beallso and Ceasar Cipher and displays it to the user.
 * Due: 03/07/2023
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Abass Shikur
*/


public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean check = true;
		for (int i =0; i<plainText.length();i++){
			if(!(plainText.charAt(i)>=LOWER_BOUND && plainText.charAt(i)<=UPPER_BOUND))
				check =false;
			}
		return check;
		//throw new RuntimeException("method not implemented");
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
	    String encryptedTxt = "";
	    if (stringInBounds(plainText)){
	        for (int i = 0; i < plainText.length(); i++){
	            int encryptedCInt = (int) plainText.charAt(i) + key;
	            while (encryptedCInt > UPPER_BOUND) {
	                encryptedCInt -= RANGE;
	            }
	            encryptedTxt += (char) encryptedCInt;
	        }
	    }
	    return encryptedTxt;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr){
		String encryptedTxt = "";
		for(int i=0; i < plainText.length(); i++){
			int encryptedCInt = ((int)plainText.charAt(i) + (int)bellasoStr.charAt(i%bellasoStr.length()));
			while (encryptedCInt > UPPER_BOUND)
				encryptedCInt -= RANGE;
			encryptedTxt += (char)encryptedCInt;
		}
		return encryptedTxt;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedTxt = "";
		for (int i=0; i < encryptedText.length(); i++){
			int decryptedCInt = ((int)encryptedText.charAt(i) - key);
			while (decryptedCInt < LOWER_BOUND)
				decryptedCInt += RANGE;
			decryptedTxt += (char)decryptedCInt;
		}
		return decryptedTxt;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedTxt = "";
		for (int i=0; i<encryptedText.length(); i++){
			int decryptedCInt = ((int)encryptedText.charAt(i)-(int)bellasoStr.charAt(i % bellasoStr.length()));
			while (decryptedCInt < LOWER_BOUND)
				decryptedCInt += RANGE;
			decryptedTxt += (char)decryptedCInt;
		}
		return decryptedTxt;
		//throw new RuntimeException("method not implemented");
	}
}