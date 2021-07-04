package cs5004.animator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.awt.Color;

/**
 * Test file for the concrete Rectangle Class.
 * @author Katie Lowen
 */
public class RectangleTest {

  /**
   * Method tests the constructor and toString for the Rectangle Object Class.
   */
  @Test
  public void testConstructor() {
    
    Shape  r = new Rectangle("R1",0.0,0.0, 1.0, 1.0, Color.BLUE, 1, 2, 1);
    
    String expected = "Name: R1\n"
        + "Type: rectangle\n"
        + "Min corner: (0,0), Width: 1, Height: 1, Color: (0,0,255)\n"
        + "appears at t=1\n"
        + "disappears at t=2";
    
    assertEquals(expected, r.toString());
    
    
    
    Shape  r2 = new Rectangle("R2", 2.0,2.0, 3.0, 3.0, Color.RED, 2, 5, 3);
    
    String expected2 = "Name: R2\n"
        + "Type: rectangle\n"
        + "Min corner: (2,2), Width: 3, Height: 3, Color: (255,0,0)\n"
        + "appears at t=2\n"
        + "disappears at t=5";
    
    assertEquals(expected2, r2.toString());

  }
  
  /**
   * Tests an exception being thrown if width or height is a negative value. 
   */
  @Test
  public void testFailConstructor() {
    //negative width
    
    try {
      Shape  r = new Rectangle("R1",-1.0,0.0, -1.0, 0.0, Color.BLUE, 0, 0, 0);

      
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage() );
      
      
    }
    try {
      Shape  r = new Rectangle("R1",-1.0,0.0, 1.0, -1.0, Color.BLUE, 0, 0, 0); 
    
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
      Shape  r1 = new Rectangle("R1",-1.0,0.0, 1.0, 0.0, Color.BLUE, -1, 0, 1);

      
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage());
      
      
    }
    try {
      Shape  r1 = new Rectangle("R1",-1.0,0.0, 1.0, -1.0, Color.BLUE, 0, 3, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  r1 = new Rectangle("R1",-1.0,0.0, -1.0, 1.0, Color.BLUE, 0, 3, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Height and width cannot be a negative number";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  r1 = new Rectangle("R1",-1.0,0.0, 1.0, 1.0, Color.BLUE, 6, 3, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "timeAppears must be before timeDisappears";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  r1 = new Rectangle("R1",-1.0,0.0, 1.0, 1.0, Color.BLUE, 1, 1, 1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "timeAppears must be before timeDisappears";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  r1 = new Rectangle("R1",1.0,0.0, 1.0, 1.0, Color.BLUE, 3, 6, -1); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Speed must be positive";
      assertEquals(expected, e.getMessage());
 
    }
    
    try {
      Shape  r1 = new Rectangle("R1",1.0,0.0, 1.0, 1.0, Color.BLUE, 3, 6, 0); 
    
    } catch (IllegalArgumentException e) {
      String expected = "Speed must be positive";
      assertEquals(expected, e.getMessage());
 
    }
    
    
  }
  
  
  
  

}
  
