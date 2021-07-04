package cs5004.tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Public class for a new TicTacToe Model Object.  
 * @author Katie Lowen
 *
 */
public class TicTacToeModel implements TicTacToe {
  private Player[][] board;
  private boolean playerX;
  private Player winner;
  private int numTurns;
  
  
  /**
   * Creates a new TicTacToeModel Object. 
   */
  public TicTacToeModel() {
    this.board = new Player[3][3];
    this.playerX = true;    
    this.winner = null;
    this.numTurns = 0;
    
    
  }
  



  @Override
  public void move(int r, int c) {
    if (this.isGameOver()) {
      throw new IllegalStateException("The game is over!");
    }
    
    if (r < 0 | c < 0 | r > 2 | c > 2) {
      throw new IllegalArgumentException("Invalid input. Try again");
    }
    
    if (this.getMarkAt(r, c) != null) {
      throw new IllegalArgumentException("Space is occupied");
    }
    
    this.board[r][c] = this.getTurn();
    
    if (isColumnWinner() || isRowWinner() || isDiagonalWinner()) {
      this.winner = this.getTurn();
    }
    this.numTurns += 1;
    this.playerX = !this.playerX;
    
    
  }
  
  /**
   * Check if one of the row has three in a row. 
   * @return true if there are three of the same player in one row. 
   */
  private boolean isRowWinner() {
    for (int i = 0; i < 3; i++) {
      if (this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2]) {
        if (this.board[i][0] != null) {
          return true;
        }
        
        
      }
      
    }
    return false;
  }
 
    
  
  
  /**
   * Check if one of the columns is three in a row.
   * @return true if there are three of the same player in one column. 
   */
  private boolean isColumnWinner() {
    for (int i = 0; i < 3; i++) {
      if (this.board[0][i] == this.board[1][i] && this.board[1][i] == this.board[2][i]) {
        if (this.board[0][i] != null) {
          return true;
        }
      
      }  
   
    }
    return false;
  }
  
  /**
   * Check if one of the diagonals have three in a row.
   * @return true if there are three of the same player in one diagonal. 
   */
  private boolean isDiagonalWinner() {
    for (int i = 0; i < 3; i++) {
      if ((this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2])   
          || (this.board[2][0] == this.board[1][1]  
          && this.board[1][1] == this.board[0][2])) {
           
        if (this.board[1][1] != null) {
          return true;
      
        }
      }
    
    }
    return false;
    
  }
 
  
  

  @Override
  public Player getTurn() {
    if (this.isGameOver()) {
      return null;
    }
    if (this.playerX) {
      return Player.X;
    }
    else {
      return Player.O;
    }
  }

  @Override
  public boolean isGameOver() {
    return (this.getWinner() != null  
        || (Arrays.stream(board).flatMap(Arrays::stream).filter(x -> x != null).count() == 9));
    // 
  }
  

  

  /**
   * Checks if this player is the winner.
   * @return True if this player is the winner, false otherwise. 
   */
  @Override
  public Player getWinner() {

    return this.winner;
  }

  @Override
  public Player[][] getBoard() {
    
    return Arrays.stream(board).map(Player[]::clone).toArray(b -> board.clone());
  }

  @Override
  public Player getMarkAt(int r, int c) throws IllegalArgumentException {
    if (r > 2 || c > 2 || r < 0 || c < 0) {
      throw new IllegalArgumentException("Invalid Placement");
    }
    
    if (this.board[r][c] == Player.O) {
      return Player.O;
    }
    
    return board[r][c];
  }
  
  
  
  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using 
    // the helpful built-in String.join method.
    //
//    List<String> rows = new ArrayList<>();
//    for(Player[] row : getBoard()) {
//      List<String> rowStrings = new ArrayList<>();
//      for(Player p : row) {
//        if(p == null) {
//          rowStrings.add(" ");
//        } else {
//          rowStrings.add(p.toString());
//        }
//      }
//      rows.add(" " + String.join(" | ", rowStrings));
//    }
//    return String.join("\n-----------\n", rows);
//    ************/
  }
}
