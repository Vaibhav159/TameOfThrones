package com.project.tameofthrones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//input:
//    AIR ROZO
//    LAND FAIJWJSOOFAMAU
//    ICE STHSTSTVSASOS
// output:
//    SPACE AIR LAND ICE

//SPACE emblem - Gorilla, LAND emblem - Panda, WATER emblem - Octopus,
//    ICE emblem - Mammoth, AIR emblem - Owl,
//    FIRE emblem - Dragon.

public class TameOfThroneApplication {

  private Map<String, Ruler> generateAllRulers() {
    Map<String, Ruler> rulers = new HashMap<>();
    Map<String, String> rulerWithAnimal = new HashMap<>();
    rulerWithAnimal.put("SPACE", "GORILLA");
    rulerWithAnimal.put("LAND","PANDA");
    rulerWithAnimal.put("WATER","OCTOPUS");
    rulerWithAnimal.put("ICE","MAMMOTH");
    rulerWithAnimal.put("AIR","OWL");
    rulerWithAnimal.put("FIRE","DRAGON");

    for (String emblem : rulerWithAnimal.keySet()) {
      Ruler ruler = new Ruler(emblem, rulerWithAnimal.get(emblem));
      ruler.makeCipher();
      rulers.put(emblem, ruler);
    }
    return rulers;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TameOfThroneApplication t = new TameOfThroneApplication();
    Map<String, Ruler> rulers = t.generateAllRulers();

    String emblem;
    String msg;
    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      String[] sArray = s.split(" ");
      emblem = sArray[0];
      msg = sArray[1];
      System.out.println(t.correctMessage(rulers.get(emblem), msg));
    }

  }

  private Boolean correctMessage(Ruler ruler, String msg) {
    Cipher cipher = new Cipher();
    return (cipher.matchCipher(ruler.getRequiredCipher(), cipher.generateCipher(msg)));
  }
}
