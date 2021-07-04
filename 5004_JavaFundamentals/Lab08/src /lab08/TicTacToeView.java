package lab08;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToeView extends JFrame implements ActionListener{
  
  private TicTacToePanel tttPanel;  
  private JPanel buttonPane;
  private JButton quitButton;  
  private JButton submitButton;  
  private JTextField moveInput;
  private JMenuBar menu;
  private JMenu file;
  private JMenuItem quit;
  
  
  
  private TicTacToeModel model;
  //jLabel puts label beside a text field
  //take in text using Jtextfield 
  
  //do not give final project view the model, get the controller to give it the 
  //TicTacToe model view implemented by the model --> the methods should only be getters
  //so that the view can "get" the correct pieces from the model
  
  //super wants a string that will label the window 
  
  public TicTacToeView(TicTacToeModel model) {
    super("Tic Tac Toe");
    this.model = model;
    this.setBackground(Color.white);
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    
    menu = new JMenuBar();
    
    this.setJMenuBar(menu);
    file = new JMenu("File");
    
    menu.add(file);
    quit = new JMenuItem("Quit");
    
    quit.setName("Quit");
    quit.addActionListener(this);
    
    file.add(quit);
    
    
    buttonPane = new JPanel(true);
    buttonPane.setBackground(Color.WHITE);
    buttonPane.setSize(200,500);
    
    //0,0 is upper left
    buttonPane.setLocation(0, 0);
    buttonPane.setLayout(new FlowLayout());
    
    
    
    this.add(buttonPane);
    quitButton = new JButton("Quit"); 
    quitButton.setName("Quit");
    quitButton.addActionListener(this);
    buttonPane.add(quitButton);
    
    submitButton = new JButton("Move");
    submitButton.setName("Move");
    submitButton.addActionListener(this);
    buttonPane.add(submitButton);
    
    moveInput = new JTextField(5);
    
    buttonPane.add(moveInput);
    
    tttPanel = new TicTacToePanel(this.model);
    
    this.add(tttPanel);
    
    
    this.setVisible(true);
    
    tttPanel.repaint();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
  
  //repaint will update the display --> method will call paint component 
  
  public void display() {
    tttPanel.repaint();
    this.repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Component b = (Component) e.getSource();
    
    if (b.getName() == "Quit") {
    System.exit(0);
    }
    else if(b.getName() == "Move") {
      String in = moveInput.getText();
      int row;
      int col;
      if(in.isEmpty() || in.isBlank() || in == null) {
        JOptionPane.showMessageDialog(this, "Enter two numbers");       
        
      }
      else {
        Scanner scan = new Scanner(in);
        String s = "";
        
        try {
        s = scan.next();
      }catch (NoSuchElementException e2) {
        JOptionPane.showMessageDialog(this, "enter two numbers!"); 
        scan.close();
        return;
      }
        
        try {
          row = Integer.parseInt(s);
          
        } catch (NumberFormatException notNumber) {
          JOptionPane.showMessageDialog(this, "Enter two numbers"); 
          scan.close();
          return;
        }
        
        try {
          col = Integer.parseInt(s);
          
        } catch (NumberFormatException notNumber) {
          JOptionPane.showMessageDialog(this, "Enter two numbers"); 
          scan.close();
          return;
        }
        
        if(scan.hasNext()) {
         

            JOptionPane.showMessageDialog(this, "Only enter two numbers"); 
            scan.close();
            return;
          
        }
        
        try {
          model.move(row-1, col-1);
          tttPanel.updateModel(model);
        } catch (IllegalStateException occupiedPosition) {
          JOptionPane.showMessageDialog(tttPanel, occupiedPosition.getMessage()); 

        } catch (IllegalArgumentException ae) {
          JOptionPane.showMessageDialog(this, ae.getMessage()); 
 
        }
        scan.close();
        
        if(model.isGameOver()) {
          String out = "Game Over";
          
          if(this.model.getWinner() != null) {
            out += "\n Winner is " + this.model.getWinner().toString();
          }
          else {
            out += "Game was a tie";
          }
          
          JOptionPane.showMessageDialog(tttPanel, out); 
          System.exit(0);

          
          
          
          
        }
          
        }
      
      
    
      
    }
    
  }
  

  
  
  
  
  
  

}
