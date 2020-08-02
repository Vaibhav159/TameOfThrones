package com.project.tameofthrones.util;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Kingdoms alliances.
 */
@Data
@NoArgsConstructor
public class KingdomsAlliances {

  /**
   * The constant MINIMUM_MAJORITY_REQUIRED
   * which can be changed according to the need.
   */
  public static final int MINIMUM_MAJORITY_REQUIRED = 3;

  @Setter(AccessLevel.NONE)
  private Set<String> alliedKingdoms = new LinkedHashSet<String>() {{
      add("SPACE");
    }
  };

  @Setter(AccessLevel.NONE)
  private int currentMajority = 0;

  /**
   * Update allies list.
   *
   * if a kingdom accepts Ruler Message,
   * update the Allied Kingdoms list
   *
   * @param emblem the emblem
   */
  public void updateAlliesList(String emblem) {
    if (!alliedKingdoms.contains(emblem)) {
      currentMajority++;
      alliedKingdoms.add(emblem);
    }
  }

  /**
   * Allies with ruler string.
   *
   * Check and return if currentMajority is
   * greater than equal to MINIMUM_MAJORITY_REQUIRED
   *
   * @return the string if condition is true it return all
   *     allies else NONE is returned
   */
  public String alliesWithRuler() {
    String ans = "NONE";
    if (currentMajority >= MINIMUM_MAJORITY_REQUIRED) {
      ans = String.join(" ", alliedKingdoms);
    }
    return ans;
  }
}
