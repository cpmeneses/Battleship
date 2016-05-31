package battleship.ship;

import battleship.IPlayer;
import battleship.IPosition;

/**La interfaz IShip es una interfaz.
 */
public interface IShip {
  public int getLength();
  
  public String getName();
  
  boolean isShip();
  
  boolean isAnchored();
  
  boolean isDeployed();
  
  void setPosition(IPosition position);
  
  void setPlayer(IPlayer player);
  
  boolean comparePlayer(IPlayer player);

  public int getSpacesAffected();
}