package battleship.ship;

import battleship.IPlayer;
import battleship.IPosition;

/**
 * Este es un javadoc.
 */
public class NullShip implements IShip {
  //OJO: hacer que devuelva errores
  public String getName() {
    //error
    return "";
  }
  
  public int getLength() {
    //error
    return 0;
  }
  
  public boolean isShip() {
    return false;
  }
  
  public boolean isAnchored() {
    //error
    return false;
  }
  
  public boolean isDeployed() {
    //error
    return false;
  }
  
  public void setPosition(IPosition position) {
    //error
  }
  
  public void setPlayer(IPlayer player) {
    //nothing
  }
  
  public boolean comparePlayer(IPlayer player) {
    return false;
  }

  @Override
  public int getSpacesAffected() {
    return 0;
  }
}
