package battleship;

/**
 * Este es un javadoc.
 */
public abstract class AbstractGameDisplay extends AbstractDisplay implements IGameDisplay {
  StringBuilder stream;
  ISymbolDisplay symbol;
  
  AbstractGameDisplay() {
    stream = new StringBuilder();
    symbol = new TildeDisplay();
  }
  
  public String display() {
    return stream.toString();
  }
  
  public void setTildeDisplay() {
    this.symbol = new TildeDisplay();
  }
  
  public void setSpaceDisplay() {
    this.symbol = new SpaceDisplay();
  }
}
