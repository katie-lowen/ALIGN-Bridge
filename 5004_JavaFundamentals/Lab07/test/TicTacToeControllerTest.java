import static org.junit.Assert.assertEquals;

import cs5004.tictactoe.TicTacToe;
import cs5004.tictactoe.TicTacToeConsoleController;
import cs5004.tictactoe.TicTacToeController;
import cs5004.tictactoe.TicTacToeModel;
import org.junit.Test;

import java.io.StringReader;
import java.util.Arrays;



/**
 * Test cases for the tic tac toe controller, using mocks for readable and appendable.
 */
public class TicTacToeControllerTest {

  // ADDITIONAL TEST CASES TO IMPLEMENT:
  // Play game to completion, where there is a winner
  // Input where the q comes instead of an integer for the row
  // Input where the q comes instead of an integer for the column
  // Input where non-integer garbage comes instead of an integer for the row
  // Input where non-integer garbage comes instead of an integer for the column
  // Input where the move is integers, but outside the bounds of the board
  // Input where the move is integers, but invalid because the cell is occupied
  // Multiple invalid moves in a row of various kinds
  // Input including valid moves interspersed with invalid moves, game is played to completion
  // What happens when the input ends "abruptly" -- no more input, but not quit, and game not over
  // THIS IS NOT AN EXHAUSTIVE LIST

  /**
   * Tests for a single move that is valid.
   */
  @Test
  public void testSingleValidMove() {
    TicTacToe m = new TicTacToeModel();
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(new StringReader("2 2 q"), gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n", gameLog.toString());
  }

  /**
   * Tests for bogus input as a row value.
   */
  @Test
  public void testBogusInputAsRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("!#$ 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    // split the output into an array of lines
    String[] lines = gameLog.toString().split("\n");
    // check that it's the correct number of lines
    
    assertEquals(13, lines.length);
    // check that the last 6 lines are correct
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  ", lastMsg);
    // note no trailing \n here, because of the earlier split
  }

  /**
   * Tests for bogus input as a col value.
   */
  @Test
  public void testBogusInputAsCol() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 !#$ q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    // split the output into an array of lines
    String[] lines = gameLog.toString().split("\n");
    // check that it's the correct number of lines
    assertEquals(13, lines.length);
    // check that the last 6 lines are correct
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  ", lastMsg);
    // note no trailing \n here, because of the earlier split
  }
  
  /**
   * Tests the case of a tie game.
   */
  @Test
  public void testTieGame() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(60, lines.length);
    assertEquals("Game is over! Tie game.", lines[lines.length - 1]);
  }

  /**
   * Tests for a failing appendable.
   */
  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }
  
  /**
   * Test game where X is a winner.
   */
  @Test
  public void testWinnerXGame() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 2 2 1 1 1 1 3 3 3");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(36, lines.length);
    assertEquals("Game is over!X wins.", lines[lines.length - 1]);
  }
  
  /**
   * Test game where O is a winner.
   */
  @Test
  public void testWinnerOGame() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 2 2 2 1 1 1 1 3 3 3");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(42, lines.length);
    assertEquals("Game is over!O wins.", lines[lines.length - 1]);
  }

  /**
   * Input where q comes instead of an integer for a row. 
   */
  @Test 
  public void testQFirst() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 q 1");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(18, lines.length);
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   | X\n"
        + "-----------\n"
        + "   |   |  ", lastMsg);
    // note no trailing \n here, because of the earlier split
  
  }
  
  /**
   * Input where q comes instead of an integer for a col. 
   */
  @Test 
  public void testQSecond() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 1 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(18, lines.length);
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   | X\n"
        + "-----------\n"
        + "   |   |  ", lastMsg);
    // note no trailing \n here, because of the earlier split
    
  }
  
  /**
   * Input where non-integer garbage comes instead of an integer for the row. 
   */
  @Test
  public void testFirstInputGarbage() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 ASFTSF$ 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 7]);
    
    
    
  }
  
  /**
   * Input where non-integer garbage comes instead of an integer for the column.
   */
  @Test
  public void testSecondInputGarbage() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 2 ASFTSF$ q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 7]);
    
    
    
  }
  
  /**
   * Input for row placement is outside the matrix.
   */
  @Test
  public void testOutOfBoundsRow() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 8 1 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(25, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
  }
  
  /**
   * Input for row is zero and outside the matrix.
   */
  @Test
  public void testOutOfBoundsZeroRow() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 0 1 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(25, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
  }
  
  /**
   * Input for row is negative and outside the matrix.
   */
  @Test
  public void testOutOfBoundsNegativeRow() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 -4 1 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(25, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
  }
  
  /**
   * Input for col placement is outside the matrix and positive.
   */
  @Test
  public void testOutOfBoundsCol() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 1 19 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(25, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
  }
  
  /**
   * Input for col  is zero and placement is outside the matrix.
   */
  @Test
  public void testOutOfBoundsZeroCol() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 1 0 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(25, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
  }
  
  /**
   * Input for col  is negative and placement is outside the matrix.
   */
  @Test
  public void testOutOfBoundsNegativeCol() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 1 -5 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(25, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
  }
  
  /**
   * Input for row and col  is zero and outside the matrix.
   */
  @Test
  public void testOutOfBoundsZero() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 0 0 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(25, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
  }
  
  /**
   * Input for cell is already occupied.
   */
  @Test
  public void testCellOccupied() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 2 3 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(25, lines.length);
    assertEquals("Space is occupied", lines[lines.length - 13]);
  }
  
  /**
   * Input for cell is already occupied.
   */
  @Test
  public void testCellOccupied2() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 1 1 2 3 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    
    assertEquals(31, lines.length);
    assertEquals("Space is occupied", lines[lines.length - 13]);
    
    
  }
  
  /**
   * Multiple incorrect moves.
   */
  @Test
  public void testMulitpleInvalidMoves() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 42 50 -1 3 42 3 100 500 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    
    assertEquals(46, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
    
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   | X\n"
        + "-----------\n"
        + "   |   |  ", lastMsg);
    
    
  }
  
  /**
   * Multiple incorrect moves interspersed with valid moves.
   */
  @Test
  public void testMulitpleInvalidMoves2() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 42 50 1 3 42 3 100 500 3 3 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    
    assertEquals(51, lines.length);
    assertEquals("Enter a move for X:", lines[lines.length - 13]);
    
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("Game quit! Ending game state:\n"
        + "   |   | O\n"
        + "-----------\n"
        + "   |   | X\n"
        + "-----------\n"
        + "   |   | X", lastMsg);
    
    
  }
  
  /**
   * Multiple incorrect moves interspersed with valid moves ending in a win.
   */
  @Test
  public void testMulitpleInvalidMovesFinish() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 3 0 0 1 3 2 3 100 500 3 3 55 4 2 2 2 1"
        + " 1 2 93 2 1 1 -3 2 3 1");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    
    assertEquals(96, lines.length);
    assertEquals("Invalid input. Try again", lines[lines.length - 13]);
    
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals(""
        + " X | O | O\n"
        + "-----------\n"
        + " X | O | X\n"
        + "-----------\n"
        + " O |   | X\n"
        + "Game is over!O wins.", lastMsg);
    
    
  }

  
  /**
   * Multiple incorrect moves interspersed with valid moves ending in a tie.
   */
  @Test
  public void testMulitpleInvalidMovesTie() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 2 2 2 32 4 1 1 14 -2 1 -3 "
        + "42 $ 34 1 3 3 1 2 1 2 1 3 2 3 2 1 3 1 3 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    
    assertEquals(97, lines.length);
    assertEquals("Enter a move for O:", lines[lines.length - 13]);
    
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals(""
        + " O | O | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + " O | X | X\n"
        + "Game is over! Tie game.", lastMsg);
    
    
  }
  
  /**
   * Tests for an abrupt ending. 
   */
  @Test (expected = IllegalStateException.class) 
   public void testAbruptEnd() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 2 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
