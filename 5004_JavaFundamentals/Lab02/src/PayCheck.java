/**
 * This is a public class for to create a new object Paycheck. This class
 * takes that parameters name, payRate, hoursworked, totalPay.
 * @author Katie Lowen
 *
 */
public class PayCheck {
	private String name;
	private double payRate;
	private double hoursWorked;
  private double totalPay;
	
/**
 * This method creates a new Paycheck object. It takes the employee name, payrate and hours worked. 
 * To calculate paycheck, we must consider if the employee is working overtime or regular hours
 * @param name the name of the employee.
 * @param payRate the payRate of the employee.
 * @param hoursWorked the number of hours worked this week by the employee.
 */
  public PayCheck(String name, double payRate, double hoursWorked) {
	this.name = name;
	this.payRate = payRate;
	this.hoursWorked = hoursWorked;
	this.totalPay = totalPay;
	
	if (this.hoursWorked > 40) {
		double normalWage = 40 * this.payRate;
		double overTimeWage = (this.hoursWorked - 40) * 1.5 * this.payRate;
		this.totalPay = overTimeWage + normalWage; 
	}
	
	else {
		this.totalPay = this.hoursWorked * this.payRate;
	}
		
}
  
  /**
   * This method returns the String representation of totalPay
   * @return the String representation of totalPay
   */
  public String toString() {
    return String.format("Total Pay: $%.2f", this.totalPay);
}
  /**
   * Returns the total pay for the week.
   * This is computed as the payRate * hoursWorked
   * @return double representation of the total pay this week.
   */
  public double getTotalPay() {
    return this.totalPay;
	  
  }
	

}

	


