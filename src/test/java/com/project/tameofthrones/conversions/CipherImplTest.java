package com.project.tameofthrones.conversions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CipherImplTest {

  String animal;
  String msg1;
  String msg2;

  @Test
  void generateCipher() {
    msg1 = "ROZO";
    CipherImpl cipherImpl = new CipherImpl();
    int[] cipherReceived = cipherImpl.generateCipherFromMessage(msg1);
    assertEquals(1, cipherReceived[17]);
    assertEquals(2, cipherReceived[14]);
    assertEquals(1, cipherReceived[25]);
  }

  @Test
  void decodeCipher() {
    animal = "OWL";
    CipherImpl cipherImpl = new CipherImpl();
    int[] cipherReceived = cipherImpl.encodeAnimalNameToCipher(animal);
    assertEquals(1, cipherReceived[17]);
    assertEquals(1, cipherReceived[14]);
    assertEquals(1, cipherReceived[25]);
  }

  @Test
  void matchCipher() {
    msg1 = "ROZO";
    animal = "OWL";
    CipherImpl cipherImpl = new CipherImpl();
    int[] cipherRequired = cipherImpl.encodeAnimalNameToCipher(animal);
    int[] cipherToBeMatched = cipherImpl.generateCipherFromMessage(msg1);
    assertTrue(cipherImpl.matchCipher(cipherRequired, cipherToBeMatched));
  }

  @Test
  void matchCipherFail() {
    animal = "OWL";
    msg2 = "OWLAOWLBOWLC";
    CipherImpl cipherImpl = new CipherImpl();
    int[] cipherRequired = cipherImpl.encodeAnimalNameToCipher(animal);
    int[] cipherToBeMatched = cipherImpl.generateCipherFromMessage(msg2);
    assertFalse(cipherImpl.matchCipher(cipherRequired, cipherToBeMatched));
  }
}