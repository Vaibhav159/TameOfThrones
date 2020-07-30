package com.project.tameofthrones;

import java.util.Map;

//input:
//    AIR ROZO
//    LAND FAIJWJSOOFAMAU
//    ICE STHSTSTVSASOS
// output:
//    SPACE AIR LAND ICE
public class TameOfThroneApplication {

  public static void main(String[] args) {
    Ruler ruler = new Ruler();
    ruler.setAnimal("PANDA");
    ruler.setEmblem("Land");
    ruler.makeCipher();
    System.out.println("Here");
    ruler.getRequiredCipher();

    Cipher cipher = new Cipher();
    String check = "FAIJWJSOOFAMAU";
    System.out.println(cipher.matchCipher(ruler.getRequiredCipher(), cipher.generateCipher(check)));
  }
}
