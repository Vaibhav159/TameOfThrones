package com.project.tameofthrones.model;

import com.project.tameofthrones.conversions.Cipher;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Kingdom {
  private String emblem;
  private String animal;

  @Setter(AccessLevel.NONE)
  private int[] requiredCipher;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private String messageReceived;

  @Setter(AccessLevel.NONE)
  private int[] translatedMessage;

  public Kingdom(String emblem, String animal) {
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
