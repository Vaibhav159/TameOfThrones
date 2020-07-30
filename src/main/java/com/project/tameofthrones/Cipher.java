package com.project.tameofthrones;

public class Cipher {

  public int[] generateCipher(String word) {
    int[] requiredCipher = new int[26];
    for (int i = 0; i < word.length(); i++) {
      requiredCipher[word.charAt(i) - 'A']++;
    }
    return requiredCipher;
  }

  public int[] decodeCipher(String word) {
    int shift = word.length();
    int[] decodedCipher = new int[26];
    for (int i = 0; i < word.length(); i++) {
      decodedCipher[((word.charAt(i) - 'A') + shift) % 26]++;
    }
    return decodedCipher;
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
