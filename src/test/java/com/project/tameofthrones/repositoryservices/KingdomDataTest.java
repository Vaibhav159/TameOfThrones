package com.project.tameofthrones.repositoryservices;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.project.tameofthrones.model.Kingdom;
import com.project.tameofthrones.repository.KingdomRepository;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class KingdomDataTest {

  @InjectMocks
  KingdomData kingdomData;

  @Mock
  KingdomRepository kingdomRepository;

  Map<String, String> kingdomWithAnimal = new HashMap<>();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void generateTestForSingleKingdom() {
    String kingdom = "SPACE";
    String animal = "GORILLA";
    kingdomWithAnimal.put(kingdom, animal);

    Mockito.when(kingdomRepository.getRulersWithAnimal())
        .thenReturn(kingdomWithAnimal);

    Map<String, Kingdom> allKingdoms = kingdomData.generateAllRulers();
    assertEquals(1, allKingdoms.size());
    int[] requiredCipher = allKingdoms.get(kingdom).getRequiredCipher();
    assertEquals(1, requiredCipher[7]);
    assertEquals(1, requiredCipher[13]);
    assertEquals(1, requiredCipher[15]);
    assertEquals(2, requiredCipher[18]);
    assertEquals(1, requiredCipher[21]);
    assertEquals(1, requiredCipher[24]);
  }

  @Test
  void generateTestForAllKingdom() {
    kingdomWithAnimal.put("SPACE", "GORILLA");
    kingdomWithAnimal.put("LAND", "PANDA");
    kingdomWithAnimal.put("WATER", "OCTOPUS");
    kingdomWithAnimal.put("ICE", "MAMMOTH");
    kingdomWithAnimal.put("AIR", "OWL");
    kingdomWithAnimal.put("FIRE", "DRAGON");

    Mockito.when(kingdomRepository.getRulersWithAnimal())
        .thenReturn(kingdomWithAnimal);

    Map<String, Kingdom> allKingdoms = kingdomData.generateAllRulers();
    assertEquals(6, allKingdoms.size());
  }

}