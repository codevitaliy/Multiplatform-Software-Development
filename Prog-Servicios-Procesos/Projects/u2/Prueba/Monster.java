package Projects.u2.Prueba;

import java.io.Serializable;
import java.util.Random;

public class Monster implements Serializable {

  String name;
  int numLimbs, numLeftLegs, numLeftArms, numRightLegs, numRightArms, color;

  public static final String HEAD = "*", BODY = " O ";

  public Monster(String name, int color, int numLimbs){
    this.name = name;
    this.color = color;
    this.numLimbs = numLimbs;

    Random random = new Random();
    numLeftArms = random.nextInt(numLimbs + 1);
    numLeftLegs = random.nextInt(numLimbs - numLeftArms + +1);
    numRightArms = random.nextInt(numLimbs - numLeftArms - numLeftLegs + 1);
    numRightLegs = random.nextInt(numLimbs - numLeftArms - numLeftLegs - numRightArms + 1);
  }


  public String toString() {
    StringBuilder monster = new StringBuilder();
    StringBuilder leftArms = new StringBuilder();
    StringBuilder leftLegs = new StringBuilder();
    StringBuilder rightArms = new StringBuilder();
    StringBuilder rightLegs = new StringBuilder();


    for (int i = 0; i < numLeftArms; i++) {
      leftArms.append("/");
    }

    for (int i = 0; i < numLeftLegs; i++) {
      leftLegs.append("/");
    }

    for (int i = 0; i < numRightArms; i++) {
      rightArms.append("\\");
    }

    for (int i = 0; i < numRightLegs; i++) {
      rightLegs.append("\\");
    }

    monster.append(HEAD + "\n")
            .append(leftArms.append(BODY).append(rightArms).append("\n"))
            .append(leftLegs.append("   ").append(rightLegs));

    return monster.toString();
  }
}