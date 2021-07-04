import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class ShapeTest {

  @Test
  public void testShapeList() {
    PlaceholderShape shapeS = new PlaceholderShape();
    Shape  r = new Rectangle(0.0,0.0, 0.0, 0.0, Color.BLUE, 0, 0, 0, shapeS);
    Shape  e = new Ellipse(1.0,1.0, 0.0, 3.0, Color.BLUE, 2, 5, 3, shapeS);
    
    e = e.addShape(r);
    
    
    String expected = "Name: Rectangle1\n"
        + "Type: Rectangle\n"
        + "Min Corner: (0.0,0.0), Width: 0.0, Height: 0.0, Color: (0,0,255)\n"
        + "Appears at t = 0 \n"
        + "Disappears at t = 0\n"
        + "Name: Ellipse1\n"
        + "Type: Ellipse\n"
        + "Center: (1.0,1.0), Width: 0.0, Height: 3.0, Color: (0,0,255)\n"
        + "Appears at t = 2\n"
        + "Disappears at t = 5";
    
    String actual = e.toString();
    assertEquals(expected, actual);

  }
  

}
