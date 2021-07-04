/**
 * This class represents a new public object Knight.
 * @author Katie Lowen
 *
 */
public class Knight extends AbstractChessPiece {
  
  /**
   * This method creates a Knight object.
   * @param row is the row the Knight object is located as an integer. 
   * @param column is the column the Knight object is located as an integer. 
   * @param color is the color of the Knight object as an enum. 
   */
  public Knight(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
public boolean canMove(int row, int col) throws IllegalArgumentException {
    
    if (row > 7 || row < 0 || col > 7 || col < 0) {
      throw new IllegalArgumentException("This placement is not on the board");
      
    }
    //moving up 2 and either left or right 1
    if (this.row + 2 == row && (this.column + 1 == col || this.column - 1 == col)) {
      return true;
    }
    //moving down two and either left or right 1
    else if ((this.row - 2 == row && (this.column + 1 == col || this.column - 1 == col))) {
      return true;
    }
    
    //moving right two and either up or down 1
    else if ((this.column + 2 == col && (this.row + 1 == row || this.row - 1 == row))) {
      return true;
    }
    //moving left 2 and either up or down 1
    else if ((this.column - 2 == col && (this.row + 1 == row || this.row - 1 == row))) {
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
      String str = String.format("Knight row: %d column: %d BLACK", 
          this.getRow(), this.getColumn());
      return  str;
    }
    else {
      String str = String.format("Knight row: %d column: %d WHITE", 
          this.getRow(), this.getColumn());
      return str;
    }
  }

}

