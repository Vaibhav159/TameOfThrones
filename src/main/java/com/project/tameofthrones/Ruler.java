package com.project.tameofthrones;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ruler {
  private String emblem;
  private String animal;
  private int[] requiredCipher;
  private String messageReceived;
  private int[] translatedMessage;

  public Ruler(String emblem, String animal) {
    this.emblem = emblem;
    this.animal = animal;
  }

  public void makeCipher() {
    Cipher cipher = new Cipher();
    this.requiredCipher = cipher.decodeCipher(animal);
  }

  public void sendMessageToRuler(String messageReceived) {
    this.messageReceived = messageReceived;
    translateMessage();
  }

  private void translateMessage() {
    Cipher cipher = new Cipher();
    this.translatedMessage = cipher.generateCipher(messageReceived);
  }

  public Boolean successfulAlliedRuler() {
    Cipher cipher = new Cipher();
    return (cipher.matchCipher(getRequiredCipher(), getTranslatedMessage()));
  }

}
