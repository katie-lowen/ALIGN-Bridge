package cs5004.animator.controller;


import java.io.IOException;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationVisual;
import cs5004.animator.view.AnimationView;

public class AnimationControllerImpl implements AnimationController {


  private AnimationModel model;
  private AnimationView view;
  
  
  public AnimationControllerImpl(AnimationModel model, AnimationView view) {
    this.model = model;
    this.view = view;
    
  }


  @Override
  public void animate() {
    //add try catch for all differrent functions in in AnimationView 
    //i.e. try and call the graphical view catch exception
    //try and catch the svg view and catch exception
    
    try {
      view.displayText(model.toString());
    } catch (UnsupportedOperationException  e) {
//      "displayText view is unsuported";
    }
    
    try {
      view.displaySVG(model.toStringSVG());
    } catch (UnsupportedOperationException e) {
//      throw new UnsupportedOperationException ("displaySVG view is unsuported");
    }
    
    try {
      view.displayVisual((AnimationVisual)model);
    } catch (UnsupportedOperationException e) {
//      throw new UnsupportedOperationException ("displayVisual view is unsuported");
    }
  }
  
  
  
  
  
 
}
