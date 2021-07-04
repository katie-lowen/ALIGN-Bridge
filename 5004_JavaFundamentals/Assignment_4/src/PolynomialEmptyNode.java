
/**
 * This class creates a new PolynomialEmptyNode Object. 
 * @author Katie Lowen
 *
 */
public class PolynomialEmptyNode implements PolynomialNode {

  /**
   * This method creates a new PolynomialEmptyNode object.
   */
  public PolynomialEmptyNode() {
    //this is an empty node
    return;
  }
  
  
  @Override
  public PolynomialNode addTerm(int coefficient, int power) throws IllegalArgumentException {
    try { 
      return new PolynomialElementNode(coefficient, power, this);
    }
    catch (IllegalArgumentException e) { 
      throw e;
    }
  }

  
  //has nothing to be removed
  @Override
  public PolynomialNode removeTerm(int power) {
    return this;
  }
    
  
  @Override
  public int getDegree() {
    
    return 0;
  }

  @Override
  public int getCoefficient(int power) {
    
    return 0;
  }
  
  /**
   * This method creates the toString representation of an empty node. 
   * @return the String representation of an empty node.
   */
  public String toString() {
    return "";
  }


  @Override
  public double evaluate(double value) {
    
    return 0;
  }

  






}
