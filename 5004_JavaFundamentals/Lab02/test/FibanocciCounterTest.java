import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibanocciCounterTest {

  @Test
  public void testConstructor() {
    FibanocciCounter count = new FibanocciCounter(1);
    assertEquals(1, count.getCurrentCount());
  }
  
  @Test
  public void testCounterMinusOne() {
    FibanocciCounter count = new FibanocciCounter(2);
    FibanocciCounter expected = new FibanocciCounter(1);
    
    FibanocciCounter actual = count.counterMinusOne();
    
    assertEquals(expected.getCurrentCount(), actual.getCurrentCount());
  }
  
  @Test
  public void testCounterPlusOne() {
    FibanocciCounter count = new FibanocciCounter(5);
    FibanocciCounter expected = new FibanocciCounter(6);
    
    FibanocciCounter actual = count.counterPlusOne();
    
    assertEquals(expected.getCurrentCount(), actual.getCurrentCount());
  }
 
  @Test
  public void testGetCurrentNumber() {
    FibanocciCounter count1 = new FibanocciCounter(1);
    int expected1 = 1;
    FibanocciCounter count2 = new FibanocciCounter(2);
    int expected2 = 1;
    FibanocciCounter count3 = new FibanocciCounter(3);
    int expected3 = 2;
    FibanocciCounter count4 = new FibanocciCounter(4);
    int expected4 = 3;
    FibanocciCounter count5 = new FibanocciCounter(5);
    int expected5 = 5;
    FibanocciCounter count6 = new FibanocciCounter(6);
    int expected6 = 8;
    FibanocciCounter count7 = new FibanocciCounter(7);
    int expected7 = 13;
    
    assertEquals(expected1, count1.currentNumber(), 0.01);
    assertEquals(expected2, count2.currentNumber(), 0.01);
    assertEquals(expected3, count3.currentNumber(), 0.01);
    assertEquals(expected4, count4.currentNumber(), 0.01);
    assertEquals(expected5, count5.currentNumber(), 0.01);
    assertEquals(expected6, count6.currentNumber(), 0.01);
    assertEquals(expected7, count7.currentNumber(), 0.01);
    
  }
  
  
 
  
  
}


