package cs5004.animator.model;
/**
 * This is the interface for the Animation Class. 
 * @author Katie Lowen
 *
 */
public interface Animation extends Comparable<Animation>{
  
  /**
   * Gets the start time of the animation.
   * @return the start time of the animation as an integer. 
   */
  public int getStartTime();
  
  /**
   * Gets the end time of the animation. 
   * @return the end time of the animation as an integer. 
   */
  public int getEndTime();

  /**
   * Creates a string representation of the animation. 
   * @return a string representation of the animation. 
   */
  public String toString();
  
  /**
   * Adds a new Animation object to the current animation.
   * @param newAnimation is the Animation Object being added. 
   * @return an Animation Object with the new Animation Object added. 
   */

  public String SVGString();
  
  
  public Shape getAnimationShape();
  
  //i.e. time = 2, animation start time = 1, animation end time = 6
  public boolean shapeOnScreen(int time);
  
  public String getTypeAnimation();
  
  public double getStartX();

  
  public double getStartY();

  
  public double getEndX();

  public double getEndY();

  
  public double getStartWidth();
  
  public double getEndWidth();
  
  
  public double getStartHeight();
  
  public double getEndHeight();
  
  
  public double getStartRed();
  
  public double getStartGreen();
  
  public double getStartBlue();
  
  public double getEndRed();
  
  public double getEndGreen();
  
  public double getEndBlue();
  
  public double getStartColor();
  
  public double getEndColor();
  
  

  





  
}
