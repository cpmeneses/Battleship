package battleship;

import battleship.ship.IShip;

/**
 * Este es un javadoc.
 */
interface IDeployment {
  IShip deploy(IShip ship, IPosition position, IBoard board, IPlayer player);
}