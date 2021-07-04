package cs5004.tictactoe;

/**
 * Creates a new Enum for a Player in TicTacToe Model. 
 * @author Katie Lowen
 *
 */
public enum Player {
  X, O;
  
  /**
   * Creates a toString representation of the player name. 
   */
  public String toString() {
    return this.name();
  }

}
