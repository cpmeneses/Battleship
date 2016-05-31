package battleship;

/**
 * Este es un javadoc.
 */
public abstract class AbstractPosition implements IPosition {
  int hor;
  int ver;
  
  public AbstractPosition() {
    this.hor = -1;
    this.ver = -1;
  }

  AbstractPosition(int hor, int ver) {
    this.hor = hor;
    this.ver = ver;
  }

  //
  public int getHorizontal() {
    return hor;
  }

  //
  public int getVertical() {
    return ver;
  }
}