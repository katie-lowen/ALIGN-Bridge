package cs5004.tictactoe;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Creates a Controller for the TicTacToe Game. 
 * @author Katie Lowen
 *
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private final Readable in;
  private final Appendable out;
  
  /**
   * Constructor for the controller for the tic tac toe game. 
   * @param in Input to the Controller. 
   * @param out Output to the Controller. 
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    this.in = in;
    this.out = out;

  }

  @Override
  public void playGame(TicTacToe m) throws IllegalStateException {
    Scanner scan = new Scanner(this.in);
    boolean moveMade = false;
     
    while (!m.isGameOver()) {
      if (!moveMade) {
             
        try {
          this.out.append(m.toString() + "\n");
        }
        catch (IOException e) {
          throw new IllegalStateException();
          
        }
        
        try {
          this.out.append("Enter a move for " + m.getTurn().toString() + ":\n");
        }
        catch (IOException e) {
          throw new IllegalStateException();
        } 
      
      }
      String r = "";
      String c = "";
   
      
      try {
        r = scan.next();
        if (r.equalsIgnoreCase("q") ) {
          try {
            this.out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
            return;
          }
          catch (IOException e) {
            throw new IllegalStateException();
          }
        }
        else {
          c = scan.next();
          if (c.equalsIgnoreCase("q") ) {
            try {
              this.out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
              return;
            }
            catch (IOException e) {
              throw new IllegalStateException();
            }
          }
        }
        
      } catch (NoSuchElementException e) {
        throw new IllegalStateException();
      }
      
      
      int row = 0;
      int column = 0;
      try {
        
        row = Integer.parseInt(r);
        column = Integer.parseInt(c);
      } catch (NumberFormatException e) {
        moveMade = true;
        
      
      }
      
      
      
      try {
        row -= 1;
        column -= 1;
        m.move(row, column);
        moveMade = false;
      } catch (IllegalArgumentException e) {
        try {
          this.out.append(e.getMessage() + "\n");
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      } catch (IllegalStateException e) {
        throw new IllegalStateException();
        
        
      }      
      
    }
  
    
    try {
      this.out.append(m.toString() + "\n");
      this.out.append("Game is over!");
      if (m.getWinner() != null) {
        this.out.append(m.getWinner().toString() + " wins.");
      } else {
        this.out.append(" Tie game.");
      }
    } catch (IOException e) {
      throw new IllegalStateException();
    }
    scan.close();
    
    return;


  }
  

}
