import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;



/**
 * This is the junit testing for the Queen Object.
 * @author Katie Lowen
 *
 */
public class QueenTest {
  
  /**
   * This method tests the getRow method in the Abstract Chess Piece class. 
   */
  @Test
  public void testGetRow() {
    Random r = new Random();
    double randomRowDouble;
    double randomColumnDouble;
  
    for (int i = 0; i < 10; i++) {
      randomRowDouble = (r.nextDouble() * 3);
      randomColumnDouble = (r.nextDouble() * 3);
      int randomRow;
      int randomColumn;
      randomRow = (int)randomRowDouble;
      randomColumn = (int)randomColumnDouble;
    

      ChessPiece randomQueenBlack = new Queen(randomRow, randomColumn, Color.BLACK);
      
      assertEquals(randomRow, randomQueenBlack.getRow());
    }
    
    
  }
  
  /**
   * This method tests the getColumn method in the Abstract Chess Piece class. 
   */
  @Test
  public void testGetColumn() {
    Random r = new Random();
    double randomRowDouble;
    double randomColumnDouble;
  
    for (int i = 0; i < 10; i++) {
      randomRowDouble = (r.nextDouble() * 3);
      randomColumnDouble = (r.nextDouble() * 3);
      int randomRow;
      int randomColumn;
      randomRow = (int)randomRowDouble;
      randomColumn = (int)randomColumnDouble;
    

      ChessPiece randomQueenBlack = new Queen(randomRow, randomColumn, Color.BLACK);
      
      assertEquals(randomColumn, randomQueenBlack.getColumn());
    }
  }
  
  
  /**
   * This method tests the constructor from the AbstractChessPiece class for a Queen. 
   */
  @Test
  public void toStringTest() {
    
    ChessPiece queenTest = new Queen(0, 2, Color.WHITE);  
    
    String expected = "Queen row: " + String.valueOf(queenTest.getRow()) + " column: " 
        + String.valueOf(queenTest.getColumn()) + " WHITE";
      
    assertEquals(expected, queenTest.toString());
    
    ChessPiece queenTest2 = new Queen(0, 2, Color.BLACK); 
    
    String expected2 = "Queen row: " + String.valueOf(queenTest2.getRow()) + " column: " 
        + String.valueOf(queenTest2.getColumn()) + " BLACK";
      
    assertEquals(expected2, queenTest2.toString());
    
      
  }
  
  /**
   * This is a randomized test of the constructor using the toString method. 
   */
  @Test
  public void randomToStringTest() {
    Random r = new Random();
    double randomRowDouble;
    double randomColumnDouble;
  
    for (int i = 0; i < 10; i++) {
      randomRowDouble = (r.nextDouble() * 3);
      randomColumnDouble = (r.nextDouble() * 3);
      int randomRow;
      int randomColumn;
      randomRow = (int)randomRowDouble;
      randomColumn = (int)randomColumnDouble;
    

      ChessPiece randomQueenBlack = new Queen(randomRow, randomColumn, Color.BLACK);
      
      String expected = "Queen row: " + String.valueOf(randomQueenBlack.getRow()) + " column: " 
          + String.valueOf(randomQueenBlack.getColumn()) + " BLACK";
      
      assertEquals(expected, randomQueenBlack.toString());
      
      ChessPiece randomQueenWhite = new Queen(randomRow, randomColumn, Color.WHITE);
      String expected2 = "Queen row: " + String.valueOf(randomQueenWhite.getRow()) + " column: " 
          + String.valueOf(randomQueenWhite.getColumn()) + " WHITE";
      
      assertEquals(expected2, randomQueenWhite.toString());
    
    
    }
  
  }
  
  
  /**
   * This method tests the canMove method. This test is testing the queen moving diagonally. 
   */
  @Test
  public void canMovequeenTest() {
    ChessPiece queenTest = new Queen(0, 2, Color.WHITE);
 
    //move diagonally upwards and right
    assertTrue(queenTest.canMove(2, 4));
    
    assertTrue(queenTest.canMove(3, 5));
    assertTrue(queenTest.canMove(4, 6));
    assertTrue(queenTest.canMove(5, 7));

    //move diagonally up and left
    ChessPiece queenTest2 = new Queen(3, 7, Color.BLACK);
    
    assertTrue(queenTest2.canMove(4, 6));
    assertTrue(queenTest2.canMove(5, 5));
    assertTrue(queenTest2.canMove(6, 4));
    assertTrue(queenTest2.canMove(7, 3));
    
    
    //move diagonally down and right
    ChessPiece queenTest3 = new Queen(7, 2, Color.BLACK);
    
    assertTrue(queenTest3.canMove(6, 3));
    assertTrue(queenTest3.canMove(5, 4));
    assertTrue(queenTest3.canMove(4, 5));
    assertTrue(queenTest3.canMove(3, 6));
    assertTrue(queenTest3.canMove(2, 7));
    

    
  }
  
  /**
   * This method tests the canMove method for a queen. This is testing a queen moving horizontally
   * or vertically. 
   */
  @Test
  public void testCanMovequeen() {
    ChessPiece queenTest = new Queen(1, 0, Color.WHITE);
    
    //test move horizontally
    assertTrue(queenTest.canMove(1, 7));
    
    //test move vertically
    assertTrue(queenTest.canMove(7, 0));
    
     
    //test can move "backwards"
    
    ChessPiece queenTest2 = new Queen(6, 7, Color.BLACK);
    
    //Move vertically
    
    assertTrue(queenTest2.canMove(0, 7));
    
    //move horizontally
    
    assertTrue(queenTest2.canMove(6, 0));
    
    
  }
  
  /**
   * This method tests the canMove method for a queen. This is testing a queen moving horizontally
   * or vertically. This test is testing illegal moves, and should be false. 
   */
  @Test
  public void testCanMoveFailQueen() {
    ChessPiece queenTest = new Queen(1, 0, Color.WHITE);
    
    //test move horizontally
    assertFalse(queenTest.canMove(3, 1));
    
    //test move vertically
    assertFalse(queenTest.canMove(2, 3));
    
     
    //test can move "backwards"
    
    ChessPiece queenTest2 = new Queen(6, 7, Color.BLACK);
    
    //Move vertically
    
    assertFalse(queenTest2.canMove(7, 5));
    
    //move horizontally
    
    assertFalse(queenTest2.canMove(4, 6));
    
  }
  
  /**
   * This method tests if an exception is thrown given a queen is illegally moved. 
   */
  @Test 
  public void canMovequeenTestIllegal() {
    ChessPiece queenTest3 = new Queen(7, 2, Color.BLACK);
    ChessPiece queenTest = new Queen(0, 2, Color.WHITE);
    
    try {
      queenTest3.canMove(1, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
    
    try {
      queenTest.canMove(6, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
   
    }
  }
  
  /**
   * This method tests an exception being thrown. This test is testing 
   * if an exception is thrown when the queen is moved to a position 
   * off of the board.  
   */
  @Test 
  public void canMoveQueenTestIllegal2() {
    ChessPiece queenTest2 = new Queen(6, 7, Color.BLACK);
    
    try {
      queenTest2.canMove(8, 5);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
    
    try {
      queenTest2.canMove(5, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
   
  
    try {
      queenTest2.canMove(8, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
   
  }
  
  /**
   * This method tests the canKill method. The following moves should be 
   * successful to kill.
   */
  @Test
  public void canKillQueen() {
    ChessPiece queenTest = new Queen(4, 0, Color.WHITE);
    ChessPiece rookKill = new Rook(7, 0, Color.BLACK);
    ChessPiece knightKill = new Knight(1, 0, Color.BLACK);
    ChessPiece rookKill2 = new Rook(7, 3, Color.BLACK);

    //test vertical up kill
    assertTrue(queenTest.canKill(rookKill));
    
    //test vertical down kill
    assertTrue(queenTest.canKill(knightKill));
    
    //test diagonal up right
    assertTrue(queenTest.canKill(rookKill2));
    
    ChessPiece rookKill3 = new Rook(2, 2, Color.BLACK);
    //test diagonal down right
    assertTrue(queenTest.canKill(rookKill3));
    
    ChessPiece queenTest2 = new Queen(5, 5, Color.WHITE);
    //test diagonal down left
    assertTrue(queenTest2.canKill(rookKill3));
    
    //test diagonal up left
    assertTrue(queenTest2.canKill(rookKill2));
    
  }
  
  /**
   * This method tests the canKill method. These tests should fail 
   * because all of the players are the same color (white). 
   */
  @Test
  public void canKillFailWhite() {
    ChessPiece queenTest = new Queen(4, 0, Color.WHITE);
    
    ChessPiece rookKill = new Rook(7, 0, Color.WHITE);
    ChessPiece knightKill = new Knight(1, 0, Color.WHITE);
    ChessPiece rookKill2 = new Rook(7, 3, Color.WHITE);
    
    
    //test same color for ALL FOLLOWING
    assertFalse(queenTest.canKill(rookKill));
    
    //test vertical down kill
    assertFalse(queenTest.canKill(knightKill));
    
    //test diagonal up right
    assertFalse(queenTest.canKill(rookKill2));
    
    ChessPiece rookKill3 = new Rook(2, 2, Color.WHITE);
    //test diagonal down right
    assertFalse(queenTest.canKill(rookKill3));
    
    ChessPiece queenTest2 = new Queen(5, 5, Color.WHITE);
    //test diagonal down left
    assertFalse(queenTest2.canKill(rookKill3));
    
    //test diagonal up left
    assertFalse(queenTest2.canKill(rookKill2));
  }
  
  /**
   * This method tests that the canKill method will not work if 
   * all the players are the same color (black). 
   */
  @Test
  public void canKillFailBlack() {
    ChessPiece queenTest = new Queen(4, 0, Color.BLACK);
    ChessPiece rookKill = new Rook(7, 0, Color.BLACK);
    ChessPiece knightKill = new Knight(1, 0, Color.BLACK);
    ChessPiece rookKill2 = new Rook(7, 3, Color.BLACK);
    
    
    //test same color for ALL FOLLOWING
    assertFalse(queenTest.canKill(rookKill));
    
    //test vertical down kill
    assertFalse(queenTest.canKill(knightKill));
    
    //test diagonal up right
    assertFalse(queenTest.canKill(rookKill2));
    
    //test diagonal down right
    ChessPiece rookKill3 = new Rook(2, 2, Color.BLACK);
    assertFalse(queenTest.canKill(rookKill3));
    
    ChessPiece queenTest2 = new Queen(5, 5, Color.BLACK);
    //test diagonal down left
    assertFalse(queenTest2.canKill(rookKill3));
    
    //test diagonal up left
    assertFalse(queenTest2.canKill(rookKill2));
  }
  
  /**
   * This method tests the canKill method. These attempts 
   * should fail as they are not legal moves for a queen to make. 
   */
  @Test
  public void canKillFailMove() {
    ChessPiece queenTest = new Queen(4, 0, Color.WHITE);
    ChessPiece rookKill = new Rook(6, 1, Color.BLACK);
    ChessPiece knightKill = new Knight(1, 1, Color.BLACK);
    ChessPiece rookKill2 = new Rook(7, 4, Color.BLACK);
    
    
    //All are invalid moves for a queen
    assertFalse(queenTest.canKill(rookKill));
    
    
    assertFalse(queenTest.canKill(knightKill));
    
    
    assertFalse(queenTest.canKill(rookKill2));
    
    ChessPiece rookKill3 = new Rook(2, 3, Color.BLACK);
    
    assertFalse(queenTest.canKill(rookKill3));
    
    ChessPiece queenTest2 = new Queen(5, 5, Color.WHITE);
    
    assertFalse(queenTest2.canKill(rookKill3));
    
    
    assertFalse(queenTest2.canKill(rookKill2));
  }
  
  
  

}


