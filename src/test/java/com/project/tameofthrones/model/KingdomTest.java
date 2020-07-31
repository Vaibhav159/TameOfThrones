package com.project.tameofthrones.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.project.tameofthrones.conversions.Cipher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KingdomTest {

  @Mock
  Kingdom kingdom;

  @InjectMocks
  Cipher cipher;

  @Test
  void makeCipherFromAnimalName() {

  }

  @Test
  void sendMessageToKingdom() {

  }

  @Test
  void isKingdomAlliedToRuler() {
  }
}