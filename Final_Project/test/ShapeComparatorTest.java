package cs5004.animator.model;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ShapeComparatorTest {

  @Test
  public void test() {
    Shape shape1 = new Rectangle("R", 200.0, 200.0, 50.0, 100.0, Color.RED, 200, 300, 1);
    Shape shape2 = new Ellipse("E", 500.0, 100.0, 60.0, 30.0, Color.BLUE, 1, 100, 1);
    
    
    List shapeList = new ArrayList<Shape>();
    shapeList.add(shape1);
    shapeList.add(shape2);
    
    Collections.sort(shapeList);
    
    String actualS = "";
    
    for(Object shape : shapeList) {
    int actual = shape2.compareTo(shape1);
    actualS += shape.toString();
    }
    
    assertEquals(shape2.toString() + shape1.toString(), actualS);
    
    
   
  }
  
  

}
