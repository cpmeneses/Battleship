package battleship;

import battleship.ship.IShip;

/**
 * Este es un javadoc.
 */
interface ISpot {
  boolean hasShip();
  
  void setShip(IShip ship);
  
  IShip getShip();
  
  boolean isWater();
  
  boolean isFreeWater();
  
  boolean isFree();
  
  boolean isPlayerShip(IPlayer player);
  //void display(IDisplay display);
}
