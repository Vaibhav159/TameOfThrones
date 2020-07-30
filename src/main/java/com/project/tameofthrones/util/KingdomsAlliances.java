package com.project.tameofthrones.util;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class KingdomsAlliances {

  public static final int MINIMUM_MAJORITY_REQUIRED = 3;

  @Setter(AccessLevel.NONE)
  private List<String> alliedKingdoms = new ArrayList<String>() {{
    add("SPACE");
  }};

  @Setter(AccessLevel.NONE)
  private int currentMajority = 0;

  public void updateAlliesList(String emblem) {
    currentMajority++;
    alliedKingdoms.add(emblem);
  }

  public String alliesWithRuler() {
    String ans = "NONE";
    if (currentMajority >= MINIMUM_MAJORITY_REQUIRED) {
      ans = String.join(" ", alliedKingdoms);
    }
    return ans;
  }
}
