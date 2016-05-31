package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
 * Este es un javadoc.
 */
public class NullPlayer implements IPlayer {
  public String getName() {
    return ""; //ERROR
  }
  
  public void setName(String name) {
    //ERROR
  }
  
  public boolean isPlayer() {
    return false;
  }
  
  public boolean comparePlayer(IPlayer player) {
    return false;
  }
  
  public IShip addShip(IShip ship) {
    //ERROR
    return new NullShip();  
  }
  
  //
  public long numberOfDeployedShips() {
    //ERROR
    return 0;  
  }
  
  //
  public long numberOfAnchoredShips() {
    //ERROR
    return 0;  
  }

  @Override
  public int countSpacesTotal() {
    return 0;
  }

  @Override
  public int countSpacesAffected() {
    return 0;
  }
}
