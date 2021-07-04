/**
 * This class represents a new public object Pawn.
 * @author Katie Lowen
 */
public class Pawn extends AbstractChessPiece {

  /**
   * This method creates a Pawn object.
   * @param row is the row the Pawn object is located as an integer. 
   * @param column is the column the Pawn object is located as an integer. 
   * @param color is the color of the Pawn object as an enum. 
   */
  public Pawn(int row, int column, Color color) {
    super(row, column, color);
   
  }

  @Override
public boolean canMove(int row, int col) throws IllegalArgumentException {
    
    if (row > 7 || row < 0 || col > 7 || col < 0) {
      throw new IllegalArgumentException("This placement is not on the board");
    } 
    
    if (this.row >= 0 && this.row <= 7 && this.color == Color.WHITE) {
      int maxWhiteMove;
      maxWhiteMove = this.row + 1;
      
      if (row == maxWhiteMove && col == this.column) {
        return true;
      }
      
    }
    else if (this.row >= 0 && this.row <= 7 && this.color == Color.BLACK) {
      int maxBlackMove;
      maxBlackMove = this.row - 1;
      
      if (row == maxBlackMove && col == this.column) {
        return true;
      }
    }
    return false;
  }
  
  
  @Override
  public boolean canKill(ChessPiece piece) {
    

    if (this.color == Color.WHITE && piece.getColor() == Color.BLACK) {
      //white pawns 
      
      //up 1 and right 1
      if (this.row + 1 == piece.getRow() && this.column + 1 == piece.getColumn()) {
        return true;
      }
      //up 1 and left 1
      else if (this.row + 1 == piece.getRow() && this.column - 1 == piece.getColumn()) {
        return true;
      }
    }
    
    else if (this.color == Color.BLACK && piece.getColor() == Color.WHITE) {
      //black pawns
      
      //down 1 and right one
      if (this.row - 1 == piece.getRow() && this.column + 1 == piece.getColumn()) {
        return true;
      }
      //down and left one
      else if (this.row - 1 == piece.getRow() && this.column - 1 == piece.getColumn()) {
        return true;
      }
      
    }
    return false;
  }
   
  /**
   * This method creates a string representation of the Object.
   * @return string representation of the Object. Displays the type, row, column and color.
   */
  public String toString() {

   
    if (this.color == Color.BLACK) {
      String str = String.format("Pawn row: %d column: %d BLACK", this.getRow(), this.getColumn());
      return  str;
    }
    else {
      String str = String.format("Pawn row: %d column: %d WHITE", this.getRow(), this.getColumn());
      return str;
    }
  }
}


