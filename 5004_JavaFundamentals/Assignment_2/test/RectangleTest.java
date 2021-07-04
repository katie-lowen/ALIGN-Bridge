import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Random;



/**
 * This is a junit test for the Rectangle Class.
 * @author Katie Lowen
 */
public class RectangleTest {

  private Rectangle sample;
  private Rectangle otherSample;
  private Rectangle otherSample2;
  private Rectangle otherSample3;
  private Rectangle otherSample4;
  
  /**
   * This method creates two sample Rectangles to be used in testing.
   */
  @Before
  public void testExpected() {
    this.sample = new Rectangle(0,0, 3, 4);
    this.otherSample = new Rectangle(1, 1, 4, 2);
    this.otherSample2 = new Rectangle(4, 2, 1, 1);
    this.otherSample3 = new Rectangle(0, 0, 4, 2);
    this.otherSample4 = new Rectangle(0,0, 2, 3);
    
  }
  
  /**
   * This method tests our rectangle constructor. We expect the constructor to fail
   * because in our Class, we are unable to have negative height or width values. 
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRectangleFail() {
    
    Rectangle failRectangle = new Rectangle(0,0, -4, 2);
    
    try {
      failRectangle.toString();
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("Width or Height cannot be a negative number", exception);
    }
   
    Rectangle failRectangle2 = new Rectangle(0,0, 4, -2);
    
    try {
      failRectangle2.toString();
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("Width or Height cannot be a negative number", exception);
    }
    
    Rectangle failRectangle3 = new Rectangle(0,0,-4,-2);
    
    try {
      failRectangle3.toString();
    }
    catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("Width or Height cannot be a negative number", exception);
    }
    
  }
    
  /**
   * This method tests our rectangle constructor. We expect the constructor to fail
   * because in our Class, we are unable to have negative height or width values. 
   * This test uses randomized values to construct rectangles that will throw an exception. 
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRectangleFail2() {
    //Randomized testing for the constructor and toString to fail
    Random r = new Random();
    int randomX;
    int randomY;
    int randomWidth;
    int randomHeight;
    
    for (int i = 0; i < 1000; i++) {
      randomX = (int) ((r.nextInt() - 0.5) * 1000);
      randomY = (int) ((r.nextInt() - 0.5) * 1000);
      randomWidth = (int) (r.nextInt() * -1000);
      randomHeight = (int) (r.nextInt() * -1000);
      Rectangle randomRectangle = new Rectangle(randomX, randomY, randomWidth, randomHeight);
      
      try {
        randomRectangle.toString();
      }
      catch (IllegalArgumentException e) {
        String exception = e.getMessage();
        assertEquals("Width or Height cannot be a negative number", exception);
      }
      
    }
    
  }
  
  /**
   * This method tests the constructor and toString method. 
   * The randomized test created randomized numbers between -500 and 500
   * for x and y, and randomized numbers between 0 and 1000 for width and height. 
   * We use the toString method to analyze if our constructor and toString work. 
   */
  @Test
  public void testToString() {
      
    Random r = new Random();
    int randomX;
    int randomY;
    int randomWidth;
    int randomHeight;
    
    for (int i = 0; i < 1000; i++) {
      randomX = (int) ((r.nextInt() - 0.5) * 1000);
      randomY = (int) ((r.nextInt() - 0.5) * 1000);
      randomWidth = (int) (r.nextInt(1000) * 1000);
      randomHeight = (int) (r.nextInt(1000) * 1000);
      Rectangle randomRectangle = new Rectangle(randomX, randomY, randomWidth, randomHeight);
      String expected = String.format("x:%d, y:%d, w:%d, h:%d", randomX, 
          randomY, randomWidth, randomHeight);
      String actual = randomRectangle.toString();
      
      assertEquals(expected, actual);
      
    }    

  }

  /**
   * This method tests the overlap method. We have created 5 distinct rectangles,
   * where 3 should pass as true and 2 as false. 
   */
  @Test
  public void testOverlap() {
    assertEquals(true, this.sample.overlap(otherSample));
    assertEquals(false, this.sample.overlap(otherSample2));
    assertEquals(true, this.otherSample.overlap(otherSample2));
    assertEquals(false, this.otherSample2.overlap(otherSample3));
    assertEquals(true, this.sample.overlap(otherSample4));
    
    //testing for a rectangle that is exactly the same size
    
    Rectangle rectangle1 = new Rectangle(0, 0, 3, 4);
    Rectangle rectangle2 = new Rectangle(0, 0, 3, 4);
    
    assertEquals(true, rectangle1.overlap(rectangle2));
  }
  
  /**
   * This method tests the overlap method. We have created a rectangle that is large 
   * enough to guarantee that our random rectangles will always fall inside of the 
   * sample rectangle. 
   * 
   */
  @Test
    public void testOverlapInside() {
    //Testing overlap function for rectangles that are inside of a larger rectangle
    Random r = new Random();
    double randomDoubleX;
    double randomDoubleY;
    double randomDoubleWidth;
    double randomDoubleHeight;

    for (int i = 0; i < 1000; i++) {
      randomDoubleX = (r.nextDouble() - 0.5 * 100);
      randomDoubleY = (r.nextDouble() - 0.5 * 100);
      randomDoubleWidth = (r.nextDouble() * 100);
      randomDoubleHeight = (r.nextDouble() * 100);
      int randomX = (int)randomDoubleX;
      int randomY = (int)randomDoubleY;
      int randomWidth = (int)randomDoubleWidth;
      int randomHeight = (int)randomDoubleHeight;
      
      Rectangle randomRectangle = new Rectangle(randomX, randomY, randomWidth, randomHeight);
      Rectangle testRectangle2 = new Rectangle(-100, -100, 200, 200);
      
      assertEquals(true, testRectangle2.overlap(randomRectangle));
    }  
  
  }
  
  /**
   * This method tests the overlap method. This test creates a rectangle that will 
   * overlap with the Random Rectangle's range. This method should always return true. 
   */
  @Test 
  public void testOverlapRandom() { 
    Random r = new Random();
    double randomDoubleX;
    double randomDoubleY;
    double randomDoubleWidth;
    double randomDoubleHeight;

    for (int i = 0; i < 1000; i++) {
      randomDoubleX = (r.nextDouble() - 0.5 * 1000);
      randomDoubleY = (r.nextDouble() - 0.5 * 1000);
      randomDoubleWidth = (r.nextDouble() * 1000);
      randomDoubleHeight = (r.nextDouble() * 1000);
      int randomX = (int)randomDoubleX;
      int randomY = (int)randomDoubleY;
      int randomWidth = (int)randomDoubleWidth;
      int randomHeight = (int)randomDoubleHeight;
      
      Rectangle randomRectangle = new Rectangle(randomX, randomY, randomWidth, randomHeight);
      Rectangle testRectangle2 = new Rectangle(-1000, -1000, 1200, 1200);
      
      assertEquals(true, testRectangle2.overlap(randomRectangle));
      
    }
    
  }
  
  /**
   * This method tests the intersect method. In this method we test for the
   * calculated overlaps using the given rectangles. 
   */
  @Test
  public void testIntersect() {
    // tests top right
    Rectangle testRectangle = new Rectangle(1, 1, 2, 2);
    
    assertEquals(testRectangle.toString(), this.sample.intersect(otherSample).toString());
    
    //tests bottom right
    Rectangle bottomRight = new Rectangle(4, 0, 2, 3);
    Rectangle expected = new Rectangle(4, 1, 1, 2);
    
    assertEquals(expected.toString(), otherSample.intersect(bottomRight).toString());
    
    //test bottom left
    
    Rectangle bottomLeft = new Rectangle(-1, 0, 3, 2);
    Rectangle expectedLeft = new Rectangle(1, 1, 1, 1);
    
    assertEquals(expectedLeft.toString(), otherSample.intersect(bottomLeft).toString());
    
    //tests top left
    
    Rectangle topLeft = new Rectangle(-1, 1, 2, 3);
    Rectangle expectedTopL = new Rectangle(0, 1, 1, 2);
    
    assertEquals(expectedTopL.toString(), otherSample4.intersect(topLeft).toString());
  
    
  }
  
  /**
   * This method uses random testing to test the exception thrown the intersect method. 
   * In this test, there is a random rectangle created that is guaranteed to not
   * overlap with the sample rectangle.
   * (expected = NoSuchElementException.class)
   */
  @Test
  public void testIntersectFail() {
    Random r = new Random();
    double randomDoubleX;
    double randomDoubleY;
    double randomDoubleWidth;
    double randomDoubleHeight;
    
    // x = -500 to +500
    //y = -500 to +500
    // width = max 1000
    //height = max 1000
    //max rect range is 500 + 100 = 1500 
   
    Rectangle testIntersectFail = new Rectangle(2000, 2000, 3, 4);
    
    for (int i = 0; i < 1000; i++) {
      randomDoubleX = (r.nextDouble() * 1000);
      randomDoubleY = (r.nextDouble() * 1000);
      randomDoubleWidth = (r.nextDouble() * 1000);
      randomDoubleHeight = (r.nextDouble() * 1000);
      int randomX = (int)randomDoubleX;
      int randomY = (int)randomDoubleY;
      int randomWidth = (int)randomDoubleWidth;
      int randomHeight = (int)randomDoubleHeight;
      
      Rectangle randomRectangle = new Rectangle(randomX, randomY, randomWidth, randomHeight);
      
      try {
        randomRectangle.intersect(testIntersectFail);
        
      }
      catch (NoSuchElementException e) {
        String exception = e.getMessage();
        assertEquals("These rectangles do not overlap!", exception);
            
      }
      
    }
  }
    
  /**
   * This method tests the union method. There are 4 different scenarios tested 
   * in this method. One for each corner of the base rectangle. 
   */
  @Test 
  public void testUnion() {
    
    //top right DONE
    
    Rectangle testRectangle = new Rectangle(0, 0, 5, 4);
    
    assertEquals(testRectangle.toString(), this.sample.union(otherSample).toString());
 
    //test lower right DONE
    
    Rectangle lowerRight = new Rectangle(3, 0, 1, 1);
    Rectangle expectedLeft = new Rectangle(1, 0, 6, 3);
    
    assertEquals(expectedLeft.toString(), otherSample.union(lowerRight).toString());
    
    //tests lower left DONE
    Rectangle lowerleft = new Rectangle(-1, -1, 2, 1);
    Rectangle expected = new Rectangle(-1, -1, 6, 4);
    
    assertEquals(expected.toString(), otherSample.union(lowerleft).toString());
    
    //tests top left
    
    Rectangle topLeft = new Rectangle(-2, 1, 2, 5);
    Rectangle expectedTopL = new Rectangle(-2, 0, 4, 6);
    
    assertEquals(expectedTopL.toString(), otherSample4.union(topLeft).toString());
    
    //tests two rectangles exactly the same
    Rectangle same1 = new Rectangle(0, 0, 4, 5);
    Rectangle same2 = new Rectangle(0, 0, 4, 5);
    
    assertEquals(same1.toString(), same1.union(same2).toString());
    
  }
  
  /**
   * This method uses randomized testing to test the union method. 
   * The test creates random rectangles that are guaranteed to fall within the larger
   * rectangle. This means that the union result will always be the larger rectangle. 
   */
  @Test
  public void testUnion2() {
    Random r = new Random();
    double randomDoubleX;
    double randomDoubleY;
    double randomDoubleWidth;
    double randomDoubleHeight;

    for (int i = 0; i < 1000; i++) {
      randomDoubleX = (r.nextDouble() - 0.5 * 100);
      randomDoubleY = (r.nextDouble() - 0.5 * 100);
      randomDoubleWidth = (r.nextDouble() * 100);
      randomDoubleHeight = (r.nextDouble() * 100);
      int randomX = (int)randomDoubleX;
      int randomY = (int)randomDoubleY;
      int randomWidth = (int)randomDoubleWidth;
      int randomHeight = (int)randomDoubleHeight;
      
      Rectangle randomRectangle = new Rectangle(randomX, randomY, randomWidth, randomHeight);
      Rectangle testRectangle2 = new Rectangle(-1000, -1000, 1200, 1200);
      
      assertEquals(testRectangle2.toString(), randomRectangle.union(testRectangle2).toString());
    
    }
  
  }
  
}

    
    
   
  
  
  
  


