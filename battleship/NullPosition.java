package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
 * Este es un javadoc.
 */
public class NullPosition implements IPosition {
  public IShip deploy(IShip ship, IBoard board, IDeployment deployment) {
    //creo que error
    return new NullShip();
  }
  
  public boolean isNull() {
    return true;
  }
  
  public int getHorizontal() {
    return -1; //ERROR
  }
  
  public int getVertical() {
    return -1; //ERROR
  }

  @Override
  public boolean checkFreeShipPlacement(IShip ship, IBoard board, int perpendicularOffset) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean checkFreeLine(IShip ship, IBoard board, int perpendicularOffset) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean checkFreeBefore(IShip ship, IBoard board) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean checkFreeAfter(IShip ship, IBoard board) {
    // TODO Auto-generated method stub
    return false;
  }
}
