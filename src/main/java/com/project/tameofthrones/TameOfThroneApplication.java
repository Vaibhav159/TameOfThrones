package com.project.tameofthrones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

  public static void main(String[] args) throws FileNotFoundException {
    Kingdom kingdom = new Kingdom();
    Map<String, Ruler> rulers = kingdom.generateAllRulers();

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
      Ruler ruler = rulers.get(emblem);
      ruler.sendMessageToRuler(msg);
      if (ruler.successfulAlliedRuler()) {
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

}
