package cs5004.animator.model;
import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

/**
 * Tests the ResizeHeightAnimation object. 
 * @author Katie Lowen
 *
 */
public class ResizeHeightAnimationTest {

  /**
   * Tests the constructor and toString for the ResizeHeightAnimation class. 
   */
  @Test
  public void testConstructorAndToString() {
   
   
   Shape shape = new Rectangle("R1",1.0, 1.0, 1.0, 1.0, Color.RED, 1, 5, 1);
   ResizeHeightAnimation changeHeight = new ResizeHeightAnimation(shape, 1, 5, 1.0, 4.0);
   String actual  = changeHeight.toString();
   String expected = "Shape1 changes height from 1.0 to 4.0 from time t=1 to t=5";
   assertEquals(expected, actual);
   
  }

}
