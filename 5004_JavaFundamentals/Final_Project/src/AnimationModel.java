package cs5004.animator.model;
import java.awt.Color;
import java.util.List;

/**
 * The interface for an Animation Model Object.
 * @author Katie Lowen
 *
 */
public interface AnimationModel {

  
  /**
   * Adds a new Shape Object to the current Shape Object. 
   * @param newShape Abstract Shape Object that is added to the current shape. 
   */
  public void addShape(Shape newShape);
  
  
  /**
   * Adds a new Animation Object to a current Animation Object.
   * @param newAnimation new Animation Object that is being 
   *     added to the current Animation Object. 
   */
  public void addAnimation(Animation newAnimation);
  
  public String toStringSVG();
  
//  /**
//   * Returns the state of the animations and shapes present at a given time
//   * @return
//   */
//  public double tween(int time, Animation animation);
  
//  public List<Animation> getAnimationList();
//  
//  public List<Shape> getShapeList();
  
  public void setDimensionsX(int x);
  
  public void setDimensionsY(int y);
  
  public void setDimensionsWidth(int width);
  
  public void setDimensionsHeight(int height);
  
  
  
  
  
  
  

}
