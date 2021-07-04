package lab08;

public class TicTacToeGUIController implements TicTacToeController {
  private TicTacToeView view;
  
  //want view to be a window 
  
  public TicTacToeGUIController(TicTacToeView view) {
    this.view = view;
    
  }

  @Override
  public void playGame(TicTacToe m) {
    view.display();
    
    
  }

}
