package com.project.tameofthrones.model;

import com.project.tameofthrones.conversions.Cipher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Kingdom {
  @Getter
  @Setter
  private String emblem;

  @Getter
  @Setter
  private String animal;

  @Getter
  private int[] requiredCipher;

  private String messageReceived;

  @Getter
  private int[] translatedMessage;

  private Cipher cipher = new Cipher();

  public Kingdom(String emblem, String animal) {
    this.emblem = emblem;
    this.animal = animal;
  }

  public void makeCipherFromAnimalName() {
    this.requiredCipher = cipher.encodeAnimalNameToCipher(animal);
  }

  public void sendMessageToKingdom(String messageReceived) {
    this.messageReceived = messageReceived;
    translateMessage();
  }

  private void translateMessage() {
    this.translatedMessage = cipher.generateCipherFromMessage(messageReceived);
  }

  public Boolean isKingdomAlliedToRuler() {
    return (cipher.matchCipher(requiredCipher, translatedMessage));
  }

}
