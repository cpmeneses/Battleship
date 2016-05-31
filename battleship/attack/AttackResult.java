package battleship.attack;

/**
 * Este es un javadoc.
 */
public class AttackResult implements IAttackResult{

  public boolean isAffectedTarget() {
    return false;
  }

  public boolean isMissedTarget() {
    return true;
  }
}