package battleship;

/**
 * Este es un javadoc.
 */
public interface IBoard {
  boolean isFreeWaterAt(int hor, int ver);
  
  boolean isFreeAt(int hor, int ver);
  
  boolean isWaterAt(int hor, int ver);
  
  void setSize(int width, int height);
  
  int getWidth();
  
  int getHeight();
  
  ISpot spot(int hor, int ver);
  
  boolean isPlayerShipAt(int hor, int ver, IPlayer player);
}
