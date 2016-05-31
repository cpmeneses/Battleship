package battleship;

import battleship.ship.IShip;

/**
 * Este es un javadoc.
 */
public class Player implements IPlayer {
  String name;
  IFleet fleet;
  
  //
  public Player() {
    this.name = "default_player_name";
    this.fleet = new Fleet();
  }
  
  public Player(IFleet fleet) {
    this.name = "default_player_name";
    this.fleet = fleet;
  }
  
  //
  public void setName(String name) {
    this.name = name;
  }
  
  //
  public String getName() {
    return this.name;
  }
  
  //
  public boolean comparePlayer(IPlayer player) {
    return this.equals(player);
  }
  
  /**
  * Esto es un javadoc.
  */
  public IShip addShip(IShip ship) {
    ship.setPlayer(this);
    this.fleet.addShip(ship);
    return ship;
  }
  
  //
  public long numberOfDeployedShips() {
    return this.fleet.numberOfDeployedShips();  
  }
  
  //
  public long numberOfAnchoredShips() {
    return this.fleet.numberOfAnchoredShips();  
  }

  @Override
  public int countSpacesTotal() {
    return fleet.countSpacesTotal();
  }
  
  @Override
  public int countSpacesAffected() {
    return fleet.countSpacesAffected();
  }
}
