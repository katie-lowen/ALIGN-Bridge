package cs5004.animator;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.controller.AnimationControllerImpl;
import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.ChangeColorAnimation;
import cs5004.animator.model.Ellipse;
import cs5004.animator.model.MoveAnimation;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.ResizeWidthAnimation;
import cs5004.animator.model.Shape;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.SVG;
import cs5004.animator.view.Text;

public final class RunAnimator {

  public static void main(String[] args) {
    
    String inputName;
    String viewName;
    String outputName;
    int speed;
    
    inputName = "";
    viewName = "";
    outputName = "";
    speed = 0;
    
    for (int i = 0; i < args.length; i++) {
      if(args[i].contentEquals("-view")) {
        try {
          if(args[i + 1].charAt(0) == '-') {
            throw new IllegalArgumentException("view must declare a view name");
          }
          viewName = args[i + 1];
        } catch (NullPointerException e) {
          throw new IllegalArgumentException("-view must contain a view name and cannot be null");
        }
      }
      
      if(args[i].contentEquals("-in")) {
        try {
          if(args[i + 1].charAt(0) == '-') {
            throw new IllegalArgumentException("-in must contain a file name");
          }
          inputName = args[i + 1];
          
        } catch (NullPointerException e) {
          
        }
        
      }
      
      if(args[i].contentEquals("-out")) {
        try {     
          if(args[i].contentEquals("-")) {
            throw new IllegalArgumentException("-out must contain a output name");
          }
          outputName = args[i + 1];
        } catch (NullPointerException e) {
          
        }
    }  
      if(args[i].contentEquals("-speed")) {
        try {     
          if(args[i].contentEquals("-")) {
            throw new IllegalArgumentException("-out must contain a output name");
          }
          speed = Integer.parseInt(args[i + 1]);
        } catch (NullPointerException e) {
          
        }
    }  
      
      

  }
    System.out.println(inputName);
    System.out.println(viewName);
    System.out.println(outputName);
    System.out.println(speed);
    

}
}
