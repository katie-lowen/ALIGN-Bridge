package cs5004.animator.model;
import java.awt.Color;

/**
 * Interface for Shape List. 
 * @author Katie Lowen
 *
 */
public interface Shape extends Comparable<Shape>{
  
  /**
   * String representation of the ShapeObject being created. 
   * @return String representation as "Create red 
   *     rectangle R with corner at (200,200), width 50 and height 100".
   */
  public String toStringShape();
  
  /**
   * String representation of the Shape Object's specific time stamp. 
   * @return String representation as "
   */
  public String toStringTime();
  
  /**
   * Creates a String representation of the Object's beginning attributes.
   * @return string representation of the Shape object's beginning state. 
   */
  public String toString();
  
  /**
   * Creates a unique name as a String representation for each object. 
   * @return a name for each object i.e. Shape1 as a string. 
   */
  public String getName();
  
  /**
   * A String representation of the beginning coordinates of the Objects location.
   * @return string representation of the location coordinates i.e. (3,4).
   */
  public String getLocation();
  
  /**
   * Gets the start time the object is created. 
   * @return the time the object is created, 
   */
  public int getStartTime();


  public int getX();
  
  public int getY();
  
  public int getWidth();
  
  public int getHeight();
  
  public String getColor();
  
  public String SVGString();
  
  public String getType();
  
  public Color getNumberColor();
  
  public double getCurrentX();
  
  public double getCurrentY();
  
  public double getCurrentWidth();
  
  public double getCurrentHeight();
  
  public double getCurrentRed();
  
  public double getCurrentGreen();
  
  public double getCurrentBlue();
  
  
  public void setCurrentX(double newX);
  
  public void setCurrentY(double newY);
  
  public void setCurrentWidth(double newWidth);
    
  public void setCurrentHeight(double newHeight); 
  
  public void setCurrentColor(Color tweenColor);
  
  public Color getCurrentColor();
//  
  

  

  


}
