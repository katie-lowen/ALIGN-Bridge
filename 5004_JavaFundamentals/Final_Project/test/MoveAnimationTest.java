package cs5004.animator.model;
import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class MoveAnimationTest {

  @Test
  public void testConstructorAndToString() {
   
   
    Shape shape = new Rectangle("R1", 1.0, 1.0, 1.0, 1.0, Color.RED, 2, 5, 1);
    MoveAnimation move = new MoveAnimation(shape, 1, 5, 1.0, 1.0, 3.0, 3.0);
    String actual  = move.toString();
    String expected = "R1 moves from (1, 1) to (3, 3) from time t=1 to t=5";
    assertEquals(expected, actual);
   
  }
  
  
  
  @Test
  public void moveXSvgTestec() {
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("P", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    MoveAnimation move = new MoveAnimation(shape1, 1000, 5000, 200.0, 3.0, 300.0, 3.0);
    
    String actual = move.SVGString();
    
    String expected = "<!--P moves from (200, 3) to (300, 3) from "
        + "time t=1000 to t=5000 -->\n"
        + "<animate attributeType=\"xml\" "
        + "begin=\"1000ms\" dur=\"4000ms\" attributeName=\"x\" "
        + "from=\"200\" to=\"300\" fill=\"freeze\" />"
        + "\n</rect>\n"
        + "</svg>";
    
    assertEquals(expected, actual);
  }

  @Test
  public void moveYSvgTestRec() {
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("P", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    MoveAnimation move = new MoveAnimation(shape1, 1000, 5000, 200.0, 3.0, 200.0, 5.0);
    
    String actual = move.SVGString();
    
    String expected = "<!--P moves from (200, 3) to (200, 5) from "
        + "time t=1000 to t=5000 -->\n"
        + "<animate attributeType=\"xml\" "
        + "begin=\"1000ms\" dur=\"4000ms\" attributeName=\"y\" "
        + "from=\"3\" to=\"5\" fill=\"freeze\" />"
        + "\n</rect>\n"
        + "</svg>";
    
    assertEquals(expected, actual);
  }
  
  @Test
  public void moveXSvgTestEll() {
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Ellipse("E", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    MoveAnimation move = new MoveAnimation(shape1, 2000, 7000, 500.0, 3.0, 600.0, 3.0);
    
    String actual = move.SVGString();
    
    String expected = "<!--E moves from (500, 3) to (600, 3) from "
        + "time t=2000 to t=7000 -->\n"
        + "<animate attributeType=\"xml\" begin=\"2000ms\""
        + " dur=\"5000ms\" attributeName=\"cx\" "
        + "from=\"500\" to=\"600\" fill=\"remove\" />"
        + "\n</ellipse>\n"
        + "</svg>";
    
    assertEquals(expected, actual);
  }

  @Test
  public void moveYSvgTestEll() {
  AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Ellipse("P", 200.0, 3.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    MoveAnimation move = new MoveAnimation(shape1, 2000, 7000, 200.0, 100.0, 200.0, 400.0);
    
    model.addAnimation(move);
    String actual = move.SVGString();
    
    String expected = "<!--P moves from (200, 100) to (200, 400) from "
        + "time t=2000 to t=7000 -->\n"
        + "<animate attributeType=\"xml\" begin=\"2000ms\" "
        + "dur=\"5000ms\" attributeName=\"cy\" from=\"100\" "
        + "to=\"400\" fill=\"remove\" />"
        + "\n</ellipse>\n"
        + "</svg>";
    
    assertEquals(expected, actual);
    
//    model.toStringSVG();
//    
//    assertEquals(expected, model.toStringSVG());
    
  }
  


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
