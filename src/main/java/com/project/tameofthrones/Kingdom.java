package com.project.tameofthrones;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Kingdom {

  public static final int MINIMUM_MAJORITY_REQUIRED = 3;

  private List<String> alliedRulers = new ArrayList<String>() {{
    add("SPACE");
  }};

  public void updateAlliesList(String emblem) {
    alliedRulers.add(emblem);
  }

  public String alliesForKingdom(int currentMajority) {
    String ans = "NONE";
    if (currentMajority >= MINIMUM_MAJORITY_REQUIRED) {
      ans = String.join(" ", alliedRulers);
    }
    return ans;
  }
}
