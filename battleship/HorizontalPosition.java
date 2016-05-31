package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
 * Este es un javadoc.
 */
public class HorizontalPosition extends AbstractPosition{
  
  public HorizontalPosition(int hor, int ver) {
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
      if (!board.isFreeAt(hor + i,ver + perpendicularOffset)) {
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
      if (!board.isFreeWaterAt(hor + i,ver + perpendicularOffset)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean checkFreeBefore(IShip ship, IBoard board) {
    return board.isFreeWaterAt(hor - 1, ver);
  }
  
  public boolean checkFreeAfter(IShip ship, IBoard board) {
    return board.isFreeWaterAt(hor + ship.getLength(), ver);
  }
  
  /**
   * Este es un javadoc.
   */
  public IShip deploy(IShip ship, IBoard board, IDeployment deployment) {
    if (checkFreeShipPlacement(ship, board, 0)) {
      ship.setPosition(this);
      for  (int i = 0; i < ship.getLength(); i++) {
        board.spot(hor + i,ver).setShip(ship);
      }
      return ship;
    } else {
      return (IShip) new NullShip();
    }
  }
}
