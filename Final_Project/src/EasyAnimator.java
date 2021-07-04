package cs5004.animator;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.controller.AnimationControllerImpl;
import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AnimationVisual;
import cs5004.animator.model.ChangeColorAnimation;
import cs5004.animator.model.Ellipse;
import cs5004.animator.model.MoveAnimation;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.ResizeHeightAnimation;
import cs5004.animator.model.ResizeWidthAnimation;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationBuilder2;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.SVG;
import cs5004.animator.view.Text;
import cs5004.animator.view.Visual;

public final class EasyAnimator {
  
  //animation reader makes model -->
  //read in arguments
  //use animation reader to make mode
  //the use arguements to make view 
  //

  public static void main(String[] args) {
//    Shape shape1 = new Rectangle("R", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 1000, 1);
//    Shape shape2 = new Ellipse("E", 250.0, 100.0, 60.0, 30.0, Color.BLUE, 6, 9000, 1);
//    Shape shape3 = new Rectangle("R2", 200.0, 210.0, 30.0, 200.0, Color.GREEN, 1, 8000, 1);
//
//    
//    Animation animation1 = new MoveAnimation(shape2, 1000, 5000, 200.0, 200.0, 300.0, 300.0);
//    Animation animation2 = new MoveAnimation(shape3, 2000, 7000, 500.0, 700.0, 500.0, 400.0);
//    Animation animation3 = new ChangeColorAnimation(shape2, 1000, 6000, Color.BLUE, Color.YELLOW);
//    Animation animation4 = new MoveAnimation(shape1, 7000, 10000, 300.0, 300.0, 200.0, 200.0);
//    Animation animation5 = new ResizeWidthAnimation(shape1, 500, 7000, 50.0, 25.0);
//    Animation animation6 = new ResizeHeightAnimation(shape3, 500, 7000, 50.0, 25.0);
//    
//    AnimationModel model = new AnimationModelImpl();
//    model.addShape(shape1);
//    model.addShape(shape2);
//    model.addShape(shape3);
//    model.addAnimation(animation1);
//    model.addAnimation(animation2);
//    model.addAnimation(animation3);
//    model.addAnimation(animation4);
//    model.addAnimation(animation5);
//    model.addAnimation(animation6);
    
    

    
    
    AnimationReader reader = new AnimationReader();
    AnimationModel model = new AnimationModelImpl();
    
    String inputName;
    String viewName;
    String outputName;
    
    
    inputName = "";
    viewName = "";
    outputName = "";
    int speed;
    speed = 1;
    
    for (int i = 0; i < args.length; i++) {
      if (args[i].contentEquals("-view")) {
        try {
          
          if (args[i + 1].charAt(0) == '-') {
            throw new IllegalArgumentException("view must declare a view name");
          }
          viewName = args[i + 1];
        } catch (NullPointerException e) {
          throw new IllegalArgumentException("-view must contain a view name and cannot be null");
        }
      }
      
      if (args[i].contentEquals("-in")) {
        try {
          
          if (args[i + 1].charAt(0) == '-') {
            throw new IllegalArgumentException("-in must contain a file name");
          }
          
          inputName = args[i + 1];
          FileReader input = new FileReader(inputName);
          model = AnimationReader.parseFile(input, new AnimationBuilder2());//something here for reading the file);
          
          
        } catch (NullPointerException e) {
          
        } catch (FileNotFoundException e) {
          
          e.printStackTrace();
        }
        
      }
      
      if (args[i].contentEquals("-out")) {
        try {     
          if (args[i + 1].charAt(0) == '-') {
            throw new IllegalArgumentException("-out must contain a output name");
          }
          outputName = args[i + 1];
    
        } catch (ArrayIndexOutOfBoundsException e) {
//          throw new IllegalArgumentException("-out without a declaration will print to the console");
        }
       catch (IllegalArgumentException a) {
//        throw new IllegalArgumentException("-out will print to console without a designated out");
 
      }
      }
      if (args[i].contentEquals("-speed")) {
        try {     
          if (args[i + 1].charAt(0) == '-') {
            throw new IllegalArgumentException("-speed will be set to 1");
          }
          speed = Integer.parseInt(args[i + 1]);
        } catch (NullPointerException e) {
          speed = 1;
          
        }
      }  
      
      

    }
    
    if (outputName == "") {
      outputName = "System.out";
    }
    if (speed == 0) {
      speed = 1;
    }
    
    try {
      if (viewName.equalsIgnoreCase("Text")) {
        if (outputName == "System.out") {
        
        AnimationView viewText = new Text(System.out);
     
        AnimationController textController = new AnimationControllerImpl(model, viewText);
    
        textController.animate();
        
      }
        
      else if(outputName.contains(".txt")){
        String fileName = outputName;
      
        File file = new File(fileName);
        file.createNewFile();
        
        FileWriter myWriter = new FileWriter(fileName);
      
        AnimationView viewText2 = new Text(myWriter); 
          
       
        AnimationController textController2 = new AnimationControllerImpl(model, viewText2);
       
        textController2.animate();
      }
      }
      
      if (viewName.equalsIgnoreCase("SVG")) {
        if (outputName == "System.out") {
          AnimationView viewSvg = new SVG(System.out);
       
        
          AnimationController svgController = new AnimationControllerImpl(model, viewSvg);
        
          svgController.animate();
        }
        else if(outputName.contains(".txt")){
          String fileName = outputName;
        
          File file = new File(fileName);
          file.createNewFile();
          
          FileWriter myWriter = new FileWriter(fileName);
        
          AnimationView viewSvg2 = new SVG(myWriter); 
            
         
          AnimationController svgController2 = new AnimationControllerImpl(model, viewSvg2);
         
          svgController2.animate();
        }
        
      }
      
      if (viewName.equalsIgnoreCase("Visual")) {
        
        AnimationView viewVisual = new Visual((AnimationVisual)model, speed);
        
        
        AnimationController visualController = new AnimationControllerImpl(model, viewVisual);
      
        visualController.animate();
        
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
     

  }
}
