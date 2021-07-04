/**
 * This is a public class for an Employee. This class takes a name, payRate, and 
 * hoursWorked for each Employee object.
 * @author Katie Lowen
 */

public class Employee {
	private String name;
	private double payRate;
	private double hoursWorked;

 /**
  * Creates a new employee object. It takes the employee name and payrate as
  * parameters and sets the hoursWorked to zero
* 
	 * @param name    The name of the employee
	 * @param payRate The hourly wage of the employee
	 */

  public Employee(String name, double payRate) {
    this.name = name;
    this.payRate = payRate;
    hoursWorked = 0;
}

  /**
   * Return the String representation of Employee. The string is formatted as
   * follows: "name payRate hoursWorked" payRate is displayed to two decimal
   * places hoursWorked is displayed to two decimal places
   * 
   * @return The string representation of Employee.
   */

  public String toString() {
    String s = String.format("%s %.2f %.2f", name, payRate, hoursWorked);
		// "" + name + " " + payRate + " " + hoursWorked
		return s;
	}
  
  //adding hours worked
  //doesn't tell us that it should be public or private, but we will want it public
  //doesn't tell us what it returns, so start by having it void
  /**
   * This method adds the input number of hours to the total hours worked by this
   * employee.
   * @param newHours is a double that contains the number of hours to add to the total number of hours.
   */
  public void addHoursWorked(double newHours) {
	  
	  this.hoursWorked += newHours;
	  
  }
  
  /**
   * This method resets this employees hours worked
   */
  public void resetHoursWorked() {
	 
	  this.hoursWorked = 0;
  }
  
  /**
   * This method 
   * @return
   */
  public PayCheck getWeeklyCheck() {
    PayCheck employee = new PayCheck(this.name, this.payRate, this.hoursWorked);
    return employee;
  }
  
  

}