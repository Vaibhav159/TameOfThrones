package com.project.tameofthrones.repositoryservices;

import com.project.tameofthrones.model.Kingdom;
import com.project.tameofthrones.repository.KingdomRepository;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Kingdom data.
 */
public class KingdomData {

  private KingdomRepository kingdomRepository = new KingdomRepository();

  /**
   * Generate all rulers map.
   * <p>
   * Generate a HashMap(Emblem, Kingdom) such that
   * String denotes emblem and
   * Kingdom denotes object of the Kingdom
   * with Cipher generated for its AnimalName
   * </p>
   *
   * @return the map
   */
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
