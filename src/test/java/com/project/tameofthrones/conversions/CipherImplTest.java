package com.project.tameofthrones.conversions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CipherImplTest {

  String animal;
  String msg1;
  String msg2;
  int[] cipherReceived;
  int[] cipherRequired;
  int[] cipherToBeMatched;

  Cipher cipher = new CipherImpl();

  @Test
  void decodeMessageTest() {
    msg1 = "ROZO";
    cipherReceived = cipher.decodeMessage(msg1);
    assertEquals(1, cipherReceived[17]);
    assertEquals(2, cipherReceived[14]);
    assertEquals(1, cipherReceived[25]);
  }

  @Test
  void encodeAnimalNameToCipherTest() {
    animal = "OWL";
    cipherReceived = cipher.encodeAnimalNameToCipher(animal);
    assertEquals(1, cipherReceived[17]);
    assertEquals(1, cipherReceived[14]);
    assertEquals(1, cipherReceived[25]);
  }

  @Test
  void matchCipherTest() {
    msg1 = "ROZO";
    animal = "OWL";
    cipherRequired = cipher.encodeAnimalNameToCipher(animal);
    cipherToBeMatched = cipher.decodeMessage(msg1);
    assertTrue(cipher.matchCipher(cipherRequired, cipherToBeMatched));
  }

  @Test
  void matchCipherFailTest() {
    animal = "OWL";
    msg2 = "OWLAOWLBOWLC";
    cipherRequired = cipher.encodeAnimalNameToCipher(animal);
    cipherToBeMatched = cipher.decodeMessage(msg2);
    assertFalse(cipher.matchCipher(cipherRequired, cipherToBeMatched));
  }

  @Test
  void emptyMessageTest() {
    animal = "OWL";
    msg2 = "";
    cipherRequired = cipher.encodeAnimalNameToCipher(animal);
    cipherToBeMatched = cipher.decodeMessage(msg2);
    assertFalse(cipher.matchCipher(cipherRequired, cipherToBeMatched));
  }

  @Test
  void messageWithSpaceTest() {
    animal = "OWL";
    msg2 = "O Z O R O";
    cipherRequired = cipher.encodeAnimalNameToCipher(animal);
    cipherToBeMatched = cipher.decodeMessage(msg2);
    assertTrue(cipher.matchCipher(cipherRequired, cipherToBeMatched));
  }

  @Test
  void messageWithSpecialCharacterTest() {
    animal = "OWL";
    msg2 = "O$O@R O";
    cipherRequired = cipher.encodeAnimalNameToCipher(animal);
    cipherToBeMatched = cipher.decodeMessage(msg2);
    assertFalse(cipher.matchCipher(cipherRequired, cipherToBeMatched));
  }

}