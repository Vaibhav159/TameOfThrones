package com.project.tameofthrones;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ruler {
  private String emblem;
  private String animal;
  private int[] requiredCipher;

  public Ruler(String emblem, String animal) {
    this.emblem = emblem;
    this.animal = animal;
  }

  public void makeCipher() {
    Cipher cipher = new Cipher();
    this.requiredCipher = cipher.decodeCipher(animal);
  }

}
