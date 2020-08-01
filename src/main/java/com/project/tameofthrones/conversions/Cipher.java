package com.project.tameofthrones.conversions;

/**
 * The interface Cipher.
 */
public interface Cipher {

  /**
   * Decode message int [ ].
   *
   * @param message the message send by Ruler to Other KingDom
   * @return the int [ ] decoded message in from of array
   */
  int[] decodeMessage(String message);

  /**
   * Encode animal name to cipher int [ ].
   *
   * @param animalName the animal name which is encoded by a key
   * @return the int [ ] encoded message in from of array
   */
  int[] encodeAnimalNameToCipher(String animalName);

  /**
   * Match cipher boolean.
   *
   * <p>
   * This Function check that cipherToBeMatched should always have
   * greater than equal to occurrence for each letter when matched
   * with requiredCipher.
   * </p>
   *
   * @param requiredCipher    the required cipher is the animalName
   * @param cipherToBeMatched the cipher to be matched is the message sent by Ruler
   * @return the boolean
   */
  Boolean matchCipher(int[] requiredCipher, int[] cipherToBeMatched);

}
