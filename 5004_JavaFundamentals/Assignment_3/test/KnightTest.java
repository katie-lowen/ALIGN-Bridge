import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;

/**
 * This is the junit test file for the Knight object. ADD MORE TESTS
 * @author Katie Lowen
 *
 */
public class KnightTest {

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
    

      ChessPiece randomKnightBlack = new Knight(randomRow, randomColumn, Color.BLACK);
      
      assertEquals(randomRow, randomKnightBlack.getRow());
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
    

      ChessPiece randomKnightBlack = new Knight(randomRow, randomColumn, Color.BLACK);
      
      assertEquals(randomColumn, randomKnightBlack.getColumn());
    }
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
    

      ChessPiece randomKnightBlack = new Knight(randomRow, randomColumn, Color.BLACK);
      
      String expected = "Knight row: " + String.valueOf(randomKnightBlack.getRow()) + " column: " 
          + String.valueOf(randomKnightBlack.getColumn()) + " BLACK";
      
      assertEquals(expected, randomKnightBlack.toString());
      
      ChessPiece randomKnightWhite = new Knight(randomRow, randomColumn, Color.WHITE);
      String expected2 = "Knight row: " + String.valueOf(randomKnightWhite.getRow()) + " column: " 
          + String.valueOf(randomKnightWhite.getColumn()) + " WHITE";
      
      assertEquals(expected2, randomKnightWhite.toString());
    }
    
    
  }
  

  /**
   * This method tests the canMove method. 
   */
  @Test
  public void testCanMoveKnight() {
    ChessPiece knightTest = new Knight(2, 2, Color.WHITE);
    
    //two up one right
    assertTrue(knightTest.canMove(4, 3));
    
    //two up one left
    assertTrue(knightTest.canMove(4, 1));
    
    //two down one right
    assertTrue(knightTest.canMove(0, 3));
    
    //two down one left
    assertTrue(knightTest.canMove(0, 1));
    
    //two right one up
    assertTrue(knightTest.canMove(3, 4));
    
    //two right one down
    assertTrue(knightTest.canMove(1, 4));
    
    //two left one up
    assertTrue(knightTest.canMove(3, 0));
    
    //two left one down
    assertTrue(knightTest.canMove(1, 0));
    
    //wrong kind of move
    ChessPiece knightTest2 = new Knight(6, 6, Color.BLACK);
    assertFalse(knightTest2.canMove(4, 4));
    
  }
  
  /**
   * This method tests illegal moves for the Knight object using the canMove method. 
   * An IllegalArgumentException is thrown because the object cannot move to 
   * a position outside of the board. 
   */
  @Test 
  public void canMoveKnightTestIllegal() {
    ChessPiece knightTest = new Knight(1, 1, Color.WHITE);
    ChessPiece knightTest2 = new Knight(6, 6, Color.BLACK);
    
    try {
      knightTest2.canMove(8, 7);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
    
    try {
      knightTest2.canMove(7, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
   
  
    try {
      knightTest.canMove(2, -1);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
  }
  
  /**
   * This method tests for illegal horizontal move for a Knight Object. 
   */
  @Test
  public void canMoveRandomIllegalMoveTest() {
    Random r = new Random();
    
    double randomColumnDouble;
    
  
    for (int i = 0; i < 100; i++) {
      randomColumnDouble = (r.nextDouble() * 3);
      int randomColumn;
      int randomRow = 6;
      randomColumn = (int)randomColumnDouble;
    
      ChessPiece knightNew = new Knight(3, 3, Color.WHITE);
      
      assertFalse(knightNew.canMove(randomRow, randomColumn));
    }
    
    
  }
  
  /**
   * This method tests for illegal vertical move for a Knight Object. 
   */
  @Test
  public void canMoveRandomIllegalMoveTest2() {
    Random r = new Random();
    
    double randomRowDouble;
    
  
    for (int i = 0; i < 100; i++) {
      randomRowDouble = (r.nextDouble() * 3);
      int randomRow;
      int randomColumn = 6;
      randomRow = (int)randomRowDouble;
    
      ChessPiece knightNew = new Knight(3, 3, Color.WHITE);
      
      assertFalse(knightNew.canMove(randomRow, randomColumn));
    }
    
    
  }
  
  /**
   * This method tests the canKill method. The following are all of the 
   * possible moves to kill a piece. 
   */
  @Test
  public void canKillTestSuccess() {
    ChessPiece knightNew = new Knight(3, 3, Color.WHITE);
    ChessPiece knight1 = new Knight(1, 2, Color.BLACK);
    ChessPiece knight2 = new Knight(2, 1, Color.BLACK);
    ChessPiece knight3 = new Knight(4, 1, Color.BLACK);

    
    
    assertTrue(knightNew.canKill(knight1));
    assertTrue(knightNew.canKill(knight2));
    assertTrue(knightNew.canKill(knight3));
    
    ChessPiece knight4 = new Knight(5, 2, Color.BLACK);
    ChessPiece knight5 = new Knight(4, 5, Color.BLACK);
    ChessPiece knight6 = new Knight(2, 5, Color.BLACK);
    
    assertTrue(knightNew.canKill(knight4));
    assertTrue(knightNew.canKill(knight5));
    assertTrue(knightNew.canKill(knight6));
    
    ChessPiece knight7 = new Knight(1, 4, Color.BLACK);
    assertTrue(knightNew.canKill(knight7));
    
    
  }

  /**
   * This method tests the canKill method. The following are all of the 
   * possible moves to kill a piece. This should fail because the pieces are
   * the same color. 
   */
  @Test
  public void canKillTestFail() {
    ChessPiece knightNew = new Knight(3, 3, Color.WHITE);
    ChessPiece knight1 = new Knight(1, 2, Color.WHITE);
    ChessPiece knight2 = new Knight(2, 1, Color.WHITE);
    ChessPiece knight3 = new Knight(4, 1, Color.WHITE);

    
    
    assertFalse(knightNew.canKill(knight1));
    assertFalse(knightNew.canKill(knight2));
    assertFalse(knightNew.canKill(knight3));
    
    ChessPiece knight4 = new Knight(5, 2, Color.WHITE);
    ChessPiece knight5 = new Knight(4, 5, Color.WHITE);
    ChessPiece knight6 = new Knight(2, 5, Color.WHITE);
    
    assertFalse(knightNew.canKill(knight4));
    assertFalse(knightNew.canKill(knight5));
    assertFalse(knightNew.canKill(knight6));
    
    ChessPiece knight7 = new Knight(1, 4, Color.WHITE);
    assertFalse(knightNew.canKill(knight7));
    
    
  }
}
