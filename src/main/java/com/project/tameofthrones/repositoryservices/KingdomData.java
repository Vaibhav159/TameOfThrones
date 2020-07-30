package com.project.tameofthrones.repositoryservices;

import com.project.tameofthrones.model.Kingdom;
import com.project.tameofthrones.repository.KingdomRepository;
import java.util.HashMap;
import java.util.Map;

public class KingdomData {

  public Map<String, Kingdom> generateAllRulers() {
    KingdomRepository kingdomRepository = new KingdomRepository();
    Map<String, String> kingdomWithAnimal;
    kingdomWithAnimal = kingdomRepository.getRulersWithAnimal();
    Map<String, Kingdom> rulers = new HashMap<>();
    for (String emblem : kingdomWithAnimal.keySet()) {
      Kingdom kingdom = new Kingdom(emblem, kingdomWithAnimal.get(emblem));
      kingdom.makeCipher();
      rulers.put(emblem, kingdom);
    }
    return rulers;
  }

}
