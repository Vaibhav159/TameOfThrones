package com.project.tameofthrones.conversions;

public class CipherImpl implements Cipher {

  @Override
  public int[] generateCipherFromMessage(String message) {
    int[] requiredCipher = new int[26];
    for (int i = 0; i < message.length(); i++) {
      requiredCipher[message.charAt(i) - 'A']++;
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
