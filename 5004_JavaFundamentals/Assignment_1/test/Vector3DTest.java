import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit test for the Vector3D class.
 * @author Katie Lowen
 *
 */
public class Vector3DTest {

  private Vector3D sample;
  private Vector3D otherSample;
  
 
  /**
   * This method creates two sample vectors to be used throughout the testing. 
   */
  @Before
  public void testExpected() {
    this.sample = new Vector3D(4.00, 2.00, 4.00);
    this.otherSample = new Vector3D(1.00, 2.00, 2.00);

  }

  /**
   * This method tests the getX method with the expected value of x. 
   */
  @Test
  public void testX() {
    assertEquals(4.00, this.sample.getX(), 0.01);
  }

  /**
   * This method tests the getY method with the expected value of y. 
   */
  @Test 
  public void testY() {
    assertEquals(2.00, this.sample.getY(), 0.01);
  }

  /**
   * This method tests the getZ method with the expected value of z. 
   */
  @Test
  public void testZ() {
    assertEquals(4.00, this.sample.getZ(), 0.01);
  }

  /**
   * This method tests the toString method by comparing it to the expected String result. 
   */
  @Test
  public void testToString() {
    assertEquals("(4.00,2.00,4.00)", this.sample.toString());
  }

  /**
   * This method tests the getMagnitude method with the expected values of magnitude. 
   */
  @Test
  public void testGetMagnitude() {

    assertEquals(6.00, this.sample.getMagnitude(), 0.01);
    assertEquals(3.00, this.otherSample.getMagnitude(), 0.01);
  } 

  /**
   * This method tests the normalized method by comparing the expected string to the calculations. 
   * There is a try and catch block...
   */
  @Test
  public void testNormalize() {
    Vector3D sampleTestVector = this.sample.normalize();
    Vector3D expectedNormalizedVector = new Vector3D(0.67, 0.33, 0.67);
    assertEquals(expectedNormalizedVector.toString(), sampleTestVector.toString());
  }
  
  /**
   * This method tests the exception thrown in normalize method.
   */
  @Test (expected = IllegalArgumentException.class)
    public void testNormalizeFail() {
    Vector3D otherVector = new Vector3D(0.00, 0.00, 0.00);
    assertEquals(27.27, otherVector.normalize());
  }


  /**
   * This method tests the method add.
   */
  @Test
  //creating new sample vector and adding values together with original sample vector
  public void testAdd() {
    Vector3D otherVector = new Vector3D(1.00, 2.00, 2.00);
    Vector3D expectedVector = new Vector3D(5.00,4.00,6.00);
    Vector3D testAddVector = this.sample.add(otherVector);
    assertEquals(expectedVector.toString(), testAddVector.toString());
  }

  /**
   * This method tests the method multiply.
   */
  @Test
  //choosing constant of 2
  public void testMultiply() {
    double constant = 2.00;
    Vector3D multipliedVector = new Vector3D(8.00, 4.00, 8.00);
    Vector3D multipliedTestSample = this.sample.multiply(constant);
    assertEquals(multipliedVector.toString(), multipliedTestSample.toString());
  }

  /**
   * this method tests the dotProduct method.
   */
  @Test 
  //create new vector to test the dotProduct
  public void testDotProduct() {
    Vector3D otherVector = new Vector3D(1.00, 2.00, 2.00);
    assertEquals(16.00, this.sample.dotProduct(otherVector), 0.01);

  }

  /**
   * This method tests the angleBetween method.
   */
  @Test 
  //create new vector to test angleBetween
  public void testAngleBetween() {
    Vector3D otherVector = new Vector3D(1.00, 2.00, 2.00);
    assertEquals(27.27, this.sample.angleBetween(otherVector),0.01);
  }
  
  /**
   * This method tests the exception thrown in angleBetween method.
   */
  @Test (expected = IllegalArgumentException.class)
    public void testAngleBetweenFail() {
    Vector3D otherVector = new Vector3D(0.00, 0.00, 0.00);
    assertEquals(27.27, this.sample.angleBetween(otherVector),0.01);
  }

}