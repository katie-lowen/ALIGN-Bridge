/**
 * This interface represents a ChessPiece.
 * @author Katie Lowen
 *
 */
public interface ChessPiece {
  
  /**
   * This method gets the current row of the ChessPiece.
   * @return current row of the ChessPiece.
   */
  int getRow();
    
  /**
   * This method gets the current column of the ChessPiece.
   * @return current column of the ChessPiece.
   */
  int getColumn();
  
  /**
   * This method gets the color of the ChessPiece.
   * @return color of the ChessPiece.
   */
  Color getColor();
  
  /**
   * This method determines if a chess piece can move to a location.
   * @param row is the row the piece wants to move to.
   * @param col is the column the piece wants to move to.
   * @return returns True of False depending on whether the piece can move there.
   * @throws an IllegalArgumentException if the placement is not on the board. 
   */
  boolean canMove(int row, int col);
  
  /**
   * This method determines if a chess piece can kill another chess piece. 
   * @param piece is the the chess piece that is potentially being "killed."
   * @return returns True or False if the piece can be killed.
   */
  boolean canKill(ChessPiece piece);

  

}
