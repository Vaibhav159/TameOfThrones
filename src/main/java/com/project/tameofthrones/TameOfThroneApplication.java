package com.project.tameofthrones;

import com.project.tameofthrones.model.Kingdom;
import com.project.tameofthrones.repositoryservices.KingdomData;
import com.project.tameofthrones.util.KingdomsAlliances;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class TameOfThroneApplication {

  public static void main(String[] args) throws IOException {
    KingdomData kingdomData = new KingdomData();
    Map<String, Kingdom> kingdoms = kingdomData.generateAllRulers();
    KingdomsAlliances kingdomsAlliances = new KingdomsAlliances();

    Path path = Paths.get(args[0]);
    Scanner scanner = new Scanner(path);

    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      String[] sArray = s.split(" ");
      String emblem = sArray[0];
      String msg = "";
      for (int i = 1; i < sArray.length; i++) {
        msg += sArray[i];
      }
      Kingdom kingdom = kingdoms.get(emblem);
      kingdom.sendMessageToKingdom(msg);
      if (kingdom.isKingdomAlliedToRuler()) {
        kingdomsAlliances.updateAlliesList(emblem);
      }

    }
    System.out.println(kingdomsAlliances.alliesWithRuler());

  }





}
