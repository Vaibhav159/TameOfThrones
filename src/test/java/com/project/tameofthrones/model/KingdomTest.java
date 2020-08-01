package com.project.tameofthrones.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;

import com.project.tameofthrones.conversions.CipherImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KingdomTest {

  @Mock
  CipherImpl cipherImpl;

  @InjectMocks
  Kingdom kingdom;

  int[] requiredCipher = new int[26];

  int[] translatedMessage = new int[26];

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
    requiredCipher[3] = 1;
    requiredCipher[4] = 1;
    requiredCipher[5] = 1;

    translatedMessage[3] = 1;
    translatedMessage[4] = 1;
    translatedMessage[5] = 1;
  }

  @Test
  void makeCipherFromAnimalName() {

    Mockito.when(cipherImpl.encodeAnimalNameToCipher(eq("ABC")))
        .thenReturn(requiredCipher);

    kingdom.setEmblem("AIR");
    kingdom.setAnimal("ABC");

    kingdom.makeCipherFromAnimalName();

    assertArrayEquals(requiredCipher, kingdom.getRequiredCipher());
    assertEquals(1, kingdom.getRequiredCipher()[3]);
  }

  @Test
  void sendMessageToKingdom() {


    Mockito.when(cipherImpl.decodeMessage(eq("DEF")))
        .thenReturn(translatedMessage);

    kingdom.sendMessageToKingdom("DEF");

    assertArrayEquals(translatedMessage, kingdom.getTranslatedMessage());
    assertEquals(1, kingdom.getTranslatedMessage()[4]);
  }

  @Test
  void isKingdomAlliedToRuler() {

    Mockito.when(cipherImpl.encodeAnimalNameToCipher(eq("ABC")))
        .thenReturn(requiredCipher);

    Mockito.when(cipherImpl.decodeMessage(eq("DEF")))
        .thenReturn(translatedMessage);

    Mockito.when(cipherImpl.matchCipher(eq(requiredCipher), eq(translatedMessage)))
        .thenReturn(Boolean.TRUE);

    kingdom.setAnimal("ABC");
    kingdom.sendMessageToKingdom("DEF");
    kingdom.makeCipherFromAnimalName();

    assertTrue(kingdom.isKingdomAlliedToRuler());

  }
}