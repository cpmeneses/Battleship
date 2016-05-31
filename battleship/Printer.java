package battleship;

/**
 *Printer imprime el tablero. tal vez haya que cambiarlo por una interfaz.
 */
class Printer {
  
  IGameDisplay gameDisplay;
  ISymbolDisplay symbolDisplay;
  IBoard board;
  
  //printBoard imprime el tablero
  public Printer() {
    this.gameDisplay = new DesktopDisplay();
    this.symbolDisplay = new TildeDisplay();
    this.board = new Board();
  }
  
  public Printer(IBoard board) {
    this.gameDisplay = new DesktopDisplay();
    this.symbolDisplay = new TildeDisplay();
    this.board = board;
  }
  
  public String displayAlly(IBoard board, IPlayer player) {
    StringBuilder res = new StringBuilder();
    res.append(gameDisplay.display(board, this.symbolDisplay, player));
    return res.toString();
  } 
  
  public String displayEnemy(IBoard board) {
    return "";
  }
  
  public void setDesktopDisplay() {
    gameDisplay = new DesktopDisplay();
  }
  
  public void setReverseDesktopDisplay() {
    gameDisplay = new ReverseDesktopDisplay();
  }
  
  public void setCompactDisplay() {
    gameDisplay = new CompactDisplay();
  }
  
  public void setTildeDisplay() {
    symbolDisplay = new TildeDisplay();
  }
  
  public void setSpaceDisplay() {
    symbolDisplay = new SpaceDisplay();
  }
  
  
}
  
  
  
  /**public String drawBoard(Fleet fleet, Board board) {
    String res = "";
    if (board.isTilde()) {
      agua = "~";
      barco = "o";
    } else {
      agua = " ";
      barco = "*";
    }
    
    boolean[][] grid = getGrid(fleet,board);
    for (int i = 1; i <= board.getHeight(); i++) {
      for (int j = 1; j <= board.getWidth(); j++) {
        if (grid[i][j]) {
          res = res + barco;
        } else {
          res = res + agua;
        }
      }
      if (i != board.getHeight()) {
        res = res + "\n";
      }
    }
    return res;
  }
  
  //getGrid retorna el tablero que se va a imprimir
  public boolean[][] getGrid(Fleet fleet, Board board) {
    boolean[][] grid = new boolean[board.getHeight()][board.getWidth()];
    for (int i = 0; i < board.getHeight(); i++) {
      for (int j = 0; j < board.getWidth(); j++) {
        grid[i][j] = false;
      }
    }
    Fleet fleetdep = fleet.getDeployed();
    for (int i = 0; i < fleetdep.getSize(); i++) {
      grid = markShip(grid,fleetdep.getShip(i));
    }
    return grid;
  }
  
  //markShip pone las marcas de un barco en una cuadrilla
  public boolean[][] markShip(boolean[][] grid, Ship ship) {
    int posx = ship.getX();
    int posy = ship.getY();
    if (ship.getDirection().equals("horizontal")) {
      for (int i = 0; i < ship.getLength(); i++) {
        grid[posy][posx + i] = true;
      }
    } else {
      for (int i = 0; i < ship.getLength(); i++) {
        grid[posy + i][posx] = true;
      }
    }
    return grid;
  }
}*/