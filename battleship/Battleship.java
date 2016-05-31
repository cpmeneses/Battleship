package battleship;


import battleship.attack.AttackResult;
import battleship.attack.IAttackResult;
import battleship.ship.IShip;

import java.util.Iterator;

/**Clase facade Battleship.
*/
public class Battleship {
  IBoard boardp1;
  IBoard boardp2;
  Fleet fleet;
  Printer printer;
  IDeployment deployment;
  IPlayer player1;
  IPlayer player2;
  

  /**Inicializador de Battleship.
   */
  public Battleship() {
    this.boardp1 = new Board(); 
    this.boardp2 = new Board();
    this.fleet = new Fleet();
    this.printer = new Printer(); //tilde y desktop
    this.deployment = new TightDeployment(); //TIGHT es default. DEBUG
    this.player1 = new Player();
    this.player2 = new Player();
  }

  /**Configuracion.*/
  //setTerritory cambia las dimensiones del tablero
  public void setTerritorySize(int width, int height) {
    boardp1.setSize(width, height);
    boardp2.setSize(width, height);
  }
  
  //
  public void setPlayerOneName(String name) {
    player1.setName(name);
  }
  
  //
  public void setPlayerTwoName(String name) {
    player2.setName(name);
  }

  /**Acceso.*/
  //getTerritoryHeight retorna la altura del tablero
  public int getTerritoryHeight() {
    return boardp1.getHeight();
  }
  
  //getTerritoryWidth retorna el ancho del tablero
  public int getTerritoryWidth() {
    return boardp1.getWidth();
  }
  
  //
  public String getPlayerOneName() {
    return player1.getName();
  }
  
  //
  public String getPlayerTwoName() {
    return player2.getName();
  }
  
  /**Visualizacion.*/
  /**Configuracion.*/
  //useTildeDisplay cambia el display a tilde
  public void useTildeDisplay() {
    printer.setTildeDisplay();
  }
  
  //useSpaceDisplay cambia el display a space
  public void useSpaceDisplay() {
    printer.setSpaceDisplay();
  }
  
  public void useCompactDisplay() {
    printer.setCompactDisplay();
  }
  
  public void useDesktopDisplay() {
    printer.setDesktopDisplay();
  }
  
  public void useReverseDesktopDisplay() {
    printer.setReverseDesktopDisplay();
  }
  
  /**Visualizacion.*/
  
  //displayTerritory retorna el tablero
  public String displayPlayerOneTerritory() {
    return printer.displayAlly(boardp1, player1);
  }
  
  public String displayPlayerTwoTerritory() {
    return printer.displayAlly(boardp2, player2);
  }
  
  public String displayPlayerOneDesk() {
    return printer.displayEnemy(boardp1);
  }
  
  public String displayPlayerTwoDesk() {
    return printer.displayEnemy(boardp2);
  }
  
  /**Fleet.*/
  /**Configuracion.*/
  
  //useTraditionalFleet cambia a fleet por la flota tradicional
  public void useTraditionalFleet() {
    fleet.useTraditionalFleet();
  }
  
  //useTacticalShip cambia a fleet por la flota tactica
  public void useTacticalFleet() {
    fleet.useTacticalFleet();
  }
  
  //useCustomFleet limpia la flota
  public void useCustomFleet() {
    fleet.reset();
  }
  
  public void addShip(String shipName, int shipLength) {
    fleet.addShip(shipName, shipLength);
  }
  
  /**Acceso.*/
  
  //getFleetSize retorna el tamanho de la flota
  public int getFleetSize() {
    return fleet.getSize();
  }
  
  public Iterator<IShip> getFleetIterator() {
    return fleet.convertToInterface();
  }
  
  /**Colocacion de Barcos.*/
  /**Configuracion.*/
  
  //useTightDeployment hace que deployment sea tight
  public void useTightDeployment() {
    deployment = new TightDeployment();
  }
  
  //useSpaciousDeployment hace que deployment sea spacious
  public void useSpaciousDeployment() {
    deployment = new SpaciousDeployment();
  }
  
  /**Colocacion.*/
  
  public IShip playerOneDeployHorizontally(int horizontalPosition, int verticalPosition) {
    IPosition position = new HorizontalPosition(horizontalPosition, verticalPosition);
    IShip ship = fleet.popShip();
    return deployment.deploy(ship, position, boardp1, player1);
  }
  
  /**
   * Este es un javadoc.
   */
  public IShip playerOneDeployVertically(int horizontalPosition, int verticalPosition) {
    IPosition position = new VerticalPosition(horizontalPosition, verticalPosition);
    IShip ship = fleet.popShip();
    return deployment.deploy(ship, position, boardp1, player1);
  }
  
  /**
   * Este es un javadoc.
   */
  public IShip playerTwoDeployHorizontally(int horizontalPosition, int verticalPosition) {
    IPosition position = new HorizontalPosition(horizontalPosition, verticalPosition);
    IShip ship = fleet.popShip();
    return deployment.deploy(ship, position, boardp2, player2);
  }
  
  /**
   * Este es un javadoc.
   */
  public IShip playerTwoDeployVertically(int horizontalPosition, int verticalPosition) {
    IPosition position = new VerticalPosition(horizontalPosition, verticalPosition);
    IShip ship = fleet.popShip();
    return deployment.deploy(ship, position, boardp2, player2);
  }
  
  /**Acceso.*/
  
  public long playerOneNumberOfDeployedShips() {
    return player1.numberOfDeployedShips();
  }
  
  public long playerOneNumberOfAnchoredShips() {
    return player1.numberOfAnchoredShips();
  }
  
  public long playerTwoNumberOfDeployedShips() {
    return player2.numberOfDeployedShips();
  }
  
  public long playerTwoNumberOfAnchoredShips() {
    return player2.numberOfAnchoredShips();
  }
  
  public boolean isPlayerOneShipAt(int horizontalPosition, int verticalPosition) {
    return boardp1.isPlayerShipAt(horizontalPosition, verticalPosition, player1);
  }
  
  public boolean isPlayerTwoShipAt(int horizontalPosition, int verticalPosition) {
    return boardp2.isPlayerShipAt(horizontalPosition, verticalPosition, player2);
  }

  /**Batalla.*/
  public IAttackResult playerOneAttackAt(int horizontalPosition, int verticalPosition) {
    return new AttackResult();
  }

  public IAttackResult playerTwoAttackAt(int horizontalPosition, int verticalPosition) {
    return new AttackResult();
  }
}