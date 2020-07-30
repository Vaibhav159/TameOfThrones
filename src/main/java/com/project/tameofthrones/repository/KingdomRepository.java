package com.project.tameofthrones.repository;

import java.util.HashMap;
import java.util.Map;

public class KingdomRepository {

  private Map<String, String> kingdomWithAnimal = new HashMap<>();

  private void setInfoOfAllRulers() {
    kingdomWithAnimal.put("SPACE", "GORILLA");
    kingdomWithAnimal.put("LAND", "PANDA");
    kingdomWithAnimal.put("WATER", "OCTOPUS");
    kingdomWithAnimal.put("ICE", "MAMMOTH");
    kingdomWithAnimal.put("AIR", "OWL");
    kingdomWithAnimal.put("FIRE", "DRAGON");
  }

  public KingdomRepository() {
    setInfoOfAllRulers();
  }

  public Map<String, String> getRulersWithAnimal() {
    return kingdomWithAnimal;
  }

  public void addRuler(String ruler, String animal) {
    kingdomWithAnimal.put(ruler, animal);
  }

  public void removeRuler(String ruler) {
    if (kingdomWithAnimal.containsKey(ruler)) {
      kingdomWithAnimal.remove(ruler);
    }
  }

  public void updateRuler(String ruler, String animal) {
    addRuler(ruler, animal);
  }
}
