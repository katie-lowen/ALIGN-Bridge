package cs5004.animator.model;
import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;


public class ChangeColorAnimationTest {

  @Test
  public void testConstructorAndToString() {

   Shape shape = new Rectangle("R1",1.0, 1.0, 1.0, 3.0, Color.RED, 1, 5, 1);
   ChangeColorAnimation colorObject = new ChangeColorAnimation(shape, 1, 5, Color.RED, Color.BLUE);
   String actual  = colorObject.toString();
   String expected = "R1 changes from rgb(255,0,0) to rgb(0,0,255) from time t=1 to t=5";
   assertEquals(expected, actual);
   
   
   
  }
  
  @Test
  public void testChangeColorRectSVG() {
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("R", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    Animation newColor = new ChangeColorAnimation(shape1, 1, 5, Color.RED, Color.BLUE);
    
    String actual = newColor.SVGString();
    
    String expected = "<!--R changes from rgb(255,0,0) to rgb(0,0,255) from "
        + "time t=1 to t=5 -->\n"
        + "<animateColor attributeName=\"fill\" attributeType=\"xml\" begin=\"1ms\""
        + " dur=\"4ms\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" />"
        + "\n</rect>\n"
        + "</svg>";
    
    assertEquals(expected, actual);
  
  }
  
  @Test
  public void testChangeColorEllSVG() {
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Ellipse("E", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    Animation newColor = new ChangeColorAnimation(shape1, 1, 5, Color.RED, Color.BLUE);
    
    String actual = newColor.SVGString();
    
    String expected = "<!--E changes from rgb(255,0,0) to rgb(0,0,255) from "
        + "time t=1 to t=5 -->\n"
        + "<animateColor attributeName=\"fill\" attributeType=\"xml\" begin=\"1ms\""
        + " dur=\"4ms\" "
        + "from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" />"
        + "\n</ellipse>\n"
        + "</svg>";
    
    
    assertEquals(expected, actual);
  
  }
}
