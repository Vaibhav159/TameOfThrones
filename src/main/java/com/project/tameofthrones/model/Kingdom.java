package com.project.tameofthrones.model;

import com.project.tameofthrones.conversions.Cipher;
import com.project.tameofthrones.conversions.CipherImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Kingdom.
 */
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

  private Cipher cipher = new CipherImpl();

  /**
   * Instantiates a new Kingdom.
   *
   * @param emblem the emblem
   * @param animal the animal
   */
  public Kingdom(String emblem, String animal) {
    this.emblem = emblem;
    this.animal = animal;
  }

  /**
   * Make cipher from animal name.
   */
  public void makeCipherFromAnimalName() {
    this.requiredCipher = cipher.encodeAnimalNameToCipher(animal);
  }

  /**
   * Send message to kingdom.
   *
   * @param messageReceived the message received
   *                        and calls translateMessage()
   *                        to convert The Message
   */
  public void sendMessageToKingdom(String messageReceived) {
    this.messageReceived = messageReceived;
    translateMessage();
  }

  /**
   * Translate Message.
   *
   * <p>
   * Populates "translatedMessage" field by converting message
   * so that it can be matched with requiredCipher
   * </p>
   */
  private void translateMessage() {
    this.translatedMessage = cipher.decodeMessage(messageReceived);
  }

  /**
   * Is kingdom allied to ruler boolean.
   * <p>
   * Calls the Function in matchCipher in CipherImpl class
   * for matching
   * </p>
   *
   * @return the boolean
   */
  public Boolean isKingdomAlliedToRuler() {
    return (cipher.matchCipher(requiredCipher, translatedMessage));
  }

}
