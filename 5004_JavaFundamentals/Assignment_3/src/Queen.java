/**
 * This class represents a new public object Queen.
 * @author Katie Lowen
 */
public class Queen extends AbstractChessPiece {

  /**
   * This method creates a Queen object.
   * @param row is the row the Queen object is located as an integer. 
   * @param column is the column the Queen object is located as an integer. 
   * @param color is the color of the Queen object as an enum. 
   */
  public Queen(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    
    if (row > 7 || row < 0 || col > 7 || col < 0) {
      throw new IllegalArgumentException("This placement is not on the board");
    }
    int i; //row
    int j; // column
    
    for (i = this.row + 1, j = this.column + 1; i < 8 && j < 8; i ++, j ++) {
      if (row == i && col == j) {
        return true;
      }
    }
    // diagonal up and left
    for (i = this.row + 1, j = this.column - 1; i < 8 && j >= 0; i ++, j --) {
      if (row == i && col == j) {
        return true;
      }
    }
    
    //diagonal down and right
    for (i = this.row - 1, j = this.column + 1; i >= 0 && j < 8; i --, j ++) {
      if (row == i && col == j) {
        return true;
      } 
    }
    
    //diagonal down and left
    for (i = this.row - 1, j = this.column - 1; i >= 0 && j < 8; i --, j --) {
      if (row == i && col == j) {
        return true;
      } 
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
   * This method creates a string representation of the Object.
   * @return string representation of the Object. Displays the type, row, column and color.
   */
  public String toString() {

   
    if (this.color == Color.BLACK) {
      String str = String.format("Queen row: %d column: %d BLACK", this.getRow(), this.getColumn());
      return  str;
    }
    else {
      String str = String.format("Queen row: %d column: %d WHITE", this.getRow(), this.getColumn());
      return str;
    }
  }
}
