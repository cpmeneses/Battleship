package battleship;

/**
 * Este es un javadoc.
 */
public class SpaceDisplay extends AbstractSymbolDisplay {
  
  /**
  * Este es un javadoc.
  */
  public char displaySymbol(ISpot spot) {
    if (spot.hasShip()) {
      return '*';
    }
    return ' ';
  }
}
