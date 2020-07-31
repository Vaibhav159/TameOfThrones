package com.project.tameofthrones.conversions;

public class Cipher {

  public int[] generateCipherFromMessage(String word) {
    int[] requiredCipher = new int[26];
    for (int i = 0; i < word.length(); i++) {
      requiredCipher[word.charAt(i) - 'A']++;
    }
    return requiredCipher;
  }

  public int[] encodeAnimalNameToCipher(String word) {
    int shift = word.length();
    int[] encodedCipher = new int[26];
    for (int i = 0; i < word.length(); i++) {
      encodedCipher[((word.charAt(i) - 'A') + shift) % 26]++;
    }
    return encodedCipher;
  }

  public Boolean matchCipher(int[] requiredCipher, int[] cipherToBeMatched) {
    for (int i = 0; i < 26; i++) {
      if (requiredCipher[i] > cipherToBeMatched[i]) {
        return Boolean.FALSE;
      }
    }
    return Boolean.TRUE;
  }

}
