package com.project.tameofthrones.repositoryservices;

import com.project.tameofthrones.model.Kingdom;
import com.project.tameofthrones.repository.KingdomRepository;
import java.util.HashMap;
import java.util.Map;

public class KingdomData {

  private KingdomRepository kingdomRepository = new KingdomRepository();

  public Map<String, Kingdom> generateAllRulers() {
    Map<String, String> kingdomWithAnimal;
    kingdomWithAnimal = kingdomRepository.getRulersWithAnimal();
    Map<String, Kingdom> kingdoms = new HashMap<>();
    for (String emblem : kingdomWithAnimal.keySet()) {
      Kingdom kingdom = new Kingdom(emblem, kingdomWithAnimal.get(emblem));
      kingdom.makeCipherFromAnimalName();
      kingdoms.put(emblem, kingdom);
    }
    return kingdoms;
  }

}
