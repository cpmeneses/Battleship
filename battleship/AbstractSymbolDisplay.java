package battleship;

/**
 * Este es un javadoc.
 */
public abstract class AbstractSymbolDisplay implements ISymbolDisplay {
  /**
   * Este es un javadoc.
   */  
  public String display(IBoard board) {
    StringBuilder res = new StringBuilder();
    int hor = 1;
    int ver = 1;
    int foundNull = 0;
    while (foundNull < 2) {
      if (board.isWaterAt(hor, ver)) {
        if (foundNull != 0) {
          foundNull = 0;
          res.append('\n');
        }
        res.append(this.displaySymbol(board.spot(hor, ver)));
        hor += 1;
      } else {
        foundNull += 1;
        ver += 1;
        hor = 1;
      }
    }
    return res.toString();
  }
  
  public abstract char displaySymbol(ISpot spot);
}
