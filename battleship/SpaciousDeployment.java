package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
* Este es un javadoc.
*/
public class SpaciousDeployment implements IDeployment {
  
  /**
  * Este es un javadoc.
  */
  public IShip deploy(IShip ship, IPosition position, IBoard board, IPlayer player) {
    if (checkAround(ship, position, board)) {
      IShip res = position.deploy(ship, board, this);
      player.addShip(res);
      return res;
    } else {
      return new NullShip();
    }
  }
  
  /**
  * Este es un javadoc.
  */
  public boolean checkAround(IShip ship, IPosition position, IBoard board) {
    if (position.checkFreeLine(ship, board, 1)
        & position.checkFreeLine(ship, board, -1)
        & position.checkFreeBefore(ship, board)
        & position.checkFreeAfter(ship, board)
    ) {
      return true;
    }
    return false;
  }
}
