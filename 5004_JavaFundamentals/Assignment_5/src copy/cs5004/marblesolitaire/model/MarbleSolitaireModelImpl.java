package cs5004.marblesolitaire.model;


/**
 * This class creates a new MarbleSolitaireModelImpl Object.
 * @author Katie Lowen
 *
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  
  private MarbleBoard board;
  
  /**
   * This method creates a new MarbleSolitaireModelImpl object, taking
   * no parameters and makes a standard sized board. 
   */
  public MarbleSolitaireModelImpl() {
    this.board = new MarbleBoard();
  }
  
  /**
   * This method creates a new MarbleSolitaireModelImpl with parameters.
   * This method creates a standard sized board with specification as to
   * where the empty slot will be.  
   * @param sRow the row where the empty slot will be located. 
   * @param sCol the col where the emply slot will be located. 
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) { 
    this.board = new MarbleBoard(sRow, sCol);
    
  }
  
  /**
   * This method creates a new MarbleSolitaireModelImpl with a specified arm size. 
   * @param arm is the size of the arm of the board. 
   */
  public MarbleSolitaireModelImpl(int arm) {
    this.board = new MarbleBoard(arm);
    
  }
  
  /**
   * This method creates a new MarbleSolitaireModelImpl with a specified arm size,
   * and location of the empty slot. 
   * @param arm size of the arm on the board.
   * @param sRow row location of the empty slot.
   * @param sCol col location of the empty slot. 
   */
  public MarbleSolitaireModelImpl(int arm, int sRow, int sCol) {
    this.board = new MarbleBoard(arm, sRow, sCol);
  }
  

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    //throws illegal argument exception if space is unavailable, too far, or off the board
    this.board.move(fromRow, fromCol, toRow, toCol);
    return;
      
  }
    
    
    

  

  @Override
  public boolean isGameOver() {
    
    return this.board.isGameOver();
  }

  @Override
  public String getGameState() {
    // ACTS AS A TOSTRING
    return this.board.toString();
  }

  @Override
  public int getScore() {
    
    return this.board.getScore();
  }
  

}
