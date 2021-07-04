package cs5004.tictactoe;

/**
 * Public Enum for the Player description. 
 * @author Katie Lowen
 *
 */
public enum Player {
  X, O;
  
  /**
   * Returns the toString for the player. 
   */
  public String toString() {
    return this.name();
  }

}
