import static org.junit.Assert.assertEquals;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Test;


/**
 * This is the jUnit test case for the MarbleSolitaireModel Class.
 * @author Katie Lowen
 *
 */
public class MarbleBoardTest {

  /**
   * This method tests the constructors without any parameters and 
   * with specifications of the empty slot. 
   */
  @Test
  public void testBoardConstructor() {
    //test marble board constructor without any parameters
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl();
    
    String actual = mb.getGameState();
    
    
    String expected = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O _ O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected, actual);
    
    
    //second marble board constructor with 2 values but regular board
    
    MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(3, 3);
    
    String actual2 = mb2.getGameState();
    
    
    String expected2 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O _ O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected2, actual2);
    
    
    MarbleSolitaireModelImpl mb3 = new MarbleSolitaireModelImpl(2, 2);
    
    String actual3 = mb3.getGameState();
    
    
    String expected3 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O _ O O O O\n"
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected3, actual3);
    
    MarbleSolitaireModelImpl mb4 = new MarbleSolitaireModelImpl(0, 3);
    
    String actual4 = mb4.getGameState();
    
   
    String expected4 = 
        "    O _ O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected4, actual4);
    
    MarbleSolitaireModelImpl mb5 = new MarbleSolitaireModelImpl(2, 6);
    
    String actual5 = mb5.getGameState();
    
    
    String expected5 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O _\n"
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected5, actual5);
    
    MarbleSolitaireModelImpl mb6 = new MarbleSolitaireModelImpl(6, 2);
    
    String actual6 = mb6.getGameState();
    
    
    String expected6 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    _ O O";
    assertEquals(expected6, actual6);
    
    MarbleSolitaireModelImpl mb7 = new MarbleSolitaireModelImpl(2, 0);
    
    String actual7 = mb7.getGameState();
    
    
    String expected7 = 
        "    O O O\n"
         + "    O O O\n"  
         + "_ O O O O O O\n"
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected7, actual7);
    
    MarbleSolitaireModelImpl mb8 = new MarbleSolitaireModelImpl(1, 2);
    
    String actual8 = mb8.getGameState();
    
    
    String expected8 = 
        "    O O O\n"
         + "    _ O O\n"  
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected8, actual8);
    
    
  }
  
  /**
   * This method tests a constructor with an even arm number. 
   */
  @Test
  public void testEvenArmFail() {
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(4);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Must have a postive and odd arm number";
      assertEquals(expected, exception);
      
    }
    
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(2);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Must have a postive and odd arm number";
      assertEquals(expected, exception);
      
    }
    
    //even arm number, valid empty space
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(4, 2, 2);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (2,2)";
      assertEquals(expected, exception);
      
    }
    
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(6, 3, 3);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (3,3)";
      assertEquals(expected, exception);
      
    }
    
    
    
    
  }
  
  /**
   * These invalid placements of empty cell in standard sized board. 
   */
  @Test
  public void testStandardConstructorFail() {
    //top left
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(1, 1);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (1,1)";
      assertEquals(expected, exception);
      
    }
    //top right
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(1, 5);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (1,5)";
      assertEquals(expected, exception);
      
    }
    //bottom left
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(5, 1);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (5,1)";
      assertEquals(expected, exception);
      
    }
    //bottom right
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(5, 5);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (5,5)";
      assertEquals(expected, exception);
      
    }
    //out of the matrix
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(7, 2);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (7,2)";
      assertEquals(expected, exception);
      
    }
    //out of the matrix
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(2, 7);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (2,7)";
      assertEquals(expected, exception);
      
    }
    
  }
  
  /**
   * This method tests placing the empty cell in an invalid position.
   */
  @Test
  public void testConstructorFailLarge() {
    //top left
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(5, 1, 1);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (1,1)";
      assertEquals(expected, exception);
      
    }
    //top right
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(7, 1, 5);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (1,5)";
      assertEquals(expected, exception);
      
    }
    //bottom left
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(3, 5, 1);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (5,1)";
      assertEquals(expected, exception);
      
    }
    //bottom right
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(7, 14, 14);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (14,14)";
      assertEquals(expected, exception);
      
    }
    //out of the matrix
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(5, 14, 2);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (14,2)";
      assertEquals(expected, exception);
      
    }
    //out of the matrix
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(7, 2, 20);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (2,20)";
      assertEquals(expected, exception);
      
    }
    
    //negative value of arm
    try {
      MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(-5, 1, 6);
    
    } catch (IllegalArgumentException e) {
      
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (1,6)";
      assertEquals(expected, exception);
      
    }
  }
  
  /**
   * This method tests the constructor with no parameters, and with placement of empty 
   * slot. 
   */
  @Test
  public void testMarblSolitaireConstructor() {

    //test marble board constructor without any parameters
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl();
    
    String actual = mb.getGameState();
    
    
    String expected = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O _ O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected, actual);
    
    
    //second marble board constructor with 2 values but regular board
    
    MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(3, 3);
    
    String actual2 = mb2.getGameState();
    
    
    String expected2 = 
          "    O O O\n"
           + "    O O O\n"  
           + "O O O O O O O\n"
           + "O O O _ O O O\n"
           + "O O O O O O O\n"
           + "    O O O\n"  
           + "    O O O";
    assertEquals(expected2, actual2);
    
    
    MarbleSolitaireModelImpl mb3 = new MarbleSolitaireModelImpl(2, 2);
    
    String actual3 = mb3.getGameState();
    
    
    String expected3 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O _ O O O O\n"
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected3, actual3);
      
    MarbleSolitaireModelImpl mb4 = new MarbleSolitaireModelImpl(0, 3);
      
    String actual4 = mb4.getGameState();
      
      
    String expected4 = 
          "    O _ O\n"
           + "    O O O\n"  
           + "O O O O O O O\n"
           + "O O O O O O O\n"
           + "O O O O O O O\n"
           + "    O O O\n"  
           + "    O O O";
    assertEquals(expected4, actual4);
      
    MarbleSolitaireModelImpl mb5 = new MarbleSolitaireModelImpl(2, 6);
      
    String actual5 = mb5.getGameState();
      
      
    String expected5 = 
          "    O O O\n"
           + "    O O O\n"  
           + "O O O O O O _\n"
           + "O O O O O O O\n"
           + "O O O O O O O\n"
           + "    O O O\n"  
           + "    O O O";
    assertEquals(expected5, actual5);
      
    MarbleSolitaireModelImpl mb6 = new MarbleSolitaireModelImpl(6, 2);
      
    String actual6 = mb6.getGameState();
      
      
    String expected6 = 
          "    O O O\n"
           + "    O O O\n"  
           + "O O O O O O O\n"
           + "O O O O O O O\n"
           + "O O O O O O O\n"
           + "    O O O\n"  
           + "    _ O O";
    assertEquals(expected6, actual6);
      
    MarbleSolitaireModelImpl mb7 = new MarbleSolitaireModelImpl(2, 0);
      
    String actual7 = mb7.getGameState();
      
      
    String expected7 = 
          "    O O O\n"
           + "    O O O\n"  
           + "_ O O O O O O\n"
           + "O O O O O O O\n"
           + "O O O O O O O\n"
           + "    O O O\n"  
           + "    O O O";
        
    assertEquals(expected7, actual7);
    
  }
  
  /**
   * This method tests the constructor for a board of odd number arm size.
   */
  @Test
  public void testConstructor3() {
    //test marble board constructor with arm thickness parameter
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(3);
    
    String actual = mb.getGameState();
    
    
    String expected = 
        "    O O O\n"
        + "    O O O\n"  
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"  
        + "    O O O";
      
    assertEquals(expected, actual);
    
    MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(5);
    
    String actual2 = mb2.getGameState();
    
    
    String expected2 = 
        "        O O O O O\n"
         + "        O O O O O\n"  
         + "        O O O O O\n" 
         + "        O O O O O\n" 
         + "O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O\n"
         + "O O O O O O _ O O O O O O\n"
         + "O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O\n"
         + "        O O O O O\n"  
         + "        O O O O O\n"
         + "        O O O O O\n"
         + "        O O O O O";
    
    assertEquals(expected2, actual2);
    
    MarbleSolitaireModelImpl mb3 = new MarbleSolitaireModelImpl(7);
    
    String actual3 = mb3.getGameState();
    
    
    String expected3 = 
        "            O O O O O O O\n"
         + "            O O O O O O O\n"
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n" 
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O _ O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n" 
         + "O O O O O O O O O O O O O O O O O O O\n" 
         + "            O O O O O O O\n"
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n"
         + "            O O O O O O O\n"
         + "            O O O O O O O";
      
    assertEquals(expected3, actual3);
    
    
  }
  
  /**
   * This method tests a constructor failing with an arm of 0. 
   */
  @Test
  public void testZeroConstructorFail() {
    
    try {
      MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(0);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Must have a postive and odd arm number";
      assertEquals(expected, exception);
    }
    
    try {
      MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(0, 3, 3);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (3,3)";
      assertEquals(expected, exception);
    }
    
    
  }
  
  /**
   * This method tests the constructor for a board of n arm thickness and 
   * specified empty starting point. 
   */
  @Test 
  public void testConstructor4() {
    //test marble board constructor with arm thickness and location of empty slot
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(3, 0, 3);
    
    String actual = mb.getGameState();
    
    
    String expected = 
        "    O _ O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
      
    assertEquals(expected, actual);
    
    MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(5, 4, 12);
    
    String actual2 = mb2.getGameState();
    
    
    String expected2 = 
        "        O O O O O\n"
         + "        O O O O O\n"  
         + "        O O O O O\n" 
         + "        O O O O O\n" 
         + "O O O O O O O O O O O O _\n"
         + "O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O\n"
         + "        O O O O O\n"  
         + "        O O O O O\n"
         + "        O O O O O\n"
         + "        O O O O O";
      
    assertEquals(expected2, actual2);
    
    MarbleSolitaireModelImpl mb3 = new MarbleSolitaireModelImpl(7, 13, 6);
    
    String actual3 = mb3.getGameState();
    
    
    String expected3 = 
        "            O O O O O O O\n"
         + "            O O O O O O O\n"
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n" 
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n"
         + "O O O O O O O O O O O O O O O O O O O\n" 
         + "O O O O O O O O O O O O O O O O O O O\n" 
         + "            _ O O O O O O\n"
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n" 
         + "            O O O O O O O\n"
         + "            O O O O O O O\n"
         + "            O O O O O O O";
    
    assertEquals(expected3, actual3);
    
  }
  
  /**
   * This method tests failing to construct a board.
   */
  @Test
  public void testCustomConstructorFail() {
    
    //test marble board constructor with arm thickness of 3 and location of empty slot invalid
    
    try {
      MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(3, 0, 1);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (0,1)";
      assertEquals(expected, exception);
    }
    
    try {
      MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(5, 9, 1);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (9,1)";
      assertEquals(expected, exception);
    }
    
    try {
      MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(5, 13, 1);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (13,1)";
      assertEquals(expected, exception);
    }
    
    try {
      MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(7, 17, 17);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (17,17)";
      assertEquals(expected, exception);
    }
    
    try {
      MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(5, 2, 2);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Invalid empty cell position (2,2)";
      assertEquals(expected, exception);
    }
  }
  
  /**
   * This method tests the move method. 
   */
  @Test
  public void testMove() {
    //create board
    //move to blank space 
    
    
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl();
    
    String actual = mb.getGameState();

    String expected = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O _ O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected, actual);
    
    //test moving RIGHT
    mb.move(3, 1, 3, 3);
    
    actual = mb.getGameState();
    
    expected = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O _ _ O O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    
    assertEquals(expected, actual);
    
    MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl();
    
    String actual2 = mb2.getGameState();
    
    
    String expected2 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O _ O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected2, actual2);
    
    //test moving UP 
    mb2.move(5, 3, 3, 3);
    
    actual2 = mb2.getGameState();
    
    expected2 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O O O O O\n"
         + "O O O _ O O O\n"
         + "    O _ O\n"  
         + "    O O O";
    
    assertEquals(expected2, actual2);
    
    MarbleSolitaireModelImpl mb3 = new MarbleSolitaireModelImpl();
    
    String actual3 = mb3.getGameState();
    
    
    String expected3 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O _ O O O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    assertEquals(expected3, actual3);
    
    //test moving LEFT
    mb3.move(3, 5, 3, 3);
    
    actual3 = mb3.getGameState();
    
    expected3 = 
        "    O O O\n"
         + "    O O O\n"  
         + "O O O O O O O\n"
         + "O O O O _ _ O\n"
         + "O O O O O O O\n"
         + "    O O O\n"  
         + "    O O O";
    
    assertEquals(expected3, actual3);
    
    
    
  }
  
  /**
   * This method tests for invalid moves. 
   */
  @Test
  public void testInvalidMove() {
    
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl();
 
    
    //try moving to many rows (up)
    try {
      mb.move(3, 2, 0, 2);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Invalid move";
      assertEquals(expected, exception);
      
    }
    
    //too many rows down
    try {
      mb.move(3, 2, 6, 2);
    } catch (IllegalArgumentException e) {
      String exception2 = e.getMessage();
      String expected2 = "Invalid move";
      assertEquals(expected2, exception2);
    }
      
    //too many to the right
    try {
      mb.move(3, 2, 3, 6);
    } catch (IllegalArgumentException e) {
      String exception3 = e.getMessage();
      String expected3 = "Invalid move";
      assertEquals(expected3, exception3);
    }
      
    //too many to the left
    try {
      mb.move(3, 3, 3, 0);
    } catch (IllegalArgumentException e) {
      String exception4 = e.getMessage();
      String expected4 = "Invalid move";
      assertEquals(expected4, exception4);
    }
    
    MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(5);
    
    //try moving to cell already occupied 
    try {
      mb2.move(4, 1, 4, 3);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      String expected = "Invalid move";
      assertEquals(expected, exception);
      
    }
    
    //move to cell out of bounds (col)
    try {
      mb2.move(4, 1, 4, -1);
    } catch (IllegalArgumentException e) {
      String exception2 = e.getMessage();
      String expected2 = "Invalid move";
      assertEquals(expected2, exception2);
    }
    
    try {
      mb2.move(4, 11, 4, 13);
    } catch (IllegalArgumentException e) {
      String exception2 = e.getMessage();
      String expected2 = "Invalid move";
      assertEquals(expected2, exception2);
    }
      
    //move to cell out of bounds (row)
    try {
      mb2.move(3, 2, 3, 6);
    } catch (IllegalArgumentException e) {
      String exception3 = e.getMessage();
      String expected3 = "Invalid move";
      assertEquals(expected3, exception3);
    }
    
    try {
      mb2.move(12, 4, 14, 4);
    } catch (IllegalArgumentException e) {
      String exception3 = e.getMessage();
      String expected3 = "Invalid move";
      assertEquals(expected3, exception3);
    }
      

    
    
  }
  

  
  /**
   * This method tests the isGameOver method. 
   */
  @Test
  public void testIsGameOver() {
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl();
    
    boolean expected = false;
    boolean actual = mb.isGameOver();
    
    assertEquals(expected, actual);
    
  }
  
  /**
   * This method tests the methods used in playing a full game.
   * This method is used to test the isGameOver method.
   */
  @Test 
  public void fullGame() {
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl();
    
    //check game over
    boolean expected = false;
    boolean actual = mb.isGameOver();
    
    assertEquals(expected, actual);
    
    mb.move(3, 5, 3, 3);
    mb.move(1, 4, 3, 4);
    
    String gameCurrent = 
        "    O O O\n"
            + "    O O _\n"  
            + "O O O O _ O O\n"
            + "O O O O O _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"  
            + "    O O O";
    
    String gameState = mb.getGameState().toString();
    
    assertEquals(gameCurrent,gameState);
    
    mb.move(2, 6, 2, 4);
    
    mb.move(4, 6, 2, 6);
    
    mb.move(2, 3, 2, 5);
    
    actual = mb.isGameOver();
    //check if game is over 
    assertEquals(expected, actual);
    
    //check current score
    
    int scoreExpected = 27;
    int scoreActual = mb.getScore();
    
    assertEquals(scoreExpected, scoreActual);
    
    mb.move(2, 6, 2, 4);
    
    gameCurrent = 
        "    O O O\n"
            + "    O O _\n"  
            + "O O O _ O _ _\n"
            + "O O O O O _ _\n"
            + "O O O O O O _\n"
            + "    O O O\n"  
            + "    O O O";
    
    gameState = mb.getGameState().toString();
    
    assertEquals(gameCurrent,gameState);
    
    
    mb.move(2, 1, 2, 3);
    
    mb.move(0, 2, 2, 2);
    
    mb.move(0, 4, 0, 2);
    
    //check game over
    expected = false;
    actual = mb.isGameOver();
    assertEquals(expected, actual);
    
    mb.move(3, 2, 1, 2);
    
    mb.move(0, 2, 2, 2);
    
    gameCurrent = 
        "    _ _ _\n"
            + "    _ O _\n"  
            + "O _ O O O _ _\n"
            + "O O _ O O _ _\n"
            + "O O O O O O _\n"
            + "    O O O\n"  
            + "    O O O";
    
    gameState = mb.getGameState().toString();
    
    assertEquals(gameCurrent,gameState);
    
    //check if game is over
    actual = mb.isGameOver();
    assertEquals(expected, actual);
    
    //check score
    scoreExpected = 21;
    scoreActual = mb.getScore();
    
    assertEquals(scoreExpected, scoreActual);
    
    
    
    mb.move(5, 2, 3, 2);
    
    mb.move(4, 0, 4, 2);
    
    mb.move(2, 0, 4, 0);
    
    mb.move(4, 3, 4, 1);
    
    gameCurrent = 
        "    _ _ _\n"
            + "    _ O _\n"  
            + "_ _ O O O _ _\n"
            + "_ O O O O _ _\n"
            + "O O _ _ O O _\n"
            + "    _ O O\n"  
            + "    O O O";
    
    gameState = mb.getGameState().toString();
    
    assertEquals(gameCurrent,gameState);
    
    //check if game is over
    actual = mb.isGameOver();
    assertEquals(expected, actual);
    
    //check score
    scoreExpected = 17;
    scoreActual = mb.getScore();
    
    assertEquals(scoreExpected, scoreActual);
    
    mb.move(4, 5, 4, 3);
    
    mb.move(6, 4, 4, 4);
    
    mb.move(6, 2, 6, 4);
    
    mb.move(3, 4, 5, 4);
    
    mb.move(6, 4, 4, 4);
    
    mb.move(4, 0, 4, 2);
    
    gameCurrent = 
        "    _ _ _\n"
            + "    _ O _\n"  
            + "_ _ O O O _ _\n"
            + "_ O O O _ _ _\n"
            + "_ _ O O O _ _\n"
            + "    _ O _\n"  
            + "    _ _ _";
    
    gameState = mb.getGameState().toString();
    
    assertEquals(gameCurrent,gameState);
    
    //check if game is over
    actual = mb.isGameOver();
    assertEquals(expected, actual);
    
    //check score
    scoreExpected = 11;
    scoreActual = mb.getScore();
    
    assertEquals(scoreExpected, scoreActual);
    
    mb.move(3, 2, 1, 2);
    
    mb.move(1, 2, 1, 4);
    
    mb.move(1, 4, 3, 4);
    
    mb.move(3, 4, 5, 4);
    
    mb.move(5, 4, 5, 2);
    
    mb.move(5, 2, 3, 2);
    
    gameCurrent = 
        "    _ _ _\n"
            + "    _ _ _\n"  
            + "_ _ _ O _ _ _\n"
            + "_ O O O _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "    _ _ _\n"  
            + "    _ _ _";
    
    gameState = mb.getGameState().toString();
    
    assertEquals(gameCurrent,gameState);
    
    //check if game is over
    actual = mb.isGameOver();
    assertEquals(expected, actual);
    
    //check score
    scoreExpected = 5;
    scoreActual = mb.getScore();
    
    assertEquals(scoreExpected, scoreActual);
    
    mb.move(3, 3, 1, 3);
    
    mb.move(3, 1, 3, 3);
    
    mb.move(4, 3, 2, 3);
    
    mb.move(1, 3, 3, 3);
    
    gameCurrent = 
        "    _ _ _\n"
            + "    _ _ _\n"  
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "    _ _ _\n"  
            + "    _ _ _";
    
    gameState = mb.getGameState().toString();
    
    assertEquals(gameCurrent,gameState);
    
    //check if game is over
    expected = true;
    actual = mb.isGameOver();
    assertEquals(expected, actual);
    
    //check score
    scoreExpected = 1;
    scoreActual = mb.getScore();
    
    assertEquals(scoreExpected, scoreActual);
   
    
  }
  
  /**
   * This method tests the getScore method in a standard sized game. 
   */
  @Test
  public void testGetScore() {
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl();
   
    int actual = 32;
    int expected = mb.getScore();
        
    assertEquals(expected, actual);
    
    mb.move(3, 5, 3, 3);
    mb.move(1, 4, 3, 4);
    
    actual = 30;
    expected = mb.getScore();
    
    assertEquals(expected, actual);
    
    mb.move(2, 6, 2, 4);
    
    mb.move(4, 6, 2, 6);
    
    mb.move(2, 3, 2, 5);
    
    actual = 27;
    expected = mb.getScore();
    
    assertEquals(expected, actual);
    
    
    
    
    
  }
  
  /**
   * This method tests the getScore method. 
   */
  @Test
  public void getScoreTest() {
    
    MarbleSolitaireModelImpl mb = new MarbleSolitaireModelImpl(5);
    
    //beginning game score
    
    int scoreExpected = 104;
    int scoreActual = mb.getScore();
    
    assertEquals(scoreExpected, scoreActual);
    
    
    MarbleSolitaireModelImpl mb2 = new MarbleSolitaireModelImpl(7);
    
    //beginning game score
    
    int scoreExpected2 = 216;
    int scoreActual2 = mb2.getScore();
    
    assertEquals(scoreExpected2, scoreActual2);
        

    

    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}

