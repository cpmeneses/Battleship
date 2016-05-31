package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
 * Este es un javadoc.
 */
public class VerticalPosition extends AbstractPosition {
  
  VerticalPosition(int hor, int ver) {
    this.hor = hor;
    this.ver = ver;
  }
  
  public boolean isNull() {
    return false;
  }
  
  /**
   * Este es un javadoc.
   */
  public boolean checkFreeLine(IShip ship, IBoard board, int perpendicularOffset) {
    for (int i = 0; i < ship.getLength(); i++) {
      if (!board.isFreeAt(hor + perpendicularOffset,ver + i)) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * Este es un javadoc.
   */
  public boolean checkFreeShipPlacement(IShip ship, IBoard board, int perpendicularOffset) {
    for (int i = 0; i < ship.getLength(); i++) {
      if (!board.isFreeWaterAt(hor + perpendicularOffset,ver + i)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean checkFreeBefore(IShip ship, IBoard board) {
    return board.isFreeAt(hor, ver - 1);
  }
  
  public boolean checkFreeAfter(IShip ship, IBoard board) {
    return board.isFreeAt(hor, ver + ship.getLength());
  }
  
  /**
   * Este es un javadoc.
   */
  public IShip deploy(IShip ship, IBoard board, IDeployment deployment) {
    if (checkFreeShipPlacement(ship, board, 0)) {
      ship.setPosition(this);
      for (int i = 0; i < ship.getLength(); i++) {
        board.spot(hor,ver + i).setShip(ship);
      }
      return ship;
    } else {
      return new NullShip();
    }
  }
}
