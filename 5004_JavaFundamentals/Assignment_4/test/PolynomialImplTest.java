import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class tests the PolynomialImpl class. 
 * @author Katie Lowen
 *
 */
public class PolynomialImplTest {

  /**
   * This method tests the PolynomialNode constructors. 
   */
  @Test
  public void testEmptyConstructor() {
    PolynomialNode empty = new PolynomialEmptyNode();
    String expected = "";
    String actual = empty.toString();
    
    assertEquals(expected, actual);
    
    Polynomial empty2 = new PolynomialImpl();
    
    String expected2 = "0";
    String actual2 = empty2.toString();
    assertEquals(expected2, actual2);
    
    
    
  }
  
  /**
   * This method tests the constructor IllegalArgumentException. 
   */
  @Test
  public void testConstructor2() {
    PolynomialNode empty = new PolynomialEmptyNode();
    try {
      empty = new PolynomialElementNode(3, -3, empty);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("Degree must be greater than 0", exception);
    }
    
    try {
      empty = new PolynomialElementNode(3, -7, empty);
      
    } catch (IllegalArgumentException e2) {
      String exception2 = e2.getMessage();
      assertEquals("Degree must be greater than 0", exception2);
    }
    
  }
    
  
  /**
   * This method tests the NodeConstructor using a a negative value.
   */
  @Test
  public void testToStringNegative() {
    PolynomialNode test = new PolynomialEmptyNode();
    test = test.addTerm(-2, 2);
    test = test.addTerm(-2,0);
    test = test.addTerm(3, 3);
    
    String expected = "3x^3 -2x^2 -2";
    String actual = test.toString();
    
    assertEquals(expected, actual);
    
    
  }
  
  /**
   * This method tests the string constructor.
   */
  @Test
  public void testStringConstructor() {

    Polynomial test7 = new PolynomialImpl("6x^3 +x^2 +3");

    
    String expected7 = "6x^3 +x^2 +3";
    String actual7 = test7.toString();
    
    assertEquals(expected7, actual7);
    
    Polynomial test8 = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    
    String expected8 = "-2x^5 -3x^4 +11x^1 -5";
    String actual8 = test8.toString();
    
    assertEquals(expected8, actual8);
    
    Polynomial test9 = new PolynomialImpl("4x^3 +3x^1 -5");
    
    String expected9 = "4x^3 +3x^1 -5";
    String actual9 = test9.toString();
    
    assertEquals(expected9, actual9);
    

    Polynomial testT = new PolynomialImpl("-x^3 +x +3");

    
    String expectedT = "-1x^3 +x^1 +3";
    String actualT = testT.toString();
    assertEquals(expectedT, actualT);
    
    

  }
  
  /**
   * This method tests the toString method. 
   */
  @Test
  public void toStringTest3() {
    Polynomial test5 = new PolynomialImpl();
    String expected = "0";
    String actual = test5.toString();
    
    assertEquals(expected, actual);
  }
  

  /**
   * This method tests the addTerm function. This function should 
   * be able to put a polynomial in decreasing order based on the degree. 
   * 
   */
  @Test
  public void testAddTerm() {
    PolynomialNode empty = new PolynomialEmptyNode();
    String expected = "";
    String actual = empty.toString();
    
    assertEquals(expected, actual);
    
    empty = empty.addTerm(4, 1);
    
    String expected2 = "4x^1";
    String actual2 = empty.toString();
    
    assertEquals(expected2, actual2);
    
    
    
    empty = empty.addTerm(3, 3);
    
    String expected3 = "3x^3 +4x^1";
    String actual3 = empty.toString();
    
    assertEquals(expected3, actual3);
    
    //add term out of order, should be 3x^3 + 2x^2 + 4x
    
    empty = empty.addTerm(2, 2);
    
    String expected4 = "3x^3 +2x^2 +4x^1";
    String actual4 = empty.toString();
    
    assertEquals(expected4, actual4);
    
    //add term to end
    empty = empty.addTerm(6, 6);
    
    String expected5 = "6x^6 +3x^3 +2x^2 +4x^1";
    String actual5 = empty.toString();
    
    assertEquals(expected5, actual5);
    
    //add term in between 
    empty = empty.addTerm(5, 5);
    
    String expected6 = "6x^6 +5x^5 +3x^3 +2x^2 +4x^1";
    String actual6 = empty.toString();
    
    assertEquals(expected6, actual6);
    
    //add term with no x value
    empty = empty.addTerm(2, 0);
    
    String expected7 = "6x^6 +5x^5 +3x^3 +2x^2 +4x^1 +2";
    String actual7 = empty.toString();
    
    assertEquals(expected7, actual7);
    
    //test add term with NEGATIVE coefficient
    
    empty = empty.addTerm(-5, 10);
    String expected8 = "-5x^10 +6x^6 +5x^5 +3x^3 +2x^2 +4x^1 +2";
    String actual8 = empty.toString();
    
    assertEquals(expected8, actual8);
    
    PolynomialNode emptyE = new PolynomialEmptyNode();
    emptyE = emptyE.addTerm(2, 0);
    String expectedE = "2";
    String actualE = emptyE.toString();
    
    assertEquals(expectedE, actualE);
    
    
    emptyE = emptyE.addTerm(-2, 1);
    String expectedE2 = "-2x^1 +2";
    String actualE2 = emptyE.toString();
    assertEquals(expectedE2, actualE2);
    
    
    
  }
  
  /**
   * This method tests the addition of the same degrees. 
   */
  @Test 
  public void testAddTerm2() {
    PolynomialNode empty = new PolynomialEmptyNode();
    String expected = "";
    String actual = empty.toString();
    
    assertEquals(expected, actual);
    
    //testing adding two terms with degree 1
    empty = empty.addTerm(4, 1);
    
    String expected2 = "4x^1";
    String actual2 = empty.toString();
    
    assertEquals(expected2, actual2);
    
    
    empty = empty.addTerm(6, 1);
    
    String expected3 = "10x^1";
    String actual3 = empty.toString();
    
    assertEquals(expected3, actual3);
    
    //testing adding two terms with degree 3
    
    empty = empty.addTerm(3, 3);
    
    String expected4 = "3x^3 +10x^1";
    String actual4 = empty.toString();
    
    assertEquals(expected4, actual4);
    
    empty = empty.addTerm(3, 3);
    
    String expected5 = "6x^3 +10x^1";
    String actual5 = empty.toString();
    
    assertEquals(expected5, actual5);
    
    //test adding two coefficients with degree 0
    
    empty = empty.addTerm(2, 0);
    
    String expected6 = "6x^3 +10x^1 +2";
    String actual6 = empty.toString();
    
    assertEquals(expected6, actual6);
    
    empty = empty.addTerm(2, 0);
    
    String expected7 = "6x^3 +10x^1 +4";
    String actual7 = empty.toString();
    
    assertEquals(expected7, actual7);
    
    //test adding a negative value coefficient
    empty = empty.addTerm(-2, 3);
    
    String expected8 = "4x^3 +10x^1 +4";
    String actual8 = empty.toString();
    
    assertEquals(expected8, actual8);
    
    
  }
  
  /**
   * This method tests the addTerm method. 
   */
  @Test 
  public void testAddTerrm3() {
    PolynomialNode test = new PolynomialEmptyNode();
    PolynomialNode other = new PolynomialEmptyNode();
    test = test.addTerm(2, 0);
    test = other.addTerm(2, 0);
    
    
    String expected = "2";
    String actual = test.toString();
    
    assertEquals(expected, actual);
   
    
  }
    
  /**
   * This method tests that the exception for adding an illegal term
   * is caught. 
   */
  @Test
  public void testAddTermCatch() {
    //test with a degree of 0
    PolynomialNode test4 = new PolynomialEmptyNode();
    test4 = test4.addTerm(4, 0); 
    
    int expected4 = 0;
    int actual4 = test4.getDegree();
    
    assertEquals(expected4, actual4);
    
    //try catch block for illegal argument exception
    try {
      test4 = test4.addTerm(3, -2);
    } catch (IllegalArgumentException e) {
      String exception = e.getMessage();
      assertEquals("Degree must be greater than 0", exception);
      
    }
    
    try {
      test4 = test4.addTerm(3, -7);
    } catch (IllegalArgumentException e2) {
      String exception2 = e2.getMessage();
      assertEquals("Degree must be greater than 0", exception2);
    }
  }
  
  /**
   * This method tests the removeTerm method.
   */
  @Test
  public void testRemoveTerm() {
    PolynomialNode test = new PolynomialEmptyNode();
    test = test.addTerm(4, 1); 
    test = test.addTerm(3, 3);
    test = test.addTerm(2, 2);

    //currently polynomial is 3x^3 + 2x^2 + 4x
    //first remove 3x^3
    test = test.removeTerm(3);
    
    String expected = "2x^2 +4x^1";
    String actual = test.toString();
        
    assertEquals(expected, actual);
    
    //test removing a power of 1
    
    test = test.removeTerm(1);
    
    String expected2 = "2x^2";
    String actual2 = test.toString();
        
    assertEquals(expected2, actual2);
    
    //test removing everything
    
    test = test.removeTerm(2);
    
    String expected3 = "";
    String actual3 = test.toString();
        
    assertEquals(expected3, actual3);
    
    //reset polynomial 
    test = test.addTerm(4, 1); 
    test = test.addTerm(3, 3);
    test = test.addTerm(2, 2);
    
    //test removing something that isn't present
    
    test = test.removeTerm(4);
    
    String expected4 = "3x^3 +2x^2 +4x^1";
    String actual4 = test.toString();
    
    assertEquals(expected4, actual4);
     
    //test removing power of 0
    test.addTerm(2, 0);
    
    test = test.removeTerm(0);
    
    String expected5 = "3x^3 +2x^2 +4x^1";
    String actual5 = test.toString();
    
    assertEquals(expected5, actual5);
    
    //test removing a negative number
    
    test = test.removeTerm(-2);
    
    String expected6 = "3x^3 +2x^2 +4x^1";
    String actual6 = test.toString();
    
    assertEquals(expected6, actual6);
    
  }
  
  /**
   * This method tests the getDegree of a polynomial. 
   */
  @Test
  public void testGetDegree() {
    PolynomialNode test = new PolynomialEmptyNode();
    test = test.addTerm(4, 1); 
    test = test.addTerm(3, 3);
    test = test.addTerm(2, 2);
    
    int expected = 3;
    int actual = test.getDegree();
    
    assertEquals(expected, actual);
    
    //test degree of a empty polynomial
    PolynomialNode test2 = new PolynomialEmptyNode();
    
    int expected2 = 0;
    int actual2 = test2.getDegree();
    
    assertEquals(expected2, actual2);
    
    //test with a Polynomial of degree 1
    PolynomialNode test3 = new PolynomialEmptyNode();
    test3 = test3.addTerm(4, 1); 
    
    int expected3 = 1;
    int actual3 = test3.getDegree();
    
    assertEquals(expected3, actual3);
    
    
    //test with a degree of 0
    PolynomialNode test4 = new PolynomialEmptyNode();
    test4 = test4.addTerm(4, 0); 
    
    int expected4 = 0;
    int actual4 = test4.getDegree();
    
    assertEquals(expected4, actual4);
    

  }
  
  /**
   * This method tests the getDegree method. 
   */
  @Test
  public void getDegree3() {
    Polynomial test = new PolynomialImpl("4x^3 +2x +10");
    int expected = 3;
    int actual = test.getDegree();
    
    assertEquals(expected, actual);
    //test for a degree that doesn't exist
    Polynomial test2 = new PolynomialImpl("4x^992 +2x^998 +10");
    int expected2 = 998;
    int actual2 = test2.getDegree();
    
    assertEquals(expected2, actual2);
    
    Polynomial test3 = new PolynomialImpl("4x^0 +2x^998 +10");
    int expected3 = 998;
    int actual3 = test3.getDegree();
    
    assertEquals(expected3, actual3);
    
    
  }
 

 
  
  
  /**
   * This method tests the getCoefficient method.
   */
  @Test
  public void getCoefficient() {
    PolynomialNode test = new PolynomialEmptyNode();
    test = test.addTerm(4, 1); 
    test = test.addTerm(3, 3);
    test = test.addTerm(2, 2);
    
    int expected = 4;
    int actual = test.getCoefficient(1);
    
    assertEquals(expected, actual);
    
    //test for a coefficient for a power that doesn't exist
    
    int expected2 = 0;
    int actual2 = test.getCoefficient(5);
    
    assertEquals(expected2, actual2);
    
    //test for a degree of 2
    
    int expected3 = 2;
    int actual3 = test.getCoefficient(2);
    
    assertEquals(expected3, actual3);
    
    //test for a degree of 0
    test = test.addTerm(4, 0);
    
    int expected4 = 4;
    int actual4 = test.getCoefficient(0);
    
    assertEquals(expected4, actual4);
    
    //test for a negative degree
    
    int expected5 = 0;
    int actual5 = test.getCoefficient(-2);
    
    assertEquals(expected5, actual5);
    
    //test get coefficient for an empty node
    PolynomialNode test2 = new PolynomialEmptyNode();
    
    int expected6 = 0;
    int actual6 = test2.getCoefficient(0);
    
    assertEquals(expected6, actual6);
    
    PolynomialImpl poly = new PolynomialImpl("3x^5 +4x^7 +3");
    int expectedPoly = 4;
    int actualPoly = poly.getCoefficient(7);
    
    assertEquals(expectedPoly, actualPoly);
    
    PolynomialImpl poly2 = new PolynomialImpl("3x^9 +4x^2 +3");
    int expectedPoly2 = 3;
    int actualPoly2 = poly2.getCoefficient(9);
    
    assertEquals(expectedPoly2, actualPoly2);
    
    
    PolynomialImpl poly3 = new PolynomialImpl("3x^9 -4x^2 +3");
    int expectedPoly3 = -4;
    int actualPoly3 = poly3.getCoefficient(2);
    
    assertEquals(expectedPoly3, actualPoly3);
    
    PolynomialImpl poly4 = new PolynomialImpl("3x^9 +x^2 +3");
    int expectedPoly4 = 1;
    int actualPoly4 = poly4.getCoefficient(2);
    
    assertEquals(expectedPoly4, actualPoly4);
    
    

  }
  
  /**
   * This method tests the evaluate method. 
   */
  @Test 
  public void testEvaluate() {
    PolynomialNode test = new PolynomialEmptyNode();
    test = test.addTerm(2, 1); 
    test = test.addTerm(2, 2);
    test = test.addTerm(2, 0);
    
    //2x^2 + 2x + 2 where x = 1
    double expected = 6;
    double actual = test.evaluate(1.0);
    
    assertEquals(expected, actual, 0.01);
    
    //test larger polynomial 
    PolynomialNode test2 = new PolynomialEmptyNode();
    test2 = test2.addTerm(-2, 1); 
    test2 = test2.addTerm(5, 3);
    test2 = test2.addTerm(-2, 0);
    
    //5x^3 - 2x - 2 where x = 1
    double expected2 = 34;
    double actual2 = test2.evaluate(2.0);
    
    assertEquals(expected2, actual2, 0.01);
    
    //test if value is 0
    
    PolynomialNode test3 = new PolynomialEmptyNode();
    test3 = test3.addTerm(-2, 1); 
    test3 = test3.addTerm(5, 3);
    test3 = test3.addTerm(-2, 0);
    
    //5x^3 - 2x - 2 where x = 1
    double expected3 = -2;
    double actual3 = test3.evaluate(0.0);
    
    assertEquals(expected3, actual3, 0.01);
    
    //example from assignment description
    PolynomialNode test4 = new PolynomialEmptyNode();
    test4 = test4.addTerm(3, 4); 
    test4 = test4.addTerm(-5, 3);
    test4 = test4.addTerm(2, 1);
    test4 = test4.addTerm(-4, 0);
    
    //5x^3 - 2x - 2 where x = 1
    double expected4 = 40.0625;
    double actual4 = test4.evaluate(2.5);
    
    assertEquals(expected4, actual4, 0.01);
    
    PolynomialImpl polyImpl = new PolynomialImpl("5x^3 -2x -2");
    double expected5 = 34;
    double actual5 = polyImpl.evaluate(2.00);
    
    assertEquals(expected5, actual5, 0.01);
    
    PolynomialImpl polyImpl2 = new PolynomialImpl("5x^3 -2x -2");
    double expected6 = -2;
    double actual6 = polyImpl2.evaluate(0.00);
    
    assertEquals(expected6, actual6, 0.01);
    
    
    
  }
  


  /**
   * This method tests the add method. 
   */
  @Test
  public void addPolynomials3() {
    Polynomial test = new PolynomialImpl("4x^3 +x +10");
    Polynomial test2 = new PolynomialImpl("5x^4 +2x^2 +9");
    
    String expected = "5x^4 +4x^3 +2x^2 +x^1 +19";
    String actual = test.add(test2).toString();
    
    assertEquals(expected, actual);
    
    Polynomial test3 = new PolynomialImpl("-40x^30 -2x^90 -10");
    Polynomial test4 = new PolynomialImpl("50x^4 +2x^2 +9");
    
    String expected3 = "-2x^90 -40x^30 +50x^4 +2x^2 -1";
    String actual3 = test3.add(test4).toString();
    
    assertEquals(expected3, actual3);
    
    Polynomial test5 = new PolynomialImpl("0");
    Polynomial test6 = new PolynomialImpl("0");
    
    String expected6 = "0";
    String actual6 = test5.add(test6).toString();
    
    assertEquals(expected6, actual6);
   
  }
  
  /**
   * This method tests the add method. 
   */
  @Test
  public void testAdd() {
    PolynomialImpl test = new PolynomialImpl("54x^30 +2x^25 +3x^3 +50");
    PolynomialImpl other = new PolynomialImpl("10x^30 +5x^25 +5x^3  -50");
    String expected = "64x^30 +7x^25 +8x^3";
    String actual =  test.add(other).toString();
    
    assertEquals(expected, actual);

  }
  

  
}















