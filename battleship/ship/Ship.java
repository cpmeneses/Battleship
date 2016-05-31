package battleship.ship;

import battleship.IPlayer;
import battleship.IPosition;
import battleship.NullPosition;

/**
 *La clase Ship guarda un barco con su nombre, largo y ubicación.
 */
public class Ship implements IShip {
  final String name;
  final int length;
  IPosition position;
  IShipDamage damage;
  IPlayer player;

  /**
   * Inicializacion.
   */
  public Ship(String name, int length) {
    this.name = name;
    this.length = length;
    this.position = new NullPosition();
    this.damage = new ShipDamageAlive(this.length);
  }
  
  public IShip convertToIShip() {
    return new Ship(this.name, this.length);
  }
  
  //getLength retorna el largo
  public int getLength() {
    return this.length;
  }
  
  //getName retorna el nombre
  public String getName() {
    return this.name;
  }
  
  //isDeployed retorna si el barco esta en el tablero
  public boolean isDeployed() {
    return !(position.isNull());
  }
  
  public boolean isShip() {
    return true;
  }
  
  public boolean isAnchored() {
    return position.isNull();
  }
  
  public boolean isAlive() {
    return damage.isAlive();
  }
  
  /**public boolean isPlayer(){
    return player.isPlayer();
  }*/

  //setPosition fija la posicion del objeto ship
  public void setPosition(IPosition position) {
    this.position = position;
  }
  
  //
  public void setPlayer(IPlayer player) {
    this.player = player;
  }
  
  public boolean comparePlayer(IPlayer player) {
    return this.player.comparePlayer(player);
  }

  @Override
  public int getSpacesAffected() {
    return this.length - damage.getHealth();
  }
}