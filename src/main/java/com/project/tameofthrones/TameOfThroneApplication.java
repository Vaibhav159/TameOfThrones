package com.project.tameofthrones;

import com.project.tameofthrones.model.Kingdom;
import com.project.tameofthrones.repositoryservices.KingdomData;
import com.project.tameofthrones.util.KingdomsAlliances;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Tame of throne application.
 */
public class TameOfThroneApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments storing the path of the file
   * @throws IOException the io exception
   */

  public static void main(String[] args) throws IOException {

    KingdomData kingdomData = new KingdomData();
    Map<String, Kingdom> kingdoms = kingdomData.generateAllRulers();
    KingdomsAlliances kingdomsAlliances = new KingdomsAlliances();

    Path path = Paths.get(args[0]);
    Scanner scanner = new Scanner(path);

    //Loops until the end of file
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      //Assign the emblem in line from 0 to first whitespace
      String emblem = line.substring(0, line.indexOf(" "));

      //From first white space till the end
      String secretMessage = line.substring(line.indexOf(" ") + 1);

      Kingdom kingdom = kingdoms.get(emblem);
      kingdom.sendMessageToKingdom(secretMessage);

      if (kingdom.isKingdomAlliedToRuler()) {
        kingdomsAlliances.updateAlliesList(emblem);
      }

    }
    //Prints allied list who are with Ruler
    System.out.println(kingdomsAlliances.alliesWithRuler());

  }

}
