
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PayCheckTest {

  /**
   * This method tests the constructor PayCheck.
   */
	@Test
	public void testPayCheck() {
	  PayCheck joe = new PayCheck("Joe", 17.00, 24.00);
	  
	  assertEquals("Total Pay: $408.00", joe.toString());
	  
	}
	
	/**
	 * This tests the get Total Paycheck Method. 
	 */
	@Test
	public void testGetTotalPay() {
	  double pay = 17;
	  double hoursWorked = 20;
	  PayCheck john = new PayCheck("Johnny", pay, hoursWorked);
	  
	  double expected = pay*hoursWorked;
	  
	  assertEquals(expected, john.getTotalPay(), 0.01);
	}
	
	/**
	 * This method tests the toString Method.
	 */
	@Test 
	public void testtoString() {
	  double pay = 17;
    double hoursWorked = 20;
    PayCheck john = new PayCheck("Johnny", pay, hoursWorked);
    
    double expected = john.getTotalPay();
    String strExpected = "Total Pay: $340.00";
	  String strActual = john.toString();
    
    assertEquals(strExpected, strActual);
	  
	}

}
