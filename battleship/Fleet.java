package battleship;

import battleship.ship.IShip;
import battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Iterator;

/**
*La clase Fleet guarda un conjunto de barcos.
*/
class Fleet implements IFleet{
  protected ArrayList<IShip> fleet = new ArrayList<IShip>();
  
  /**Constructor de Fleet.
   */
  public Fleet() {
    this.fleet = new ArrayList<IShip>();
  }
  
  //entrega una interfaz
  public Iterator<IShip> convertToInterface() {
    ArrayList<IShip> aiShip = new ArrayList<IShip>();
    for (int i = 0; i < this.getSize(); i++) {
      aiShip.add(this.getShip(i));
    }
    return aiShip.iterator();
  }
  
  //reset reseta la flota
  public void reset() {
    this.fleet = new ArrayList<IShip>();
  }
  
  //getSize retorna el tamanho de la flota
  public int getSize() {
    return fleet.size();
  }
  
  //addShip anhade un barco sin desplegar a la flota
  public void addShip(String shipName, int shipLength) {
    Ship ship = new Ship(shipName,shipLength);
    fleet.add(ship);
  }
  
  //addShip anhade un barco sin desplegar a la flota
  public void addShip(IShip ship) {
    fleet.add(ship);
  }

  //getShip retorna un barco de una posicion de la lista dada.
  public IShip getShip(int index) {
    return fleet.get(index);
  }
  
  //popShip retorna el barco de mas abajo
  public IShip popShip() {
    for (int i = 0; i < this.getSize(); i++) {
      if (!(this.getShip(i).isDeployed())) {
        IShip res = getShip(i);
        this.fleet.remove(i);
        return res;
      }
    }
    return null;
  }
  
  //getFleet retorna la flota
  public ArrayList<IShip> getFleet() {
    return this.fleet;
  }
  
  //getDeployed retorna los barcos que esten desplegados
  public Fleet getDeployed() {
    Fleet fleet = new Fleet();
    for (int i = 0; i < fleet.getSize(); i++) {
      if (this.getShip(i).isDeployed()) {
        fleet.addShip(this.getShip(i));
      }
    }
    return fleet;
  }
  
  //numberOfDeployedShips retorna la cantidad de barcos desplegados
  public long numberOfDeployedShips() {
    int res = 0;
    for (int i = 0; i < this.getSize(); i++) {
      if (this.getShip(i).isDeployed()) {
        res += 1;
      }
    }
    return res;
  }
  
  public long numberOfAnchoredShips() {
    return (long)this.getSize() - this.numberOfDeployedShips();
  }
  
  //useTraditionalFleet cambia a fleet a la flota tradicional
  public void useTraditionalFleet() {
    this.addShip("Aircraft carrier",5);
    this.addShip("Battleship",4);
    this.addShip("Submarine",3);
    this.addShip("Destroyer",3);
    this.addShip("Patrol boat",2);
  }
  
  //useTacticalFleet cambia a fleet a la flota tactica
  public void useTacticalFleet() {
    this.addShip("Aircraft carrier",5);
    this.addShip("Battleship",4);
    this.addShip("Cruiser",3);
    this.addShip("Destroyer",2);
    this.addShip("Destroyer",2);
    this.addShip("Submarine",1);
    this.addShip("Submarine",1);
  }

  @Override
  public int countSpacesTotal() {
    int res = 0;
    for (int i = 0; i < fleet.size(); i++) {
      res += fleet.get(i).getLength();
    }
    return res;
  }
  
  @Override
  public int countSpacesAffected() {
    int res = 0;
    for (int i = 0; i < fleet.size(); i++) {
      res += fleet.get(i).getSpacesAffected();
    }
    return res;
  }
}