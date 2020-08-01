package com.project.tameofthrones.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.Test;

class KingdomRepositoryTest {

  KingdomRepository kingdomRepository = new KingdomRepository();

  @Test
  void getRulersWithAnimal() {
    Map<String, String> kingdomWithAnimal = kingdomRepository
        .getRulersWithAnimal();

    assertEquals(6, kingdomWithAnimal.size());
    assertEquals("OWL", kingdomWithAnimal.get("AIR"));
    assertEquals("DRAGON", kingdomWithAnimal.get("FIRE"));
    assertEquals("PANDA", kingdomWithAnimal.get("LAND"));
    assertEquals("MAMMOTH", kingdomWithAnimal.get("ICE"));
    assertEquals("GORILLA", kingdomWithAnimal.get("SPACE"));
    assertEquals("OCTOPUS", kingdomWithAnimal.get("WATER"));

  }

  @Test
  void addKingdom() {
    String kingdom = "GALAXY";
    String animal = "LION";
    kingdomRepository.addKingdom(kingdom, animal);
    assertEquals(animal,
        kingdomRepository.getRulersWithAnimal().get(kingdom));
  }

  @Test
  void removeExistingKingdom() {
    String kingdom = "SPACE";

    kingdomRepository.removeKingdom(kingdom);
    assertEquals(null,
        kingdomRepository.getRulersWithAnimal().get(kingdom));
  }

  @Test
  void removeNonExistingKingdom() {
    String kingdom = "Lava";

    kingdomRepository.removeKingdom(kingdom);
    assertEquals(null,
        kingdomRepository.getRulersWithAnimal().get(kingdom));
  }

  @Test
  void updateRulerForExistingRuler() {
    String kingdom = "AIR";
    String animal = "BAT";

    kingdomRepository.addKingdom(kingdom, animal);
    assertEquals(animal,
        kingdomRepository.getRulersWithAnimal().get(kingdom));
  }

  @Test
  void updateRulerForNonExistingRuler() {
    String kingdom = "LAVA";
    String animal = "BAT";

    kingdomRepository.updateKingdom(kingdom, animal);

    assertEquals(null,
        kingdomRepository.getRulersWithAnimal().get(kingdom));
  }


}