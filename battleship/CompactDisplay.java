package battleship;

/**
 * Este es un javadoc.
 */
public class CompactDisplay extends AbstractGameDisplay implements IGameDisplay{
  
  /**
  * Este es un javadoc.
  */
  public String display(IBoard board, ISymbolDisplay symbol, IPlayer player) {
    StringBuilder base = new StringBuilder();
    base.append(symbol.display(board));
    StringBuilder auxiliar = new StringBuilder();
    auxiliar.append("Player: " + player.getName() + "\n");
    auxiliar.append(" with " + player.countSpacesAffected() +
    " out of " + player.countSpacesTotal() + " affected ship parts.\n\n");
    auxiliar.append(base);
    return auxiliar.toString();
  }
}
