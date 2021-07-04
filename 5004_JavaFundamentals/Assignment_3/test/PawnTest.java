import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;

/**
 * This is the junit test file for the Pawn object. ADD MORE TESTS. 
 * @author Katie Lowen
 *
 */
public class PawnTest {
  
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
    

      ChessPiece randomPawnBlack = new Pawn(randomRow, randomColumn, Color.BLACK);
      
      assertEquals(randomRow, randomPawnBlack.getRow());
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
    

      ChessPiece randomPawnBlack = new Pawn(randomRow, randomColumn, Color.BLACK);
      
      assertEquals(randomColumn, randomPawnBlack.getColumn());
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
    

      ChessPiece randomPawnBlack = new Pawn(randomRow, randomColumn, Color.BLACK);
      
      String expected = "Pawn row: " + String.valueOf(randomPawnBlack.getRow()) + " column: " 
          + String.valueOf(randomPawnBlack.getColumn()) + " BLACK";
      
      assertEquals(expected, randomPawnBlack.toString());
      
      ChessPiece randomPawnWhite = new Pawn(randomRow, randomColumn, Color.WHITE);
      String expected2 = "Pawn row: " + String.valueOf(randomPawnWhite.getRow()) + " column: " 
          + String.valueOf(randomPawnWhite.getColumn()) + " WHITE";
      
      assertEquals(expected2, randomPawnWhite.toString());
    }
    
    
  }
  

  /**
   * This tests the canMove method by giving valid moving inputs.
   * This tests for a white opening pawn's ability to move 
   * one OR two spots. 
   */
  @Test
  public void testCanMoveWhite() {
    ChessPiece pawnTest = new Pawn(1, 1, Color.WHITE);
    
    //can move one spot or two spots ahead
    assertTrue(pawnTest.canMove(2, 1));
    assertFalse(pawnTest.canMove(3, 1));
    
    
    //cannot move three ahead
    assertFalse(pawnTest.canMove(4, 1));
    
    //cannot move one behind
    assertFalse(pawnTest.canMove(0, 1));
    
    //cannot move to a different column
    assertFalse(pawnTest.canMove(2, 2));
    
  }
  
  /**
   * This tests the canMove method for pawns. This method tests if 
   * the black opening pawn can move one AND two slots.
   */
  @Test
  public void testCanMoveBlack() {
    ChessPiece pawnTest2 = new Pawn(6, 1, Color.BLACK);
    ChessPiece pawnTest3 = new Pawn(3, 3, Color.WHITE);
    
    //can move in the opening spot one lower
    
    assertFalse(pawnTest2.canMove(4, 1));
    assertTrue(pawnTest2.canMove(5, 1));
    assertTrue(pawnTest3.canMove(4, 3));
    
    //test cannot move backwards
    assertFalse(pawnTest2.canMove(7, 1));
    assertFalse(pawnTest3.canMove(2, 3));
    
    //test cannot move sideways
    assertFalse(pawnTest2.canMove(6, 2));
    assertFalse(pawnTest3.canMove(3, 4)); 
    
    //test cannot move diagonal
    assertFalse(pawnTest2.canMove(5, 2));
    assertFalse(pawnTest3.canMove(4, 4)); 
  }
  
  /**
   * This tests an illegal pawn move using a try and catch block. 
   * The illegal exception argument is thrown when the placement is 
   * off the board. 
   */
  @Test 
  public void canMovePawnTestIllegal() {
    ChessPiece pawnTest2 = new Pawn(0, 1, Color.BLACK);
    ChessPiece pawnTest3 = new Pawn(7, 3, Color.WHITE);
    
    try {
      pawnTest2.canMove(-1, 1);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
    
    try {
      pawnTest3.canMove(8, 3);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
  }
  
  /**
   * This method tests for illegal horizontal move for a Pawn Object. 
   */
  @Test
  public void canMoveRandomIllegalMoveTest() {
    Random r = new Random();
    
    double randomColumnDouble;
    
  
    for (int i = 0; i < 100; i++) {
      randomColumnDouble = (r.nextDouble() * 3);
      int randomColumn;
      int randomRow = 5;
      randomColumn = (int)randomColumnDouble;
    
      ChessPiece pawnNew = new Pawn(3, 3, Color.WHITE);
      
      assertFalse(pawnNew.canMove(randomRow, randomColumn));
    }
    
    
  }
  
  /**
   * This method tests for illegal vertical move for a Pawn Object. 
   */
  @Test
  public void canMoveRandomIllegalMoveTest2() {
    Random r = new Random();
    
    double randomRowDouble;
    
  
    for (int i = 0; i < 100; i++) {
      randomRowDouble = (r.nextDouble() * 3);
      int randomRow;
      int randomColumn = 4;
      randomRow = (int)randomRowDouble;
    
      ChessPiece pawnNew = new Pawn(3, 3, Color.WHITE);
      
      assertFalse(pawnNew.canMove(randomRow, randomColumn));
    }
    
    
  }
  
  /**
   * This method uses randomized testing to test the canMove method. 
   */
  @Test
  public void canMoveRandomTest() {
    Random r = new Random();
    double randomRowDouble;
    
    for (int i = 0; i < 100; i++) {
      randomRowDouble = (r.nextDouble() * 3);
      int randomRow;
      int randomColumn = 4;
      randomRow = (int)randomRowDouble;
      int randomMoveRow = randomRow + 1;
      int randomMoveColumn = randomColumn;
    
      ChessPiece pawnNew = new Pawn(randomRow, randomColumn, Color.WHITE);
      
      assertTrue(pawnNew.canMove(randomMoveRow, randomMoveColumn));

    
    }
  }
  
  /**
   * This method tests the can kill method for pawns. 
   */
  @Test
  public void canKillRandomTest() {
    Random r = new Random();
    double randomRowDouble;
    
    for (int i = 0; i < 100; i++) {
      randomRowDouble = (r.nextDouble() * 3);
      int randomRow;
      int randomColumn = 4;
      randomRow = (int)randomRowDouble;
      int randomMoveRow = randomRow + 1;
      int randomMoveColumn = randomColumn + 1;
      int randomMoveColumn2 = randomColumn - 1;
    
      ChessPiece pawnNew = new Pawn(randomRow, randomColumn, Color.WHITE);
      ChessPiece pawnKill = new Pawn(randomMoveRow, randomMoveColumn, Color.BLACK);
      ChessPiece pawnKill2 = new Pawn(randomMoveRow, randomMoveColumn2, Color.BLACK);
      
      assertTrue(pawnNew.canKill(pawnKill));
      assertTrue(pawnNew.canKill(pawnKill2));
  
    }
  }
  
  /**
   * This method tests the can kill method for pawns. 
   */
  @Test
  public void canKillTest2() {
    ChessPiece pawnTest = new Pawn(1, 2, Color.WHITE);
    ChessPiece rook1 = new Pawn(2, 3, Color.BLACK);
    ChessPiece rook2 = new Pawn(2, 1, Color.BLACK);
    
    assertTrue(pawnTest.canKill(rook1));
    assertTrue(pawnTest.canKill(rook2));
    
    ChessPiece pawnTest1 = new Pawn(5, 2, Color.BLACK);
    ChessPiece rook3 = new Pawn(4, 1, Color.WHITE);
    ChessPiece rook4 = new Pawn(4, 3, Color.WHITE);
    
    assertTrue(pawnTest1.canKill(rook3));
    assertTrue(pawnTest1.canKill(rook4));

  
  }
  
}




