package battleship;

/**La clase Board guarda informacion del tablero.
 */
final class Board implements IBoard {
  private int width;
  private int height;
  ISpot[][] spots;
  
  public Board() {
    this.width = 10;
    this.height = 10;
    spots = new ISpot[width + 2][height + 2];
    initSpots();
  }
  
  void initSpots() {
    for (int i = 0; i <= width + 1; i++) {
      for (int j = 0; j <= height + 1; j++) {
        if (i > 0 && j > 0 && i < width + 1 && j < height + 1) {
          spots[i][j] = new WaterSpot();
        } else {
          spots[i][j] = new NullSpot();
        }
      }
    }
  }
  
  //setSize fija el tamanho del tablero
  public void setSize(int width, int height) {
    this.width = width;
    this.height = height;
  }

  //getHeight devuelve la altura del tablero
  public int getHeight() {
    return height;
  }

  //getWidth devuelve el ancho del tablero
  public int getWidth() {
    return width;
  }
  
  public boolean isWaterAt(int hor, int ver) {
    if (isWithin(hor, ver)) {
      return spots[hor][ver].isWater();
    } else {
      return false;
    }
  }
  
  public boolean isFreeWaterAt(int hor, int ver) {
    if (isWithin(hor, ver)) {
      return spots[hor][ver].isFreeWater();
    } else {
      return false;
    }
  }
  
  public boolean isFreeAt(int hor, int ver) {
    if (isWithin(hor, ver)) {
      return spots[hor][ver].isFree();
    } else {
      return false;
    }
  }
  
  public ISpot spot(int hor, int ver) {
    return spots[hor][ver];
  }
  
  public boolean isPlayerShipAt(int hor, int ver, IPlayer player) {
    if (isWithin(hor, ver)) {
      return spots[hor][ver].isPlayerShip(player);
    } else {
      return false;
    }
  }
  
  public boolean isWithin(int hor, int ver) {
    try {
      return spots[hor][ver].isWater();
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  //isWithin indica si el barco se ubica dentro del tablero
  /**public boolean isWithin(Ship ship) {
    if (ship.isHorizontal() && this.width < ship.getX() + ship.getLength()) {
      return false;
    }
    if (ship.isVertical() && this.height < ship.getY() + ship.getLength()) {
      return false;
    }
    return true;
  }
  
  //isPlaceableTight retorna si se puede ubicar en el tablero con la opcion tight
  public boolean isPlaceableTight(Ship ship, Fleet fleet) {
    if (!(this.isWithin(ship))) {
      return false;
    }
    if (ship.isHorizontal()) {
      for (int i = 0; i < ship.getLength(); i++) {
        if (fleet.isShipAt(ship.getX() + i, ship.getY())) {
          return false;
        }
      }
    }
    if (ship.isVertical()) {
      for (int i = 0; i < ship.getLength(); i++) {
        if (fleet.isShipAt(ship.getX(), ship.getY() + i)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean isFreeWaterAt(int hor, int ver){
    return (spots[hor][ver].isWater() && !(spots[hor][ver].hasShip()));
  }*/
}