
/**
 * This interface represents all operations for a PolyNomialNode. 
 * @author Katie Lowen
 *
 */
public interface PolynomialNode {
  
  /**
   * This method takes a coefficient and a power (both integral numbers) and
   * adds the resulting term to the PolynomialNode. 
   * @return an integer value of the addition of two terms. 
   * @throws IllegalArgumentException if a negative power is passed. 
   */
  public PolynomialNode addTerm(int coefficient, int power) throws IllegalArgumentException;
  
  /**
   * This method takes a power and removes any terms in the PolynomialNode with 
   * the same power. 
   * @return a PolynomialNode without the term. 
   */
  public PolynomialNode removeTerm(int power);
  
  /**
   * This method gets the degree of the PolynomialNode. 
   * @return an integer value representing the degree of the PolynomialNode. 
   */
  public int getDegree();

  /**
   * This method takes a power and returns the coefficient for the term with 
   * that power. 
   * @param power is the degree of the desired coefficient. 
   * @return the coefficient for the term with the given power. 
   */
  public int getCoefficient(int power);
  
  /**
   * This method evaluates a PolynomialNode. It takes a double and returns a double. 
   * @param value is the value used to evaluate a PolynomialNode.
   * @return a double that represents the evaluation of a PolynomialNode. 
   */
  public double evaluate(double value);


 
 
  
}







