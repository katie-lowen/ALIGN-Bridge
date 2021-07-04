import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class ChangeSpeedAnimationTest {

  /**
   * Tests the constructor and toString for the ChangeSpeedAnimation class. 
   */
  @Test
  public void testConstructorAndToString() {
   
   
   Shape shape = new Rectangle("R1",1.0, 1.0, 1.0, 1.0, Color.RED, 1, 5, 1);
   ChangeSpeedAnimation changeSpeed = new ChangeSpeedAnimation(shape, 1, 5, 1, 4);
   String actual  = changeSpeed.toString();
   String expected = "R1 changes speed from 1 to 4 from time t=1 to t=5";
   assertEquals(expected, actual);
   
  }

}
