import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;

/**
 * This is the junit test file for the Bishop object. ADD MORE TESTS
 * @author Katie Lowen
 */
public class BishopTest {
  

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
    

      ChessPiece randomBishopBlack = new Bishop(randomRow, randomColumn, Color.BLACK);
      
      assertEquals(randomRow, randomBishopBlack.getRow());
    }
    
    
  }
  
  /**
   * This method tests the getRow method by hand. 
   */
  @Test
  public void getRowTest2() {
    ChessPiece randomBishopWhite = new Bishop(2, 2, Color.BLACK);
    
    assertEquals(2, randomBishopWhite.getRow());
    
    
  }
  
  /**
   * This method tests the getColumn method by hand. 
   */
  @Test
  public void getColumnTest2() {
    ChessPiece randomBishopWhite = new Bishop(2, 3, Color.BLACK);
    
    assertEquals(3, randomBishopWhite.getColumn());
    
    
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
    

      ChessPiece randomBishopBlack = new Bishop(randomRow, randomColumn, Color.BLACK);
      
      assertEquals(randomColumn, randomBishopBlack.getColumn());
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
    

      ChessPiece randomBishopBlack = new Bishop(randomRow, randomColumn, Color.BLACK);
      
      String expected = "Bishop row: " + String.valueOf(randomBishopBlack.getRow()) + " column: " 
          + String.valueOf(randomBishopBlack.getColumn()) + " BLACK";
      
      assertEquals(expected, randomBishopBlack.toString());
      
      ChessPiece randomBishopWhite = new Bishop(randomRow, randomColumn, Color.WHITE);
      String expected2 = "Bishop row: " + String.valueOf(randomBishopWhite.getRow()) + " column: " 
          + String.valueOf(randomBishopWhite.getColumn()) + " WHITE";
      
      assertEquals(expected2, randomBishopWhite.toString());
    }
    
    
  }

  /**
   * This method tests the canMove method. All the moves should be valid, 
   * and return true. This test tests all the directions a bishop can move. 
   */
  @Test
  public void canMoveBishopTest() {
    ChessPiece bishopTest = new Bishop(0, 2, Color.WHITE);
    
    
    //move diagonally upwards and right
    assertTrue(bishopTest.canMove(1, 3));
    assertTrue(bishopTest.canMove(2, 4));
    assertTrue(bishopTest.canMove(3, 5));
    assertTrue(bishopTest.canMove(4, 6));
    assertTrue(bishopTest.canMove(5, 7));
    
    //move diagonally upwards and left
    ChessPiece bishopTest2 = new Bishop(3, 7, Color.BLACK);
    
    assertTrue(bishopTest2.canMove(4, 6));
    assertTrue(bishopTest2.canMove(5, 5));
    assertTrue(bishopTest2.canMove(6, 4));
    assertTrue(bishopTest2.canMove(7, 3));
    
    
    //move diagonally down and right
    ChessPiece bishopTest3 = new Bishop(7, 2, Color.BLACK);
    
    assertTrue(bishopTest3.canMove(6, 3));
    assertTrue(bishopTest3.canMove(5, 4));
    assertTrue(bishopTest3.canMove(4, 5));
    assertTrue(bishopTest3.canMove(3, 6));
    assertTrue(bishopTest3.canMove(2, 7));
    
    //move diagonally down and left
    ChessPiece bishopTest4 = new Bishop(7, 5, Color.BLACK);
    
    assertTrue(bishopTest4.canMove(6, 4));
    assertTrue(bishopTest4.canMove(5, 3));
    assertTrue(bishopTest4.canMove(4, 2));
    assertTrue(bishopTest4.canMove(3, 1));
    assertTrue(bishopTest4.canMove(2, 0));
  }
  
  /**
   * This method tests the illegal moves for the canMove method. 
   * We expect an IllegalArgumentException to be throw because all the moves 
   * would be off the board. 
   */
  @Test 
  public void canMoveBishopTestIllegal() {
    ChessPiece bishopTest3 = new Bishop(7, 2, Color.BLACK);
    ChessPiece bishopTest = new Bishop(0, 2, Color.WHITE);
    
    try {
      bishopTest3.canMove(1, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
    
    try {
      bishopTest.canMove(6, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
   
    }

  }
  
  /**
   * This method tests for illegal horizontal move for a Bishop Object. 
   */
  @Test
  public void canMoveRandomIllegalMoveTest() {
    Random r = new Random();
    
    double randomColumnDouble;
    
  
    for (int i = 0; i < 100; i++) {
      randomColumnDouble = (r.nextDouble() * 3);
      int randomColumn;
      int randomRow = 3;
      randomColumn = (int)randomColumnDouble;
    
      ChessPiece bishopNew = new Bishop(3, 3, Color.WHITE);
      
      assertFalse(bishopNew.canMove(randomRow, randomColumn));
    }
    
    
  }
  
  /**
   * This method tests for illegal vertical move for a Bishop Object. 
   */
  @Test
  public void canMoveRandomIllegalMoveTest2() {
    Random r = new Random();
    
    double randomRowDouble;
    
  
    for (int i = 0; i < 100; i++) {
      randomRowDouble = (r.nextDouble() * 3);
      int randomRow;
      int randomColumn = 3;
      randomRow = (int)randomRowDouble;
    
      ChessPiece bishopNew = new Bishop(3, 3, Color.WHITE);
      
      assertFalse(bishopNew.canMove(randomRow, randomColumn));
    }
    
  }
  
  /**
   * This method tests the canKill method for a bishop moving down and left.
   */
  @Test
  public void canKillTestLL() {
    ChessPiece bishopTest = new Bishop(7, 5, Color.BLACK);
    ChessPiece bishopTest2 = new Bishop(6, 4, Color.WHITE);
    ChessPiece bishopTest3 = new Bishop(5, 3, Color.WHITE);
    ChessPiece bishopTest4 = new Bishop(4, 2, Color.WHITE);
    
    
    
    // tests the lower left diagonal 
    assertTrue(bishopTest.canKill(bishopTest2));
    assertTrue(bishopTest.canKill(bishopTest3));
    assertTrue(bishopTest.canKill(bishopTest4));
    
    ChessPiece bishopTest5 = new Bishop(3, 1, Color.WHITE);
    assertTrue(bishopTest.canKill(bishopTest5));
    
    ChessPiece bishopTest6 = new Bishop(2, 0, Color.WHITE);
    assertTrue(bishopTest.canKill(bishopTest6));
    
  }
  
  /**
   * This method tests the canKill method for a Bishop object moving down and right. 
   */
  @Test
  public void canKillTestLR() {
    ChessPiece bishopTest = new Bishop(2, 0, Color.BLACK);
    ChessPiece bishopTest2 = new Bishop(6, 4, Color.WHITE);
    ChessPiece bishopTest3 = new Bishop(5, 3, Color.WHITE);
    ChessPiece bishopTest4 = new Bishop(4, 2, Color.WHITE);
    
    
    
    // tests the lower left diagonal 
    assertTrue(bishopTest.canKill(bishopTest2));
    assertTrue(bishopTest.canKill(bishopTest3));
    assertTrue(bishopTest.canKill(bishopTest4));
    
    ChessPiece bishopTest5 = new Bishop(3, 1, Color.WHITE);
    assertTrue(bishopTest.canKill(bishopTest5));
    
    ChessPiece bishopTest6 = new Bishop(7, 5, Color.WHITE);
    assertTrue(bishopTest.canKill(bishopTest6));
    
  }
  
  /**
   * This method tests the canKill method for a Bishop object moving up and Left.
   */
  @Test
  public void canKillTestUR() {
    ChessPiece bishopTest = new Bishop(0, 0, Color.BLACK);
    ChessPiece bishopTest2 = new Bishop(1, 1, Color.WHITE);
    ChessPiece bishopTest3 = new Bishop(2, 2, Color.WHITE);
    ChessPiece bishopTest4 = new Bishop(3, 3, Color.WHITE);
    
    
    
    // tests the lower left diagonal 
    assertTrue(bishopTest.canKill(bishopTest2));
    assertTrue(bishopTest.canKill(bishopTest3));
    assertTrue(bishopTest.canKill(bishopTest4));
    
    ChessPiece bishopTest5 = new Bishop(4, 4, Color.WHITE);
    assertTrue(bishopTest.canKill(bishopTest5));
    
    ChessPiece bishopTest6 = new Bishop(5, 5, Color.WHITE);
    assertTrue(bishopTest.canKill(bishopTest6));
    
  }
  
  /**
   * This method tests the canKill method for a Bishop object moving up and Left.
   */
  @Test
  public void canKillTestUL() {
    ChessPiece bishopTest = new Bishop(0, 7, Color.BLACK);
    ChessPiece bishopTest2 = new Bishop(1, 6, Color.WHITE);
    ChessPiece bishopTest3 = new Bishop(2, 5, Color.WHITE);
    ChessPiece bishopTest4 = new Bishop(3, 4, Color.WHITE);
    
    
    
    // tests the lower left diagonal 
    assertTrue(bishopTest.canKill(bishopTest2));
    assertTrue(bishopTest.canKill(bishopTest3));
    assertTrue(bishopTest.canKill(bishopTest4));
    
    ChessPiece bishopTest5 = new Bishop(4, 3, Color.WHITE);
    assertTrue(bishopTest.canKill(bishopTest5));
    
    ChessPiece bishopTest6 = new Bishop(5, 2, Color.WHITE);
    assertTrue(bishopTest.canKill(bishopTest6));
    
  }
  
  /**
   * This method tests the canKill method for a Bishop object moving up and Left.
   */
  @Test
  public void canKillFailTest() {
    ChessPiece bishopTest = new Bishop(0, 7, Color.WHITE);
    ChessPiece bishopTest2 = new Bishop(1, 6, Color.WHITE);
    ChessPiece bishopTest3 = new Bishop(2, 5, Color.WHITE);
    ChessPiece bishopTest4 = new Bishop(3, 4, Color.WHITE);
    
    
    
    // tests the lower left diagonal 
    assertFalse(bishopTest.canKill(bishopTest2));
    assertFalse(bishopTest.canKill(bishopTest3));
    assertFalse(bishopTest.canKill(bishopTest4));
    
    ChessPiece bishopTest5 = new Bishop(4, 3, Color.WHITE);
    assertFalse(bishopTest.canKill(bishopTest5));
    
    ChessPiece bishopTest6 = new Bishop(5, 2, Color.WHITE);
    assertFalse(bishopTest.canKill(bishopTest6));
    
  }
}
