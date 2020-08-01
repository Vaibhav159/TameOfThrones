package com.project.tameofthrones.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Map;
import org.junit.jupiter.api.Test;

class KingdomRepositoryTest {

  KingdomRepository kingdomRepository = new KingdomRepository();

  @Test
  void getKingdomsWithAnimalTest() {
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
  void addKingdomTest() {
    String kingdom = "GALAXY";
    String animal = "LION";
    kingdomRepository.addKingdom(kingdom, animal);
    assertEquals(animal,
        kingdomRepository.getRulersWithAnimal().get(kingdom));
  }

  @Test
  void removeExistingKingdomTest() {
    String kingdom = "SPACE";

    kingdomRepository.removeKingdom(kingdom);
    assertNull(kingdomRepository.getRulersWithAnimal()
        .get(kingdom));
  }

  @Test
  void removeNonExistingKingdomTest() {
    String kingdom = "Lava";

    kingdomRepository.removeKingdom(kingdom);
    assertNull(kingdomRepository.getRulersWithAnimal()
        .get(kingdom));
  }

  @Test
  void updateRulerForExistingKingdomTest() {
    String kingdom = "AIR";
    String animal = "BAT";

    kingdomRepository.addKingdom(kingdom, animal);
    assertEquals(animal,
        kingdomRepository.getRulersWithAnimal().get(kingdom));
  }

  @Test
  void updateRulerForNonExistingKingdomTest() {
    String kingdom = "LAVA";
    String animal = "BAT";

    kingdomRepository.updateKingdom(kingdom, animal);

    assertNull(kingdomRepository.getRulersWithAnimal()
        .get(kingdom));
  }


}