package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
 * Este es un javadoc.
 */
public class WaterSpot implements ISpot {
  IShip ship;
  
  WaterSpot() {
    ship = new NullShip();
  }
  
  @Override
  public boolean hasShip() {
    return ship.isShip();
  }

  @Override
  public void setShip(IShip ship) {
    this.ship = ship;    
  }

  @Override
  public IShip getShip() {
    return this.ship;
  }

  @Override
  public boolean isWater() {
    return true;
  }
  
  @Override
  public boolean isFreeWater() {
    return !(this.hasShip());
  }
  
  @Override
  public boolean isFree() {
    return !(this.hasShip());
  }
  
  @Override
  public boolean isPlayerShip(IPlayer player) {
    return this.ship.comparePlayer(player); //FIX
  }

  //@Override
  public void display(IDisplay display) {
    // TODO Auto-generated method stub
  }
}
