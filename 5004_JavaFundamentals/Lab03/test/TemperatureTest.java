import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;


/**
 * Tests for Temperature, both Celsius and Fahrenheit representations.
 */
public class TemperatureTest {

  private Temperature cTemp;
  private Temperature cTemp2;
  private Temperature fTemp;
  private Temperature fTemp2;

  /**
   * This builds sample temperature objects to be used in the tests.
   */
  @Before
  public void init() {
    cTemp = new CelsiusTemperature(100);
    cTemp2 = new CelsiusTemperature(100, true);
    fTemp = new FahrenheitTemperature(100, true);
    fTemp2 = new FahrenheitTemperature(100);
  }

  /**
   * This method tests for an illegal temperature input.
   * An IllegalArgumentException is thrown if the temperature 
   * is below Absolute Zero. 
   */
  @Test(expected = IllegalArgumentException.class)
  public void testForInvalidFTemp() {
    new FahrenheitTemperature(-1000);
    new CelsiusTemperature(-1000);
  
  }

  /**
   * This method tests the temperature getters. 
   */
  @Test
  public void testObservers() {
    assertEquals(100, cTemp.inCelsius(), 0.001);
    assertEquals(212, cTemp.inFahrenheit(), 0.001);
    assertEquals(373.15, cTemp.inKelvin(), 0.001);
    assertEquals(100, cTemp2.inFahrenheit(), 0.001);
  }

  /**
   * This method tests our inFahrenheit method. 
   */
  @Test
  public void testInF() {
    assertEquals(100, fTemp.inCelsius(), 0.001);
    assertEquals(212, fTemp.inFahrenheit(), 0.001);
    assertEquals(373.15, fTemp.inKelvin(), 0.001);
    assertEquals(100.0, fTemp2.inFahrenheit(), 0.001);
   
  }

  /**
   * This method tests the add method. In this test we add
   * temperatures of the same class. 
   */
  @Test
  public void testAdd() {
    Temperature hot = new CelsiusTemperature(150);
    Temperature hot2 = new CelsiusTemperature(100);
    String actual = (hot.add(hot2)).toString();
    
    Temperature cold = new FahrenheitTemperature(150);
    Temperature cold2 = new FahrenheitTemperature(100);
    
    String actual2 = (cold.add(cold2)).toString();

    
    assertEquals("250.0° Celsius", actual);
    assertEquals("250.0° Fahrenheit", actual2);
  }
  
  /**
   * This method adds two temperatures of different class. 
   * 
   */
  @Test
  public void testAdd2() {
    Temperature celsius = new CelsiusTemperature(100);
    Temperature fahrenheit = new FahrenheitTemperature(100);
    
    Temperature actualCelsius = celsius.add(fahrenheit);
    
    assertEquals("137.8° Celsius", actualCelsius.toString());
    
    Temperature actualFahrenheit = fahrenheit.add(celsius);
    
    assertEquals("312.0° Fahrenheit", actualFahrenheit.toString());
       
    
  }
  
  /**
   * This method randomly tests the add method in Celsius. 
   */
  @Test
  public void testFuzzyAdd() {
    Random rand = new Random();
    
    for (int i = 0; i < 1000; i++) {
      double x = rand.nextDouble() * 100;
      double y = rand.nextDouble() * 100;
      Temperature temp1 = new CelsiusTemperature(x);
      Temperature temp2 = new CelsiusTemperature(y);
      Temperature temp3 = new FahrenheitTemperature(y, true);
      
      Temperature expected1 = temp1.add(temp2);
      Temperature expected2 = temp1.add(temp3);
      
      double z = x + y;

      
      assertEquals(z, expected1.inCelsius(), 0.001);
      assertEquals(z, expected2.inCelsius(), 0.001);
    }
  }
  
  /**
   * This method randomly tests the add method in Fahrenheit. 
   */
  @Test
  public void testFuzzyAdd2() {
    Random rand = new Random();
    
    for (int i = 0; i < 1000; i++) {
      double x = rand.nextDouble() * 100;
      double y = rand.nextDouble() * 100;
      Temperature temp1 = new FahrenheitTemperature(x);
      Temperature temp2 = new FahrenheitTemperature(y);
      Temperature temp3 = new CelsiusTemperature(y, true);
      
      Temperature expected1 = temp1.add(temp2);
      Temperature expected2 = temp1.add(temp3);
      
      double z = x + y;

      
      assertEquals(z, expected1.inFahrenheit(), 0.001);
      assertEquals(z, expected2.inFahrenheit(), 0.001);
    }
  }

  /**
   * This method tests the toString method. 
   */
  @Test
  public void testToString() {
    assertEquals("100.0° Celsius", cTemp.toString());
    assertEquals("212.0° Fahrenheit", fTemp.toString());
  }
  
  /**
   * Tests the compareTo method in Abstract Class. 
   */
  @Test
  public void testCompareTo() {
    Temperature hot = new CelsiusTemperature(150);
    Temperature cold = new FahrenheitTemperature(0);
    Temperature same1 = new CelsiusTemperature(150);
    
    
    assertEquals(1, hot.compareTo(cold));
    assertEquals(-1, cold.compareTo(hot)); 
    assertEquals(0, hot.compareTo(same1));
    
  }
  
  /**
   * This method randomly tests the compareTo method.
   */
  @Test
  public void testFuzzyCompare() {
    Random rand = new Random();
    
    for (int i = 0; i < 1000; i++) {
      double x = (rand.nextDouble() - 0.5) * 100;
      double y = (rand.nextDouble() + 0.5 ) * 100;
      Temperature temp1 = new CelsiusTemperature(x);
      Temperature temp2 = new CelsiusTemperature(y);
      Temperature temp3 = new FahrenheitTemperature(y, true);
     
      assertEquals(-1, temp1.compareTo(temp2));
      assertEquals(-1, temp1.compareTo(temp3));
      assertEquals(1, temp2.compareTo(temp1));
      
    }
  }
}



















