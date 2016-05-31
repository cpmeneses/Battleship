package battleship;

/**
 * Este es un javadoc.
 */
public class DesktopDisplay extends AbstractGameDisplay{
  ISymbolDisplay symbol;
  
  DesktopDisplay() {
    symbol = new TildeDisplay();
  }
  
  /**
   * Este es un javadoc.
   */
  public String display(IBoard board, ISymbolDisplay symbol, IPlayer player) {
    return symbol.display(board);
  }
  
  /**
  public String display(IBoard board, ISymbolDisplay symbol) {
    StringBuilder res = new StringBuilder();
    int hor = 1;
    int ver = 1;
    int foundNull = 0;
    while (foundNull < 2) {
      if (board.spot(hor, ver).isWater()) {
        res.append(symbol.displaySymbol(board.spot(hor, ver)));
        hor += 1;
        foundNull = 0;
      }
      else{
        ver += 1;
        hor = 1;
        foundNull += 1;
      }
    }
    return res.toString();
  }
  */
}
