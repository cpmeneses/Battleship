package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
 * Este es un javadoc.
 */
public class NullSpot implements ISpot {
  
  @Override
  public boolean hasShip() {
    return false; //ERROR
  }
  
  @Override
  public boolean isWater() {
    return false;
  }
  
  @Override
  public boolean isFreeWater() {
    return false;
  }
  
  @Override
  public boolean isFree() {
    return true;
  }
  
  @Override
  public void setShip(IShip ship) {
    //ERROR
  }
  
  @Override
  public IShip getShip() {
    return new NullShip();
  }
  
  @Override
  public boolean isPlayerShip(IPlayer player) {
    return false;
  }
}
