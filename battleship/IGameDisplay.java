package battleship;

/**
 * Este es un javadoc.
 */
public interface IGameDisplay extends IDisplay{
  public void setTildeDisplay();
  
  public void setSpaceDisplay();
  
  public String display(IBoard board, ISymbolDisplay symbol, IPlayer player);
}
