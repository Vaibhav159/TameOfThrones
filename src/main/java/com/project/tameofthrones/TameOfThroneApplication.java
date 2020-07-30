package com.project.tameofthrones;

import com.project.tameofthrones.model.Kingdom;
import com.project.tameofthrones.repositoryservices.KingdomData;
import com.project.tameofthrones.util.KingdomsAlliances;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class TameOfThroneApplication {

  public static void main(String[] args) throws FileNotFoundException {
    KingdomData kingdomData = new KingdomData();
    Map<String, Kingdom> kingdoms = kingdomData.generateAllRulers();
    KingdomsAlliances kingdomsAlliances = new KingdomsAlliances();

    File file = new File(args[0]);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      String[] sArray = s.split(" ");
      String emblem = sArray[0];
      String msg = sArray[1];
      Kingdom kingdom = kingdoms.get(emblem);
      kingdom.sendMessageToRuler(msg);
      if (kingdom.successfulAlliedRuler()) {
        kingdomsAlliances.updateAlliesList(emblem);
      }

    }
    System.out.println(kingdomsAlliances.alliesWithRuler());

  }



}
