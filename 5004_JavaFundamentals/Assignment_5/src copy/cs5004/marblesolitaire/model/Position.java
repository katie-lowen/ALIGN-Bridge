package cs5004.marblesolitaire.model;

/**
 * This is an enum class for the MarbleBoard class. 
 * @author Katie Lowen
 *
 */
public enum Position {
  
  
  EMPTY("_"), MARBLE("O"), NA(" ");
  

  private String myString;
  
  Position(String myString) {
    this.myString = myString;
  }
  
  /**
   * This is the method creates a string representation for the enum values. 
   */
  public String toString() {
    return this.myString;
  }
}


