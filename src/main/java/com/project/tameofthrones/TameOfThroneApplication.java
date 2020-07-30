package com.project.tameofthrones;

import java.io.File;
import java.io.FileNotFoundException;
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
    RulerData rulerData = new RulerData();
    Map<String, Ruler> rulers = rulerData.generateAllRulers();
    Kingdom kingdom = new Kingdom();

    int currentMajority = 0;

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
        kingdom.updateAlliesList(emblem);
      }

    }
    System.out.println(kingdom.alliesForKingdom(currentMajority));

  }



}
