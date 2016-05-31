package battleship;

import battleship.ship.IShip;

/**
 * Este es un javadoc.
 */
public interface IPlayer {
  public void setName(String name);
  
  public String getName();
  
  public boolean comparePlayer(IPlayer player);
  
  public IShip addShip(IShip ship);
  
  public long numberOfDeployedShips();
  
  public long numberOfAnchoredShips();

  public int countSpacesTotal();

  public int countSpacesAffected();
}
