package battleship.ship;

/**
 * Este es un javadoc.
 */
public class ShipDamageAlive implements IShipDamage {
  int health;
  
  public ShipDamageAlive(int length) {
    this.health = length;
  }
  
  public boolean isAlive() {
    return true;
  }
  
  public int getHealth() {
    return this.health;
  }
  
  public void receiveDamage() {
    this.health -= 1;
  }
  
  //public void sink() {
  //  
  //}
}
