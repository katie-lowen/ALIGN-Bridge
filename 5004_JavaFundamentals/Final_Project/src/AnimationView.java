package cs5004.animator.view;

import java.io.IOException;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AnimationVisual;


public interface AnimationView {
    
  /**
   * 
   * @param model
   */
  public void displayText(String str);
  
  /**
   * 
   * @param model

   */
  public void displaySVG(String str);
  
  /**
   * 
   * @param model
   */
  public void displayVisual(AnimationVisual model);
 
}
