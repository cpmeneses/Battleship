package battleship;

import battleship.ship.IShip;

/**
 * Este es un javadoc.
 */
public interface IPosition {
  public IShip deploy(IShip ship, IBoard board, IDeployment deployment);
  
  public boolean isNull();
  
  public int getHorizontal();
  
  public int getVertical();
  
  public boolean checkFreeShipPlacement(IShip ship, IBoard board, int perpendicularOffset);
  
  public boolean checkFreeLine(IShip ship, IBoard board, int perpendicularOffset);
  
  public boolean checkFreeBefore(IShip ship, IBoard board);
  
  public boolean checkFreeAfter(IShip ship, IBoard board);
}
