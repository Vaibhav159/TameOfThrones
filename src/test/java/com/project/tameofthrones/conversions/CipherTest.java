package com.project.tameofthrones.conversions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CipherTest {

  String animal;
  String msg1;
  String msg2;

  @Test
  void generateCipher() {
    msg1 = "ROZO";
    Cipher cipher = new Cipher();
    int[] cipherReceived = cipher.generateCipherFromMessage(msg1);
    assertEquals(1, cipherReceived[17]);
    assertEquals(2, cipherReceived[14]);
    assertEquals(1, cipherReceived[25]);
  }

  @Test
  void decodeCipher() {
    animal = "OWL";
    Cipher cipher = new Cipher();
    int[] cipherReceived = cipher.encodeAnimalNameToCipher(animal);
    assertEquals(1, cipherReceived[17]);
    assertEquals(1, cipherReceived[14]);
    assertEquals(1, cipherReceived[25]);
  }

  @Test
  void matchCipher() {
    msg1 = "ROZO";
    animal = "OWL";
    Cipher cipher = new Cipher();
    int[] cipherRequired = cipher.encodeAnimalNameToCipher(animal);
    int[] cipherToBeMatched = cipher.generateCipherFromMessage(msg1);
    assertTrue(cipher.matchCipher(cipherRequired, cipherToBeMatched));
  }

  @Test
  void matchCipherFail() {
    animal = "OWL";
    msg2 = "OWLAOWLBOWLC";
    Cipher cipher = new Cipher();
    int[] cipherRequired = cipher.encodeAnimalNameToCipher(animal);
    int[] cipherToBeMatched = cipher.generateCipherFromMessage(msg2);
    assertFalse(cipher.matchCipher(cipherRequired, cipherToBeMatched));
  }
}