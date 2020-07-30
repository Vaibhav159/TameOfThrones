package com.project.tameofthrones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

  public static final int MINIMUM_MAJORITY_REQUIRED = 3;

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

  public static void main(String[] args) throws FileNotFoundException {
    TameOfThroneApplication t = new TameOfThroneApplication();
    Map<String, Ruler> rulers = t.generateAllRulers();

    int currentMajority = 0;
    List<String> alliedRulers = new ArrayList<>();
    alliedRulers.add("SPACE");

    File file = new File(args[0]);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      String[] sArray = s.split(" ");
      String emblem = sArray[0];
      String msg = sArray[1];
      if (t.correctMessage(rulers.get(emblem), msg)) {
        currentMajority++;
        alliedRulers.add(emblem);
      }

    }

    if (currentMajority >= MINIMUM_MAJORITY_REQUIRED) {
      String ans = String.join(" ", alliedRulers);
      System.out.println(ans);
    }
    else {
      System.out.println("NONE");
    }

  }

  private Boolean correctMessage(Ruler ruler, String msg) {
    Cipher cipher = new Cipher();
    return (cipher.matchCipher(ruler.getRequiredCipher(), cipher.generateCipher(msg)));
  }
}
