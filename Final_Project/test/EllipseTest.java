package cs5004.animator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.awt.Color;

/**
 * Tests the Abstract Shape concrete class Ellipse. 
 * @author Katie Lowen
 *
 */
public class EllipseTest {

    
  /**
   * Method tests the constructor and toString for the Ellipse Object Class.
   */
  @Test
  public void testConstructor() {
    
    
    Shape  e = new Ellipse("E1", 1.0,1.0, 1.0, 3.0, Color.BLUE, 2, 5, 3);
    
    String expected = "Name: E1\n"
        + "Type: ellipse\n"
        + "Center: (1,1), Width: 1, Height: 3, Color: (0,0,255)\n"
        + "Appears at t=2\n"
        + "Disappears at t=5";
    
    assertEquals(expected, e.toString());
  
    
    Shape  e2 = new Ellipse("E2",3.0, 1.0, 3.0, 1.0, Color.GREEN, 3, 6, 3);
    
    String expected2 = "Name: E2\n"
        + "Type: ellipse\n"
        + "Center: (3,1), Width: 3, Height: 1, Color: (0,255,0)\n"
        + "Appears at t=3\n"
        + "Disappears at t=6";
    
    assertEquals(expected2, e2.toString());
    
    
    
    Shape  e3 = new Ellipse("E3",0.0, 0.0, 3.0, 5.0, Color.RED, 0, 1, 5);
    
    String expected3 = "Name: E3\n"
        + "Type: ellipse\n"
        + "Center: (0,0), Width: 3, Height: 5, Color: (255,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=1";
    
    assertEquals(expected3, e3.toString());
    
    
    Shape  e4 = new Ellipse("E4",0.0,0.0, 1.0, 1.0, Color.RED, 0, 3, 5);
    
    String expected4 = "Name: E4\n"
        + "Type: ellipse\n"
        + "Center: (0,0), Width: 1, Height: 1, Color: (255,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=3";
    
    assertEquals(expected4, e4.toString());

  }
  
  /**
   * Tests an exception being thrown if width or height is a negative value. 
   */
  @Test
  public void testFailConstructor() {
    
    //negative width
    try {
      Shape  e1 = new Ellipse("E1",-1.0,0.0, -1.0, 0.0, Color.BLUE, 0, 0, 1);

      
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage());
      
      
    }
    try {
      Shape  e1 = new Ellipse("E1",-1.0,0.0, 1.0, -1.0, Color.BLUE, 0, 0, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage());
 
    }
  }
  
  /**
   * Tests an exception being thrown if timeAppears or timeDisappears is a negative value. 
   */
  @Test
  public void testFailConstructorTime() {
    
    //negative width
    try {
      Shape  e1 = new Ellipse("E1",-1.0,0.0, 1.0, 0.0, Color.BLUE, -1, 0, 1);

      
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage());
      
      
    }
    try {
      Shape  e1 = new Ellipse("E1",-1.0,0.0, 1.0, -1.0, Color.BLUE, 0, 3, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  e1 = new Ellipse("E1",-1.0,0.0, -1.0, 1.0, Color.BLUE, 0, 3, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  e1 = new Ellipse("E1",-1.0,0.0, 1.0, 1.0, Color.BLUE, 6, 3, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "timeAppears must be before timeDisappears";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  e1 = new Ellipse("E1",-1.0,0.0, 1.0, 1.0, Color.BLUE, 1, 1, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "timeAppears must be before timeDisappears";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  e1 = new Ellipse("E1",1.0,0.0, 1.0, 1.0, Color.BLUE, 3, 6, -1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Speed must be positive";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  e1 = new Ellipse("E1",1.0,0.0, 1.0, 1.0, Color.BLUE, 3, 6, 0); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Speed must be positive";
      assertEquals(expected, e.getMessage());
 
    }
    
    
  }
  

  
  

}
  
