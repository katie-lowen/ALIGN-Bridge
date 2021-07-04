/**
 * This class represents a new public object Rook.
 * @author Katie Lowen
 *
 */
public class Rook extends AbstractChessPiece {

  /**
   * This method creates a Rook object.
   * @param row is the row the Rook object is located as an integer. 
   * @param column is the column the Rook object is located as an integer. 
   * @param color is the color of the Rook object as an enum. 
   */
  public Rook(int row, int column, Color color) {
    super(row, column, color);
    
  }


  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    
    if (row > 7 || row < 0 || col > 7 || col < 0) {
      throw new IllegalArgumentException("This placement is not on the board");
    }
    //moving vertically
    if (this.column == col && row >= 0 && row <= 7) {
      return true;
    }
    //moving horizontally
    else if (this.row == row && col >= 0 && col <= 7) {
      return true;
    }
    
    return false;
  } 
  
  /**
   * This method creates a string representation of a Rook Object.
   * @return string representation of the Rook Object. Displays the type, row, column and color.
   */
  public String toString() {

   
    if (this.color == Color.BLACK) {
      String str = String.format("Rook row: %d column: %d BLACK", this.getRow(), this.getColumn());
      return  str;
    }
    else {
      String str = String.format("Rook row: %d column: %d WHITE", this.getRow(), this.getColumn());
      return str;
    }
  }
}




