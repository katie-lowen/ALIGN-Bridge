

import static org.junit.Assert.assertEquals;
import java.util.StringTokenizer;

import java.util.Random;
import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test() {
		Employee joe;
		
		joe = new Employee ("Joe", 25.25);
		String expected, actual;
		expected = "Joe, 25.00, 0.00";
		actual = joe.toString();
		
		//using tokens
		//looks through a string and breaks up according to commas, spaces, etc
		//we can use assertequals 
		//StringTokenizer st = new StringTokenizer(expected, ", ");
		//assertEquals("Joe", st.nextToken());
		//assertEquals("25.00", st.nextToken());
		//assertEquals("0.00", st.nextToken());
		
		
		
		//assertEquals(expected, actual);
		
		//we want to declare our variables before the for loop
		//nextDouble is only between 0 and 1
		//to have bigger numbers, we multiply i.e. x 10 gives us between 0-10
		//if we want to go negative, subtract something from it i.e -0.5
		//now is only going from -500 to +500
		//it is doing 1000 tests of the constructor
		
		Random r = new Random(256);
		double payRate;
		for (int i = 0; i < 1000; i++) {
			payRate = (r.nextDouble()-0.5)*1000;
			joe = new Employee ("Joe", payRate);
			expected = String.format("Joe %.2f 0.00", payRate);
			actual = joe.toString();
			assertEquals(expected, actual);
			
			
		}
	}
	
	@Test
	public void testAddHoursWorked() {
		Random r = new Random(34262);
		double payRate;
		double hoursWorked;

		String expected;
		String actual;

		for (int i = 0; i < 10000; i ++);
		  payRate = r.nextDouble() * 100;
		  hoursWorked = r.nextDouble()-0.5 * 2000;
		  Employee jenn = new Employee("Jenn", payRate);
		  jenn.addHoursWorked(hoursWorked);
		  
		  expected = String.format("Jenn %.2f %.2f", payRate, hoursWorked);
		  actual = jenn.toString();
		  
		  assertEquals(expected, actual);
		  
			
	}
		
	@Test
	public void testResetHoursWorked() {
		Random r = new Random(34262);
		double payRate;
		double hoursWorked;

		String expected;
		String actual;

		for (int i = 0; i < 10000; i ++);
		  payRate = r.nextDouble() * 100;
		  hoursWorked = r.nextDouble()-0.5 * 2000;
		  Employee jenn = new Employee("Jenn", payRate);
		  jenn.addHoursWorked(hoursWorked);
		  
		  expected = String.format("Jenn %.2f %.2f", payRate, 0.00);
		  jenn.resetHoursWorked();
		 
		  actual = jenn.toString();
		  
		  assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetWeeklyCheck() {
	  Employee jenn = new Employee("Jenn", 10.00);
	  double hoursWorked = 10.00;
	  jenn.addHoursWorked(hoursWorked);
	  
	  PayCheck expectedCheck = new PayCheck("Jenn", 10.00, 10.00);
	  
	  assertEquals(expectedCheck.toString(),jenn.getWeeklyCheck().toString());
	}

		//this is an "exhaustive approach" to testing
		//this is much slower than random testing 
		//for (int x = -500; i <= 500; x +=5) {
			//for (int y = -500; i <= 500; y +=5)
		//}
		
		
		
		
		
		//making a random object to test
		//if we see Random(100), 100 is the seed value
		//r is the random object and i am grabbing the next random int
		
//		Random r = new Random(256);
//		int myValue = r.nextInt();
//		System.out.println(" " + myValue);
//		//r = new Random(100);
//		myValue = r.nextInt();
//		System.out.println(" " + myValue);
		
	}


