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
import cs5004.animator.model.ResizeHeightAnimation;
import cs5004.animator.model.ResizeWidthAnimation;
import cs5004.animator.model.Shape;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.SVG;
import cs5004.animator.view.Text;
import cs5004.animator.view.Visual;

public class AnimatorProgram {
  



  public static void main(String[] args) throws IOException {
    
   
    Shape shape1 = new Rectangle("R", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 1000, 1);
//    Shape shape2 = new Ellipse("E", 250.0, 100.0, 60.0, 30.0, Color.BLUE, 6, 9000, 1);
//    Shape shape3 = new Rectangle("R2", 200.0, 210.0, 30.0, 200.0, Color.GREEN, 1, 8000, 1);

    
//    Animation animation1 = new MoveAnimation(shape2, 1000, 5000, 200.0, 200.0, 300.0, 300.0);
//    Animation animation2 = new MoveAnimation(shape3, 2000, 7000, 500.0, 700.0, 500.0, 400.0);
//    Animation animation3 = new ChangeColorAnimation(shape1, 0, 6000, Color.RED, Color.BLUE);
//    Animation animation4 = new MoveAnimation(shape1, 7000, 10000, 300.0, 300.0, 200.0, 200.0);
    Animation animation5 = new ResizeWidthAnimation(shape1, 500, 7000, 50.0, 25.0);
//    Animation animation6 = new ResizeHeightAnimation(shape1, 500, 7000, 50.0, 25.0);
    
    AnimationModel model = new AnimationModelImpl();
    model.addShape(shape1);
//    model.addShape(shape2);
//    model.addShape(shape3);
//    model.addAnimation(animation1);
//    model.addAnimation(animation2);
    model.addAnimation(animation5);
//    model.addAnimation(animation4);
//    model.addAnimation(animation5);
//    model.addAnimation(animation6);
    
  //************************* TEXT View prints to console:
//    AnimationView viewText = new Text(System.out);
//    
//    AnimationController textController = new AnimationControllerImpl(model, viewText);
//   
//    textController.animate();
  
//    System.out.println("\n\n\n");
    
    
 //**************************** Text view prints to file:
    
//    String fileName = "testText.txt";
//   
//    File file = new File(fileName);
//    file.createNewFile();
//     
//    FileWriter myWriter = new FileWriter(fileName);
//   
//    AnimationView viewText2 = new SVG(myWriter); 
//       
//    
//    AnimationController textController2 = new AnimationControllerImpl(model, viewText2);
//    
//    textController2.animate();
  
    //************************* SVG prints to console:
//    AnimationView viewSVG = new SVG(System.out);
//    
//     
//    AnimationController svgController = new AnimationControllerImpl(model, viewSVG);
//    
//    svgController.animate();
    
    //*************************
    
    //************************* SVG View prints to FILE:
    
//    String fileName = "testSVG2.txt";
//   
//    File file = new File(fileName);
//    file.createNewFile();
//     
//    FileWriter myWriter = new FileWriter(fileName);
//   
//    AnimationView viewSVG2 = new SVG(myWriter); 
//       
//    
//    AnimationController svgController2 = new AnimationControllerImpl(model, viewSVG2);
//    
//    svgController2.animate();
     
  //************************* Visual View pop up window
    
//    AnimationView viewVisual = new Visual(model, 1);
//  
//   
//    AnimationController visualController = new AnimationControllerImpl(model, viewVisual);
//  
//    visualController.animate();
//    
   
    
    
    
   
    return;
    
    
    
    

    
    
  }

}
