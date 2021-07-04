
public class FibanocciCounter {
  private int initialCount;
  
  /**
   * This method creates the object Fibanocci Counter. It takes an 
   * integer as the initial count.
   * @param initialCount integer that is the initial count. 
   */
  public FibanocciCounter(int initialCount) throws IllegalArgumentException{
    if (initialCount < 0) {
      throw new IllegalArgumentException();
    }
    this.initialCount = initialCount;
}
  
  /**
   * This method gets the current count of the fibanocci numbers.
   * @return the current count of the fibanocci numbers as an int. 
   */
  public int getCurrentCount() {
    return this.initialCount;
  }
  
  /**
   * This method creates a new FibonacciCounter object decreased by 1.
   * @return A new FibanocciCounter object minus 1.
   */
  public FibanocciCounter counterMinusOne() {
    
    FibanocciCounter rValue;
    if (this.initialCount <= 1) {
      rValue = new FibanocciCounter(this.initialCount);
      return rValue;
    }
    
    rValue = new FibanocciCounter(this.initialCount - 1);
    return rValue;
    
        
  }
  /**
   * Thsi method....
   * @return
   */
  public FibanocciCounter counterPlusOne() {
    
    FibanocciCounter rValue = new FibanocciCounter(this.initialCount + 1);
    
    return rValue;
    
  }
  /**
   * This method gets the Fibanocci number corresponding to the count.
   * @return The current fibanocci number corresponding to the count. 
   */
  public double currentNumber() {
    
   int number = (int)((1 / Math.sqrt(5)) *  (Math.pow(( (1 + Math.sqrt(5)) / 2 ) , this.initialCount)
       -  (Math.pow(( (1 - Math.sqrt(5)) / 2 ) , this.initialCount) ) ));
   
   return number;
  }
  
  
  

}
