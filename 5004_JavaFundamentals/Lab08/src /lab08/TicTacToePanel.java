package lab08;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TicTacToePanel extends JPanel {
  
  TicTacToeModel model;
  
 public TicTacToePanel(TicTacToeModel model) {
    super(true);
    
    this.setBackground(Color.WHITE);
    this.setSize(500, 500);
    this.setLocation(0, 50);
    
    this.model = model;
  }
  
 public void updateModel(TicTacToeModel model) {
    this.model = model;
    this.repaint();
  }
 
 @Override
 public void paintComponent(Graphics g) {
   super.paintComponent(g);
   
   g.fillRect(165, 0, 2, 500);
   g.fillRect(332, 0, 2, 500);
   
   g.fillRect(0, 165, 500, 2);
   g.fillRect(0, 332, 500, 2);
   
   for(int i = 0; i<3; i++) {
     for(int j = 0; j < 3; j++) {
       Player p = model.getMarkAt(i, j);
       
       if (p == Player.O) {
         g.fillOval(j*167 + 45, i*167 + 45, 75, 75);
       }
       else if(p == Player.X) {
         g.fillRect(j*167 + 45, i*167 + 45, 75, 75);
       }
     }
   }
   
   
 }

}
