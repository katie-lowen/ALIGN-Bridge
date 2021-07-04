package cs5004.marblesolitaire.model;



/**
 * This is the public class for a MarbleBoard Object.
 * @author Katie Lowen
 *
 */
public class MarbleBoard {
  //enum is for three states of a cell "N/A", "Empty", "Marble"
  
  public Position position;
  
  private String [][] board;
  
  /**
   * This method is the constructor for a new MarbleBoard object. 
   */
  public MarbleBoard() {
    board = new String [7][7];
    this.position = position;

    
   
    
    //[row] [column]
    //row 0
    board [0][0] = Position.NA.toString();
    board [0][1] = Position.NA.toString();
    board [0][2] = Position.MARBLE.toString();
    board [0][3] = Position.MARBLE.toString();
    board [0][4] = Position.MARBLE.toString();
    board [0][5] = Position.NA.toString();
    board [0][6] = Position.NA.toString();
    
    //row 1
    board [1][0] = Position.NA.toString();
    board [1][1] = Position.NA.toString();
    board [1][2] = Position.MARBLE.toString();
    board [1][3] = Position.MARBLE.toString();
    board [1][4] = Position.MARBLE.toString();
    board [1][5] = Position.NA.toString();
    board [1][6] = Position.NA.toString();
    
    //row 2
    
    board [2][0] = Position.MARBLE.toString();
    board [2][1] = Position.MARBLE.toString();
    board [2][2] = Position.MARBLE.toString();
    board [2][3] = Position.MARBLE.toString();
    board [2][4] = Position.MARBLE.toString();
    board [2][5] = Position.MARBLE.toString();
    board [2][6] = Position.MARBLE.toString();
    
    //row 3
    
    board [3][0] = Position.MARBLE.toString();
    board [3][1] = Position.MARBLE.toString();
    board [3][2] = Position.MARBLE.toString();
    board [3][3] = Position.EMPTY.toString();
    board [3][4] = Position.MARBLE.toString();
    board [3][5] = Position.MARBLE.toString();
    board [3][6] = Position.MARBLE.toString();
    
    //row 4
    board [4][0] = Position.MARBLE.toString();
    board [4][1] = Position.MARBLE.toString();
    board [4][2] = Position.MARBLE.toString();
    board [4][3] = Position.MARBLE.toString();
    board [4][4] = Position.MARBLE.toString();
    board [4][5] = Position.MARBLE.toString();
    board [4][6] = Position.MARBLE.toString();
    
    //row 5
    board [5][0] = Position.NA.toString();
    board [5][1] = Position.NA.toString();
    board [5][2] = Position.MARBLE.toString();
    board [5][3] = Position.MARBLE.toString();
    board [5][4] = Position.MARBLE.toString();
    board [5][5] = Position.NA.toString();
    board [5][6] = Position.NA.toString();
    
    //row 6
    
    
    board [6][0] = Position.NA.toString();
    board [6][1] = Position.NA.toString();
    board [6][2] = Position.MARBLE.toString();
    board [6][3] = Position.MARBLE.toString();
    board [6][4] = Position.MARBLE.toString();
    board [6][5] = Position.NA.toString();
    board [6][6] = Position.NA.toString();
      
  }
    
  /**
   * This is the constructor for a new MarbleBoard object. 
   * @param sRow row in the board used to indicate the opening empty cell. 
   * @param sCol column in the board used to indicate the opening empty cell. 
   * @throws IllegalArgumentException when the placement of the opening empty cell is
   *     outside of the playing board. 
   */
  public MarbleBoard(int sRow, int sCol) throws IllegalArgumentException {
    //cases as four corners TL, TR, LL, LR
    if ((sRow < 2 && sCol < 2) 
        || (sRow < 2 && sCol > 4) 
        || (sRow > 4 && sCol < 2) 
        || (sRow > 4 && sCol > 4)
        || (sRow > 6) || (sRow < 0)
        || (sCol > 6) || (sCol < 0)) {
      throw new IllegalArgumentException(String.format(
          "Invalid empty cell position (%d,%d)", sRow, sCol));
    }
    
    board = new String [7][7];
    this.position = position;
    
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        //account for custom blank space

        
        //accounts for the marbles in first two rows
        if (i < 2) {
          if (j <= 1 || j >= 5) {
            board [i][j] = Position.NA.toString();
          }
        
          else if (j > 1 || j < 5) {
            board [i][j] = Position.MARBLE.toString();
          }
        }
        
        //middle section of board
        else if (i >= 2 && i < 5) {
          board[i][j] = Position.MARBLE.toString();
        }
        
        //last section 
        else if (i >= 5) {
          if (j <= 1 || j >= 5) {
            board [i][j] = Position.NA.toString();
          }
        
          else if (j > 1 || j < 5) {
            board [i][j] = Position.MARBLE.toString();
          }
        }
          
      }
      
    }
    
    if (board[sRow][sCol] == Position.NA.toString()) {
      throw new IllegalArgumentException(String.format(
          "Invalid empty cell position (%d,%d)", sRow, sCol));
    }
    
    board[sRow][sCol] = Position.EMPTY.toString();
  }
    
  /**
   * This method creates a new MarbleBoard object based on the arm size. 
   * @param arm is the size of the arm the MarbleBoard is based on.
   */
  public MarbleBoard(int arm) throws IllegalArgumentException {
    if (arm < 0 || (arm % 2 == 0)) {
      throw new IllegalArgumentException("Must have a postive and odd arm number");
    }
    int row = (arm * 3) - 2;
    int col = (arm * 3) - 2;
  
    
    board = new String [row][col];
    this.position = position;
    
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        //account for custom blank space

        
        //accounts for the marbles in first three rows
        if (i <= (arm - 2)) {
          if (j <= (arm - 2) || j > (2 * arm - 2)) {
            board [i][j] = Position.NA.toString();
          }
        
          else if (j > (arm - 2) || j <= (2 * arm - 2)) {
            board [i][j] = Position.MARBLE.toString();
          }
        }
        
        //middle section of board
        else if (i >= (arm - 2) && i <= (2 * arm - 2)) {
          board[i][j] = Position.MARBLE.toString();
        }
        
        //last section 
        else if (i > (2 * arm - 2)) {
          if (j <= (arm - 2) || j > (2 * arm - 2)) {
            board [i][j] = Position.NA.toString();
          }
        
          else if (j > arm - 2 || j <= (2 * arm - 2)) {
            board [i][j] = Position.MARBLE.toString();
          }
        }
          
      }
      
    }
    
    int center = row / 2;
    
    board[center][center] = Position.EMPTY.toString();
      
    
  }
  
  /**
   * This method creates a new MarbleBoard Object. 
   * @param arm size of the new MarbleBoard Object.
   * @param sRow of the empty slot in the MarbleBoard Object.
   * @param sCol of the empty slot in the MarbleBoard Object.
   * @throws IllegalArgumentException if the empty slot is outside of the playing area. 
   */
  public MarbleBoard(int arm, int sRow, int sCol) throws IllegalArgumentException {
    
    if ((sRow <= (arm - 2) && sCol <= (arm - 2)) 
        || (sRow <= (arm - 2) && sCol > (2 * arm - 2) ) 
        || (sRow > (2 * arm - 2) && sCol <= (arm - 2)) 
        || (sRow > (2 * arm - 2) && sCol > (2 * arm - 2))
        || (sRow > (3 * arm - 2)) || (sRow < 0)
        || (sCol > (3 * arm - 2)) || (sCol < 0)) {
      throw new IllegalArgumentException(String.format(
          "Invalid empty cell position (%d,%d)", sRow, sCol));
    }
    
    if ((arm < 0 || (arm % 2 == 0))) {
      throw new IllegalArgumentException("Must have a postive and odd arm number");
    
    }
    
    int row = (arm * 3) - 2;
    int col = (arm * 3) - 2;
 
    board = new String [row][col];
    this.position = position;
    
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        //account for custom blank space

        
        //accounts for the marbles in first three rows
        if (i <= (arm - 2)) {
          if (j <= (arm - 2) || j > (2 * arm - 2)) {
            board [i][j] = Position.NA.toString();
          }
        
          else if (j > (arm - 2) || j <= (2 * arm - 2)) {
            board [i][j] = Position.MARBLE.toString();
          }
        }
        
        //middle section of board
        else if (i >= (arm - 2) && i <= (2 * arm - 2)) {
          board[i][j] = Position.MARBLE.toString();
        }
        
        //last section 
        else if (i > (2 * arm - 2)) {
          if (j <= (arm - 2) || j > (2 * arm - 2)) {
            board [i][j] = Position.NA.toString();
          }
        
          else if (j > arm - 2 || j <= (2 * arm - 2)) {
            board [i][j] = Position.MARBLE.toString();
          }
        }         
      }     
    }
  
    
    board[sRow][sCol] = Position.EMPTY.toString();
    
  }
  

  
  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow the row number of the position to be moved to
   *              (starts at 0)
   * @param toCol the column number of the position to be moved to
   *              (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  public String[][] move(int fromRow, int fromCol, int toRow, int toCol) 
      throws IllegalArgumentException {
    //throws illegal argument exception if space is unavailable, too far, or off the board
    
    if (toRow > (this.board.length - 1) || toCol > (this.board.length - 1)
        || fromRow > (this.board.length - 1) || fromCol > (this.board.length - 1)
        || toRow < 0 || fromRow < 0 || toCol < 0 || fromCol < 0
        || this.board[toRow][toCol] != Position.EMPTY.toString()
        || this.board[toRow][toCol] == Position.NA.toString()
        || this.board[fromRow][fromCol] == Position.NA.toString()
        || this.board[fromRow][fromCol] != Position.MARBLE.toString()
        //move up or down
        || fromCol != toCol &&  Math.abs(toRow - fromRow) == 2
        //move left or right
        || toRow != fromRow && Math.abs(toCol - fromCol) == 2
        //moving the wrong amounts
        || toRow == fromRow && Math.abs(toCol - fromCol) != 2
        || toCol == fromCol && Math.abs(toRow - fromRow) != 2) {
    
      
      
      throw new IllegalArgumentException("Invalid move");
    }

      
    //scenarios
    
    //moving to space above
    if (fromRow > toRow && fromCol == toCol) {
      if (this.board[fromRow - 1][fromCol] == Position.MARBLE.toString() 
          && this.board[fromRow - 2][fromCol] == Position.EMPTY.toString() 
              && this.board[fromRow - 2][fromCol] == this.board[toRow][toCol]) {
        
        this.board[fromRow][fromCol] = Position.EMPTY.toString();
        this.board[fromRow - 1][fromCol] = Position.EMPTY.toString();
        this.board[toRow][fromCol] = Position.MARBLE.toString();
        return this.board;
      }
    }
      
    else if (fromRow < toRow && fromCol == toCol) {
      //moving to space below
      if (this.board[fromRow + 1][fromCol] == Position.MARBLE.toString() 
          && this.board[fromRow + 2][fromCol] == Position.EMPTY.toString() 
          && this.board[fromRow + 2][fromCol] == this.board[toRow][toCol]) {
        
        this.board[fromRow][fromCol] = Position.EMPTY.toString();
        this.board[fromRow + 1][fromCol] = Position.EMPTY.toString();
        this.board[toRow][toCol] = Position.MARBLE.toString();
        return this.board;
     
      }
    }
      
    else if (fromCol < toCol && fromRow == toRow) {
      //moving to space to the right
      if (this.board[fromRow][fromCol + 1] == Position.MARBLE.toString() 
          && this.board[fromRow][fromCol + 2] == Position.EMPTY.toString() 
          && this.board[fromRow][fromCol + 2] == this.board[toRow][toCol]) {
        
        this.board[fromRow][fromCol] = Position.EMPTY.toString();
        this.board[fromRow][fromCol + 1] = Position.EMPTY.toString();
        this.board[toRow][toCol] = Position.MARBLE.toString();
        return this.board;
      }

    }
      
    else if (fromCol > toCol && fromRow == toRow) {
      //moving to space to the left
      if (this.board[fromRow][fromCol - 1] == Position.MARBLE.toString() 
          && this.board[fromRow][fromCol - 2] == Position.EMPTY.toString() 
          && this.board[fromRow][fromCol - 2] == this.board[toRow][toCol]) {
      
        
        this.board[fromRow][fromCol] = Position.EMPTY.toString();
        this.board[fromRow][fromCol - 1] = Position.EMPTY.toString();
        this.board[toRow][toCol] = Position.MARBLE.toString();
        return this.board;
      }
    }
      

    return this.board;
          
      
    
  }
  
  /**
   * This method counts the current score of the board by counting the Marbles. 
   * @return the total count of MARBLE of the board.
   */
  public int getScore() {
    int count = 0;
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        if (this.board[i][j] == Position.MARBLE.toString()) {
          count++;
        }
      }
    }
    return count;
  }  
  
  /**
   * This method determines if the game is over by returning a boolean. 
   * @return boolean if game is over, returns true. 
   */
  public boolean isGameOver() {
    
    int count = 0;
    
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        if (board[i][j] == Position.MARBLE.toString()) {
          //check four possibilities for a move
          
          if (this.getScore() == 1) {
            return true;
          }
          else if ((j < board.length - 2) 
                //move right (row stays constant)
                && (board[i][j + 1] == Position.MARBLE.toString())
                && (board[i][j + 2] == Position.EMPTY.toString())) {
            count ++;
          }
      
            
          
          else if ((j > board.length - (board.length - 2)) 
                //move left (row stays constant)
                && (board[i][j - 1] == Position.MARBLE.toString()) 
                && (board[i][j - 2] == Position.EMPTY.toString())) {
            count ++;
          } 
          
          else if ((i > board.length - (board.length - 2)) 
                //move up (col stays constant)
                && (board[i - 1][j] == Position.MARBLE.toString())
                && (board[i - 2][j] == Position.EMPTY.toString())) {
            count ++;
          }
          
          else if ((i < board.length - 2)
                //move down (col stays constant)
                && (board[i + 1][j] == Position.MARBLE.toString())
                && (board[i + 2][j] == Position.EMPTY.toString())) {
            count ++;
              
          }
          
        }
      }
    }
    boolean result = true;
    if (count != 0) {
      result = false;
    }
    return result;
    
   
    
  }
    
  
  
  
  /**
   * This method creates a string representation of the MarbleBoard Object. 
   */
  public String toString() {

    String str = ""; 
    for (int i = 0; i < board.length; i++) { 
      
      //first two rows
      if (i < ((board.length - 1) / 3)) {
        for (int j = 0; j <= (((board.length - 1) / 3) * 2); j++) {
          if (j < (((board.length - 1) / 3) * 2)) {
            str += board[i][j] + " ";
          }
          else if (j == (((board.length - 1) / 3) * 2)) {
            str += board[i][j];
          }
       
        }
        str += "\n";
      }
      
      //middle section
      if (i >= ((board.length - 1) / 3) && i <= ((board.length - 1) - ((board.length - 1) / 3)) ) {
        for (int j = 0; j < board.length; j++) {
          if (j < board.length - 1) {
            str += board[i][j] + " ";
          }
          else if (j == board.length - 1) {
            str += board[i][j];
          }
       
        }
        str += "\n";
      }
      
      if (i > ((board.length - 1) - ((board.length - 1) / 3)) && i < (board.length - 1)) {
        for (int j = 0; j <= ((board.length / 3) * 2); j++) {
          if (j < (((board.length - 1) / 3) * 2)) {
            str += board[i][j] + " ";
          }
          else if (j == (((board.length - 1) / 3) * 2)) {
            str += board[i][j];
          }
       
        }
        str += "\n";
      }
      if (i == board.length - 1) {
        for (int j = 0; j < board.length - (board.length / 3); j++) {
          if (j < (((board.length - 1) / 3) * 2)) {
            str += board[i][j] + " ";
          }
          else if (j == (((board.length - 1) / 3) * 2)) {
            str += board[i][j];
          }
       
        }
       
      }
    }
      
      
    
    return str;
  }
    
    
     
  


}
