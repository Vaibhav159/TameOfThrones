package com.project.tameofthrones.conversions;

/**
 * The type Cipher.
 */
public class CipherImpl implements Cipher {

  //Keeps only Upper case Letters From message
  private String removeSpecialCharacter(String message) {
    String filteredMessage = "";
    for (int i = 0; i < message.length(); i++) {
      char c = message.charAt(i);
      if (Character.isUpperCase(c)) {
        filteredMessage += c;
      }
    }
    return filteredMessage;
  }

  @Override
  public int[] decodeMessage(String message) {
    String filteredMessage = removeSpecialCharacter(message);
    int[] requiredCipher = new int[26];
    for (int i = 0; i < filteredMessage.length(); i++) {
      requiredCipher[filteredMessage.charAt(i) - 'A']++;
    }
    return requiredCipher;
  }

  @Override
  public int[] encodeAnimalNameToCipher(String animalName) {
    int shift = animalName.length();
    int[] encodedCipher = new int[26];
    for (int i = 0; i < animalName.length(); i++) {
      encodedCipher[((animalName.charAt(i) - 'A') + shift) % 26]++;
    }
    return encodedCipher;
  }

  @Override
  public Boolean matchCipher(int[] requiredCipher, int[] cipherToBeMatched) {
    for (int i = 0; i < 26; i++) {
      if (requiredCipher[i] > cipherToBeMatched[i]) {
        return Boolean.FALSE;
      }
    }
    return Boolean.TRUE;
  }

}
