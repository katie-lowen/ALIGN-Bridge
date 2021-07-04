
/**
 * This interface represents a List of terms.
 * @author Katie Lowen
 *
 */
public interface Polynomial {
  
  /**
   * This method takes a coefficient and a power (both integral numbers) and
   * adds the resulting term to the polynomial. 
   * @throws IllegalArgumentException if a negative power is passed. 
   */
  public void addTerm(int coefficient, int power) throws IllegalArgumentException;
  
  /**
   * This method takes a power and removes any terms in the polynomial with 
   * the same power. 
   */
  public void removeTerm(int power);
  
  /**
   * This method gets the degree of the polynomial. 
   * @return an integer value representing the degree of the polynomial. 
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
   * This method evaluates a polynomial. It takes a double and returns a double. 
   * @param value is the value used to evaluate a polynomial.
   * @return a double that represents the evaluation of a polynomial. 
   */
  public double evaluate(double value);
  
  /**
   * This method adds two Polynomial objects together and creates a new Polynomial. 
   * @param other the Polynomial object being added. 
   * @return a new Polynomial object as the result of adding two together. 
   * @throws IllegalArgumentException if the two objects are of different classes. 
   */
  public Polynomial add(Polynomial other) throws IllegalArgumentException;

 
  
}



