import java.util.Scanner;

/**
 * This method creates a new PolynomialImpl class.
 * @author Katie Lowen
 *
 */
public class PolynomialImpl implements Polynomial { 
  
  private PolynomialNode head;
  
  /**
   * This method creates a new PolynomialImpl Object. 
   */
  public PolynomialImpl() {
    head = new PolynomialEmptyNode();
  }
  
  
  /**
   * This method creates a PolynomialElementNode object with a string parameter. 
   * @param polynomialStr is the String representation of the polynomial. 
   */
  public PolynomialImpl(String polynomialStr) {
    int coefficient;
    int degree;
    

    head = new PolynomialEmptyNode(); 
    Scanner s = new Scanner(polynomialStr);
      
    String str = "";
  
    int index;
    String num; 
    String power;
    int index2;
    while (s.hasNext()) {
      str = s.next();
      //NumberFormatException
      
      //conditional for 4x^3 or x^3
      if (str.contains("x") && str.contains("^"))  {
        
        index = str.indexOf('x');
        index2 = str.indexOf('^');
        num = str.substring(0, index);
        if (num.equals("+") || num.equals("")) {
          coefficient = 1;
          power = str.substring(index2 + 1);
          degree = Integer.parseInt(power);
        }
        
        else if (num.equals("-")) {
          coefficient = -1;
          power = str.substring(index2 + 1);
          degree = Integer.parseInt(power);   
        } 
        
        else {
          power = str.substring(index2 + 1);
          coefficient = Integer.parseInt(num);
          degree = Integer.parseInt(power);
        }
      }
      
      //conditional formatting for 4x or x
      else if (str.contains("x")) {
        index = str.indexOf('x');
        num = str.substring(0, index); 
        
        if (num.equals("+") || num.equals("")) {     
          coefficient = 1;
          degree = 1;
        }
        
        else if (num.equals("-")) {   
          coefficient = -1;
          degree = 1;      
        }
        
        else {
     
          coefficient = Integer.parseInt(num);
          degree = 1;
        }
      }
      
      //conditional for 4
      else if (!str.contains("x") && !str.contains("^")) {
        num = str.substring(0);
        coefficient = Integer.parseInt(num);
        degree = 0;    
      }
      
      else {
        coefficient = 0;
        degree = 0;     
      }
      
      head = head.addTerm(coefficient, degree);
      
    }
    
    s.close();
  
    
  }
  

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("degree must be positive");
    }
    
    head = head.addTerm(coefficient, power);
    
  }

  @Override
  public void removeTerm(int power) {
    head = head.removeTerm(power);
    
  }

  @Override
  public int getDegree() {
    
    return head.getDegree();
  }

  @Override
  public int getCoefficient(int power) {
    
    return head.getCoefficient(power);
  }

  @Override
  public double evaluate(double value) {

    
    
    double total = head.evaluate(value);
        

    
    
    
    return total;
  
    
 
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!this.getClass().equals(other.getClass())) {
      throw new IllegalArgumentException("These polynomials are not the same class!");
      
    }
   
    Polynomial clone = new PolynomialImpl(this.toString());
    
    String cloneStr = clone.toString();
    
    
    int coefficient;
    int degree;
    
   
    PolynomialNode newHead = new PolynomialEmptyNode();

    
    Scanner s = new Scanner(cloneStr);
      
    String str = "";
  
    int index;
    String num; 
    String power;
    int index2;
    while (s.hasNext()) {
      str = s.next();
       
      if (str.contains("x") && str.contains("^")) {
        index = str.indexOf('x');
        index2 = str.indexOf('^');
        num = str.substring(0, index);
        if (num.equals("+") || num.equals("")) {
          power = str.substring(index2 + 1);
          coefficient = 1;
          degree = Integer.parseInt(power);
        }
        
        else if (num.equals("-")) {
          power = str.substring(index2 + 1);
          coefficient = -1;
          degree = Integer.parseInt(power);
        } 
        
        else {
           
          power = str.substring(index2 + 1);
          coefficient = Integer.parseInt(num);
          degree = Integer.parseInt(power);     
        }
      }
         
      else if (str.contains("x")) {
        index = str.indexOf('x');
        num = str.substring(0, index);
        
        if (str.contains("x") && str.contains("^")) {
          coefficient = 1;
          degree = 1;


        }
        else if (num.equals("-")) {
          coefficient = Integer.parseInt(num);
          degree = -1;

        }
        else {
          coefficient = Integer.parseInt(num);
          degree = 1;

        }
      }
      
      
      else if (!str.contains("x") && !str.contains("^")) {        
        num = str.substring(0);
        coefficient = Integer.parseInt(num);
        degree = 0;    
      }
      
      else {
        coefficient = 0;
        degree = 0;
      }
      
      newHead = newHead.addTerm(coefficient, degree);
      
    }
    
    
    
    s.close();

    
    
    Polynomial combined = new PolynomialImpl(other.toString());
    
    String combinedStr = combined.toString();
      
    Scanner s2 = new Scanner(combinedStr);
    
    
    String str2 = "";
  
    int coefficient2;
    int degree2;
    
    int indexX;
    String num2; 
    String power2;
    int index4;
    while (s2.hasNext()) {
      str2 = s2.next();
      
      
      if (str2.contains("x") && str2.contains("^")) {
        indexX = str2.indexOf('x');
        index4 = str2.indexOf('^');
        num2 = str2.substring(0, indexX);
        if (num2.equals("+") || num2.equals("")) {
          power2 = str2.substring(index4 + 1);
          coefficient2 = 1;
          degree2 = Integer.parseInt(power2);
        }
        
        else if (num2.equals("-")) {
          power2 = str2.substring(index4 + 1);
          coefficient2 = -1;
          degree2 = Integer.parseInt(power2);
        }
        
        else {
          power2 = str2.substring(index4 + 1);
          coefficient2 = Integer.parseInt(num2);
          degree2 = Integer.parseInt(power2);
     
        }
      }
      
      else if (str2.contains("x")) {
        indexX = str2.indexOf('x');
        num2 = str2.substring(0, indexX);
        if (num2.equals("+") || num2.equals("")) {
          coefficient2 = 1;
          degree2 = 1;
        }
        
        else if ((num2.equals("-"))) {
          coefficient2 = -1;
          degree2 = 1;
        }
        
        else {
        
          coefficient2 = Integer.parseInt(num2);
          degree2 = 1;

        }
      }
      
      else if (!str2.contains("x") && !str2.contains("^")) {
        num2 = str2.substring(0);
        coefficient2 = Integer.parseInt(num2);
        degree2 = 0;


      }
      else {
        coefficient2 = 0;
        degree2 = 0;

      }
      
      newHead = newHead.addTerm(coefficient2, degree2); 
      
    }
    
    s.close();
    
    PolynomialImpl complete = new PolynomialImpl(newHead.toString());
    
   
    return complete;
  }

  /**
   * This method is the toString representation of the LinkedList.
   */
  public String toString() {
    if (head instanceof PolynomialEmptyNode) {
    
      return "0";
    }
    
    
    return head.toString();
    
  }
}






