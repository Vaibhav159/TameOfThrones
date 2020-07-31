package com.project.tameofthrones.conversions;

public interface Cipher {
  int[] generateCipherFromMessage(String message);
  int[] encodeAnimalNameToCipher(String animalName);
  Boolean matchCipher(int[] requiredCipher, int[] cipherToBeMatched);
}
