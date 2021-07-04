package cs5004.animator.util;

import java.awt.Color;
import java.util.HashMap;

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

public class AnimationBuilder2 implements AnimationBuilder<AnimationModel> {
  
  //dictionary field of builder //potentially a hash table and hash map
  //or two lists name and type 
  
  private AnimationModelImpl model;
  private HashMap<String, String> shapeNames;
  
  
  public AnimationBuilder2() {
    this.model = new AnimationModelImpl(); 
  }

  @Override
  public AnimationModel build() {
    // TODO Auto-generated method stub
    //called last in the parse file
    
    //for each in this list, add to model 
    //shape for each list, build model 
    
    
    return model;
  }

  @Override
  public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
   model.setDimensionsX(x);
   model.setDimensionsY(y);
   model.setDimensionsWidth(width);
   model.setDimensionsHeight(height);
    
    return this;
  }

  @Override
  public AnimationBuilder<AnimationModel> declareShape(String name, String type) {

    if(shapeNames == null) {
      this.shapeNames = new HashMap<String, String>();
    }
    this.shapeNames.put(name, type);
    
    System.out.println(this.shapeNames);
    
    return this;
  }

  @Override
  public AnimationBuilder<AnimationModel> addMotion(String nameInput, int t1, int x1, int y1, int w1,
      int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
      int b2) {

    double x1D = (double)x1;
    double y1D = (double)y1;
    double w1D = (double)w1;
    double h1D = (double)h1;
    double x2D = (double)x2;
    double y2D = (double)y2;
    double w2D = (double)w2;
    double h2D = (double)h2;
    
    Color startColor = new Color(r1, g1, b1);
    Color endColor = new Color(r2, g2, b2);
    
    if(shapeNames == null) {
      throw new IllegalArgumentException("No shapes have been added to your model");     
     
    }
       
    
    
    if(this.shapeNames.containsKey(nameInput)) {
      String type = this.shapeNames.get(nameInput);
      
      if(type.equalsIgnoreCase("rectangle")) {
        Shape shape = new Rectangle(nameInput, x1D, y1D, w1D, h1D, startColor, t1, t2, 1);
        model.addShape(shape);
        System.out.println(shape.toString());
        
        if((x1 != x2) || (y1 != y2)) {
          Animation move = new MoveAnimation(shape, t1, t2, x1D, y1D, x2D, y2D);
          model.addAnimation(move);
//          System.out.println(move.toString());
          }
        
        if(w1 != w2) {
          Animation resizeWidth = new ResizeWidthAnimation(shape, t1, t2, w1D, w2D);
          model.addAnimation(resizeWidth);
          }
        if(h1 != h2) {
          Animation resizeHeight = new ResizeHeightAnimation(shape, t1, t2, h1D, h2D);
          model.addAnimation(resizeHeight);
          
            }
        if((r1 != r2) || (g1 != g2) || (b1 != b2)) {          
          Animation changeColor = new ChangeColorAnimation(shape, t1, t2, startColor, endColor);
          model.addAnimation(changeColor);
          }

        }
        
        
      if(type.equalsIgnoreCase("ellipse")) {
        Shape shape = new Ellipse(nameInput, x1D, y1D, w1D, h1D, startColor, t1, t2, 1);
        model.addShape(shape);
        System.out.println(shape.toString());
        
        
      if((x1 != x2) || (y1 != y2)) {
        Animation move = new MoveAnimation(shape, t1, t2, x1D, y1D, x2D, y2D);
        model.addAnimation(move);
      }
      if(w1 != w2) {
        Animation resizeWidth = new ResizeWidthAnimation(shape, t1, t2, w1D, w2D);
        model.addAnimation(resizeWidth);
     
      }
      if(h1 != h2) {
        Animation resizeHeight = new ResizeHeightAnimation(shape, t1, t2, h1D, h2D);
        model.addAnimation(resizeHeight);
      }
      if((r1 != r2) || (g1 != g2) || (b1 != b2)) {     
        Animation changeColor = new ChangeColorAnimation(shape, t1, t2, startColor, endColor);
        model.addAnimation(changeColor);
      }
 
     
      }
       
    
  }
    return this;
  }
}


