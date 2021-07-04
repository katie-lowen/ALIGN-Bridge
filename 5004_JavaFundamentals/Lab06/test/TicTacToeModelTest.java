import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import cs5004.tictactoe.Player;
import cs5004.tictactoe.TicTacToe;
import cs5004.tictactoe.TicTacToeModel;
import org.junit.Test;


/**
 * Test cases for the tic tac toe model. Verifying that game state is properly managed, and
 * all game actions are properly validated.
 */
public class TicTacToeModelTest {

  private TicTacToe ttt1 = new TicTacToeModel();

  /**
   * Tests the move method. 
   */
  @Test
  public void testMove() {
    TicTacToe myModel = new TicTacToeModel();
    boolean isX = true;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        try {
          myModel.move(r, c);
        
          if (myModel.isGameOver()) {
            break;
          }
        
          isX = !isX;
          if (isX) {
            assertEquals(Player.X, myModel.getTurn());
          } else {
            assertEquals(Player.O, myModel.getTurn());
          }
        } catch (Exception e) {
          fail();
        }
      }
    }
    assertEquals(" X | O | X\n"
        + "-----------\n"
        + " O | X | O\n"
        + "-----------\n"
        + " X |   |  ", myModel.toString());
    
    
    
  }

  /**
   * This method tests for a horizontal win.
   */
  @Test
  public void testHorizontalWin() {
    ttt1.move(0, 0); // X takes upper left
    assertFalse(ttt1.isGameOver());
    ttt1.move(1, 0); // O takes middle left
    ttt1.move(0, 1); // X takes upper middle
    assertNull(ttt1.getWinner());
    ttt1.move(2, 0); // O takes lower left
    ttt1.move(0, 2); // X takes upper right
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.X, ttt1.getWinner());
    assertEquals(" X | X | X\n"
                          + "-----------\n"
                          + " O |   |  \n"
                          + "-----------\n"
                          + " O |   |  ", ttt1.toString());
  }

  /**
   * This method tests for a diagonal win.
   */
  @Test
  public void testDiagonalWin() {
    diagonalWinHelper();
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.O, ttt1.getWinner());
    assertEquals(" X | X | O\n"
            + "-----------\n"
            + " X | O |  \n"
            + "-----------\n"
            + " O |   |  ", ttt1.toString());
  }

  // set up situation where game is over, O wins on the diagonal, board is not full
  private void diagonalWinHelper() {
    ttt1.move(0, 0); // X takes upper left
    assertFalse(ttt1.isGameOver());
    ttt1.move(2, 0); // O takes lower left
    ttt1.move(1, 0); // X takes middle left
    assertNull(ttt1.getWinner());
    ttt1.move(1, 1); // O takes center
    ttt1.move(0, 1); // X takes upper middle
    ttt1.move(0, 2); // O takes upper right
  }

  /**
   * Tests making an invalid move. 
   */
  @Test
  public void testInvalidMove() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    assertEquals(Player.X, ttt1.getMarkAt(0, 0));
    try {
      ttt1.move(0, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      ttt1.move(-1, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  /**
   * Tests if a move is possible if the game is over. 
   */
  @Test(expected = IllegalStateException.class)
  public void testMoveAttemptAfterGameOver() {
    diagonalWinHelper();
    ttt1.move(2, 2); // 2,2 is an empty position
  }

  /**
   * Tests if the game is a tie.
   */
  @Test
  public void testCatsGame() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(1, 1);
    assertEquals(Player.X, ttt1.getTurn());
    ttt1.move(0, 2);
    ttt1.move(0, 1);
    ttt1.move(2, 1);
    ttt1.move(1, 0);
    ttt1.move(1, 2);
    ttt1.move(2, 2);
    ttt1.move(2, 0);
    assertTrue(ttt1.isGameOver());
    assertNull(ttt1.getWinner());
    assertEquals( " X | O | X\n"
            + "-----------\n"
            + " O | O | X\n"
            + "-----------\n"
            + " X | X | O", ttt1.toString());
  }

  /**
   * This method checks for an invalid getMark.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtRow() {
    ttt1.getMarkAt(-12, 0);
  }

  /**
   * This method checks for invalid getMark.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtCol() {
    ttt1.getMarkAt(0, -30);
  }

  /**
   * Tests the getBoard method. 
   */
  @Test
  public void testGetBoard() {
    diagonalWinHelper();
    Player[][] bd = ttt1.getBoard();
    assertEquals(Player.X, bd[0][0]);
    assertEquals(Player.O, bd[1][1]);
    assertEquals(Player.X, bd[0][1]);

    // attempt to cheat by mutating board returned by getBoard()
    // check correct preconditions
    assertEquals(Player.O, bd[2][0]);
    assertEquals(Player.O, ttt1.getMarkAt(2, 0));
    bd[2][0] = Player.X;  // mutate
    // check correct post conditions
    assertEquals(Player.O, ttt1.getMarkAt(2, 0));
    Player[][] bd2 = ttt1.getBoard();
    assertEquals(Player.O, bd2[2][0]);
  }

 
  
  /**
   * This method tests the getWinner method.
   */
  @Test
  public void testgetWinner() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(1, 1);
    assertEquals(Player.X, ttt1.getTurn());
    ttt1.move(0, 2);
    ttt1.move(2, 1);
    ttt1.move(0, 1);
   
    assertTrue(ttt1.isGameOver());
    assertEquals("X", ttt1.getWinner().toString());
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
