package com.project.tameofthrones.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Kingdom repository.
 */
public class KingdomRepository {

  private Map<String, String> kingdomWithAnimal = new HashMap<>();

  private void setInfoOfAllKingdoms() {
    kingdomWithAnimal.put("SPACE", "GORILLA");
    kingdomWithAnimal.put("LAND", "PANDA");
    kingdomWithAnimal.put("WATER", "OCTOPUS");
    kingdomWithAnimal.put("ICE", "MAMMOTH");
    kingdomWithAnimal.put("AIR", "OWL");
    kingdomWithAnimal.put("FIRE", "DRAGON");
  }

  /**
   * Instantiates a new Kingdom repository.
   */
  public KingdomRepository() {
    setInfoOfAllKingdoms();
  }

  /**
   * Gets rulers with animal.
   *
   * @return the all the existing rulers with animal
   *     in hashmap data structure
   */
  public Map<String, String> getRulersWithAnimal() {
    return kingdomWithAnimal;
  }

  /**
   * Add kingdom.
   * <p>
   * Add a new kingdom to current hashmap
   * </p>
   *
   * @param kingdom the kingdom
   * @param animal  the animal
   */
  public void addKingdom(String kingdom, String animal) {
    kingdomWithAnimal.put(kingdom, animal);
  }

  /**
   * Remove kingdom.
   * <p>
   * If a kingdom exists, remove it from hashmap
   * </p>
   *
   * @param kingdom the kingdom
   */
  public void removeKingdom(String kingdom) {
    if (kingdomWithAnimal.containsKey(kingdom)) {
      kingdomWithAnimal.remove(kingdom);
    }
  }

  /**
   * Update kingdom.
   * <p>
   * If a kingdom exists,
   * update it in hashmap with new animal
   * </p>
   *
   * @param kingdom the kingdom
   * @param animal  the animal
   */
  public void updateKingdom(String kingdom, String animal) {
    if (kingdomWithAnimal.containsKey(kingdom)) {
      addKingdom(kingdom, animal);
    }
  }
}
