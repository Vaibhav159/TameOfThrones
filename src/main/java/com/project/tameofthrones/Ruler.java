package com.project.tameofthrones;

public class Ruler {
  private String emblem;
  private String animal;
  private int[] requiredCipher;

  public String getEmblem() {
    return emblem;
  }

  public Ruler() {
  }

  public Ruler(String emblem, String animal) {
    this.emblem = emblem;
    this.animal = animal;
  }

  public void setEmblem(String emblem) {
    this.emblem = emblem;
  }

  public String getAnimal() {
    return animal;
  }

  public void setAnimal(String animal) {
    this.animal = animal;
  }

  public int[] getRequiredCipher() {
    return requiredCipher;
  }

  public void setRequiredCipher(int[] requiredCipher) {
    this.requiredCipher = requiredCipher;
  }

  public void makeCipher() {
    Cipher cipher = new Cipher();
    this.requiredCipher = cipher.decodeCipher(animal);
  }

}
