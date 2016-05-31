package battleship;

import battleship.ship.IShip;

/**
 * Este es un javadoc.
 */
public class TightDeployment implements IDeployment{
  
  /**
  * Este es un javadoc.
  */
  public IShip deploy(IShip ship, IPosition position, IBoard board, IPlayer player) {
    IShip res = position.deploy(ship, board, this);
    player.addShip(res);
    return res;
  }
}
