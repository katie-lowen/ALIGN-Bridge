import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;

/**
 * This is the junit test for the Rook Object. 
 * @author Katie Lowen
 *
 */
public class RookTest {
  
  /**
   * This method tests the constructor from the AbstractChessPiece class for a rook. 
   */
  @Test
  public void constructor() {
    
    ChessPiece rookTest = new Rook(0, 2, Color.WHITE);  
    
    String expected = "Rook row: " + String.valueOf(rookTest.getRow()) + " column: " 
        + String.valueOf(rookTest.getColumn()) + " WHITE";
      
    assertEquals(expected, rookTest.toString());
    
    ChessPiece rookTest2 = new Rook(0, 2, Color.BLACK); 
    
    String expected2 = "Rook row: " + String.valueOf(rookTest2.getRow()) + " column: " 
        + String.valueOf(rookTest2.getColumn()) + " BLACK";
      
    assertEquals(expected2, rookTest2.toString());
      
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
      
  
      ChessPiece randomrookBlack = new Rook(randomRow, randomColumn, Color.BLACK);
      
      String expected = "Rook row: " + String.valueOf(randomrookBlack.getRow()) + " column: " 
          + String.valueOf(randomrookBlack.getColumn()) + " BLACK";
      
      assertEquals(expected, randomrookBlack.toString());
      
      ChessPiece randomrookWhite = new Rook(randomRow, randomColumn, Color.WHITE);
      String expected2 = "Rook row: " + String.valueOf(randomrookWhite.getRow()) + " column: " 
          + String.valueOf(randomrookWhite.getColumn()) + " WHITE";
      
      assertEquals(expected2, randomrookWhite.toString());
      
      
    }
    
  }

  /**
   * This method tests the canMove method for a Rook object. 
   * This method tests for all the possible legal moves. 
   */
  @Test
  public void testCanMoveRook2() {
    ChessPiece rookTest = new Rook(4, 0, Color.WHITE);
    
    
    //test move horizontally to right
    assertTrue(rookTest.canMove(4, 7));
    
    //test move vertically up
    assertTrue(rookTest.canMove(7, 0));
    
    //test move horizontally left 
    ChessPiece rookTest3 = new Rook(4, 3, Color.WHITE);
    
    assertTrue(rookTest3.canMove(4, 0));
    
    //test move vertically down
    assertTrue(rookTest.canMove(1, 0));

    //TESTS FOR rookTest1
    //test move horizontally to right
    ChessPiece rookTest1 = new Rook(6, 5, Color.BLACK);
    assertTrue(rookTest1.canMove(6, 7));
    
    //test move vertically up
    assertTrue(rookTest1.canMove(7, 5));
    
    //test move horizontally left 
    assertTrue(rookTest1.canMove(6, 0));
    
    //test move vertically down
    assertTrue(rookTest1.canMove(2, 5));
    
  }
  /**
   * This method tests the canMove method for a Rook object. A rook can move
   * horizontally and vertically, but not diagonally. The cases in this test should fail.  
   */
  
  @Test
  public void testCanMoveRook() {
    ChessPiece rookTest = new Rook(1, 0, Color.WHITE);
   
    assertFalse(rookTest.canMove(2, 7));
    assertFalse(rookTest.canMove(7, 2));
    assertFalse(rookTest.canMove(4, 5));
    

    ChessPiece rookTest2 = new Rook(6, 7, Color.BLACK);
    assertFalse(rookTest2.canMove(3, 4));
    assertFalse(rookTest2.canMove(2, 6));
    assertFalse(rookTest2.canMove(4, 5));
   
  }

  
  /**
   * The following tests for an illegal argument exception to be thrown for the canMove method.
   * The illegal argument exception if thrown because the move is off the board. 
   */
  @Test 
  public void canMoverookTestIllegal() {
    ChessPiece rookTest3 = new Rook(1, 0, Color.WHITE);
    ChessPiece rookTest = new Rook(6, 7, Color.BLACK);
    
    try {
      rookTest3.canMove(1, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
    
    try {
      rookTest.canMove(6, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
   
    }  
  }
  
  /**
   * This method tests the canMove method to see if an illegal argument exception is thrown.
   * In this test, the player if moving the rook off the board.
   */
  @Test 
  public void canMoverookTestIllegal2() {
    ChessPiece rookTest2 = new Rook(6, 7, Color.BLACK);
    
    try {
      rookTest2.canMove(8, 7);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
    
    try {
      rookTest2.canMove(-1, 7);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
   
  
    try {
      rookTest2.canMove(6, 8);
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("This placement is not on the board", exception);
    }
  }

  /**
   * This method tests if the canKill method with all of the players being the same color.
   * This method should fail because the players must be opposite colors. 
   */
  @Test
  public void canKillFailTest() {
    ChessPiece rookTest = new Rook(4, 0, Color.WHITE);
    ChessPiece pawnKill = new Pawn(7, 0, Color.WHITE);
    ChessPiece pawnKill2 = new Pawn(1, 0, Color.WHITE);
    ChessPiece pawnKill3 = new Pawn(7, 3, Color.WHITE);

    //test vertical up kill
    assertFalse(rookTest.canKill(pawnKill));
    
    //test vertical down kill
    assertFalse(rookTest.canKill(pawnKill2));
    
    //fail- move not allowed
    assertFalse(rookTest.canKill(pawnKill3));
    
    
    //move not allowed
    ChessPiece rookTest2 = new Rook(5, 5, Color.WHITE);
    assertFalse(rookTest2.canKill(pawnKill3));
    
    
    //test horizontal right
    ChessPiece pawnKill4 = new Pawn(5, 7, Color.WHITE);
    assertFalse(rookTest2.canKill(pawnKill4));
    
    //test horizontal left
    ChessPiece pawnKill5 = new Pawn(5, 1, Color.WHITE);
    assertFalse(rookTest2.canKill(pawnKill5));
  }
  
  /**
   * This method tests the canKill method. 
   */
  @Test
  public void canKillTest() {
    ChessPiece rookTest = new Rook(4, 0, Color.BLACK); 
    ChessPiece pawnKill3 = new Pawn(7, 3, Color.WHITE);
 
    //test vertical up kill
    ChessPiece pawnKillV = new Pawn(5, 0, Color.WHITE);
    ChessPiece pawnKillV2 = new Pawn(6, 0, Color.WHITE);
    ChessPiece pawnKillV3 = new Pawn(7, 0, Color.WHITE);
    
    assertTrue(rookTest.canKill(pawnKillV));
    assertTrue(rookTest.canKill(pawnKillV2));
    assertTrue(rookTest.canKill(pawnKillV3));
    
    
    
    //test vertical down kill
    ChessPiece pawnKillD = new Pawn(3, 0, Color.WHITE);
    ChessPiece pawnKillD2 = new Pawn(2, 0, Color.WHITE);
    ChessPiece pawnKillD3 = new Pawn(1, 0, Color.WHITE);
    
    assertTrue(rookTest.canKill(pawnKillD));
    assertTrue(rookTest.canKill(pawnKillD2));
    assertTrue(rookTest.canKill(pawnKillD3));
 
    
    //fail- move not allowed
    assertFalse(rookTest.canKill(pawnKill3));
    
    //move not allowed
    ChessPiece rookTest2 = new Rook(5, 5, Color.BLACK);
    assertFalse(rookTest2.canKill(pawnKill3));
    
    //test horizontal right
    ChessPiece rook3 = new Rook(3, 3, Color.WHITE);
    ChessPiece pawnKillH = new Pawn(3, 4, Color.BLACK);
    ChessPiece pawnKillH2 = new Pawn(3, 5, Color.BLACK);
    ChessPiece pawnKillH3 = new Pawn(3, 6, Color.BLACK);
    ChessPiece pawnKillH4 = new Pawn(3, 7, Color.BLACK);
    
    assertTrue(rook3.canKill(pawnKillH));
    assertTrue(rook3.canKill(pawnKillH2));
    assertTrue(rook3.canKill(pawnKillH3));
    assertTrue(rook3.canKill(pawnKillH4));
    
    
    //test horizontal left
    ChessPiece pawnKillH5 = new Pawn(3, 2, Color.BLACK);
    ChessPiece pawnKillH6 = new Pawn(3, 1, Color.BLACK);
    ChessPiece pawnKillH7 = new Pawn(3, 0, Color.BLACK);
    
    assertTrue(rook3.canKill(pawnKillH5));
    assertTrue(rook3.canKill(pawnKillH6));
    assertTrue(rook3.canKill(pawnKillH7));
  }
  

  /**
   * This method tests for illegal diagonal move for a Rook Object. 
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
    
      ChessPiece rookNew = new Rook(3, 3, Color.WHITE);
      
      assertFalse(rookNew.canMove(randomRow, randomColumn));
    }  
    
  }
  
  /**
   * This method tests for illegal vertical move for a Rook Object. 
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
    
      ChessPiece rookNew = new Rook(3, 3, Color.WHITE);
      
      assertFalse(rookNew.canMove(randomRow, randomColumn));
    } 
  }
}
