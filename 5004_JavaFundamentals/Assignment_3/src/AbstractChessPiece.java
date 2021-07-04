/**
 * This class represents a new public object AbstractChessPiece.
 * @author Katie Lowen
 */
public class AbstractChessPiece implements ChessPiece {
  
  protected int row;
  protected int column;
  protected Color color;

 
  /**
   * This method constructs an Abstract ChessPiece object. A piece requires a row, column,
   * and color. 
   * @param row is the row of the ChessPiece. 
   * @param column is the column of the ChessPiece.
   * @param color is the color of the ChessPiece.
   * @throws IllegalArgumentException is thrown when the player is being constructed out
   *     of the boards boundary. 
   */
  public AbstractChessPiece(int row, int column, Color color) throws IllegalArgumentException {
    this.row = row;
    this.column = column;
    this.color = color;
  
    if (this.row < 0 || this.row > 7 || this.column < 0 || this.column > 7) {
      throw new IllegalArgumentException("This placement is out of the board boundary");
    }
  
  }

  @Override
  public int getRow() {
    
    return this.row;
  }

  @Override
  public int getColumn() {
    
    return this.column;
  }

  @Override
  public Color getColor() {
    
    return this.color;
  }

  
  @Override
  public boolean canMove(int row, int col) {
    
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    int pieceRow;
    int pieceColumn;
    Color pieceColor;
    pieceRow = piece.getRow();
    pieceColumn = piece.getColumn();
    pieceColor = piece.getColor();
    
    return (this.canMove(pieceRow, pieceColumn) && this.color != pieceColor);
     
  }
}
