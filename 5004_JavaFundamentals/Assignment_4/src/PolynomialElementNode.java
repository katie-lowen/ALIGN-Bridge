


/**
 * This is the PolynomialElementNode class. 
 * @author Katie Lowen
 *
 */
public class PolynomialElementNode implements PolynomialNode {
  
  private int coefficient;
  private String variable = "x";
  private int degree;
  private PolynomialNode rest;
  

  /**
   * This is a method to create a PolynomialElementNode with a coefficient, variable, and degree. 
   * @param coefficient the coefficient of the PolynomialElementNode as an integer.
   * @param variable the variable of the PolynomialElementNode as an character. 
   * @param degree the degree of the PolynomialElementNode as an integer. 
   * @throws IllegalArgumentException if the coefficient is 0.
   */
  public PolynomialElementNode(int coefficient, String variable, 
      int degree, PolynomialNode rest) throws IllegalArgumentException {
    if (this.coefficient == 0) {
      throw new IllegalArgumentException("Degree must be positive!");
        
    }
    
    this.coefficient = coefficient;
    this.variable = variable;
    this.degree = degree;
    this.rest = rest;
  }


  
  /**
   * This method creates a PolynomialElementNode object with no parameters, 
   * resulting in a PolynomialElementNode of 0. 
   */
  public PolynomialElementNode() {
    this.coefficient = 0;
    this.variable = "";
    this.degree = 0;
  }
  
  /**
   * This method creates a PolynomialElementNode object with no parameters, 
   * resulting in a PolynomialElementNode of 0. 
   * @throws IllegalArgumentException is degree is less than zero. 
   */
  public PolynomialElementNode(int coefficient, int degree, PolynomialNode rest) 
      throws IllegalArgumentException {
    
    if (degree < 0) {
      throw new IllegalArgumentException("Degree must be greater than 0");
    }
    

    
    this.coefficient = coefficient;
    this.degree = degree;
    this.rest = rest;
    
  }
   

  @Override
  public PolynomialNode addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (this.degree < power) {
      return new PolynomialElementNode(coefficient, power, this);
    }
    else if (power == this.degree) {
      this.coefficient = this.coefficient + coefficient;
      
      if (this.coefficient == 0) {
        return this.rest;
      }
   
      return this;
       
    }

    else {
      this.rest = this.rest.addTerm(coefficient, power);
      return this;
    }
  }

  @Override
  public PolynomialNode removeTerm(int power) {
    if (this.degree == power) {
      return this.rest;
    }
    else {
      this.rest = this.rest.removeTerm(power);
      return this;
    }
  }

  
  @Override
  public int getDegree() {
    
    return this.degree;
  }

  @Override
  public int getCoefficient(int power) {
    if (this.degree == power) {
      return this.coefficient;
    }
    else if (this.degree != power) {
      return this.rest.getCoefficient(power);
 
    }
    else {
      return 0;
    }
    
  }
  
  /**
   * This method creates a String representation of the PolynomialElementNode. 
   */
  public String toString() {
    String str = "";  
    //all individual nodes
    //complete i.e. 4x^3
    
    if (this.coefficient > 1 && this.degree >= 1) {
      str = this.coefficient  + this.variable + "^" + this.degree;
      
    }
    //single terms
    if (this.coefficient > 1 && this.degree == 0) {
      str = Integer.toString(this.coefficient);
      
    }
    if (this.coefficient < 1 && this.degree >= 1) {
      str = this.coefficient + this.variable +  "^" + this.degree;
    }
    //negative coefficient
    if (this.coefficient < 0 && this.degree == 0) {
      str = Integer.toString(this.coefficient);
    }
    
    //coefficient of 1:
    if (this.coefficient == 1 && this.degree >= 1) {
      str = this.variable + "^" + this.degree;
    }

    //just a variable i.e. x
    if (this.coefficient == 1 && this.degree == 0) {
      str = this.variable;
    }
    
    if (this.rest instanceof PolynomialElementNode) {

      str = str + " +" + this.rest.toString();
    }
   
    String newStr = str.replace("+-", "-");
    
     
    return newStr;
    
  }
    


  @Override
  public double evaluate(double value) {
    double total = 0;
    
    total = Math.pow(value, degree) * coefficient + this.rest.evaluate(value);
    return total;
  }





} 



  



