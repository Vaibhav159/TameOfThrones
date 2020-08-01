package com.project.tameofthrones.repository;

import java.util.HashMap;
import java.util.Map;

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

  public KingdomRepository() {
    setInfoOfAllKingdoms();
  }

  public Map<String, String> getRulersWithAnimal() {
    return kingdomWithAnimal;
  }

  public void addKingdom(String kingdom, String animal) {
    kingdomWithAnimal.put(kingdom, animal);
  }

  public void removeKingdom(String kingdom) {
    if (kingdomWithAnimal.containsKey(kingdom)) {
      kingdomWithAnimal.remove(kingdom);
    }
  }

  public void updateKingdom(String kingdom, String animal) {
    if (kingdomWithAnimal.containsKey(kingdom)) {
      addKingdom(kingdom, animal);
    }
  }
}
