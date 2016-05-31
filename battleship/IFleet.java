package battleship;

import battleship.ship.IShip;

/**
 * Este es un javadoc.
 */
public interface IFleet {
  public void addShip(IShip ship);

  public long numberOfDeployedShips();

  public long numberOfAnchoredShips();

  public int countSpacesTotal();

  public int countSpacesAffected();
}
