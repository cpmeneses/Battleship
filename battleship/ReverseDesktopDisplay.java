package battleship;

/**
 * Este es un javadoc.
 */
public class ReverseDesktopDisplay extends AbstractGameDisplay {
  
  public String display(IBoard board, ISymbolDisplay symbol, IPlayer player) {
    return symbol.display(board);
  }
}
